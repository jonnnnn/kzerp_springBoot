(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-29cf9a26"],{"09d6":function(e,t,a){},c0cf:function(e,t,a){"use strict";var r=a("09d6"),l=a.n(r);l.a},e025:function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"loading",rawName:"v-loading.fullscreen.lock",value:e.fullscreenLoading,expression:"fullscreenLoading",modifiers:{fullscreen:!0,lock:!0}}],staticClass:"abow_dialog",attrs:{"close-on-press-escape":!1,title:"仓库拣货","close-on-click-modal":!1,visible:e.visible,width:"80%"},on:{"update:visible":function(t){e.visible=t}}},[a("dynamic-form",{ref:"dataForm",attrs:{formprops:e.formprops,"col-span":"6,6,*,6","read-only":e.formReadOnly,alldescriptors:e.descriptors},model:{value:e.dataForm,callback:function(t){e.dataForm=t},expression:"dataForm"}}),a("vxe-grid",{ref:"sGrid",staticClass:"vxe-table-element",attrs:{border:"",resizable:"",size:"mini","remote-filter":"",toolbar:e.toolbar,"proxy-config":e.tableProxy,columns:e.tableColumn,"mouse-config":{selected:!0},"keyboard-config":{isArrow:!0,isDel:!0,isTab:!0,isEdit:!0},"edit-config":{trigger:"dblclick",mode:"cell"},"cell-class-name":e.cellClassName,"footer-cell-class-name":e.footerCellClassName,"footer-method":e.footerMethod,"show-footer":""},scopedSlots:e._u([{key:"buttons",fn:function(){return[a("label",{staticStyle:{"margin-left":"30px"}},[e._v("输入产品条码：")]),a("el-input",{ref:"barCodeInput",staticClass:"barCode",attrs:{size:"mini",clearable:""},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.doScan(t)}},model:{value:e.dataForm.barCode,callback:function(t){e.$set(e.dataForm,"barCode",t)},expression:"dataForm.barCode"}})]},proxy:!0}])}),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"danger"},on:{click:function(t){e.visible=!1}}},[e._v("取消")]),a("el-button",{directives:[{name:"show",rawName:"v-show",value:e.enableSubmit,expression:"enableSubmit"}],attrs:{type:"primary",disabled:e.btnDisable},on:{click:e.dataFormSubmit}},[e._v("确定")])],1)],1)},l=[],o=(a("163d"),a("6d57"),a("e1a58")),i=a("be17"),n=a.n(i),s={type:"separate"},c={name:"inv-inoutbillline",mixins:[o["a"]],data:function(){var e=this;return{mixinViewModuleOptions:{getDataListURL:"/inv/inoutbillline/list",updateURL:"/inv/inoutbill/save",deleteIsBatch:!0,getDataListIsPage:!1},visible:!1,btnDisable:!1,dataForm:{},descriptors:{billNum:{type:"string",label:"业务单号",props:{clearable:!0}},transactionType:{type:"cust",label:"业务类型",name:"im-selector",props:{mapKeyVal:"transactionType",dataType:"code.tran_type",clearable:!0,placeholder:"请选择业务类型"}},status:{type:"cust",label:"单据状态",name:"im-selector",props:{mapKeyVal:"status",dataType:"code.status",clearable:!0}},separate1:s,sourceOrderNum:{type:"string",label:"单据单号"},warehouseId:{type:"cust",label:"出入仓库",ruletype:"integer",name:"im-selector",props:{mapKeyVal:"warehouseCode:warehouseId",dataType:"biz.warehouse",clearable:!0}},inDate:{name:"el-date-picker",type:"cust",label:"出入库日期",props:{type:"date"}}},tableProxy:{autoLoad:!1},tableColumn:[{type:"selection",width:30,align:"center"},{type:"index",width:50,align:"center"},{title:"产品",field:"productCode",sortable:!0,align:"center"},{title:"条码",field:"barCode",sortable:!0,align:"center"},{title:"单位",field:"uom",align:"center",footerRender:function(e,t){return"汇总"}},{title:"目标出入库数量",field:"qty",align:"center",footerRender:function(e,t){return n.a.sum(t,e.property)}},{title:"实际出入库数量",field:"realQty",align:"center",editRender:{name:"input"},footerRender:function(e,t){return n.a.sum(t,e.property)},editPost:function(t,a){return e.doScan(a.barCode)}},{title:"状态",field:"statusMean",sortable:!0,align:"center"},{title:"备注",field:"remark",sortable:!0,align:"center",editRender:{name:"input"}}],toolbar:{id:"full_edit_1",resizable:{storage:!0},setting:{storage:!0}},statusProps:{clearable:!0,placeholder:"请选择状态"}}},created:function(){},methods:{initCB:function(){var e=this;this.$nextTick((function(){e.$refs.barCodeInput&&e.$refs.barCodeInput.focus(),e.$refs.dataForm.readOnly(!0)}))},doScan:function(e){var t=this,a=0,r=e.target?e.target.value:e;if(r&&r.length>0){var l=!1,o=!1;if(this.dataList.forEach((function(i){var n=i.realQty||0;i.barCode===r&&(l=!0,e.target?i.qty>0?n<i.qty?i.realQty=Number(i.realQty)+1:o=!0:n>i.qty?i.realQty=Number(i.realQty)-1:o=!0:(a=i.realQty,i.qty>0?i.realQty==i.qty?o=!0:i.realQty>i.qty&&(a=i.realQty=0):i.realQty==i.qty?o=!0:i.realQty<i.qty&&(a=i.realQty=0))),Math.abs(i.realQty)>0?t.$refs.sGrid.setSelection([i],!0):t.$refs.sGrid.setSelection([i],!1)})),!e.target)return a;if(!l)return this.dataForm.barCode="",this.$message({message:"条码不存在",type:"error",duration:2e3});if(o)return this.dataForm.barCode="",this.$message({message:"条码["+r+"]已完成拣货",type:"warn",duration:2e3});this.$refs.sGrid.updateFooter()}},cellClassName:function(e){var t=e.row,a=e.column,r=t.realQty||0;if(t.qty>r&&"realQty"===a.property)return"col-red"}},computed:{},mounted:function(){}},d=c,u=(a("c0cf"),a("623f")),p=function(e){e.options.__source="src/views/inv/inoutbill-add-or-update.vue"},f=p,b=Object(u["a"])(d,r,l,!1,null,null,null);"function"===typeof f&&f(b);t["default"]=b.exports}}]);