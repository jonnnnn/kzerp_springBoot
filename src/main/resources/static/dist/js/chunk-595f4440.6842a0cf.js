(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-595f4440","chunk-259a1a12","chunk-2d0c9159"],{"07a4":function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{attrs:{visible:e.visible,title:e.isNew?e.$t("views.public.add"):e.$t("views.public.update"),"close-on-click-modal":!1,"close-on-press-escape":!1,width:"388px"},on:{"update:visible":function(t){e.visible=t}}},[a("el-form",{ref:"dataForm",staticClass:"tb-matthew",attrs:{model:e.dataForm,rules:e.rules,"label-width":"120px",labelSuffix:"：",size:"mini"}},[a("el-form-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{prop:"id"}}),a("el-form-item",{attrs:{prop:"parentId",label:e.data.form.input.parentId}},[a("im-selector",{attrs:{placeholder:"请选择上级菜单",mapModel:e.dataForm,mapKeyVal:"pname:parentId",dataType:"biz.pvehicle"},on:{"update:mapModel":function(t){e.dataForm=t},"update:map-model":function(t){e.dataForm=t}},model:{value:e.dataForm.parentId,callback:function(t){e.$set(e.dataForm,"parentId",t)},expression:"dataForm.parentId"}})],1),a("el-form-item",{attrs:{prop:"name",label:e.data.form.input.name}},[a("el-input",{attrs:{placeholder:e.data.form.input.name},model:{value:e.dataForm.name,callback:function(t){e.$set(e.dataForm,"name",t)},expression:"dataForm.name"}})],1),a("el-form-item",{attrs:{prop:"remark",label:e.data.form.input.remark}},[a("el-input",{attrs:{placeholder:e.data.form.input.remark},model:{value:e.dataForm.remark,callback:function(t){e.$set(e.dataForm,"remark",t)},expression:"dataForm.remark"}})],1)],1),a("template",{slot:"footer"},[a("el-button",{on:{click:function(t){e.visible=!1}}},[e._v(e._s(e.$t("views.public.cancel")))]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.dataFormSubmitHandle()}}},[e._v(e._s(e.$t("views.public.confirm")))])],1)],2)},r=[],n=a("5844"),o=a("e1a58"),l={mixins:[o["a"]],data:function(){return{mixinViewModuleOptions:{getDataListURL:"/base/productvehicle/list",updateURL:"/base/productvehicle/save",getDataListIsPage:!1,activatedIsNeed:!1},data:n,visible:!1,dataForm:{id:void 0,code:void 0,name:void 0,pinyinCode:void 0,wbCode:void 0,remark:void 0,parentId:void 0,pname:void 0},rules:{name:[{required:!0,message:"名称不可缺少"}]}}},methods:{dataFormSubmitHandle:function(){var e=this,t=this;this.$refs["dataForm"].validate((function(a){if(!a)return!1;t.$axios({url:"/base/productvehicle/save",method:"post",data:t.dataForm}).then((function(t){e.$message({message:e.$t("views.public.success"),type:"success",duration:500,onClose:function(){e.visible=!1,e.$emit("refreshDataList")}})})).catch((function(){}))}))}}},s=l,d=a("623f"),c=function(e){e.options.__source="src/views/base/pvehicle/add-or-update.vue"},u=c,m=Object(d["a"])(s,i,r,!1,null,null,null);"function"===typeof u&&u(m);t["default"]=m.exports},5844:function(e){e.exports=JSON.parse('{"form":{"input":{"code":"编号","name":"名称","pinyinCode":"拼音码","wbCode":"五笔码","remark":"备注","parentId":"上级菜单"}}}')},f878:function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("d2-container",{staticClass:"mod-sys__user"},[a("el-collapse",{attrs:{slot:"header"},slot:"header",model:{value:e.activeName,callback:function(t){e.activeName=t},expression:"activeName"}},[a("el-collapse-item",{attrs:{name:"1"}},[a("template",{slot:"title"},[e._v("\n                查询条件"),a("i",{staticClass:"el-icon-d-arrow-right"})]),a("el-form",{ref:"dataForm",attrs:{inline:!0,size:"mini",model:e.dataForm},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.search(t)}}},[a("el-form-item",{attrs:{prop:"code"}},[a("el-input",{attrs:{placeholder:e.data.form.input.code,clearable:""},model:{value:e.dataForm.code,callback:function(t){e.$set(e.dataForm,"code",t)},expression:"dataForm.code"}})],1),a("el-form-item",{attrs:{prop:"name"}},[a("el-input",{attrs:{placeholder:e.data.form.input.name,clearable:""},model:{value:e.dataForm.name,callback:function(t){e.$set(e.dataForm,"name",t)},expression:"dataForm.name"}})],1),a("el-form-item",[a("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:e.search}},[e._v(e._s(e.$t("views.public.query"))+"\n                    ")])],1),a("el-form-item",[a("el-button",{on:{click:e.handleFormReset}},[a("d2-icon",{attrs:{name:"refresh"}}),e._v("\n                        重置\n                    ")],1)],1)],1)],2)],1),a("vxe-grid",{ref:"pGrid",attrs:{border:"",resizable:"","highlight-current-row":"","remote-filter":"",size:"mini","row-id":"id",toolbar:e.toolbar,"proxy-config":e.tableProxy,columns:e.columns,"select-config":{reserve:!0},"edit-config":{trigger:"click",mode:"row",showStatus:!0},"tree-config":{children:"children"}},on:{"cell-dblclick":e.cellDblClick},scopedSlots:e._u([{key:"buttons",fn:function(){return[a("el-button",{ref:"btnAdd",attrs:{size:"mini",icon:"el-icon-circle-plus"},on:{click:e.addHandle}},[e._v("新增\n            ")]),a("el-button",{ref:"btnEdit",attrs:{type:"primary",size:"mini",icon:"el-icon-edit"},on:{click:function(t){return e.updateHandle(e.$refs.pGrid)}}},[e._v("修改\n            ")]),a("el-button",{ref:"btnDelete",attrs:{type:"danger",size:"mini",icon:"el-icon-delete"},on:{click:function(t){return e.deleteHandleSetter(e.$refs.pGrid)}}},[e._v("删除\n            ")])]},proxy:!0}])}),a("el-pagination",{attrs:{slot:"footer","current-page":e.page,"page-sizes":[10,20,50,100],"page-size":e.limit,total:e.total,layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":function(t){return e.pageSizeChangeHandle(t,"vxe")},"current-change":function(t){return e.pageCurrentChangeHandle(t,"vxe")}},slot:"footer"}),e.addOrUpdateVisible?a("add-or-update",{ref:"addOrUpdate",on:{refreshDataList:e.search}}):e._e()],1)},r=[],n=a("e1a58"),o=a("07a4"),l=a("5844"),s={name:"pvehicle",mixins:[n["a"]],data:function(){var e=this;return{activeName:"1",data:l,mixinViewModuleOptions:{getDataListURL:"/base/productvehicle/list",getDataListIsPage:!0,deleteURL:"/base/productvehicle/delete",deleteIsBatch:!0},dataForm:{code:void 0,name:void 0},rowHandler:{width:"160px",custom:[{text:this.$t("views.public.update"),type:"primary",size:"mini",emit:"user-update",show:function(t,a){return e.$hasPermission("sys:user:update")}},{text:this.$t("views.public.delete"),type:"danger",size:"mini",emit:"user-delete",show:function(t,a){return e.$hasPermission("sys:user:delete")}}]},toolbar:{id:"full_edit_1",refresh:!0,resizable:{storage:!0},setting:{storage:!0}},columns:[{type:"index",width:60},{title:"名称",field:"name",sortable:!0,align:"left",treeNode:!0},{title:"拼音码",field:"pinyinCode",sortable:!0,align:"center"},{title:"五笔码",field:"wbCode",sortable:!0,align:"center"},{title:"备注",field:"remark",sortable:!0,align:"center"},{title:"修改人",field:"updateBy",sortable:!0,align:"center"},{title:"修改日期",field:"updateDate",sortable:!0,align:"center",formatter:["toDateString","yyyy-MM-dd"]}]}},components:{AddOrUpdate:o["default"]},methods:{handleFormReset:function(){this.$refs["dataForm"].resetFields()}}},d=s,c=a("623f"),u=function(e){e.options.__source="src/views/base/pvehicle/index.vue"},m=u,p=Object(c["a"])(d,i,r,!1,null,null,null);"function"===typeof m&&m(p);t["default"]=p.exports}}]);