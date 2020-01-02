package com.imema.common.utils;

import com.imema.modules.base.dao.SysBillnumRuleDao;
import com.imema.modules.base.entity.SysBillnumRule;
import com.imema.modules.sys.entity.SysUserEntity;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Mr.Lee
 * @since 2019-08-06 00:56
 * Description:
 **/
@Service
@Transactional(readOnly = true)
public class BillnumHelper {
    @Resource
    private SysBillnumRuleDao sysBillnumRuleDao;
    @Transactional(rollbackFor = Exception.class)
    public String getNextNum(Class<?> clazz) throws Exception {
        Field field = clazz.getDeclaredField("BILL_CODE");
        if(field == null) {
            throw new Exception("没有找到单据类型。");
        }
        field.setAccessible(true);
        return getNextNum(field.get(null).toString());
    }
    @Transactional(rollbackFor = Exception.class)
    public synchronized String getNextNum(String code) throws Exception{
        SysBillnumRule rule=sysBillnumRuleDao.isExistRule(code,ShiroUtils.getCompanyId());
        if(null==rule){
            sysBillnumRuleDao.insertNextNum(code,ShiroUtils.getCompanyId());
            rule=sysBillnumRuleDao.getNextNum(code,ShiroUtils.getCompanyId());
        }
        if (rule == null
                || (StringUtils.defaultString(
                rule.getEnabledFlag(), "Y")
                .equalsIgnoreCase("Y") == false)
                || (StringUtils.defaultString(
                rule.getDeletedFlag(), "N")
                .equalsIgnoreCase("Y"))) {
            throw new Exception("没有找到唯一的单据类型。");
        }
//        正式生成序号
        Calendar currentDate=Calendar.getInstance();
        StringBuffer nextNum=new StringBuffer();

//        第一部分  前缀
        String prefix=StringUtils.defaultString(rule.getPrefix())
                +StringUtils.defaultString(rule.getPrefixSeprator());
        nextNum.append(prefix);

        // 第2部分 年
        if ((rule.getYearFlag() == null)
                || (rule.getYearFlag().shortValue() == 1)) {
            int yearLength = (rule.getYLength() == null) ? 2 : rule
                    .getYLength().shortValue();
            if (yearLength == 2) {
                nextNum.append(DateUtils.format(currentDate.getTime(),"yy"));
            } else {
                nextNum.append(DateUtils.format(currentDate.getTime(),"yyyy"));
            }
        }

        // 第3部分 月
        if ((rule.getMonthFlag() == null)
                || (rule.getMonthFlag().shortValue() == 1)) {
            nextNum.append(DateUtils.format(currentDate.getTime(),"MM"));
        }
        // 第4部分 日
        if ((rule.getDayFlag() == null)
                || (rule.getDayFlag().shortValue() == 1)) {
            nextNum.append(DateUtils.format( currentDate.getTime(),"dd"));
        }

        // 第5部分 序号
        // 查找上一次生成序号的日期, year, month, day 应该同是为Null或同时有值
        int seqNo = (rule.getSequenceNum() == null) ? 0 : rule.getSequenceNum();
        Calendar lastDateOn = (rule.getYear() == null) ? currentDate
                : new GregorianCalendar(rule.getYear(), (rule.getMonth() - 1),
                rule.getDay());
        String loopType = StringUtils.defaultString(rule.getLoopType(), "YY");
        if ("YY".equalsIgnoreCase(loopType)) {
            // 已开始新的一年
            if (currentDate.get(Calendar.YEAR) - lastDateOn.get(Calendar.YEAR) > 0) {
                seqNo = 1;
            } else {
                seqNo++;
            }
        } else if ("MM".equalsIgnoreCase(loopType)) {
            // 已开始新的一月
            if (Integer.parseInt(DateUtils.format(
                    currentDate.getTime(),"yyyyMM"))
                    - Integer.parseInt(DateUtils.format(
                    lastDateOn.getTime(),"yyyyMM")) > 0) {
                seqNo = 1;
            } else {
                seqNo++;
            }

        } else if ("DD".equalsIgnoreCase(loopType)) {
            // 已开始新的一日
            if (Integer.parseInt(DateUtils.format(
                    currentDate.getTime(),"yyyyMMdd"))
                    - Integer.parseInt(DateUtils.format(
                    lastDateOn.getTime(),"yyyyMMdd")) > 0) {
                seqNo = 1;
            } else {
                seqNo++;
            }

        }

        seqNo = seqNo < 1 ? 1 : seqNo; // add by alo

        int sequenceLength = (rule.getSequenceLength() == null) ? 5 : rule
                .getSequenceLength().shortValue();
        nextNum.append(StringUtils.leftPad(String.valueOf(seqNo),
                sequenceLength, '0'));

        // 第5部分 后缀
        String suffix = StringUtils.defaultString(rule
                .getSuffixSeprator())
                + StringUtils.defaultString(rule.getSuffix());
        nextNum.append(suffix);

        // 记录到DB中
        rule.setYear(currentDate.get(Calendar.YEAR));
        rule.setMonth(currentDate.get(Calendar.MONTH) + 1);
        rule.setDay(currentDate.get(Calendar.DAY_OF_MONTH));
        rule.setSequenceNum(seqNo);
        rule.setLastUpdateDate(new Date());


        SysUserEntity userEntity=ShiroUtils.getUserEntity();
        rule.setLastUpdatedBy(userEntity == null ? "会话超时"
                : userEntity.getUsername());
        sysBillnumRuleDao.updateById(rule);

        return nextNum.toString();
    }

}
