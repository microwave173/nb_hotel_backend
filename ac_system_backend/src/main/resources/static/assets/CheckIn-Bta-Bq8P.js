import{r as p,c as T,d as n,a as l,u as C,w as o,f as R,L as I,b as u,o as y,Q as S,i as d,t as r,F as W,y as j,J as k}from"./index-BE7gfLc4.js";import{_ as z}from"./_plugin-vue_export-helper-DlAUqK2U.js";const A={class:"check-in-container"},G={class:"page-header"},H={class:"room-status"},K={class:"dialog-footer"},X={class:"confirm-content"},Y={class:"dialog-footer"},Z={class:"card-header"},h={class:"booking-preview"},ee={__name:"CheckIn",setup(le){const U=j(),x=p([{roomNumber:"101",roomType:"大床房",price:300,occupied:!1},{roomNumber:"102",roomType:"大床房",price:300,occupied:!0},{roomNumber:"103",roomType:"双床房",price:400,occupied:!1},{roomNumber:"104",roomType:"双床房",price:400,occupied:!1},{roomNumber:"105",roomType:"双床房",price:400,occupied:!0}]),m=p(!1),c=p(!1),V=p(!0),t=p({name:"",idNumber:"",secondName:"",secondIdNumber:"",roomType:"",roomNumber:"",checkInDate:"",days:1}),N=p({roomType:"大床房",date:"2023-12-25"}),B=f=>{t.value.roomType=f.roomType,t.value.roomNumber=f.roomNumber,m.value=!0},D=()=>{m.value=!1,c.value=!0},q=()=>{const f=Math.floor(1e5+Math.random()*9e5);k.success("押金支付成功，入住办理完成！"),k({message:`您的房间密码是：${f}，请妥善保管`,type:"success",duration:0,showClose:!0}),c.value=!1},F=()=>{c.value=!1,m.value=!0},P=()=>{V.value=!1,k.info("正在处理在线预订请求...")};return(f,e)=>{const s=u("el-button"),v=u("el-table-column"),$=u("el-tag"),M=u("el-table"),_=u("el-divider"),b=u("el-input"),i=u("el-form-item"),w=u("el-option"),E=u("el-select"),O=u("el-date-picker"),J=u("el-input-number"),L=u("el-form"),g=u("el-dialog"),Q=u("el-card");return y(),T("div",A,[n("div",G,[l(s,{type:"primary",icon:C(S),circle:"",onClick:e[0]||(e[0]=a=>C(U).back()),class:"back-button"},null,8,["icon"]),e[11]||(e[11]=n("span",{class:"title"},"办理入住",-1))]),n("div",H,[l(M,{data:x.value,style:{width:"100%"}},{default:o(()=>[l(v,{prop:"roomNumber",label:"房间号",width:"80"}),l(v,{prop:"roomType",label:"房型",width:"120"}),l(v,{prop:"price",label:"定价",width:"100"}),l(v,{prop:"occupied",label:"入住状态",width:"120"},{default:o(a=>[l($,{type:a.row.occupied?"success":"info"},{default:o(()=>[d(r(a.row.occupied?"已入住":"空闲"),1)]),_:2},1032,["type"])]),_:1}),l(v,{label:"操作"},{default:o(a=>[l(s,{type:"primary",onClick:oe=>B(a.row),disabled:a.row.occupied},{default:o(()=>e[12]||(e[12]=[d("办理入住")])),_:2},1032,["onClick","disabled"])]),_:1})]),_:1},8,["data"])]),l(g,{modelValue:m.value,"onUpdate:modelValue":e[9]||(e[9]=a=>m.value=a),title:"入住登记",width:"600px"},{footer:o(()=>[n("div",K,[l(s,{onClick:e[8]||(e[8]=a=>m.value=!1)},{default:o(()=>e[16]||(e[16]=[d("取消")])),_:1}),l(s,{type:"primary",onClick:D},{default:o(()=>e[17]||(e[17]=[d("确认入住")])),_:1})])]),default:o(()=>[l(L,{model:t.value,"label-width":"120px"},{default:o(()=>[l(_,{"content-position":"left"},{default:o(()=>e[13]||(e[13]=[d("入住人信息")])),_:1}),l(i,{label:"姓名",required:""},{default:o(()=>[l(b,{modelValue:t.value.name,"onUpdate:modelValue":e[1]||(e[1]=a=>t.value.name=a),placeholder:"请输入姓名"},null,8,["modelValue"])]),_:1}),l(i,{label:"身份证号",required:""},{default:o(()=>[l(b,{modelValue:t.value.idNumber,"onUpdate:modelValue":e[2]||(e[2]=a=>t.value.idNumber=a),placeholder:"请输入身份证号"},null,8,["modelValue"])]),_:1}),l(_,{"content-position":"left"},{default:o(()=>e[14]||(e[14]=[d("第二入住人信息（选填）")])),_:1}),l(i,{label:"姓名"},{default:o(()=>[l(b,{modelValue:t.value.secondName,"onUpdate:modelValue":e[3]||(e[3]=a=>t.value.secondName=a),placeholder:"请输入第二位入住人姓名"},null,8,["modelValue"])]),_:1}),l(i,{label:"身份证号"},{default:o(()=>[l(b,{modelValue:t.value.secondIdNumber,"onUpdate:modelValue":e[4]||(e[4]=a=>t.value.secondIdNumber=a),placeholder:"请输入第二位入住人身份证号"},null,8,["modelValue"])]),_:1}),l(_,{"content-position":"left"},{default:o(()=>e[15]||(e[15]=[d("入住信息")])),_:1}),l(i,{label:"房型",required:""},{default:o(()=>[l(E,{modelValue:t.value.roomType,"onUpdate:modelValue":e[5]||(e[5]=a=>t.value.roomType=a),placeholder:"请选择房型"},{default:o(()=>[l(w,{label:"大床房",value:"大床房"}),l(w,{label:"双床房",value:"双床房"})]),_:1},8,["modelValue"])]),_:1}),l(i,{label:"入住时间",required:""},{default:o(()=>[l(O,{modelValue:t.value.checkInDate,"onUpdate:modelValue":e[6]||(e[6]=a=>t.value.checkInDate=a),type:"date",placeholder:"选择入住日期",style:{width:"100%"}},null,8,["modelValue"])]),_:1}),l(i,{label:"入住天数",required:""},{default:o(()=>[l(J,{modelValue:t.value.days,"onUpdate:modelValue":e[7]||(e[7]=a=>t.value.days=a),min:1,max:30},null,8,["modelValue"])]),_:1})]),_:1},8,["model"])]),_:1},8,["modelValue"]),l(g,{modelValue:c.value,"onUpdate:modelValue":e[10]||(e[10]=a=>c.value=a),title:"确认入住信息",width:"400px"},{footer:o(()=>[n("div",Y,[l(s,{onClick:F},{default:o(()=>e[23]||(e[23]=[d("返回修改")])),_:1}),l(s,{type:"primary",onClick:q},{default:o(()=>e[24]||(e[24]=[d("支付押金")])),_:1})])]),default:o(()=>[n("div",X,[e[18]||(e[18]=n("h4",null,"房间信息",-1)),n("p",null,"房间号："+r(t.value.roomNumber),1),n("p",null,"房型："+r(t.value.roomType),1),n("p",null,"入住时间："+r(t.value.checkInDate),1),n("p",null,"入住天数："+r(t.value.days)+"天",1),e[19]||(e[19]=n("h4",null,"入住人信息",-1)),n("p",null,"姓名："+r(t.value.name),1),n("p",null,"身份证号："+r(t.value.idNumber),1),t.value.secondName?(y(),T(W,{key:0},[n("p",null,"第二入住人："+r(t.value.secondName),1),n("p",null,"第二入住人身份证号："+r(t.value.secondIdNumber),1)],64)):I("",!0),e[20]||(e[20]=n("h4",null,"押金信息",-1)),e[21]||(e[21]=n("p",null,"押金金额：500元",-1)),e[22]||(e[22]=n("div",{class:"wifi-info"},[n("h4",null,"WiFi信息"),n("p",null,"名称：BUPT_hotel"),n("p",null,"密码：BUPT123")],-1))])]),_:1},8,["modelValue"]),V.value?(y(),R(Q,{key:0,class:"online-booking-card"},{header:o(()=>[n("div",Z,[e[26]||(e[26]=n("span",null,"新的在线预订请求",-1)),l(s,{type:"text",onClick:P},{default:o(()=>e[25]||(e[25]=[d("查看详情")])),_:1})])]),default:o(()=>[n("div",h,[d(" 预订房型："+r(N.value.roomType),1),e[27]||(e[27]=n("br",null,null,-1)),d(" 预订时间："+r(N.value.date),1)])]),_:1})):I("",!0)])}}},ae=z(ee,[["__scopeId","data-v-c9cc4555"]]);export{ae as default};
