(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-09d13832","chunk-d2dc7d2a"],{"1d48":function(e,t,i){"use strict";var a=i("b8a6"),r=i.n(a);r.a},a047:function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{staticClass:"abow_dialog",attrs:{visible:e.visible,title:null==e.dataForm.roleId?e.$t("views.public.add"):e.$t("views.public.update"),"close-on-click-modal":!1,"close-on-press-escape":!1,width:"50%"},on:{"update:visible":function(t){e.visible=t}}},[i("el-form",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],ref:"dataForm",attrs:{model:e.dataForm,rules:e.dataRule,"label-width":"120px",size:"mini"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.dataFormSubmitHandle()}}},[i("el-form-item",{attrs:{prop:"roleName",label:"角色名称"}},[i("el-input",{attrs:{placeholder:"角色名称"},model:{value:e.dataForm.roleName,callback:function(t){e.$set(e.dataForm,"roleName",t)},expression:"dataForm.roleName"}})],1),i("el-form-item",{staticClass:"dept-list",attrs:{prop:"deptName",label:"所属部门"}},[i("el-popover",{ref:"deptListPopover",attrs:{placement:"bottom-start",trigger:"click"},model:{value:e.deptListVisible,callback:function(t){e.deptListVisible=t},expression:"deptListVisible"}},[i("el-tree",{ref:"deptListTree",attrs:{data:e.deptList,props:{label:"name",children:"children"},"node-key":"deptId","highlight-current":!0,"expand-on-click-node":!1,accordion:""},on:{"current-change":e.deptListTreeCurrentChangeHandle}})],1),i("el-input",{directives:[{name:"popover",rawName:"v-popover:deptListPopover",arg:"deptListPopover"}],attrs:{readonly:!0,placeholder:e.$t("views.public.dept.parentId")},model:{value:e.dataForm.deptName,callback:function(t){e.$set(e.dataForm,"deptName",t)},expression:"dataForm.deptName"}})],1),i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:!1,expression:"false"}],attrs:{prop:"deptId",label:"所属部门"}},[i("el-input",{attrs:{placeholder:"所属部门"},model:{value:e.dataForm.deptId,callback:function(t){e.$set(e.dataForm,"deptId",t)},expression:"dataForm.deptId"}})],1),i("el-row",[i("el-col",{attrs:{span:12}},[i("el-form-item",{staticClass:"dept-list",attrs:{prop:"menuName",label:"菜单授权"}},[i("el-tree",{ref:"menuListTree",attrs:{data:e.menuList,props:{label:"name",children:"children"},"node-key":"menuId","highlight-current":!0,"expand-on-click-node":!1,accordion:"","show-checkbox":""}})],1)],1),i("el-col",{attrs:{span:12}},[i("el-form-item",{staticClass:"dept-list",attrs:{prop:"deptNames",label:"数据授权"}},[i("el-tree",{ref:"deptTree",attrs:{data:e.deptList,props:{label:"name",children:"children"},"node-key":"deptId","highlight-current":!0,"expand-on-click-node":!1,accordion:"","show-checkbox":""}})],1)],1)],1)],1),i("template",{slot:"footer"},[i("el-button",{on:{click:function(t){e.visible=!1}}},[e._v(e._s(e.$t("views.public.cancel")))]),i("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.dataFormSubmitHandle()}}},[e._v(e._s(e.$t("views.public.confirm")))])],1)],2)},r=[],n=(i("5ab2"),i("e10e"),i("289c")),s=(i("6d57"),i("cc57"),i("391c"));function o(e,t){var i=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),i.push.apply(i,a)}return i}function l(e){for(var t=1;t<arguments.length;t++){var i=null!=arguments[t]?arguments[t]:{};t%2?o(Object(i),!0).forEach((function(t){Object(n["a"])(e,t,i[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(i)):o(Object(i)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(i,t))}))}return e}var d={data:function(){return{visible:!1,deptList:[],menuList:[],deptListVisible:!1,loading:!0,dataForm:{roleId:"",roleName:"",deptId:"",deptName:"",deptNames:"",companyId:"",companyName:"",deptIdList:[],menuIdList:[]}}},created:function(){this.getDeptList(),this.getMenuList()},computed:{dataRule:function(){var e=this,t=function(t,i,a){if(!e.dataForm.roleId&&!/\S/.test(i))return a(new Error("角色名称不能为空！"));a()},i=function(t,i,a){if(!e.dataForm.roleId&&!/\S/.test(i))return a(new Error("部门名称不能为空！"));a()};return{roleName:[{required:!0,message:"角色名称不能为空！",trigger:"blur"},{validator:t,trigger:"blur"}],deptName:[{required:!0,message:"所属部门不能为空！",trigger:"change"},{validator:i,trigger:"blur"}]}}},methods:{init:function(){var e=this;this.visible=!0,this.loading=!0,this.dataForm.roleId=null,this.$nextTick((function(){e.loading=!1,e.$refs.dataForm.resetFields()}))},update:function(e){var t=this;this.visible=!0,this.loading=!0,this.$nextTick((function(){t.dataForm=Object.assign({},e);var i=setInterval((function(){t.menuList.length>0&&t.deptList.length>0&&(t.setTree(e),clearInterval(i)),t.loading=!1}),500);t.$refs["dataForm"].clearValidate()}))},setTree:function(e){for(var t in this.$refs.menuListTree.setCheckedKeys([]),this.$refs.deptTree.setCheckedKeys([]),e.menuIdList)this.$refs.menuListTree.setChecked(e.menuIdList[t],!0,!1);for(var i in e.deptIdList)this.$refs.deptTree.setChecked(e.deptIdList[i],!0,!1)},resetTree:function(){this.$refs.menuListTree.setCheckedKeys([]),this.$refs.deptTree.setCheckedKeys([])},getDeptList:function(){var e=this;return this.$axios.get("/sys/dept/select").then((function(t){e.deptList=t})).catch((function(){}))},getMenuList:function(){var e=this;return this.$axios.get("/sys/menu/select").then((function(t){e.menuList=t})).catch((function(){}))},deptListTreeCurrentChangeHandle:function(e,t){this.dataForm.deptId=e.deptId,this.dataForm.deptName=e.name,this.dataForm.deptNames=e.naem,this.deptListVisible=!1},deptIdListTreeCurrentChangeHandle:function(e){var t=e.$refs.deptTree.getCheckedNodes(!1,!0);e.dataForm.deptIdList=[],t.forEach((function(t){e.dataForm.deptIdList.push(t.deptId)}))},menuListTreeCurrentChangeHandle:function(e){var t=e.$refs.menuListTree.getCheckedNodes(!1,!0);e.dataForm.menuIdList=[],t.forEach((function(t){e.dataForm.menuIdList.push(t.menuId)}))},dataFormSubmitHandle:Object(s["debounce"])((function(){var e=this;this.$refs["dataForm"].validate((function(t){if(!t)return!1;e.menuListTreeCurrentChangeHandle(e),e.deptIdListTreeCurrentChangeHandle(e),e.$axios["post"]("/sys/role/save",l({},e.dataForm)).then((function(t){e.$message({message:e.$t("views.public.success"),type:"success",duration:500,onClose:function(){e.visible=!1,e.$emit("refreshDataList")}})})).catch((function(){}))}))}),1e3,{leading:!0,trailing:!1})}},c=d,u=(i("1d48"),i("623f")),p=function(e){e.options.__source="src/views/sys/role-add-or-update.vue"},m=p,f=Object(u["a"])(c,a,r,!1,null,null,null);"function"===typeof m&&m(f);t["default"]=f.exports},b8a6:function(e,t,i){},f7ae:function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("d2-container",{staticClass:"mod-sys__user"},[i("el-form",{attrs:{inline:!0,size:"mini",model:e.dataForm},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.getDataList()}}},[i("el-form-item",[i("el-input",{attrs:{"data-operate":e.dataFormOp.roleName,placeholder:"角色名称",clearable:""},model:{value:e.dataForm.roleName,callback:function(t){e.$set(e.dataForm,"roleName",t)},expression:"dataForm.roleName"}})],1),i("el-form-item",[i("el-button",{attrs:{icon:"el-icon-search",type:"primary"},on:{click:function(t){return e.getDataList()}}},[e._v(e._s(e.$t("views.public.query")))])],1),i("el-form-item",[e.$hasPermission("sys:role:save")?i("el-button",{attrs:{type:"primary",icon:"el-icon-circle-plus"},on:{click:function(t){return e.addOrUpdateData()}}},[e._v(e._s(e.$t("views.public.add")))]):e._e()],1),i("el-form-item",[e.$hasPermission("sys:user:export")?i("el-button",{attrs:{type:"info"},on:{click:function(t){return e.exportHandle()}}},[e._v(e._s(e.$t("views.public.export")))]):e._e()],1)],1),i("vxe-grid",{ref:"pGrid",attrs:{border:"",resizable:"","highlight-hover-row":"",size:"mini",columns:e.columns,loading:e.dataListLoading,data:e.dataList,customs:e.customColumns,"edit-config":{trigger:"click",mode:"row",showStatus:!0}},on:{"update:customs":function(t){e.customColumns=t}}}),i("el-pagination",{attrs:{slot:"footer","current-page":e.page,"page-sizes":[10,20,50,100],"page-size":e.limit,total:e.total,layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":e.pageSizeChangeHandle,"current-change":e.pageCurrentChangeHandle},slot:"footer"}),e.addOrUpdateVisible?i("add-or-update",{ref:"addOrUpdate",on:{refreshDataList:e.getDataList}}):e._e()],1)},r=[],n=i("e1a58"),s=i("a047"),o={mixins:[n["a"]],data:function(){var e=this,t=this.$createElement;return{mixinViewModuleOptions:{getDataListURL:"/sys/role/list",getDataListIsPage:!0,deleteURL:"/sys/role/delete",deleteIsBatch:!0,deleteIsBatchKey:"roleId",exportURL:"/sys/role/export"},addOrUpdateVisible:!1,dataForm:{roleName:""},customColumns:[],dataFormOp:{roleName:"like"},columns:[{title:"角色名称",field:"roleName",sortable:!0,align:"center"},{title:"公司名称",field:"companyName",sortable:!0,align:"center"},{title:"部门名称",field:"deptName",sortable:!0,align:"center"},{title:"创建时间",field:"createTime",sortable:!0,align:"center"},{title:"操作",field:"other",width:170,sortable:!0,align:"center",slots:{default:function(i){var a=i.row;return[t("el-button",{attrs:{size:"mini",icon:"el-icon-edit",type:"primary"},on:{click:function(){return e.addOrUpdateData(a)}}},["修改"]),t("el-button",{attrs:{size:"mini",icon:"el-icon-delete",type:"danger"},on:{click:function(){return e.deleteHandleSetter(a)}}},["删除"])]}}}]}},components:{AddOrUpdate:s["default"]},methods:{addOrUpdateData:function(e){var t=this;this.addOrUpdateVisible=!0,e?this.$nextTick((function(){t.$refs.addOrUpdate.dataForm.id=e.roleId,t.$refs.addOrUpdate.update(e)})):this.$nextTick((function(){t.$refs.addOrUpdate.init()}))},deleteHandleSetter:function(e){var t,i,a=this;if(this.mixinViewModuleOptions.deleteIsBatch&&this.dataListSelections.length>0&&(t=this.dataListSelections.map((function(e){return e[a.mixinViewModuleOptions.deleteIsBatchKey]}))),i=e||void 0,i){var r=i.roleId;r&&(t=[r])}this.$confirm(this.$t("public.prompt.info",{handle:this.$t("views.public.delete")}),this.$t("public.prompt.title"),{confirmButtonText:this.$t("views.public.confirm"),cancelButtonText:this.$t("views.public.cancel"),type:"warning"}).then((function(){a.$axios.post("".concat(a.mixinViewModuleOptions.deleteURL).concat(a.mixinViewModuleOptions.deleteIsBatch?"":"/"+id),a.mixinViewModuleOptions.deleteIsBatch?{data:t}:{}).then((function(e){a.$message({message:a.$t("views.public.success"),type:"success",duration:500,onClose:function(){a.getDataList()}})})).catch((function(){}))})).catch((function(){}))}},created:function(){}},l=o,d=i("623f"),c=function(e){e.options.__source="src/views/sys/role.vue"},u=c,p=Object(d["a"])(l,a,r,!1,null,null,null);"function"===typeof u&&u(p);t["default"]=p.exports}}]);