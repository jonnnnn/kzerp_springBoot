(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b771b726"],{"4c9f":function(t,e,i){var n=i("149f"),s=i("80a9"),a=i("09b9"),r=i("4f18").f;t.exports=function(t){return function(e){var i,o=a(e),c=s(o),u=c.length,l=0,d=[];while(u>l)i=c[l++],n&&!r.call(o,i)||d.push(t?[i,o[i]]:o[i]);return d}}},6491:function(t,e,i){"use strict";var n=i("e46b"),s=i("eafa"),a=i("7c0a"),r="startsWith",o=""[r];n(n.P+n.F*i("bc96")(r),"String",{startsWith:function(t){var e=a(this,t,r),i=s(Math.min(arguments.length>1?arguments[1]:void 0,e.length)),n=String(t);return o?o.call(e,n,i):e.slice(i,i+n.length)===n}})},a2cd:function(t,e,i){"use strict";var n=i("238a");t.exports=function(t,e){return!!t&&n((function(){e?t.call(null,(function(){}),1):t.call(null)}))}},c904:function(t,e,i){"use strict";var n=i("e46b"),s=i("5daa"),a=i("008a"),r=i("238a"),o=[].sort,c=[1,2,3];n(n.P+n.F*(r((function(){c.sort(void 0)}))||!r((function(){c.sort(null)}))||!i("a2cd")(o)),"Array",{sort:function(t){return void 0===t?o.call(a(this)):o.call(a(this),s(t))}})},de78:function(t,e,i){var n=i("e46b"),s=i("4c9f")(!1);n(n.S,"Object",{values:function(t){return s(t)}})},e1a58:function(t,e,i){"use strict";i("5ab2"),i("e10e"),i("de78"),i("ed63"),i("8cf2"),i("9a33"),i("163d");var n=i("289c"),s=(i("6491"),i("c0c3"),i("f548"),i("06a2"),i("6d57"),i("63ff"),i("57f0")),a=(i("c904"),i("82c6")),r=i.n(a),o=i("be17"),c=i.n(o),u=i("c276");function l(t,e){var i=Object.keys(t);if(Object.getOwnPropertySymbols){var n=Object.getOwnPropertySymbols(t);e&&(n=n.filter((function(e){return Object.getOwnPropertyDescriptor(t,e).enumerable}))),i.push.apply(i,n)}return i}function d(t){for(var e=1;e<arguments.length;e++){var i=null!=arguments[e]?arguments[e]:{};e%2?l(Object(i),!0).forEach((function(e){Object(n["a"])(t,e,i[e])})):Object.getOwnPropertyDescriptors?Object.defineProperties(t,Object.getOwnPropertyDescriptors(i)):l(Object(i)).forEach((function(e){Object.defineProperty(t,e,Object.getOwnPropertyDescriptor(i,e))}))}return t}e["a"]={data:function(){var t=this;return{mixinViewModuleOptions:{activatedIsNeed:!0,getDataListURL:"",getDataListIsPage:!1,deleteURL:"",deleteIsBatch:!1,deleteIsBatchKey:"id",exportURL:""},dataForm:{},dataFormOp:{},dataList:[],order:"",orderField:"",page:1,limit:10,total:0,dataListLoading:!1,fullscreenLoading:!1,dataListSelections:[],addOrUpdateVisible:!1,updatePasswordVisible:!1,formprops:{labelSuffix:"："},formReadOnly:!1,enableSubmit:!0,selectionRow:!1,sortConfig:{trigger:"cell"},options:{size:"mini",stripe:!0,border:!0},curStatus:"",visible:!1,btnDisable:!1,pGrid:{},sGrid:{},addOrUpdate:{},updatePassword:{},entityModel:{},isNew:!1,tableProxy:{index:!0,sort:!0,filter:!0,autoLoad:!0,ajax:{query:function(e){var i=e.page,n=e.sort,s=e.filters;return t.vxeTabQuery({page:i,sort:n,filters:s})}},props:{list:"list",result:"list",total:"totalCount"}},toolbar:{id:"vxe_toolbar_1",refresh:!0,resizable:{storage:!0},setting:{storage:!0}},pickerOptions:{shortcuts:[{text:"最近一周",onClick:function(t){var e=new Date,i=new Date;i.setTime(i.getTime()-6048e5),t.$emit("pick",[i,e])}},{text:"最近一个月",onClick:function(t){var e=new Date,i=new Date;i.setTime(i.getTime()-2592e6),t.$emit("pick",[i,e])}},{text:"最近三个月",onClick:function(t){var e=new Date,i=new Date;i.setTime(i.getTime()-7776e6),t.$emit("pick",[i,e])}}]}}},methods:{init:function(t){arguments.length>1&&void 0!==arguments[1]&&arguments[1];var e=!(arguments.length>2&&void 0!==arguments[2])||arguments[2];this.isNew=!t,this.entityModel=t?Object.assign({},t):{},this.enableSubmit=e,this.visible=!0,this.initCB()},initCB:function(){},initSelData:function(){},getDataList:function(){var t=Object(s["a"])(regeneratorRuntime.mark((function t(e){var i=this;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(""!=this.mixinViewModuleOptions.getDataListURL){t.next=2;break}return t.abrupt("return");case 2:return this.dataListLoading=!0,t.next=5,this.$axios.post(this.mixinViewModuleOptions.getDataListURL,{pageForm:this.mixinViewModuleOptions.getDataListIsPage?{order:this.order,orderField:this.orderField,page:this.mixinViewModuleOptions.getDataListIsPage?this.page:null,limit:this.mixinViewModuleOptions.getDataListIsPage?this.limit:null}:{},dataForm:{data:Object.assign({},this.dataForm,e),op:this.dataFormOp}}).then((function(t){i.dataList=i.mixinViewModuleOptions.getDataListIsPage?t.list:t,i.total=i.mixinViewModuleOptions.getDataListIsPage?t.totalCount:0,i.getDataListCB(i,t)})).catch((function(){i.dataList=[],i.total=0}));case 5:this.dataListLoading=!1;case 6:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),getDataListCB:function(t,e){},vxeTabQuery:function(t,e){var i=this,n=(t.page,t.sort),s=t.filters;n&&n.field&&""!==n.field&&(this.order=n.order,this.orderField=n.field);var a=e||{};return s.forEach((function(t){t.column;var e=t.property,i=t.values;a[e]=i.join(",")})),new Promise((function(t,e){i.getDataList(a).then((function(){t({total:i.total,list:i.dataList})})).catch((function(t){e(t)}))}))},search:function(t){var e=this;this.dataListLoading=!0;var i={page:null,sort:null,filters:[]};this.vxeTabQuery(i,t).then((function(t,i){e.dataListLoading=!1,e.$refs.sGrid?(e.$refs.sGrid.loadData(e.dataList),e.$refs.sGrid.updateFooter(),e.$refs.sGrid.clearCurrentRow()):e.$refs.pGrid&&(e.$refs.pGrid.loadData(e.dataList),e.$refs.pGrid.updateFooter(),e.$refs.pGrid.clearCurrentRow()),e.vxeQueryCB(e)}))},vxeQueryCB:function(t){},dataFormSubmit:function(){var t=this;Promise.all([this.checkForm(),this.checkGrid(this.$refs.sGrid)]).then((function(){t.$confirm("确定保存?","操作提示",{confirmButtonText:t.$t("views.public.confirm"),cancelButtonText:t.$t("views.public.cancel"),type:"info"}).then((function(){t.doSubmit()})).catch((function(){}))})).catch((function(t){}))},doSubmit:function(){var t=this;this.btnDisable=!0,this.$refs.sGrid&&(this.dataForm.lineList=this.getItemListDate(this.$refs.sGrid)),this.isNew?this.dataForm.__state="NEW":this.dataForm.__state="MODIFIED",this.fullscreenLoading=!0,this.$axios.post(this.mixinViewModuleOptions.updateURL,this.dataForm).then((function(){t.fullscreenLoading=!1,t.visible=!1,t.$emit("refreshDataList"),t.$message({message:"操作成功",type:"success",duration:1e3,onClose:function(){t.btnDisable=!1}})})).catch((function(){t.btnDisable=!1,t.fullscreenLoading=!1}))},dataListSelectionChangeHandle:function(t){this.dataListSelections=t},dataListSortChangeHandle:function(t){if(!t.order||!t.prop)return this.order="",this.orderField="",!1;this.order=t.order.replace(/ending$/,""),this.orderField=t.prop.replace(/([A-Z])/g,"_$1").toLowerCase(),this.getDataList()},pageSizeChangeHandle:function(t,e){this.page=1,this.limit=t,e?this.search():this.getDataList()},pageCurrentChangeHandle:function(t,e){this.page=t,e?this.search():this.getDataList()},cellDblClick:function(t,e){var i=this,n=t.row;if("undefined"===typeof n||null===n)return this.$message({message:"请选择要修改的记录",type:"warning"});this.addOrUpdateVisible=!0,this.$nextTick((function(){var t=null;for(var e in i.$refs)if(e.startsWith("btnStatus")){var s=i.$refs[e].$attrs["row-dbclick"];if(t=i.$refs[e].$attrs["form-readonly"],t="undefined"!==typeof t&&null!==t,"undefined"!==typeof s&&null!==s&&"none"===i.$refs[e].$el.style.display)return void i.$refs.addOrUpdate.init(n,t,!1)}i.$refs.addOrUpdate.init(n,t)}))},addHandle:function(){var t=this;this.addOrUpdateVisible=!0,this.$nextTick((function(){t.$refs.addOrUpdate.init()}))},updateHandle:function(){var t=this,e=this.pGrid.getCurrentRow();if(this.addOrUpdateVisible=!0,!e)return this.$message({message:"请选择要修改的记录",type:"warning"});this.$nextTick((function(){t.$refs.addOrUpdate.init(e)}))},submitHandle:function(t,e){var i=this,n=this.pGrid.getCurrentRow();if(!n)return this.$message({message:"请选择要提交的记录",type:"warning"});this.$confirm("确定要提交吗，提交后不能在修改！","操作提示",{confirmButtonText:this.$t("views.public.confirm"),cancelButtonText:this.$t("views.public.cancel"),type:"info"}).then((function(){i.$axios.post(i.mixinViewModuleOptions.submitURL,{id:n.id,isAuto:e}).then((function(t){i.$message({message:i.$t("views.public.success"),type:"success",duration:500,onClose:function(){i.search()}})})).catch((function(){}))})).catch((function(){}))},rollbackHandle:function(t){var e=this,i=this.pGrid.getCurrentRow();if(!i)return this.$message({message:"请选择要撤回的记录",type:"warning"});this.$confirm("确定要撤回吗！","操作提示",{confirmButtonText:this.$t("views.public.confirm"),cancelButtonText:this.$t("views.public.cancel"),type:"warning"}).then((function(){e.$axios.get(e.mixinViewModuleOptions.rollbackURL+"?sourceId="+i.id).then((function(t){e.$message({message:e.$t("views.public.success"),type:"success",duration:500,onClose:function(){e.search()}})})).catch((function(){}))})).catch((function(){}))},deleteEntityHandle:function(t){var e=this,i=this.pGrid.getCurrentRow();if(!i)return this.$message({message:"请选择要删除的记录",type:"error"});this.$confirm("确定要删除选中的记录吗！","操作提示",{confirmButtonText:this.$t("views.public.confirm"),cancelButtonText:this.$t("views.public.cancel"),type:"error"}).then((function(){i.__state="DELETED",e.$axios.post(e.mixinViewModuleOptions.updateURL,i).then((function(t){e.$message({message:e.$t("views.public.success"),type:"success",duration:500,onClose:function(){e.search()}})})).catch((function(){}))})).catch((function(){}))},deleteHandle:function(t){var e=this,i="";if(this.dataListSelections=t.getSelectRecords(),0===t.getSelectRecords().length){if(!t.getCurrentRow())return this.$message({message:"请选择要删除的记录",type:"warning"});i=t.getCurrentRow().id}else i=this.dataListSelections.map((function(t){return t.id})).join();this.$confirm("确定要删除选中的记录","操作提示",{confirmButtonText:this.$t("views.public.confirm"),cancelButtonText:this.$t("views.public.cancel"),type:"error"}).then((function(){e.$axios.post(e.mixinViewModuleOptions.deleteURL,{ids:i}).then((function(t){e.$message({message:e.$t("views.public.success"),type:"success",duration:500,onClose:function(){e.search()}})})).catch((function(){}))})).catch((function(){}))},deleteHandleSetter:function(t){var e=this,i="";if(this.dataListSelections=t.getSelectRecords(),0===t.getSelectRecords().length){if(!t.getCurrentRow())return this.$message({message:"请选择要删除的记录",type:"warning"});i=[t.getCurrentRow().id]}else i=this.dataListSelections.map((function(t){return t.id})).join();this.$confirm("确定要删除选中的记录","操作提示",{confirmButtonText:this.$t("views.public.confirm"),cancelButtonText:this.$t("views.public.cancel"),type:"error"}).then((function(){e.$axios.post(e.mixinViewModuleOptions.deleteURL,{ids:i}).then((function(t){e.$message({message:e.$t("views.public.success"),type:"success",duration:500,onClose:function(){e.search()}})})).catch((function(){}))})).catch((function(){}))},deliverData:function(t,e){var i=this;this.$nextTick((function(){var n=i.$refs.addOrUpdate.dataForm;n.custId=t,n.custName=e}))},exportHandle:function(){var t=r.a.stringify(d({token:u["a"].cookies.get("Mema-Token")},this.dataForm));window.location.href="".concat(window.SITE_CONFIG["apiURL"]).concat(this.mixinViewModuleOptions.exportURL,"?").concat(t)},getItemListDate:function(t){var e=[];if(this.subTableAll){var i=t.getTableData();if(i.fullData&&i.fullData.length>0){for(var n=0;n<i.fullData.length;n++)i.fullData[n].__state="NEW";e=e.concat(i.fullData)}}else{var s=t.getRecordset();if(s){if(s.insertRecords&&s.insertRecords.length>0){for(var a=0;a<s.insertRecords.length;a++)s.insertRecords[a].__state="NEW";e=e.concat(s.insertRecords)}if(s.updateRecords&&s.updateRecords.length>0){for(var r=0;r<s.updateRecords.length;r++)s.updateRecords[r].__state="MODIFIED";e=e.concat(s.updateRecords)}if(s.removeRecords&&s.removeRecords.length>0){for(var o=0;o<s.removeRecords.length;o++)s.removeRecords[o].__state="DELETED";e=e.concat(s.removeRecords)}}}return e},footerCellClassName:function(t){t.$rowIndex;var e=t.column;t.columnIndex,t.$columnIndex;if(e.align)return"col--"+e.align},footerMethod:function(t){var e=this,i=t.columns,n=t.data;return[i.map((function(t,i){n.map((function(e){var i=t.own.editPost;i&&(e[t.property]=i(t,e))}));var s=t.own.footerRender;if(s){var a=s(t,n),r=a,o=t.formatter;o&&"汇总"!=a&&(r=c.a.isString(o)?c.a[o](a):c.a.isArray(o)?c.a[o[0]].apply(c.a,[a].concat(o.slice(1))):o(Object.assign({cellValue:a})));var u=t.own.needReturnAmount;return u&&e.setAmount(r),r}return null}))]},removeSelecteds:function(t){t.removeSelecteds().then((function(){t.updateFooter()}))},computeHeight:function(){},collapseChange:function(){setTimeout(this.computeHeight,500)},currentChange:function(t){var e=t.row;this.curStatus=e.status},btnStatus:function(t,e){var i=t.$attrs.enablestatus;i&&i.length>0&&(i=i.split(","),t.$el.style="display:"+(i.includes(e)?"inline-block":"none"))},reset:function(){var t=this;this.$nextTick((function(){t.$refs["dataForm"].resetFields()}))},checkForm:function(){var t=this;return new Promise((function(e,i){t.$refs.dataForm.validate((function(t){t?e(!0):i(!1)}))}))},checkGrid:function(t){var e=this,i=this.$createElement;return new Promise((function(n,s){t?t.fullValidate((function(t,a){if(t)n(!0);else{var r=[];Object.values(a).forEach((function(t){t.forEach((function(t){var e=t.rowIndex,i=t.column,n=t.rules;n.forEach((function(t){r.push("第 ".concat(e," 行 ").concat(i.title," 校验错误：").concat(t.message))}))}))})),e.$XMsg.message({status:"error",message:function(){return[i("div",{class:"red",style:"max-height: 400px;overflow: auto;"},[r.map((function(t){return i("div",[t])}))])]}}),s(!1)}})):n(!0)}))},footerSum:function(t,e){return c.a.sum(e,t.property)},formatMoney:function(t,e,i,n,s){t=t||0,e=isNaN(e=Math.abs(e))?2:e,i=void 0!==i?i:"",n=n||",",s=s||".";var a=t<0?"-":"",r=parseInt(t=Math.abs(+t||0).toFixed(e),10)+"",o=(o=r.length)>3?o%3:0;return i+a+(o?r.substr(0,o)+n:"")+r.substr(o).replace(/(\d{3})(?=\d)/g,"$1"+n)+(e?s+Math.abs(t-r).toFixed(e).slice(2):"")},formatterMoney:function(t){var e=t.cellValue;t.row,t.rowIndex,t.column,t.columnIndex;return this.formatMoney(e)}},watch:{visible:function(t,e){var i=this;t&&this.$nextTick((function(){i.$refs.sGrid&&""!=i.mixinViewModuleOptions.getDataListURL?(i.dataList=[],i.$refs.sGrid.loadData(i.dataList),i.isNew?(i.reset(),i.$refs.sGrid.updateFooter()):(i.dataForm=i.entityModel,i.initSelData(),i.search(i.entityModel))):i.isNew?i.reset():i.dataForm=i.entityModel}))},curStatus:function(t,e){for(var i in this.$refs)i.startsWith("btnStatus")&&this.btnStatus(this.$refs[i],t)}},created:function(){},mounted:function(){var t=this;this.$nextTick((function(){t.pGrid=t.$refs.pGrid,t.sGrid=t.$refs.sGrid,t.addOrUpdate=t.$refs.addOrUpdate,t.$refs.pGrid&&(window.onresize=function(){t.computeHeight()},t.computeHeight())}))},activated:function(){}}}}]);