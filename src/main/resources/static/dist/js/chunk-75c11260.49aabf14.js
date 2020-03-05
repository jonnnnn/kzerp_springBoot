(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-75c11260"],{"453c":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"loading",rawName:"v-loading.fullscreen.lock",value:e.fullscreenLoading,expression:"fullscreenLoading",modifiers:{fullscreen:!0,lock:!0}}],staticClass:"abow_dialog",attrs:{title:e.pageTitle,"close-on-click-modal":!1,visible:e.visible,width:"80%"},on:{"update:visible":function(t){e.visible=t}}},[a("div",[a("dynamic-form",{ref:"dataForm",attrs:{formprops:e.formprops,"col-span":"8,8,8","read-only":e.formReadOnly,alldescriptors:e.descriptors},model:{value:e.dataForm,callback:function(t){e.dataForm=t},expression:"dataForm"}})],1),a("vxe-grid",{ref:"sGrid",staticClass:"vxe-table-element",attrs:{border:"",resizable:"",size:"mini","highlight-current-row":"","remote-filter":"",toolbar:e.toolbar,"proxy-config":e.tableProxy,"edit-rules":e.validRules,"edit-config":{trigger:"dblclick",mode:"cell"},columns:e.tableColumn,"select-config":{reserve:!0},"mouse-config":{selected:!0},"keyboard-config":{isArrow:!0,isDel:!0,isTab:!0,isEdit:!0},"footer-cell-class-name":e.footerCellClassName,"footer-method":e.footerMethod,"show-footer":""},on:{"edit-closed":e.editClosed},scopedSlots:e._u([{key:"buttons",fn:function(){return[a("el-button",{directives:[{name:"show",rawName:"v-show",value:e.enableSubmit&&"SUBMIT"!==e.entityModel.status&&"SENDED"!==e.entityModel.status,expression:"enableSubmit && (entityModel.status !== 'SUBMIT' && entityModel.status !== 'SENDED')"}],attrs:{size:"mini",icon:"el-icon-circle-plus"},on:{click:function(t){return e.$refs.sGrid.insert({})}}},[e._v("新增")]),a("el-button",{directives:[{name:"show",rawName:"v-show",value:e.enableSubmit&&"SUBMIT"!==e.entityModel.status&&"SENDED"!==e.entityModel.status,expression:"enableSubmit &&  (entityModel.status !== 'SUBMIT' && entityModel.status !== 'SENDED')"}],attrs:{type:"danger",size:"mini",icon:"el-icon-delete"},on:{click:function(t){return e.removeSelecteds(e.$refs.sGrid)}}},[e._v("删除")])]},proxy:!0}])}),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{directives:[{name:"show",rawName:"v-show",value:e.enableSubmit,expression:"enableSubmit"}],attrs:{type:"danger"},on:{click:function(t){e.visible=!1}}},[e._v("取消")]),a("el-button",{directives:[{name:"show",rawName:"v-show",value:e.enableSubmit,expression:"enableSubmit"}],attrs:{type:"primary",disabled:e.btnDisable},on:{click:e.dataFormSubmit}},[e._v("确定")])],1)],1)},i=[],o=(a("9d30"),a("163d"),a("e1a58")),l=(a("be17"),{type:"separate"}),s={mixins:[o["a"]],data:function(){return{mixinViewModuleOptions:{getDataListURL:"/pur/poline/list",updateURL:"/pur/poheader/save",prodURL:"/base/product/search",deleteIsBatch:!0,getDataListIsPage:!1},visible:!1,btnDisable:!1,pageTitle:"采购退货单新增",dataForm:{orderType:"PO_RETURN",vendorId:"",contactName:"",contactPhone:"",agentId:"",warehouseId:"",planDeliveryDate:"",payType:null,shipType:null,shipName:null,shipId:null,shipNum:null,freight:null,isAuto:!0,remark:""},descriptors:{orderNum:{type:"string",label:"采购退货单号",disabled:"disabled",props:{clearable:!0}},agentId:{type:"cust",label:"负责人",name:"im-selector",props:{mapKeyVal:"agentName:agentId",dataType:"biz.employee",clearable:!0},required:!0},warehouseId:{type:"cust",label:"退货仓库",ruletype:"integer",name:"im-selector",props:{mapKeyVal:"warehouseCode:warehouseId",dataType:"biz.warehouse",clearable:!0},required:!0},separate1:l,vendorId:{type:"cust",label:"供应商",ruletype:"integer",name:"im-selector",props:{mapKeyVal:"vendorName:vendorId",dataType:"biz.vendor",clearable:!0},required:!0},contactName:{type:"string",label:"供应商联系人",props:{clearable:!0}},contactPhone:{type:"string",label:"供应商联系电话",props:{clearable:!0}},separate2:l,payType:{type:"cust",label:"运费付款方式",name:"im-selector",props:{mapKeyVal:"payType",dataType:"code.SHIP_PAYTYPE",clearable:!0}},shipType:{type:"cust",label:"发运方式",name:"im-selector",ruletype:"integer",props:{mapKeyVal:"shipType",dataType:"dict.SHIP_TYPE",clearable:!0}},shipId:{type:"cust",label:"发运公司",ruletype:"integer",name:"im-selector",props:{mapKeyVal:"shipName:shipId",dataType:"biz.shipComp",clearable:!0}},separate3:l,shipNum:{type:"string",label:"发运单号",props:{clearable:!0}},freight:{type:"string",label:"运费",props:{clearable:!0}},isAuto:{label:"拣货方式",type:"boolean",required:!0,props:{inactiveText:"人工",activeText:"自动"}},separate4:l,remark:{type:"string",label:"备注",colspan:3}},tableProxy:{autoLoad:!1},validRules:{productCode:[{required:!0,message:"物料必填"}],orderQty:[{required:!0,message:"退货数必填"},{type:"number",message:"请输入数字"}],costPrice:[{required:!0,message:"退货价必填"},{type:"number",message:"请输入数字"}],acceptQty:[{validator:function(e,t,a,r){var i=r.row;t&&Math.abs(Number(t))>Math.abs(Number(i.orderQty))-Math.abs(Number(i.totalAcceptQty))?a(new Error("退货数不能大于剩余退货数")):a()}}]},tableColumn:[{type:"selection",width:30,align:"center"},{type:"index",width:30,align:"center"},{title:"商品",field:"productCode",sortable:!0,align:"center",editRender:{name:"ElAutocomplete",props:{fetchSuggestions:this.prodSeach,triggerOnFocus:!1,popperClass:"prod-popper"},events:{select:this.handleProcSelect}},footerRender:function(e,t){return"汇总"}},{title:"单位",field:"uom",sortable:!0,align:"center"},{title:"物料描述",field:"description",sortable:!0,align:"center"},{title:"退货数",field:"orderQty",sortable:!0,align:"center",editRender:{name:"input"},editPost:function(e,t){var a=t.orderQty;if(!Number.isNaN(a))return-Math.abs(Number(a))},footerRender:this.footerSum},{title:"累计退货数",field:"totalAcceptQty",sortable:!0,align:"center",editPost:function(e,t){var a=t.totalAcceptQty;if(!Number.isNaN(a))return-Math.abs(Number(a))},footerRender:this.footerSum},{title:"实际退货数",field:"acceptQty",sortable:!0,align:"center",editRender:{name:"input"},editPost:function(e,t){var a=t.acceptQty;if(!Number.isNaN(a))return-Math.abs(Number(a))},footerRender:this.footerSum},{title:"退货价",field:"costPrice",sortable:!0,align:"right",formatter:this.formatterMoney,editRender:{name:"input"}},{title:"退货总金额",field:"totalPrice",align:"right",formatter:this.formatterMoney,editPost:function(e,t){var a=t.orderQty,r=t.costPrice;if(!Number.isNaN(a)&&!Number.isNaN(r))return Number(a)*Number(r).toFixed(2)},footerRender:this.footerSum},{title:"货位",field:"warehouseSlotId",sortable:!0,align:"center"}],toolbar:{id:"full_edit_1",resizable:{storage:!0},setting:{storage:!0}}}},methods:{prodSeach:function(e,t){var a=this;e&&this.$axios.post(this.mixinViewModuleOptions.prodURL,{name:e,warehouseId:this.dataForm.warehouseId}).then((function(e){for(var r=0;r<e.length;r++)e[r].value=e[r].val;clearTimeout(a.timeout),a.timeout=setTimeout((function(){t(e)}),100*Math.random())}))},handleProcSelect:function(e,t){var a=e.row;t&&(Object.assign(a,t),a.uom=t.unit,a.productId=t.id,a.productCode=t.code)},initCB:function(){var e=this;this.pageTitle=this.isNew?"采购退货单新增":"采购退货单修改",this.$nextTick((function(){if(e.isNew)e.$refs.dataForm.readOnly(!1);else if("NEW"===e.entityModel.status)e.$refs.dataForm.readOnly(!1);else{if("SUBMIT"===e.entityModel.status||"SENDED"===e.entityModel.status)return e.entityModel.saveType="pick",e.enableSubmit=!0,e.pageTitle="采购退货单退货",e.$refs.dataForm.readOnly(!0,["shipId","shipType","payType","shipNum","freight","isAuto","remark"]),delete e.tableColumn[2].editRender,delete e.tableColumn[5].editRender,Object.assign(e.tableColumn[7],{editRender:{name:"input"}}),void e.$refs.sGrid.loadColumn(e.tableColumn);e.$refs.dataForm.readOnly(!0)}delete e.dataForm.saveType,delete e.tableColumn[7].editRender,Object.assign(e.tableColumn[5],{editRender:{name:"input"}}),Object.assign(e.tableColumn[2],{editRender:{name:"ElAutocomplete",props:{fetchSuggestions:e.prodSeach,triggerOnFocus:!1,popperClass:"prod-popper"},events:{select:e.handleProcSelect},autoselect:!0}}),e.$refs.sGrid.loadColumn(e.tableColumn)}))}},mounted:function(){}},n=s,d=a("623f"),u=function(e){e.options.__source="src/views/pur/poreturnheader-add-or-update.vue"},c=u,p=Object(d["a"])(n,r,i,!1,null,null,null);"function"===typeof c&&c(p);t["default"]=p.exports},"9d30":function(e,t,a){var r=a("e46b");r(r.S,"Number",{isNaN:function(e){return e!=e}})}}]);