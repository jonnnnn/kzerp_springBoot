package com.imema.common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.*;

/**
 * @author Mr.Lee
 * @since 2019-09-23 10:08
 * Description: 树形数据处理
 **/
public class TreeDataUtils<T> {
    public TreeDataUtils(List<T> list){
        this.setTreeData(list);
    }
    private List<T> treeData;
    public List<T> getTreeData() {
        return treeData;
    }
    //    处理结果
     public void setTreeData(List<T> list) {
    //  TODO  排序功能
    //  缓存查询结果
        Map<Integer, List<T>> pidMap = new HashMap<>();

        int size = list.size();
        Map<Integer, T> idMap = new HashMap<>(size);


        for (T tree : list) {
//            Field field=
            Integer id=(Integer)ReflectionUtils.getFieldValue(tree,"id");
            idMap.put(id, tree);

            Integer pid=(Integer)ReflectionUtils.getFieldValue(tree,"parentId");
            if (pidMap.containsKey(pid)) {
                pidMap.get(pid).add(tree);
            } else {
                List<T> list1 = new ArrayList<>();
                list1.add(tree);
                pidMap.put(pid, list1);
            }
        }

//        设置子队列
        Set<Integer> set = pidMap.keySet();
        for (Integer pid : set) {
            List<T> treeList = pidMap.get(pid);
            if (pid == 0) {
                for (T t : treeList) {
                    ReflectionUtils.setFieldValue(t,"pname","顶级菜单");
                }
            } else {
                //过滤条件可能将父级菜单过滤除去
                T tree = idMap.get(pid);
                if (tree == null) {
                    continue;
                }

                ReflectionUtils.setFieldValue(tree,"children",treeList);
                for (T t : treeList) {
                    ReflectionUtils.setFieldValue(t,"pname",
                            ReflectionUtils.getFieldValue(tree,"name"));
                }
            }
        }

        if (pidMap.get(0) == null) {
            List<T> resolvedList = new ArrayList<>();

            for (Integer pid : pidMap.keySet()) {
                if (idMap.get(pid) == null) {
                    resolvedList.addAll(pidMap.get(pid));
                }
            }
            this.treeData = resolvedList;
        }else {
            this.treeData= pidMap.get(0);
        }
    }

    //      伪分页效果(解决子查询问题)
    public PageUtils handlePage(Map<String,Object> pageForm){

        //分页参数
        long curPage = 1;
        long limit = 10;

        if(pageForm.get(Constant.PAGE) != null){
            curPage = (Integer)pageForm.get(Constant.PAGE);
        }
        if(pageForm.get(Constant.LIMIT) != null){
            limit = (Integer)pageForm.get(Constant.LIMIT);
        }

        //分页对象
        Page<T> page = new Page<>(curPage, limit);

        int beginIndex=(int)(limit*(curPage-1)+1);

        List<T> list=this.getTreeData();
        int size=list.size();
        page.setTotal(size);
        page.setPages(Math.round(size/limit));

        if (beginIndex > size){
            page.setRecords(null);
        } else if ((beginIndex+(int)limit) > size){
            page.setRecords(list.subList(beginIndex-1,size));
        } else {
            page.setRecords(list.subList(beginIndex-1,beginIndex+(int)limit));
        }

        return new PageUtils(page);
    }
}
