(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-f179881a","chunk-2d213957"],{"2b3a":function(a,t,e){},"811b":function(a,t,e){"use strict";e.r(t);var r=function(){var a=this,t=a.$createElement,e=a._self._c||t;return e("el-dialog",{attrs:{visible:a.visible,title:a.isNew?a.$t("views.public.add"):a.$t("views.public.update"),"close-on-click-modal":!1,"close-on-press-escape":!1,width:"750px"},on:{"update:visible":function(t){a.visible=t}}},[e("el-form",{ref:"dataForm",staticClass:"tb-matthew",attrs:{model:a.dataForm,rules:a.rules,"label-width":"120px",inline:!0,labelSuffix:"：",size:"mini"}},[e("el-form-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{prop:"id"}}),e("el-form-item",{attrs:{prop:"prodno",label:a.data.form.input.prodno}},[e("el-input",{attrs:{placeholder:a.data.form.input.prodno,disabled:a.dataForm.id},model:{value:a.dataForm.prodno,callback:function(t){a.$set(a.dataForm,"prodno",t)},expression:"dataForm.prodno"}})],1),e("el-form-item",{attrs:{prop:"name",label:a.data.form.input.name}},[e("el-input",{attrs:{placeholder:a.data.form.input.name,disabled:a.dataForm.id},model:{value:a.dataForm.name,callback:function(t){a.$set(a.dataForm,"name",t)},expression:"dataForm.name"}})],1),e("el-form-item",{attrs:{prop:"manufacture",label:a.data.form.input.manufacture}},[e("el-input",{attrs:{placeholder:a.data.form.input.manufacture,disabled:a.dataForm.id},model:{value:a.dataForm.manufacture,callback:function(t){a.$set(a.dataForm,"manufacture",t)},expression:"dataForm.manufacture"}})],1),e("el-form-item",{attrs:{prop:"approvalno",label:a.data.form.input.approvalno}},[e("el-input",{attrs:{placeholder:a.data.form.input.approvalno,disabled:a.dataForm.id},model:{value:a.dataForm.approvalno,callback:function(t){a.$set(a.dataForm,"approvalno",t)},expression:"dataForm.approvalno"}})],1),e("el-form-item",{attrs:{prop:"busitypetext",label:a.data.form.input.busitypetext}},[e("el-input",{attrs:{placeholder:a.data.form.input.busitypetext,disabled:a.dataForm.id},model:{value:a.dataForm.busitypetext,callback:function(t){a.$set(a.dataForm,"busitypetext",t)},expression:"dataForm.busitypetext"}})],1),e("el-form-item",{attrs:{prop:"midpackagequantity",label:a.data.form.input.midpackagequantity}},[e("el-input",{attrs:{placeholder:a.data.form.input.midpackagequantity,disabled:a.dataForm.id},model:{value:a.dataForm.midpackagequantity,callback:function(t){a.$set(a.dataForm,"midpackagequantity",t)},expression:"dataForm.midpackagequantity"}})],1),e("el-form-item",{attrs:{prop:"bigpackagequantity",label:a.data.form.input.bigpackagequantity}},[e("el-input",{attrs:{placeholder:a.data.form.input.bigpackagequantity,disabled:a.dataForm.id},model:{value:a.dataForm.bigpackagequantity,callback:function(t){a.$set(a.dataForm,"bigpackagequantity",t)},expression:"dataForm.bigpackagequantity"}})],1),e("el-form-item",{attrs:{prop:"purchaser",label:a.data.form.input.purchaser}},[e("el-input",{attrs:{placeholder:a.data.form.input.purchaser},model:{value:a.dataForm.purchaser,callback:function(t){a.$set(a.dataForm,"purchaser",t)},expression:"dataForm.purchaser"}})],1),e("el-form-item",{attrs:{prop:"specialParam",label:a.data.form.input.specialParam}},[e("el-input",{attrs:{placeholder:a.data.form.input.specialParam,disabled:a.dataForm.id},model:{value:a.dataForm.specialParam,callback:function(t){a.$set(a.dataForm,"specialParam",t)},expression:"dataForm.specialParam"}})],1),e("el-form-item",{attrs:{prop:"unit",label:a.data.form.input.unit}},[e("el-input",{attrs:{placeholder:a.data.form.input.unit,disabled:a.dataForm.id},model:{value:a.dataForm.unit,callback:function(t){a.$set(a.dataForm,"unit",t)},expression:"dataForm.unit"}})],1),e("el-form-item",{attrs:{prop:"sterilization",label:a.data.form.input.sterilization}},[e("el-input",{attrs:{placeholder:a.data.form.input.sterilization,disabled:a.dataForm.id},model:{value:a.dataForm.sterilization,callback:function(t){a.$set(a.dataForm,"sterilization",t)},expression:"dataForm.sterilization"}})],1),e("el-form-item",{attrs:{prop:"status",label:a.data.form.input.status}},[e("el-input",{attrs:{placeholder:a.data.form.input.status},model:{value:a.dataForm.status,callback:function(t){a.$set(a.dataForm,"status",t)},expression:"dataForm.status"}})],1),e("el-form-item",{attrs:{prop:"remark",label:a.data.form.input.remark}},[e("el-input",{attrs:{placeholder:a.data.form.input.remark},model:{value:a.dataForm.remark,callback:function(t){a.$set(a.dataForm,"remark",t)},expression:"dataForm.remark"}})],1)],1),e("template",{slot:"footer"},[e("el-button",{on:{click:function(t){a.visible=!1}}},[a._v(a._s(a.$t("views.public.cancel")))]),e("el-button",{attrs:{type:"primary"},on:{click:function(t){return a.dataFormSubmitHandle()}}},[a._v(a._s(a.$t("views.public.confirm")))])],1)],2)},o=[],i=(e("cc57"),e("acfe")),d=e("e1a58"),n={mixins:[d["a"]],data:function(){var a=this,t=function(t,e,r){if(e){var o={};a.dataForm.name&&(o.name=a.dataForm.name),a.dataForm.prodno&&(o.prodno=a.dataForm.prodno),a.dataForm.id&&(o.id=a.dataForm.id),a.$axios({url:"/base/product/checkCode",method:"post",data:o}).then((function(a){a?r(new Error(a)):r()}))}else r(new Error("内容不能为空"))},e=function(t,e,r){if(e){var o={};o.name=e,a.dataForm.id&&(o.id=a.dataForm.id),a.$axios({url:"/base/product/checkCode",method:"post",data:o}).then((function(a){a?r(new Error(a)):r()}))}else r(new Error("内容不能为空"))};return{mixinViewModuleOptions:{getDataListURL:"/base/product/list",updateURL:"/base/product/save",getDataListIsPage:!1,activatedIsNeed:!1},data:i,visible:!1,dataForm:{id:void 0,prodno:void 0,name:void 0,manufacture:void 0,approvalno:void 0,bigpackagequantity:void 0,midpackagequantity:void 0,busitypetext:void 0,purchaser:void 0,sterilization:void 0,specialParam:void 0,unit:void 0,defaultVendorId:void 0,status:void 0,pinyinCode:void 0,remark:void 0},rules:{cateCode:[{validator:e,trigger:"blur"}],code:[{validator:t,trigger:"blur"}],barCode:[{validator:t,trigger:"blur"}]}}},methods:{dataFormSubmitHandle:function(){var a=this,t=this;this.$refs["dataForm"].validate((function(e){if(!e)return!1;t.$axios({url:"/base/product/save",method:"post",data:t.dataForm}).then((function(t){a.$message({message:a.$t("views.public.success"),type:"success",duration:500,onClose:function(){a.visible=!1,a.$emit("refreshDataList")}})})).catch((function(){}))}))}}},l=n,s=(e("b257"),e("623f")),p=function(a){a.options.__source="src/views/base/product/add-or-update.vue"},u=p,m=Object(s["a"])(l,r,o,!1,null,null,null);"function"===typeof u&&u(m);t["default"]=m.exports},acfe:function(a){a.exports=JSON.parse('{"form":{"input":{"prodno":"商品编码","name":"商品名称","approvalno":"批准文号","bigpackagequantity":"大包装数量","midpackagequantity":"中包装数量","busitypetext":"业务类型","manufacture":"生产厂家","purchaser":"采购员","sterilization":"灭菌批号","specialParam":"规格属性","unit":"包装单位","defaultVendorId":"默认供应商","status":"商品状态","pinyinCode":"助记码","remark":"备注","companyId":"公司"}}}')},b257:function(a,t,e){"use strict";var r=e("2b3a"),o=e.n(r);o.a}}]);