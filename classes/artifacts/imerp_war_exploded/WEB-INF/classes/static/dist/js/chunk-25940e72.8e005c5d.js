(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-25940e72","chunk-2d0cb790"],{"4a8e":function(e){e.exports=JSON.parse('{"form":{"input":{"productId":"产品","salePrice":"默认销售价","costPrice":"当前成本价","remark":"备注"}}}')},a49b:function(e,t,a){"use strict";var r=a("ebc3e"),i=a.n(r);i.a},e1a5:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{visible:e.visible,title:e.isNew?e.$t("views.public.add"):e.$t("views.public.update"),"close-on-click-modal":!1,"close-on-press-escape":!1,width:"388px"},on:{"update:visible":function(t){e.visible=t}}},[a("el-form",{ref:"dataForm",staticClass:"tb-matthew",attrs:{model:e.dataForm,rules:e.rules,"label-width":"120px",labelSuffix:"：",size:"mini"}},[a("el-form-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{prop:"id"}}),a("el-form-item",{attrs:{prop:"productId",label:e.data.form.input.productId}},[a("im-selector",{staticStyle:{width:"300px"},attrs:{placeholder:"请选择产品",mapModel:e.dataForm,mapKeyVal:"productName:productId",dataType:"bizall.priceproduct",disabled:e.dataForm.productId},on:{"update:mapModel":function(t){e.dataForm=t},"update:map-model":function(t){e.dataForm=t}},model:{value:e.dataForm.productId,callback:function(t){e.$set(e.dataForm,"productId",t)},expression:"dataForm.productId"}})],1),a("el-form-item",{attrs:{prop:"salePrice",label:e.data.form.input.salePrice}},[a("el-input",{staticStyle:{width:"193px"},attrs:{placeholder:e.data.form.input.salePrice},model:{value:e.dataForm.salePrice,callback:function(t){e.$set(e.dataForm,"salePrice",e._n(t))},expression:"dataForm.salePrice"}})],1),a("el-form-item",{attrs:{prop:"costPrice",label:e.data.form.input.costPrice}},[a("el-input",{staticStyle:{width:"193px"},attrs:{placeholder:e.data.form.input.costPrice},model:{value:e.dataForm.costPrice,callback:function(t){e.$set(e.dataForm,"costPrice",e._n(t))},expression:"dataForm.costPrice"}})],1),a("el-form-item",{attrs:{prop:"remark",label:e.data.form.input.remark}},[a("el-input",{staticStyle:{width:"193px"},attrs:{placeholder:e.data.form.input.remark},model:{value:e.dataForm.remark,callback:function(t){e.$set(e.dataForm,"remark",t)},expression:"dataForm.remark"}})],1)],1),a("template",{slot:"footer"},[a("el-button",{on:{click:function(t){e.visible=!1}}},[e._v(e._s(e.$t("views.public.cancel")))]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.dataFormSubmitHandle()}}},[e._v(e._s(e.$t("views.public.confirm")))])],1)],2)},i=[],o=a("4a8e"),s=a("e1a58"),c={mixins:[s["a"]],data:function(){return{mixinViewModuleOptions:{getDataListURL:"/base/productprice/list",updateURL:"/base/productprice/save",getDataListIsPage:!1,activatedIsNeed:!1},data:o,visible:!1,dataForm:{id:void 0,productId:void 0,salePrice:void 0,costPrice:void 0,remark:void 0},rules:{productId:[{required:!0,message:"产品不可为空"}],salePrice:[{type:"number",message:"必须为数字类型",trigger:"blur"}],costPrice:[{type:"number",message:"必须为数字类型",trigger:"blur"}]}}},methods:{dataFormSubmitHandle:function(){var e=this,t=this;this.$refs["dataForm"].validate((function(a){if(!a)return!1;t.$axios({url:"/base/productprice/save",method:"post",data:t.dataForm}).then((function(t){e.$message({message:e.$t("views.public.success"),type:"success",duration:500,onClose:function(){e.visible=!1,e.$emit("refreshDataList")}})})).catch((function(){}))}))}}},l=c,d=(a("a49b"),a("623f")),n=function(e){e.options.__source="src/views/base/pprice/add-or-update.vue"},u=n,p=Object(d["a"])(l,r,i,!1,null,null,null);"function"===typeof u&&u(p);t["default"]=p.exports},ebc3e:function(e,t,a){}}]);