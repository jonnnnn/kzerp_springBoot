(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0da54f"],{"6ac1":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("d2-container",[a("el-collapse",{attrs:{slot:"header"},slot:"header"},[a("el-collapse-item",[a("template",{slot:"title"},[e._v("\n\t\t\t\t查询条件"),a("i",{staticClass:"el-icon-d-arrow-right"})]),a("dynamic-form",{ref:"dataForm",attrs:{formprops:e.formprops,"col-span":"6,6,5,7",alldescriptors:e.descriptors},model:{value:e.dataForm,callback:function(t){e.dataForm=t},expression:"dataForm"}},[a("template",{slot:"btnsearch"},[a("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.search}},[e._v("查询")]),a("el-button",{attrs:{icon:"el-icon-refresh"},on:{click:e.reset}},[e._v("重置")])],1)],2)],2)],1),a("vxe-grid",{ref:"pGrid",attrs:{border:"",resizable:"","highlight-current-row":"","remote-filter":"",size:"mini","row-id":"id",toolbar:e.toolbar,"proxy-config":e.tableProxy,columns:e.tableColumn,"select-config":{reserve:!0},"edit-config":{trigger:"click",mode:"row",showStatus:!0}},scopedSlots:e._u([{key:"buttons",fn:function(){return[e.$hasPermission("inv:transactions:export")?a("el-button",{attrs:{type:"info",size:"mini",icon:"fa fa-file-excel-o"},on:{click:function(t){return e.$refs.pGrid.exportCsv()}}},[e._v(" 导出\n\t\t\t")]):e._e()]},proxy:!0}])}),a("el-pagination",{attrs:{slot:"footer","current-page":e.page,"page-sizes":[10,20,50,100],"page-size":e.limit,total:e.total,layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":function(t){return e.pageSizeChangeHandle(t,"vxe")},"current-change":function(t){return e.pageCurrentChangeHandle(t,"vxe")}},slot:"footer"})],1)},n=[],o=a("e1a58"),l={name:"inv-transactions",mixins:[o["a"]],data:function(){return{mixinViewModuleOptions:{getDataListURL:"/inv/transactions/list",getDataListIsPage:!0,exportURL:"/inv/transactions/export"},dataForm:{warehouseId:null,productCode:null,transactionDate:[new Date,new Date],sourceCode:null,transactionReference:null,tranType:null},tableProxy:{autoLoad:!1},descriptors:{warehouseId:{type:"cust",label:"仓库",ruletype:"integer",name:"im-selector",props:{mapKeyVal:"warehouseCode:warehouseId",dataType:"biz.warehouse",clearable:!0}},productCode:{type:"string",label:"物料编码"},transactionDate:{type:"cust",label:"事物日期",colspan:2,ruletype:"date",name:"el-date-picker",props:{type:"daterange",rangeSeparator:"至",startPlaceholder:"开始日期",endPlaceholder:"结束日期",valueFormat:"yyyy-MM-dd",class:"input-class"}},separate1:this.$g.separate,sourceCode:{type:"string",label:"来源单据"},transactionReference:{type:"string",label:"业务单据"},tranType:{type:"cust",label:"事物类型",placeholder:"请选择事物类型",name:"im-selector",props:{mapKeyVal:"tranType",dataType:"code.tran_type",clearable:!0}},btnSearch:{type:"slot",name:"btnsearch"}},tableColumn:[{type:"index",width:30,align:"center"},{title:"仓库",field:"warehouseCode",sortable:!0,align:"center"},{title:"物料编码",field:"productCode",sortable:!0,align:"center"},{title:"事物数量",field:"transactionQuantity",sortable:!0,align:"center"},{title:"事务日期",field:"transactionDate",sortable:!0,align:"center",formatter:["toDateString","yyyy-MM-dd"]},{title:"事物类型",field:"tranTypeMean",sortable:!0,align:"center"},{title:"前期数量",field:"priorQuantity",sortable:!0,align:"center"},{title:"结余数量",field:"balanceQuantity",sortable:!0,align:"center"},{title:"来源单据",field:"sourceCode",sortable:!0,align:"center"},{title:"业务单据",field:"transactionReference",sortable:!0,align:"center"},{title:"单位",field:"transactionUom",sortable:!0,align:"center"},{title:"销售价",field:"salePrice",sortable:!0,align:"center"},{title:"成本价",field:"costPrice",sortable:!0,align:"center"},{title:"执行人",field:"employeeName",sortable:!0,align:"center"}],toolbar:{id:"full_edit_1",refresh:!0,resizable:{storage:!0},setting:{storage:!0}}}},components:{},methods:{handleFormReset:function(){this.$refs.dataForm.resetFields()}},mounted:function(){}},i=l,s=a("623f"),c=function(e){e.options.__source="src/views/inv/transactions.vue"},d=c,p=Object(s["a"])(i,r,n,!1,null,null,null);"function"===typeof d&&d(p);t["default"]=p.exports}}]);