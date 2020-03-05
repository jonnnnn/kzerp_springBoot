(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-4c837158","chunk-2d0dea85"],{"871a":function(e){e.exports=JSON.parse('{"form":{"columns":[{"title":"需求日期","field":"requirementDate","sortable":true,"align":"center","width":"110px"},{"title":"公司编号","field":"companyId","sortable":true,"align":"center","width":"110px"},{"title":"产品Id","field":"productId","sortable":true,"align":"center","width":"110px"},{"title":"仓库Id","field":"warehouseId","sortable":true,"align":"center","width":"110px"},{"title":"保留类型","field":"tranType","sortable":true,"align":"center","width":"110px"},{"title":"需求来源单头Id","field":"demandSourceHeaderId","sortable":true,"align":"center","width":"140px"},{"title":"需求来源行Id","field":"demandSourceLineId","sortable":true,"align":"center","width":"160px"},{"title":"保留量计量单位","field":"reservationUomCode","sortable":true,"align":"center","width":"140px"},{"title":"保留数量","field":"reservationQuantity","sortable":true,"align":"center","width":"110px"},{"title":"备注","field":"remark","sortable":true,"align":"center"},{"title":"修改人","field":"updateBy","sortable":true,"align":"center","width":"110px"},{"title":"修改日期","field":"updateDate","sortable":true,"align":"center","width":"110px"}],"input":{"requirementDate":"需求日期","companyId":"公司ID","productId":"产品ID","warehouseId":"仓库ID","tranType":"保留类型","demandSourceHeaderId":"需求来源单头ID","demandSourceLineId":"需求来源行ID","reservationUomCode":"保留量计量单位","reservationQuantity":"保留数量","remark":"备注"}}}')},9966:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{visible:e.visible,title:e.isNew?e.$t("views.public.add"):e.$t("views.public.update"),"close-on-click-modal":!1,"close-on-press-escape":!1,width:"800px"},on:{"update:visible":function(t){e.visible=t}}},[a("el-form",{ref:"dataForm",attrs:{model:e.dataForm,rules:e.rules,"label-width":"120px",inline:!0}},[a("el-form-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{prop:"id"}}),a("el-form-item",{attrs:{prop:"requirementDate",label:e.data.form.input.requirementDate}},[a("el-date-picker",{attrs:{"value-format":"yyyy-MM-dd",type:"date",placeholder:e.data.form.input.requirementDate},model:{value:e.dataForm.requirementDate,callback:function(t){e.$set(e.dataForm,"requirementDate",t)},expression:"dataForm.requirementDate"}})],1),a("el-form-item",{attrs:{prop:"productId",label:e.data.form.input.productId}},[a("el-input",{attrs:{placeholder:e.data.form.input.productId},model:{value:e.dataForm.productId,callback:function(t){e.$set(e.dataForm,"productId",t)},expression:"dataForm.productId"}})],1),a("el-form-item",{attrs:{prop:"warehouseId",label:e.data.form.input.warehouseId}},[a("el-input",{attrs:{placeholder:e.data.form.input.warehouseId},model:{value:e.dataForm.warehouseId,callback:function(t){e.$set(e.dataForm,"warehouseId",t)},expression:"dataForm.warehouseId"}})],1),a("el-form-item",{attrs:{prop:"tranType",label:e.data.form.input.tranType}},[a("el-input",{attrs:{placeholder:e.data.form.input.tranType},model:{value:e.dataForm.tranType,callback:function(t){e.$set(e.dataForm,"tranType",t)},expression:"dataForm.tranType"}})],1),a("el-form-item",{attrs:{prop:"demandSourceHeaderId",label:e.data.form.input.demandSourceHeaderId}},[a("el-input",{attrs:{placeholder:e.data.form.input.demandSourceHeaderId},model:{value:e.dataForm.demandSourceHeaderId,callback:function(t){e.$set(e.dataForm,"demandSourceHeaderId",t)},expression:"dataForm.demandSourceHeaderId"}})],1),a("el-form-item",{attrs:{prop:"demandSourceLineId",label:e.data.form.input.demandSourceLineId}},[a("el-input",{attrs:{placeholder:e.data.form.input.demandSourceLineId},model:{value:e.dataForm.demandSourceLineId,callback:function(t){e.$set(e.dataForm,"demandSourceLineId",t)},expression:"dataForm.demandSourceLineId"}})],1),a("el-form-item",{attrs:{prop:"reservationUomCode",label:e.data.form.input.reservationUomCode}},[a("el-input",{attrs:{placeholder:e.data.form.input.reservationUomCode},model:{value:e.dataForm.reservationUomCode,callback:function(t){e.$set(e.dataForm,"reservationUomCode",t)},expression:"dataForm.reservationUomCode"}})],1),a("el-form-item",{attrs:{prop:"reservationQuantity",label:e.data.form.input.reservationQuantity}},[a("el-input",{attrs:{placeholder:e.data.form.input.reservationQuantity},model:{value:e.dataForm.reservationQuantity,callback:function(t){e.$set(e.dataForm,"reservationQuantity",t)},expression:"dataForm.reservationQuantity"}})],1),a("el-form-item",{attrs:{prop:"remark",label:e.data.form.input.remark}},[a("el-input",{attrs:{placeholder:e.data.form.input.remark},model:{value:e.dataForm.remark,callback:function(t){e.$set(e.dataForm,"remark",t)},expression:"dataForm.remark"}})],1)],1)],1)},o=[],d=a("871a"),i=a("e1a58"),n={mixins:[i["a"]],data:function(){return{mixinViewModuleOptions:{getDataListURL:"/base/reservation/list",updateURL:"/base/reservation/save",getDataListIsPage:!1,activatedIsNeed:!1},data:d,visible:!1,dataForm:{requirementDate:void 0,companyId:void 0,productId:void 0,warehouseId:void 0,tranType:void 0,demandSourceHeaderId:void 0,demandSourceLineId:void 0,reservationUomCode:void 0,reservationQuantity:void 0,remark:void 0},rules:{name:[{required:!0,message:"名称不可缺少"}],code:[{required:!0,message:"编码不可缺少"}]}}},methods:{init:function(){var e=this;this.visible=!0,this.$nextTick((function(){e.$refs["dataForm"].resetFields(),e.dataForm.id&&(e.dataForm.id=void 0),e.$refs["dataForm"].clearValidate()}))},update:function(e){var t=this;this.visible=!0,this.$nextTick((function(){t.dataForm=Object.assign({},e),t.$refs["dataForm"].clearValidate()}))},dataFormSubmitHandle:function(){var e=this,t=this;this.$refs["dataForm"].validate((function(a){if(!a)return!1;t.$axios({url:"/base/reservation/save",method:"post",data:t.dataForm}).then((function(t){e.$message({message:e.$t("views.public.success"),type:"success",duration:500,onClose:function(){e.visible=!1,e.$emit("refreshDataList")}})})).catch((function(){}))}))}}},l=n,s=a("623f"),u=function(e){e.options.__source="src/views/base/inv/add-or-update.vue"},m=u,c=Object(s["a"])(l,r,o,!1,null,null,null);"function"===typeof m&&m(c);t["default"]=c.exports}}]);