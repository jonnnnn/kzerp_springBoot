(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-d757fb94"],{"44fa":function(e,t,a){"use strict";a.r(t);var r=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-dialog",{directives:[{name:"loading",rawName:"v-loading.fullscreen.lock",value:e.fullscreenLoading,expression:"fullscreenLoading",modifiers:{fullscreen:!0,lock:!0}}],staticClass:"abow_dialog",attrs:{title:e.isNew?"销售单新增":"销售单修改","close-on-click-modal":!1,visible:e.visible,width:"80%"},on:{"update:visible":function(t){e.visible=t}}},[a("div",[a("el-form",{ref:"dataForm",attrs:{model:e.dataForm,labelSuffix:"：",size:"mini",rules:e.dataRule,"label-width":"120px"}},[a("el-input",{staticStyle:{display:"none"},model:{value:e.dataForm.orderType,callback:function(t){e.$set(e.dataForm,"orderType",t)},expression:"dataForm.orderType"}}),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"客户",prop:"customerId"}},[a("im-selector",{attrs:{mapModel:e.dataForm,mapKeyVal:"customerName:customerId",dataType:"biz.customer",placeholder:"请选择客户"},on:{"update:mapModel":function(t){e.dataForm=t},"update:map-model":function(t){e.dataForm=t},change:e.changeCust},model:{value:e.dataForm.customerId,callback:function(t){e.$set(e.dataForm,"customerId",t)},expression:"dataForm.customerId"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"销售日期",prop:"orderDate"}},[a("el-date-picker",{attrs:{placeholder:"销售日期","value-format":"yyyy-MM-dd"},model:{value:e.dataForm.orderDate,callback:function(t){e.$set(e.dataForm,"orderDate",t)},expression:"dataForm.orderDate"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"要求交货期",prop:"planDeliveryDate"}},[a("el-date-picker",{attrs:{placeholder:"要求交货期","value-format":"yyyy-MM-dd"},model:{value:e.dataForm.planDeliveryDate,callback:function(t){e.$set(e.dataForm,"planDeliveryDate",t)},expression:"dataForm.planDeliveryDate"}})],1)],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"发运方式",prop:"shipType"}},[a("im-selector",{attrs:{mapModel:e.dataForm,mapKeyVal:"shipType",dataType:"dict.SHIP_TYPE"},on:{"update:mapModel":function(t){e.dataForm=t},"update:map-model":function(t){e.dataForm=t},change:e.changeCust},model:{value:e.dataForm.shipType,callback:function(t){e.$set(e.dataForm,"shipType",t)},expression:"dataForm.shipType"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"订单金额",prop:"orderAmount"}},[a("el-input",{attrs:{disabled:"",placeholder:"订单金额",clearable:""},model:{value:e.dataForm.orderAmount,callback:function(t){e.$set(e.dataForm,"orderAmount",t)},expression:"dataForm.orderAmount"}})],1)],1)],1),a("el-row",[a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"收货人",prop:"receiveName"}},[a("el-input",{attrs:{placeholder:"收货人",clearable:""},model:{value:e.dataForm.receiveName,callback:function(t){e.$set(e.dataForm,"receiveName",t)},expression:"dataForm.receiveName"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"收货人电话",prop:"receivePhone"}},[a("el-input",{attrs:{placeholder:"收货人电话",clearable:""},model:{value:e.dataForm.receivePhone,callback:function(t){e.$set(e.dataForm,"receivePhone",t)},expression:"dataForm.receivePhone"}})],1)],1),a("el-col",{attrs:{span:8}},[a("el-form-item",{attrs:{label:"收货地址",prop:"receiveAddress"}},[a("el-input",{attrs:{placeholder:"收货地址",clearable:""},model:{value:e.dataForm.receiveAddress,callback:function(t){e.$set(e.dataForm,"receiveAddress",t)},expression:"dataForm.receiveAddress"}})],1)],1)],1),a("el-row",[a("el-col",[a("el-form-item",{attrs:{label:"备注",prop:"remark"}},[a("el-input",{staticStyle:{width:"100%"},attrs:{placeholder:"备注"},model:{value:e.dataForm.remark,callback:function(t){e.$set(e.dataForm,"remark",t)},expression:"dataForm.remark"}})],1)],1)],1)],1)],1),a("vxe-grid",{ref:"sGrid",staticClass:"vxe-table-element",attrs:{border:"",resizable:"",size:"mini","highlight-current-row":"","remote-filter":"",toolbar:e.toolbar,"proxy-config":e.tableProxy,"edit-rules":e.validRules,columns:e.itableColumn,"select-config":{reserve:!0},"mouse-config":{selected:!0},"keyboard-config":{isArrow:!0,isDel:!0,isTab:!0,isEdit:!0},"edit-config":{trigger:"dblclick",mode:"cell"},"footer-cell-class-name":e.footerCellClassName,"footer-method":e.footerMethod,"show-footer":""},scopedSlots:e._u([{key:"buttons",fn:function(){return[a("el-button",{attrs:{size:"mini",icon:"el-icon-circle-plus"},on:{click:function(t){return e.$refs.sGrid.insert({})}}},[e._v("新增")]),a("el-button",{attrs:{type:"danger",size:"mini",icon:"el-icon-delete"},on:{click:function(t){return e.removeSelecteds(e.$refs.sGrid)}}},[e._v("删除")])]},proxy:!0}])}),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.visible=!1}}},[e._v("取消")]),a("el-button",{attrs:{type:"primary",disabled:e.btnDisable},on:{click:e.dataFormSubmit}},[e._v("确定")])],1)],1)},o=[],l=(a("cc57"),a("163d"),a("9d30"),a("e1a58")),i=a("be17"),s=a.n(i),n={mixins:[l["a"]],data:function(){return{restaurants:[],state1:"",state2:"",mixinViewModuleOptions:{getDataListURL:"/so/salesorderline/list",getDataListIsPage:!1,updateURL:"/so/salesorder/update",deleteIsBatch:!0,prodURL:"/base/product/search"},visible:!1,btnDisable:!1,dataForm:{id:void 0,orderNum:"",orderType:"SO",customerId:"",orderDate:new Date,planDeliveryDate:new Date,orderAmount:"0",shipType:"",remark:"",autoPeaking:!0,deletedFlag:"N",receiveName:"",receivePhone:"",receiveAddress:""},dataRule:{customerId:[{required:!0,message:"客户不能为空",trigger:"blur"}],orderDate:[{required:!0,message:"销售日期不能为空",trigger:"blur"}]},tableProxy:{autoLoad:!1},validRules:{name:[{required:!0,message:"商品必填"}],prodno:[{required:!0,message:"商品必填"}],orderQty:[{required:!0,message:"销售数量必填"},{type:"number",message:"请输入数字"}],price:[{required:!0,message:"销售价格必填"},{type:"number",message:"请输入数字"}]},itableColumn:[{type:"selection",width:50,align:"center"},{type:"index",width:50,align:"center"},{title:"商品编码",field:"prodno",width:"110px",align:"center"},{title:"商品名称",field:"name",width:"150px",align:"center",editRender:{name:"ElAutocomplete",props:{placeholder:"请输入内容",fetchSuggestions:this.prodSeach,triggerOnFocus:!1,popperClass:"prod-popper"},events:{select:this.handleProcSelect},autoselect:!0}},{title:"单位",field:"unit",width:"40px",align:"center"},{title:"规格",field:"specialParam",width:"100",align:"center"},{title:"生产厂家",field:"manufacture",width:"110px",align:"left"},{title:"批准文号",field:"approvalno",width:"110px",align:"left"},{title:"业务类型",field:"busitypetext",width:"110px",align:"center"},{title:"灭菌批号",field:"sterilization",width:"110px",align:"center"},{title:"数量",field:"orderQty",align:"center",width:"60px",editRender:{name:"input",autoselect:!0}},{title:"销售价",field:"price",sortable:!0,align:"center",width:"100px",editRender:{name:"input",autoselect:!0},footerRender:function(e,t){return"汇总"}},{title:"总金额",field:"amount",align:"left",width:"100px",formatter:["toFixedString",2],needReturnAmount:!0,editPost:function(e,t){var a=t.orderQty,r=t.price;if(!Number.isNaN(a)&&!Number.isNaN(r))return Number(a)*Number(r).toFixed(2)},footerRender:function(e,t){return s.a.sum(t,e.property)}},{title:"备注",field:"note",align:"center",width:"130px",editRender:{name:"input",autoselect:!0}}],toolbar:{id:"full_edit_1",resizable:{storage:!0},setting:{storage:!0}}}},methods:{prodSeach:function(e,t){var a=this;e&&this.$axios.post(this.mixinViewModuleOptions.prodURL,{name:e,customerId:this.dataForm.customerId,lastPrice:1}).then((function(e){for(var r=0;r<e.length;r++)e[r].value=e[r].allString;clearTimeout(a.timeout),a.timeout=setTimeout((function(){t(e)}),100*Math.random())}))},handleProcSelect:function(e,t){var a=e.row;t&&(Object.assign(a,t),a.productId=t.id,a.productName=t.name,a.stock=t.stock,a.bPrice=t.salePrice,a.productCode=t.code,a.price=t.salePrice,this.$refs.sGrid.updateFooter())},changeCust:function(e){},setAmount:function(e){this.dataForm.orderAmount=e},mounted:function(){}}},d=n,c=a("623f"),m=function(e){e.options.__source="src/views/so/salesorder-add-or-update.vue"},u=m,p=Object(c["a"])(d,r,o,!1,null,null,null);"function"===typeof u&&u(p);t["default"]=p.exports},"9d30":function(e,t,a){var r=a("e46b");r(r.S,"Number",{isNaN:function(e){return e!=e}})}}]);