(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-041eb6e8"],{6510:function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-dialog",{attrs:{title:e.dataForm.id?"修改":"新增","close-on-click-modal":!1,visible:e.visible,width:"80%"},on:{"update:visible":function(t){e.visible=t}}},[i("div",{attrs:{slot:"title"},slot:"title"},[i("el-form",{ref:"dataForm",attrs:{model:e.dataForm,labelSuffix:"：",size:"mini",rules:e.dataRule,"label-width":"120px"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.dataFormSubmit()}}},[i("el-row",{attrs:{inline:""}},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"客户",prop:"customerId"}},[i("el-input",{staticStyle:{width:"220px"},attrs:{placeholder:"客户"},model:{value:e.dataForm.customerId,callback:function(t){e.$set(e.dataForm,"customerId",t)},expression:"dataForm.customerId"}})],1)],1),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"销售日期",prop:"orderDate"}},[i("el-date-picker",{staticStyle:{width:"160px"},attrs:{placeholder:"销售日期","value-format":"yyyy-MM-dd"},model:{value:e.dataForm.orderDate,callback:function(t){e.$set(e.dataForm,"orderDate",t)},expression:"dataForm.orderDate"}})],1)],1),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"要求交货期",prop:"planDeliveryDate"}},[i("el-date-picker",{staticStyle:{width:"160px"},attrs:{placeholder:"要求交货期","value-format":"yyyy-MM-dd"},model:{value:e.dataForm.planDeliveryDate,callback:function(t){e.$set(e.dataForm,"planDeliveryDate",t)},expression:"dataForm.planDeliveryDate"}})],1)],1)],1),i("el-row",{attrs:{inline:""}},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"发运方式",prop:"shipType"}},[i("el-input",{attrs:{placeholder:"发运方式"},model:{value:e.dataForm.shipType,callback:function(t){e.$set(e.dataForm,"shipType",t)},expression:"dataForm.shipType"}})],1)],1),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"订单金额",prop:"orderAmount"}},[i("el-input",{attrs:{placeholder:"订单金额"},model:{value:e.dataForm.orderAmount,callback:function(t){e.$set(e.dataForm,"orderAmount",t)},expression:"dataForm.orderAmount"}})],1)],1)],1),i("el-row",{attrs:{inline:""}},[i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"收货人",prop:"receiveName"}},[i("el-input",{attrs:{placeholder:"收货人"},model:{value:e.dataForm.receiveName,callback:function(t){e.$set(e.dataForm,"receiveName",t)},expression:"dataForm.receiveName"}})],1)],1),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"收货人电话",prop:"receivePhone"}},[i("el-input",{attrs:{placeholder:"收货人电话"},model:{value:e.dataForm.receivePhone,callback:function(t){e.$set(e.dataForm,"receivePhone",t)},expression:"dataForm.receivePhone"}})],1)],1),i("el-col",{attrs:{span:8}},[i("el-form-item",{attrs:{label:"收货地址",prop:"receiveAddress"}},[i("el-input",{attrs:{placeholder:"收货地址"},model:{value:e.dataForm.receiveAddress,callback:function(t){e.$set(e.dataForm,"receiveAddress",t)},expression:"dataForm.receiveAddress"}})],1)],1)],1),i("el-form-item",{attrs:{label:"备注",prop:"remark"}},[i("el-input",{attrs:{placeholder:"备注"},model:{value:e.dataForm.remark,callback:function(t){e.$set(e.dataForm,"remark",t)},expression:"dataForm.remark"}})],1)],1)],1),i("vxe-grid",{ref:"xGrid2",staticClass:"vxe-table-element",attrs:{border:"",resizable:"",size:"mini","highlight-current-row":"","remote-filter":"",toolbar:e.toolbar,"proxy-config":e.itableProxy,columns:e.itableColumn,"select-config":{reserve:!0},"mouse-config":{selected:!0},"keyboard-config":{isArrow:!0,isDel:!0,isTab:!0,isEdit:!0},"edit-config":{trigger:"dblclick",mode:"cell"}},on:{"edit-closed":e.setTotal}}),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(t){e.visible=!1}}},[e._v("取消")]),i("el-button",{attrs:{type:"primary",disabled:e.btnDisable},on:{click:function(t){return e.dataFormSubmit()}}},[e._v("确定")])],1)],1)},r=[],n=(i("163d"),i("9d30"),i("63ff"),i("57f0")),o=(i("6d57"),i("c904"),i("ed57")),s=i("e8bc"),l=i("e1a58"),u={mixins:[l["a"]],components:{ElInput:s["a"],ElCol:o["a"]},data:function(){var e=this;return{mixinViewModuleOptions:{getDataListURL:"/so/salesorderline/list",getDataListIsPage:!1,updateURL:"/so/salesorder/update",deleteIsBatch:!0,prodURL:"/so/salesorder/prod"},visible:!1,btnDisable:!1,dataForm:{id:0,orderType:"SO",orderNum:"",customerId:"1",orderDate:"2019-08-05",pic:"销售员1",shipType:"1",planDeliveryDate:"2019-08-05",status:"",orderAmount:"",receiveAddress:"地址",receiveName:"收货人",receivePhone:"收货电话",remark:"",deletedFlag:"N"},dataRule:{orderType:[{required:!0,message:"订单类型(销售/退货/报价)不能为空",trigger:"blur"}],orderNum:[{required:!0,message:"订单号不能为空",trigger:"blur"}],customerId:[{required:!0,message:"客户id不能为空",trigger:"blur"}],orderDate:[{required:!0,message:"销售日期不能为空",trigger:"blur"}],pic:[{required:!0,message:"业务员id不能为空",trigger:"blur"}],planDeliveryDate:[{required:!0,message:"要求交货期不能为空",trigger:"blur"}],status:[{required:!0,message:"单据状态不能为空",trigger:"blur"}],orderAmount:[{required:!0,message:"订单金额不能为空",trigger:"blur"}],receiveAddress:[{required:!0,message:"收货地址不能为空",trigger:"blur"}],receiveName:[{required:!0,message:"收货人不能为空",trigger:"blur"}],receivePhone:[{required:!0,message:"收货人电话不能为空",trigger:"blur"}],remark:[{required:!0,message:"备注不能为空",trigger:"blur"}],companyId:[{required:!0,message:"公司不能为空",trigger:"blur"}],deletedFlag:[{required:!0,message:"删除标记不能为空",trigger:"blur"}],createBy:[{required:!0,message:"创建人不能为空",trigger:"blur"}],createDate:[{required:!0,message:"创建日期不能为空",trigger:"blur"}],updateBy:[{required:!0,message:"修改人不能为空",trigger:"blur"}],updateDate:[{required:!0,message:"修改日期不能为空",trigger:"blur"}]},restaurants:[{id:1,value:"前端",name:"前端"},{id:2,value:"后端",name:"后端"}],itableColumn:[{type:"selection",width:30,align:"center"},{type:"index",width:30,align:"center"},{title:"物料名称",field:"productName",width:"200px",align:"center",editRender:{name:"ElAutocomplete",props:{fetchSuggestions:this.prodSeach,triggerOnFocus:!1},events:{select:this.handleProcSelect}}},{title:"当前库存",field:"stock",align:"left"},{title:"指导售价",field:"bPrice",align:"left"},{title:"下单数量",field:"orderQty",align:"left",editRender:{name:"input"}},{title:"销售价",field:"price",sortable:!0,align:"center",editRender:{name:"input"}},{title:"总金额",field:"totalPrice",align:"center",formatter:["toFixedString",2]},{title:"条码",field:"barCode",align:"center"},{title:"品牌",field:"brand",align:"center"},{title:"车型",field:"vehicle",align:"center"},{title:"产地",field:"madein",align:"center"},{title:"规格属性",field:"specialParam",align:"center"}],itableProxy:{index:!0,sort:!0,filter:!0,ajax:{query:function(t){t.page;var i=t.sort,a=t.filters,r={sort:i.property,order:i.order};return a.forEach((function(e){e.column;var t=e.property,i=e.values;r[t]=i.join(",")})),new Promise(function(){var t=Object(n["a"])(regeneratorRuntime.mark((function t(i,a){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.$axios.post(e.mixinViewModuleOptions.getDataListURL,{pageForm:{order:e.order,orderField:e.orderField,page:e.mixinViewModuleOptions.getDataListIsPage?e.page:null,limit:e.mixinViewModuleOptions.getDataListIsPage?e.limit:null},dataForm:{data:e.dataForm}}).then((function(t){e.dataList=t}));case 2:i({total:e.total,list:e.dataList});case 3:case"end":return t.stop()}}),t)})));return function(e,i){return t.apply(this,arguments)}}())},save:function(e){e.body}},props:{list:"list",result:"list",total:"totalCount"}},toolbar:{id:"full_edit_1",buttons:[{code:"insert_actived",name:"新增"},{code:"remove_selection",name:"删除"},{code:"save",name:"保存"}],resizable:{storage:!0},setting:{storage:!0}}}},methods:{init:function(e){var t=this;this.dataForm.id=e||0,this.visible=!0,this.$nextTick((function(){t.$refs["dataForm"].resetFields(),t.dataForm.id&&t.$axios.get("/so/salesorder/info/".concat(t.dataForm.id)).then((function(e){e&&(t.dataForm=e),t.$refs.xGrid2.commitProxy("reload")})).catch((function(e){}))}))},dataFormSubmit:function(){var e=this;this.btnDisable=!0;var t=this.getItemListDate(this.$refs.xGrid2);this.$refs["dataForm"].validate((function(i){i&&(e.dataForm.lines=t,e.$axios.post(e.mixinViewModuleOptions.updateURL,e.dataForm).then((function(t){t.data;e.btnDisable=!1,e.$message({message:"操作成功",type:"success",duration:1500,onClose:function(){e.visible=!1,e.$emit("refreshDataList")}})})))}))},prodSeach:function(e,t){var i=this;e&&this.$axios.post(this.mixinViewModuleOptions.prodURL,{name:e}).then((function(e){for(var a=0;a<e.length;a++)e[a].value=e[a].val;clearTimeout(i.timeout),i.timeout=setTimeout((function(){t(e)}),100*Math.random())}))},handleProcSelect:function(e,t){var i=e.row;t&&(i.barCode=t.barCode,i.brand=t.brand,i.vehicle=t.vehicle,i.madein=t.madein,i.specialParam=t.specialParam,i.stock=t.stock,i.bPrice=t.salePrice)},setTotal:function(e){var t=e.column,i=e.row;if("orderQty"===t.property||"price"===t.property){var a=i.orderQty,r=i.price;Number.isNaN(a)||Number.isNaN(r)||(i.totalPrice=Number(a)*Number(r).toFixed(2))}}}},d=u,c=i("623f"),p=function(e){e.options.__source="src/views/so/lizi-add-or-update.vue"},m=p,h=Object(c["a"])(d,a,r,!1,null,null,null);"function"===typeof m&&m(h);t["default"]=h.exports},"9d30":function(e,t,i){var a=i("e46b");a(a.S,"Number",{isNaN:function(e){return e!=e}})},e8bc:function(e,t,i){"use strict";var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{class:["textarea"===e.type?"el-textarea":"el-input",e.inputSize?"el-input--"+e.inputSize:"",{"is-disabled":e.inputDisabled,"is-exceed":e.inputExceed,"el-input-group":e.$slots.prepend||e.$slots.append,"el-input-group--append":e.$slots.append,"el-input-group--prepend":e.$slots.prepend,"el-input--prefix":e.$slots.prefix||e.prefixIcon,"el-input--suffix":e.$slots.suffix||e.suffixIcon||e.clearable||e.showPassword}],on:{mouseenter:function(t){e.hovering=!0},mouseleave:function(t){e.hovering=!1}}},["textarea"!==e.type?[e.$slots.prepend?i("div",{staticClass:"el-input-group__prepend"},[e._t("prepend")],2):e._e(),"textarea"!==e.type?i("input",e._b({ref:"input",staticClass:"el-input__inner",attrs:{tabindex:e.tabindex,type:e.showPassword?e.passwordVisible?"text":"password":e.type,disabled:e.inputDisabled,readonly:e.readonly,autocomplete:e.autoComplete||e.autocomplete,"aria-label":e.label},on:{compositionstart:e.handleCompositionStart,compositionend:e.handleCompositionEnd,input:e.handleInput,focus:e.handleFocus,blur:e.handleBlur,change:e.handleChange}},"input",e.$attrs,!1)):e._e(),e.$slots.prefix||e.prefixIcon?i("span",{staticClass:"el-input__prefix"},[e._t("prefix"),e.prefixIcon?i("i",{staticClass:"el-input__icon",class:e.prefixIcon}):e._e()],2):e._e(),e.getSuffixVisible()?i("span",{staticClass:"el-input__suffix"},[i("span",{staticClass:"el-input__suffix-inner"},[e.showClear&&e.showPwdVisible&&e.isWordLimitVisible?e._e():[e._t("suffix"),e.suffixIcon?i("i",{staticClass:"el-input__icon",class:e.suffixIcon}):e._e()],e.showClear?i("i",{staticClass:"el-input__icon el-icon-circle-close el-input__clear",on:{click:e.clear}}):e._e(),e.showPwdVisible?i("i",{staticClass:"el-input__icon el-icon-view el-input__clear",on:{click:e.handlePasswordVisible}}):e._e(),e.isWordLimitVisible?i("span",{staticClass:"el-input__count"},[i("span",{staticClass:"el-input__count-inner"},[e._v("\n            "+e._s(e.textLength)+"/"+e._s(e.upperLimit)+"\n          ")])]):e._e()],2),e.validateState?i("i",{staticClass:"el-input__icon",class:["el-input__validateIcon",e.validateIcon]}):e._e()]):e._e(),e.$slots.append?i("div",{staticClass:"el-input-group__append"},[e._t("append")],2):e._e()]:i("textarea",e._b({ref:"textarea",staticClass:"el-textarea__inner",style:e.textareaStyle,attrs:{tabindex:e.tabindex,disabled:e.inputDisabled,readonly:e.readonly,autocomplete:e.autoComplete||e.autocomplete,"aria-label":e.label},on:{compositionstart:e.handleCompositionStart,compositionend:e.handleCompositionEnd,input:e.handleInput,focus:e.handleFocus,blur:e.handleBlur,change:e.handleChange}},"textarea",e.$attrs,!1)),e.isWordLimitVisible&&"textarea"===e.type?i("span",{staticClass:"el-input__count"},[e._v(e._s(e.textLength)+"/"+e._s(e.upperLimit))]):e._e()],2)},r=[];i("163d");function n(e,t,i){this.$children.forEach(a=>{var r=a.$options.componentName;r===e?a.$emit.apply(a,[t].concat(i)):n.apply(a,[e,t].concat([i]))})}var o={methods:{dispatch(e,t,i){var a=this.$parent||this.$root,r=a.$options.componentName;while(a&&(!r||r!==e))a=a.$parent,a&&(r=a.$options.componentName);a&&a.$emit.apply(a,[t].concat(i))},broadcast(e,t,i){n.call(this,e,t,i)}}};i("0261");Object.prototype.hasOwnProperty;var s={mounted(){},methods:{getMigratingConfig(){return{props:{},events:{}}}}};let l;const u="\n  height:0 !important;\n  visibility:hidden !important;\n  overflow:hidden !important;\n  position:absolute !important;\n  z-index:-1000 !important;\n  top:0 !important;\n  right:0 !important\n",d=["letter-spacing","line-height","padding-top","padding-bottom","font-family","font-weight","font-size","text-rendering","text-transform","width","text-indent","padding-left","padding-right","border-width","box-sizing"];function c(e){const t=window.getComputedStyle(e),i=t.getPropertyValue("box-sizing"),a=parseFloat(t.getPropertyValue("padding-bottom"))+parseFloat(t.getPropertyValue("padding-top")),r=parseFloat(t.getPropertyValue("border-bottom-width"))+parseFloat(t.getPropertyValue("border-top-width")),n=d.map(e=>`${e}:${t.getPropertyValue(e)}`).join(";");return{contextStyle:n,paddingSize:a,borderSize:r,boxSizing:i}}function p(e,t=1,i=null){l||(l=document.createElement("textarea"),document.body.appendChild(l));let{paddingSize:a,borderSize:r,boxSizing:n,contextStyle:o}=c(e);l.setAttribute("style",`${o};${u}`),l.value=e.value||e.placeholder||"";let s=l.scrollHeight;const d={};"border-box"===n?s+=r:"content-box"===n&&(s-=a),l.value="";let p=l.scrollHeight-a;if(null!==t){let e=p*t;"border-box"===n&&(e=e+a+r),s=Math.max(e,s),d.minHeight=`${e}px`}if(null!==i){let e=p*i;"border-box"===n&&(e=e+a+r),s=Math.min(e,s)}return d.height=`${s}px`,l.parentNode&&l.parentNode.removeChild(l),l=null,d}var m=function(e){for(let t=1,i=arguments.length;t<i;t++){let i=arguments[t]||{};for(let t in i)if(i.hasOwnProperty(t)){let a=i[t];void 0!==a&&(e[t]=a)}}return e},h={name:"ElInput",componentName:"ElInput",mixins:[o,s],inheritAttrs:!1,inject:{elForm:{default:""},elFormItem:{default:""}},data:function(){return{textareaCalcStyle:{},hovering:!1,focused:!1,isComposing:!1,passwordVisible:!1}},props:{value:[String,Number],size:String,resize:String,form:String,disabled:Boolean,readonly:Boolean,type:{type:String,default:"text"},autosize:{type:[Boolean,Object],default:!1},autocomplete:{type:String,default:"off"},autoComplete:{type:String,validator:function(e){return!0}},validateEvent:{type:Boolean,default:!0},suffixIcon:String,prefixIcon:String,label:String,clearable:{type:Boolean,default:!1},showPassword:{type:Boolean,default:!1},showWordLimit:{type:Boolean,default:!1},tabindex:String},computed:{_elFormItemSize:function(){return(this.elFormItem||{}).elFormItemSize},validateState:function(){return this.elFormItem?this.elFormItem.validateState:""},needStatusIcon:function(){return!!this.elForm&&this.elForm.statusIcon},validateIcon:function(){return{validating:"el-icon-loading",success:"el-icon-circle-check",error:"el-icon-circle-close"}[this.validateState]},textareaStyle:function(){return m({},this.textareaCalcStyle,{resize:this.resize})},inputSize:function(){return this.size||this._elFormItemSize||(this.$ELEMENT||{}).size},inputDisabled:function(){return this.disabled||(this.elForm||{}).disabled},nativeInputValue:function(){return null===this.value||void 0===this.value?"":String(this.value)},showClear:function(){return this.clearable&&!this.inputDisabled&&!this.readonly&&this.nativeInputValue&&(this.focused||this.hovering)},showPwdVisible:function(){return this.showPassword&&!this.inputDisabled&&!this.readonly&&(!!this.nativeInputValue||this.focused)},isWordLimitVisible:function(){return this.showWordLimit&&this.$attrs.maxlength&&("text"===this.type||"textarea"===this.type)&&!this.inputDisabled&&!this.readonly&&!this.showPassword},upperLimit:function(){return this.$attrs.maxlength},textLength:function(){return"number"===typeof this.value?String(this.value).length:(this.value||"").length},inputExceed:function(){return this.isWordLimitVisible&&this.textLength>this.upperLimit}},watch:{value:function(e){this.$nextTick(this.resizeTextarea),this.validateEvent&&this.dispatch("ElFormItem","el.form.change",[e])},nativeInputValue:function(){this.setNativeInputValue()},type:function(){var e=this;this.$nextTick((function(){e.setNativeInputValue(),e.resizeTextarea(),e.updateIconOffset()}))}},methods:{focus:function(){this.getInput().focus()},blur:function(){this.getInput().blur()},getMigratingConfig:function(){return{props:{icon:"icon is removed, use suffix-icon / prefix-icon instead.","on-icon-click":"on-icon-click is removed."},events:{click:"click is removed."}}},handleBlur:function(e){this.focused=!1,this.$emit("blur",e),this.validateEvent&&this.dispatch("ElFormItem","el.form.blur",[this.value])},select:function(){this.getInput().select()},resizeTextarea:function(){if(!this.$isServer){var e=this.autosize,t=this.type;if("textarea"===t)if(e){var i=e.minRows,a=e.maxRows;this.textareaCalcStyle=p(this.$refs.textarea,i,a)}else this.textareaCalcStyle={minHeight:p(this.$refs.textarea).minHeight}}},setNativeInputValue:function(){var e=this.getInput();e&&e.value!==this.nativeInputValue&&(e.value=this.nativeInputValue)},handleFocus:function(e){this.focused=!0,this.$emit("focus",e)},handleCompositionStart:function(){this.isComposing=!0},handleCompositionEnd:function(e){this.isComposing=!1,this.handleInput(e)},handleInput:function(e){this.isComposing||e.target.value!==this.nativeInputValue&&(this.$emit("input",e.target.value),this.$nextTick(this.setNativeInputValue))},handleChange:function(e){this.$emit("change",e.target.value)},calcIconOffset:function(e){var t=[].slice.call(this.$el.querySelectorAll(".el-input__".concat(e))||[]);if(t.length){for(var i=null,a=0;a<t.length;a++)if(t[a].parentNode===this.$el){i=t[a];break}if(i){var r={suffix:"append",prefix:"prepend"},n=r[e];this.$slots[n]?i.style.transform="translateX(".concat("suffix"===e?"-":"").concat(this.$el.querySelector(".el-input-group__".concat(n)).offsetWidth,"px)"):i.removeAttribute("style")}}},updateIconOffset:function(){this.calcIconOffset("prefix"),this.calcIconOffset("suffix")},clear:function(){this.$emit("input",""),this.$emit("change",""),this.$emit("clear")},handlePasswordVisible:function(){this.passwordVisible=!this.passwordVisible,this.focus()},getInput:function(){return this.$refs.input||this.$refs.textarea},getSuffixVisible:function(){return this.$slots.suffix||this.suffixIcon||this.showClear||this.showPassword||this.isWordLimitVisible||this.validateState&&this.needStatusIcon}},created:function(){this.$on("inputSelect",this.select)},mounted:function(){this.setNativeInputValue(),this.resizeTextarea(),this.updateIconOffset()},updated:function(){this.$nextTick(this.updateIconOffset)}},f=h,g=i("623f"),b=function(e){e.options.__source="node_modules/_element-ui@2.10.1@element-ui/packages/input/src/input.vue"},v=b,x=Object(g["a"])(f,a,r,!1,null,null,null);"function"===typeof v&&v(x);t["a"]=x.exports},ed57:function(e,t,i){"use strict";t["a"]={name:"ElCol",props:{span:{type:Number,default:24},tag:{type:String,default:"div"},offset:Number,pull:Number,push:Number,xs:[Number,Object],sm:[Number,Object],md:[Number,Object],lg:[Number,Object],xl:[Number,Object]},computed:{gutter(){let e=this.$parent;while(e&&"ElRow"!==e.$options.componentName)e=e.$parent;return e?e.gutter:0}},render(e){let t=[],i={};return this.gutter&&(i.paddingLeft=this.gutter/2+"px",i.paddingRight=i.paddingLeft),["span","offset","pull","push"].forEach(e=>{(this[e]||0===this[e])&&t.push("span"!==e?`el-col-${e}-${this[e]}`:`el-col-${this[e]}`)}),["xs","sm","md","lg","xl"].forEach(e=>{if("number"===typeof this[e])t.push(`el-col-${e}-${this[e]}`);else if("object"===typeof this[e]){let i=this[e];Object.keys(i).forEach(a=>{t.push("span"!==a?`el-col-${e}-${a}-${i[a]}`:`el-col-${e}-${i[a]}`)})}}),e(this.tag,{class:["el-col",t],style:i},this.$slots.default)}}}}]);