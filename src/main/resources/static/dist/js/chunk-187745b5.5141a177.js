(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-187745b5","chunk-2d0c7eb2"],{"3d50":function(t,a,e){"use strict";var r=e("8ed1"),i=e.n(r);i.a},"506d":function(t,a,e){"use strict";e.r(a);var r=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",[e("el-dialog",{attrs:{visible:t.visible,title:t.isNew?t.$t("views.public.add"):t.$t("views.public.update"),"close-on-click-modal":!1,"close-on-press-escape":!1,width:"55%"},on:{"update:visible":function(a){t.visible=a}}},[e("el-form",{ref:"dataForm",staticClass:"tb-matthew",attrs:{model:t.dataForm,rules:t.rules,inline:!0,"label-width":"105px",labelSuffix:"：",size:"mini"}},[e("el-form-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{prop:"id"}}),e("el-form-item",{attrs:{prop:"pname",label:t.data.data.input.pname},nativeOn:{click:function(a){return t.showPid(a)}}},[e("el-input",{attrs:{placeholder:t.data.data.input.pname},model:{value:t.dataForm.pname,callback:function(a){t.$set(t.dataForm,"pname",a)},expression:"dataForm.pname"}})],1),e("el-form-item",{attrs:{prop:"type",label:t.data.data.input.type}},[e("el-input",{attrs:{placeholder:t.data.data.input.type},model:{value:t.dataForm.type,callback:function(a){t.$set(t.dataForm,"type",a)},expression:"dataForm.type"}})],1),e("el-form-item",{attrs:{prop:"code",label:t.data.data.input.code}},[e("el-input",{attrs:{placeholder:t.data.data.input.code,disabled:t.dataForm.id},model:{value:t.dataForm.code,callback:function(a){t.$set(t.dataForm,"code",a)},expression:"dataForm.code"}})],1),e("el-form-item",{attrs:{prop:"name",label:t.data.data.input.name}},[e("el-input",{attrs:{placeholder:t.data.data.input.name},model:{value:t.dataForm.name,callback:function(a){t.$set(t.dataForm,"name",a)},expression:"dataForm.name"}})],1),e("el-form-item",{attrs:{prop:"orderNum",label:t.data.data.input.orderNum}},[e("el-input",{attrs:{placeholder:t.data.data.input.orderNum},model:{value:t.dataForm.orderNum,callback:function(a){t.$set(t.dataForm,"orderNum",a)},expression:"dataForm.orderNum"}})],1),e("el-form-item",{attrs:{prop:"sys",label:t.data.data.input.sys}},[e("el-radio-group",{model:{value:t.dataForm.sys,callback:function(a){t.$set(t.dataForm,"sys",a)},expression:"dataForm.sys"}},[e("el-radio",{attrs:{label:1}},[t._v("是")]),e("el-radio",{attrs:{label:0}},[t._v("否")])],1)],1),e("el-form-item",{attrs:{prop:"remark",label:t.data.data.input.remark}},[e("el-input",{attrs:{placeholder:t.data.data.input.remark},model:{value:t.dataForm.remark,callback:function(a){t.$set(t.dataForm,"remark",a)},expression:"dataForm.remark"}})],1),e("el-form-item",{attrs:{prop:"attr1",label:t.data.data.input.attr1}},[e("el-input",{attrs:{placeholder:t.data.data.input.attr1},model:{value:t.dataForm.attr1,callback:function(a){t.$set(t.dataForm,"attr1",a)},expression:"dataForm.attr1"}})],1),e("el-form-item",{attrs:{prop:"attr2",label:t.data.data.input.attr2}},[e("el-input",{attrs:{placeholder:t.data.data.input.attr2},model:{value:t.dataForm.attr2,callback:function(a){t.$set(t.dataForm,"attr2",a)},expression:"dataForm.attr2"}})],1),e("el-form-item",{attrs:{prop:"attr3",label:t.data.data.input.attr3}},[e("el-input",{attrs:{placeholder:t.data.data.input.attr3},model:{value:t.dataForm.attr3,callback:function(a){t.$set(t.dataForm,"attr3",a)},expression:"dataForm.attr3"}})],1),e("el-form-item",{attrs:{prop:"attr4",label:t.data.data.input.attr4}},[e("el-input",{attrs:{placeholder:t.data.data.input.attr4},model:{value:t.dataForm.attr4,callback:function(a){t.$set(t.dataForm,"attr4",a)},expression:"dataForm.attr4"}})],1),e("el-form-item",{attrs:{prop:"attr5",label:t.data.data.input.attr5}},[e("el-input",{attrs:{placeholder:t.data.data.input.attr5},model:{value:t.dataForm.attr5,callback:function(a){t.$set(t.dataForm,"attr5",a)},expression:"dataForm.attr5"}})],1)],1),e("template",{slot:"footer"},[e("el-button",{on:{click:function(a){t.visible=!1}}},[t._v(t._s(t.$t("views.public.cancel")))]),e("el-button",{attrs:{type:"primary"},on:{click:t.dataFormSubmit}},[t._v(t._s(t.$t("views.public.confirm")))])],1)],2),e("el-dialog",{attrs:{title:"菜单选择",visible:t.menuFormVisible,width:"388px"},on:{"update:visible":function(a){t.menuFormVisible=a}}},[e("el-input",{attrs:{placeholder:"输入关键字进行过滤"},nativeOn:{keyup:function(a){return!a.type.indexOf("key")&&t._k(a.keyCode,"enter",13,a.key,"Enter")?null:t.getParentData(a)}},model:{value:t.filterText,callback:function(a){t.filterText=a},expression:"filterText"}}),e("el-tree",{ref:"tree",staticClass:"tree-container",staticStyle:{height:"300px"},attrs:{data:t.menuList,props:t.defaultProps,"node-key":"id","default-expand-all":"","filter-node-method":t.filterNode},on:{"node-click":t.getSelectedMenu}}),e("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[e("div",{staticClass:"menuDia"},[e("el-button",{on:{click:function(a){t.menuFormVisible=!1}}},[t._v("取消")]),e("el-button",{attrs:{type:"primary"},on:{click:t.getSelectedMenu}},[t._v("确定")])],1)])],1)],1)},i=[],o=(e("cc57"),e("e1a58")),d=e("5353"),l={mixins:[o["a"]],data:function(){var t=this,a=function(a,e,r){if(e){var i={};t.dataForm.id&&(i.id=t.dataForm.id),i.code=e,t.$axios({url:"/base/tree/checkCode",method:"post",data:i}).then((function(t){t>0?r(new Error("编码重复，请重新指定")):r()}))}else r(new Error("编码必须被填写"))};return{mixinViewModuleOptions:{getDataListURL:"/base/tree/list",updateURL:"/base/tree/save",getDataListIsPage:!1,activatedIsNeed:!1},filterText:void 0,menuList:[],parentDataList:[],defaultProps:{children:"children",label:"name",id:"id"},data:d,visible:!1,dataForm:{id:void 0,parentId:void 0,type:void 0,code:void 0,name:void 0,orderNum:0,sys:0,companyId:void 0,remark:void 0,attr1:void 0,attr2:void 0,attr3:void 0,attr4:void 0,attr5:void 0,pname:void 0},rules:{code:[{validator:a,trigger:"blur"}],name:[{required:!0,message:"名称不可缺少",trigger:"blur"}],pname:[{required:!0,message:"父级菜单不可缺少"}],type:[{required:!0,message:"类型不可缺少",trigger:"blur"},{max:6,message:"此处最多6个字符",trigger:"blur"}]},menuFormVisible:!1}},watch:{filterText:function(t){},parentDataList:function(t){this.menuList=[{id:0,name:"顶级菜单",children:this.parentDataList}]}},methods:{showPid:function(){this.menuFormVisible=!0},getSelectedMenu:function(){var t=this.$refs.tree.getCurrentNode();this.dataForm.pname=t.name,this.dataForm.parentId=t.id,this.menuFormVisible=!1},filterNode:function(t,a){return!t||-1!==a.label.indexOf(t)},getParentData:function(){var t=this,a={data:{}};a.data.name=this.filterText,this.$axios.post("/base/tree/nolist",{dataForm:a}).then((function(a){t.parentDataList=a}))}},created:function(){this.getParentData()}},n=l,s=(e("3d50"),e("623f")),m=function(t){t.options.__source="src/views/base/tree/add-or-update.vue"},u=m,p=Object(s["a"])(n,r,i,!1,null,null,null);"function"===typeof u&&u(p);a["default"]=p.exports},5353:function(t){t.exports=JSON.parse('{"data":{"input":{"pname":"父级菜单","parentId":"父级菜单","type":"类型","code":"编码","name":"名称","orderNum":"排序序号","sys":"系统数据与否","companyId":"公司ID","remark":"备注","attr1":"扩展弹性域1","attr2":"扩展弹性域2","attr3":"扩展弹性域3","attr4":"扩展弹性域4","attr5":"扩展弹性域5"}}}')},"8ed1":function(t,a,e){}}]);