(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-6ba44870","chunk-2d0f02c0"],{"0e32":function(e,a,t){"use strict";var o=t("ecc2"),r=t.n(o);r.a},"9adf":function(e){e.exports=JSON.parse('{"form":{"input":{"warehouse":"仓库","warehouseName":"请输入仓库名称","name":"货位名称","remark":"备注","productId":"物料","productName":"物料"}}}')},c624:function(e,a,t){"use strict";t.r(a);var o=function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("el-dialog",{staticClass:"dlg-matthew",attrs:{visible:e.visible,title:e.isNew?e.$t("views.public.add"):e.$t("views.public.update"),"close-on-click-modal":!1,"close-on-press-escape":!1,width:"400px"},on:{"update:visible":function(a){e.visible=a}}},[t("el-form",{ref:"dataForm",staticClass:"tb-matthew",attrs:{model:e.dataForm,rules:e.rules,"label-width":"120px",labelSuffix:"：",size:"mini"}},[t("el-form-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{prop:"id"}}),t("el-form-item",{attrs:{prop:"productId",label:e.data.form.input.productId}},[t("im-selector",{staticStyle:{width:"300px"},attrs:{placeholder:"请选择产品",mapModel:e.dataForm,mapKeyVal:"productName:productId",dataType:"bizall.product",disabled:e.dataForm.id},on:{"update:mapModel":function(a){e.dataForm=a},"update:map-model":function(a){e.dataForm=a}},model:{value:e.dataForm.productId,callback:function(a){e.$set(e.dataForm,"productId",a)},expression:"dataForm.productId"}})],1),t("el-form-item",{attrs:{prop:"warehouseId",label:e.data.form.input.warehouse}},[t("im-selector",{attrs:{placeholder:"请选择仓库",mapModel:e.dataForm,mapKeyVal:"warehouseName:warehouseId",dataType:"biz.warehouse"},on:{"update:mapModel":function(a){e.dataForm=a},"update:map-model":function(a){e.dataForm=a}},model:{value:e.dataForm.warehouseId,callback:function(a){e.$set(e.dataForm,"warehouseId",a)},expression:"dataForm.warehouseId"}})],1),t("el-form-item",{attrs:{prop:"name",label:e.data.form.input.name}},[t("el-input",{staticStyle:{width:"200px"},attrs:{placeholder:e.data.form.input.name},model:{value:e.dataForm.name,callback:function(a){e.$set(e.dataForm,"name",a)},expression:"dataForm.name"}})],1),t("el-form-item",{attrs:{prop:"remark",label:e.data.form.input.remark}},[t("el-input",{staticStyle:{width:"200px"},attrs:{placeholder:e.data.form.input.remark},model:{value:e.dataForm.remark,callback:function(a){e.$set(e.dataForm,"remark",a)},expression:"dataForm.remark"}})],1)],1),t("template",{slot:"footer"},[t("el-button",{on:{click:function(a){e.visible=!1}}},[e._v(e._s(e.$t("views.public.cancel")))]),t("el-button",{attrs:{type:"primary"},on:{click:function(a){return e.dataFormSubmitHandle()}}},[e._v(e._s(e.$t("views.public.confirm")))])],1)],2)},r=[],s=t("9adf"),i=t("e1a58"),d={mixins:[i["a"]],data:function(){return{mixinViewModuleOptions:{getDataListURL:"/base/warehouseslot/list",updateURL:"/base/warehouseslot/save",getDataListIsPage:!1,activatedIsNeed:!1},data:s,visible:!1,dataForm:{id:void 0,warehouseId:void 0,name:void 0,remark:void 0,productId:void 0},rules:{name:[{required:!0,message:"名称不可缺少"}],code:[{required:!0,message:"编码不可缺少"}],warehouseId:[{required:!0,message:"仓库不可缺少"}],productId:[{required:!0,message:"产品不可缺少"}]}}},methods:{dataFormSubmitHandle:function(){var e=this,a=this;this.$refs["dataForm"].validate((function(t){if(!t)return!1;a.$axios({url:"/base/warehouseslot/save",method:"post",data:a.dataForm}).then((function(a){e.$message({message:e.$t("views.public.success"),type:"success",duration:500,onClose:function(){e.visible=!1,e.$emit("refreshDataList")}})})).catch((function(){}))}))}}},l=d,u=(t("0e32"),t("623f")),n=function(e){e.options.__source="src/views/base/wareslot/add-or-update.vue"},m=n,c=Object(u["a"])(l,o,r,!1,null,null,null);"function"===typeof m&&m(c);a["default"]=c.exports},ecc2:function(e,a,t){}}]);