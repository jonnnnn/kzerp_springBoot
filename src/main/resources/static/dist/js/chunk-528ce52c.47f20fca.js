(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-528ce52c","chunk-2d0af10b"],{"0d78":function(a){a.exports=JSON.parse('{"form":{"account":{"name":"账户名称","bankName":"开户行","bankNum":"账号","balance":"账户余额","initBalance":"初始余额","status":"状态","remark":"备注"},"invoice":{"code":"编号","name":"票据名","customerName":"往来单位","customerId":"往来单位","ivDate":"票据日期","amount":"票据金额","summary":"摘要","ivType":"票据类型","cpName":"公司名称","taxNum":"税号","cpAddress":"公司地址","cpPhone":"公司电话","cpBank":"开户银行","cpBankNum":"银行账户","status":"状态","remark":"备注","updateBy":"更新人","updateDate":"更新日期"},"subject":{"id":"ID","parentId":"父级","companyId":"公司ID","code":"编码","name":"名称","subjectType":"类别","category":"科目类别","subjectLevel":"级别","direction":"余额方向"}}}')},"5a1f":function(a,e,t){},"6def":function(a,e,t){"use strict";var o=t("5a1f"),r=t.n(o);r.a},b607:function(a,e,t){"use strict";t.r(e);var o=function(){var a=this,e=a.$createElement,t=a._self._c||e;return t("div",[t("el-dialog",{attrs:{visible:a.visible,title:a.isNew?"新增":"修改","close-on-click-modal":!1,"close-on-press-escape":!1,width:"55%"},on:{"update:visible":function(e){a.visible=e}}},[t("el-form",{ref:"dataForm",staticClass:"tb-matthew",attrs:{model:a.dataForm,rules:a.rules,"label-width":"100px",inline:!0,labelSuffix:"：",size:"mini"}},[t("el-form-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{prop:"id"}}),t("el-form-item",{attrs:{prop:"code",label:a.data.form.invoice.code}},[t("el-input",{attrs:{placeholder:a.data.form.invoice.code,disabled:a.dataForm.id},model:{value:a.dataForm.code,callback:function(e){a.$set(a.dataForm,"code",e)},expression:"dataForm.code"}})],1),t("el-form-item",{attrs:{prop:"name",label:a.data.form.invoice.name}},[t("el-input",{attrs:{placeholder:a.data.form.invoice.name},model:{value:a.dataForm.name,callback:function(e){a.$set(a.dataForm,"name",e)},expression:"dataForm.name"}})],1),t("el-form-item",{attrs:{prop:"ivDate",label:a.data.form.invoice.ivDate}},[t("el-date-picker",{attrs:{type:"date",placeholder:a.data.form.invoice.ivDate},model:{value:a.data.ivDate,callback:function(e){a.$set(a.data,"ivDate",e)},expression:"data.ivDate"}})],1),t("el-form-item",{attrs:{prop:"amount",label:a.data.form.invoice.amount}},[t("el-input",{attrs:{placeholder:a.data.form.invoice.amount},model:{value:a.dataForm.amount,callback:function(e){a.$set(a.dataForm,"amount",a._n(e))},expression:"dataForm.amount"}})],1),t("el-form-item",{attrs:{prop:"ivType",label:a.data.form.invoice.ivType}},[t("im-selector",{attrs:{placeholder:"请选择票据分类",mapModel:a.dataForm,mapKeyVal:"ivName:ivType"},on:{"update:mapModel":function(e){a.dataForm=e},"update:map-model":function(e){a.dataForm=e}},model:{value:a.dataForm.ivType,callback:function(e){a.$set(a.dataForm,"ivType",e)},expression:"dataForm.ivType"}})],1),t("el-form-item",{attrs:{prop:"summary",label:a.data.form.invoice.summary}},[t("el-input",{attrs:{placeholder:a.data.form.invoice.summary},model:{value:a.dataForm.summary,callback:function(e){a.$set(a.dataForm,"summary",e)},expression:"dataForm.summary"}})],1),t("el-form-item",{attrs:{prop:"customerName",label:a.data.form.invoice.customerName}},[t("im-selector",{attrs:{placeholder:"请选择单位",mapModel:a.dataForm,mapKeyVal:"customerName:customerId",dataType:"biz.customersearch"},on:{"update:mapModel":function(e){a.dataForm=e},"update:map-model":function(e){a.dataForm=e},change:a.changeCust},model:{value:a.dataForm.customerName,callback:function(e){a.$set(a.dataForm,"customerName",e)},expression:"dataForm.customerName"}})],1),t("el-form-item",{attrs:{prop:"taxNum",label:a.data.form.invoice.taxNum}},[t("el-input",{attrs:{placeholder:a.data.form.invoice.taxNum},model:{value:a.dataForm.taxNum,callback:function(e){a.$set(a.dataForm,"taxNum",e)},expression:"dataForm.taxNum"}})],1),t("el-form-item",{attrs:{prop:"cpAddress",label:a.data.form.invoice.cpAddress}},[t("el-input",{attrs:{placeholder:a.data.form.invoice.cpAddress},model:{value:a.dataForm.cpAddress,callback:function(e){a.$set(a.dataForm,"cpAddress",e)},expression:"dataForm.cpAddress"}})],1),t("el-form-item",{attrs:{prop:"cpPhone",label:a.data.form.invoice.cpPhone}},[t("el-input",{attrs:{placeholder:a.data.form.invoice.cpPhone},model:{value:a.dataForm.cpPhone,callback:function(e){a.$set(a.dataForm,"cpPhone",e)},expression:"dataForm.cpPhone"}})],1),t("el-form-item",{attrs:{prop:"cpBank",label:a.data.form.invoice.cpBank}},[t("el-input",{attrs:{placeholder:a.data.form.invoice.cpBank},model:{value:a.dataForm.cpBank,callback:function(e){a.$set(a.dataForm,"cpBank",e)},expression:"dataForm.cpBank"}})],1),t("el-form-item",{attrs:{prop:"cpBankNum",label:a.data.form.invoice.cpBankNum}},[t("el-input",{attrs:{placeholder:a.data.form.invoice.cpBankNum},model:{value:a.dataForm.cpBankNum,callback:function(e){a.$set(a.dataForm,"cpBankNum",e)},expression:"dataForm.cpBankNum"}})],1),t("el-form-item",{attrs:{prop:"status",label:a.data.form.invoice.status}},[t("el-radio-group",{model:{value:a.dataForm.status,callback:function(e){a.$set(a.dataForm,"status",e)},expression:"dataForm.status"}},[t("el-radio",{attrs:{label:1}},[a._v("是")]),t("el-radio",{attrs:{label:0}},[a._v("否")])],1)],1),t("el-form-item",{attrs:{prop:"remark",label:a.data.form.invoice.remark}},[t("el-input",{attrs:{placeholder:a.data.form.invoice.remark},model:{value:a.dataForm.remark,callback:function(e){a.$set(a.dataForm,"remark",e)},expression:"dataForm.remark"}})],1)],1),t("template",{slot:"footer"},[t("el-button",{on:{click:function(e){a.visible=!1}}},[a._v(a._s(a.$t("views.public.cancel")))]),t("el-button",{attrs:{type:"primary"},on:{click:a.dataFormSubmit}},[a._v(a._s(a.$t("views.public.confirm")))])],1)],2)],1)},r=[],i=t("0d78"),m=t("e1a58"),d={mixins:[m["a"]],data:function(){var a=this,e=function(e,t,o){if(t){var r={};a.dataForm.id&&(r.id=a.dataForm.id),r.code=t,a.$axios({url:"/fin/invoice/checkCode",method:"post",data:r}).then((function(a){a>0?o(new Error("编码重复，请重新指定")):o()}))}else o(new Error("编码必须被填写"))},t=function(a,e,t){if(e){var o=/((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d)|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d))$)/;o.test(e)?t():t(new Error("输入的电话号码不符合格式"))}else t()};return{custVisible:!1,mixinViewModuleOptions:{getDataListURL:"/fin/invoice/list",updateURL:"/fin/invoice/save",getDataListIsPage:!1,activatedIsNeed:!1},data:i,visible:!1,dataForm:{code:void 0,name:void 0,customerName:void 0,customerId:void 0,ivDate:void 0,amount:void 0,summary:void 0,ivType:void 0,cpName:void 0,taxNum:void 0,cpAddress:void 0,cpPhone:void 0,cpBank:void 0,cpBankNum:void 0,status:1,remark:void 0},rules:{code:[{validator:e,trigger:"blur"}],name:[{required:!0,message:"名称不可缺少"}],cpPhone:[{validator:t,trigger:"blur"}],amount:[{type:"number",message:"票据金额必须为数字类型",trigger:"blur"}]}}},methods:{changeCust:function(a){a&&(this.dataForm.customerId=a.ID,this.dataForm.taxNum=a.TAX_NUM,this.dataForm.cpAddress=a.COMPANY_ADDRESS,this.dataForm.cpPhone=a.TEL,this.dataForm.cpBankNum=a.BANK_ACCOUNT,this.dataForm.cpBank=a.BANK)}},watch:{visible:function(a,e){if(a){var t=new Date;this.dataForm.ivDate=t}}}},n=d,c=(t("6def"),t("623f")),s=function(a){a.options.__source="src/views/fin/invoice/add-or-update.vue"},l=s,u=Object(c["a"])(n,o,r,!1,null,null,null);"function"===typeof l&&l(u);e["default"]=u.exports}}]);