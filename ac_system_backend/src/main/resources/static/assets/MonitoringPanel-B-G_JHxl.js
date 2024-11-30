import{r as _,I as j,D as I,b as d,o as g,c as x,d as e,t as r,a as l,w as u,i as f,J as B,K as W,F as D,e as E,n as X,f as L,L as N,y as Y}from"./index-BE7gfLc4.js";import{_ as Q}from"./_plugin-vue_export-helper-DlAUqK2U.js";const Z={class:"air-conditioner-control"},ee={class:"room-info"},te={class:"info-row"},oe={class:"control-panel"},se={class:"control-section"},le={class:"temperature-range"},ae={class:"control-section"},ne={class:"ac-controls"},ie={class:"actions"},ue={__name:"AirConditionerControl",props:{room:{type:Object,required:!0}},setup(y){const c=y,i=_({cool:{min:16,max:24},heat:{min:22,max:28}}),n=_({power:!1,mode:"cool",fanSpeed:"1",targetTemp:24});j(()=>{c.room.status&&(n.value={power:c.room.status.power,mode:c.room.status.mode,fanSpeed:c.room.status.fanSpeed.toString(),targetTemp:c.room.status.targetTemp})});const b=I(()=>n.value.power?n.value.mode==="cool"?i.value.cool:i.value.heat:{min:16,max:28}),v=w=>{w||(n.value.targetTemp=24,n.value.fanSpeed="1")},$=async()=>{try{await U("saveAcSettings",{roomId:c.room.id,settings:{tempRange:i.value,acStatus:n.value}}),B.success("设置已保存")}catch{B.error("保存失败")}},k=()=>{i.value={cool:{min:16,max:24},heat:{min:22,max:28}},n.value={power:!1,mode:"cool",fanSpeed:"1",targetTemp:24}},U=async(w,o)=>(console.log("API Call:",w,o),new Promise(m=>setTimeout(m,1e3)));return(w,o)=>{const m=d("el-input-number"),C=d("el-form-item"),M=d("el-form"),z=d("el-switch"),V=d("el-option"),h=d("el-select"),S=d("el-button");return g(),x("div",Z,[e("div",ee,[o[8]||(o[8]=e("h3",null,"房间信息",-1)),e("div",te,[e("span",null,"房间号："+r(y.room.number),1),e("span",null,"类型："+r(y.room.type),1)])]),e("div",oe,[e("div",se,[o[11]||(o[11]=e("h3",null,"温度区间设置",-1)),e("div",le,[l(M,{model:i.value,"label-width":"100px"},{default:u(()=>[l(C,{label:"制冷模式"},{default:u(()=>[l(m,{modelValue:i.value.cool.min,"onUpdate:modelValue":o[0]||(o[0]=s=>i.value.cool.min=s),min:16,max:i.value.cool.max,size:"small"},null,8,["modelValue","max"]),o[9]||(o[9]=f(" - ")),l(m,{modelValue:i.value.cool.max,"onUpdate:modelValue":o[1]||(o[1]=s=>i.value.cool.max=s),min:i.value.cool.min,max:28,size:"small"},null,8,["modelValue","min"])]),_:1}),l(C,{label:"制热模式"},{default:u(()=>[l(m,{modelValue:i.value.heat.min,"onUpdate:modelValue":o[2]||(o[2]=s=>i.value.heat.min=s),min:16,max:i.value.heat.max,size:"small"},null,8,["modelValue","max"]),o[10]||(o[10]=f(" - ")),l(m,{modelValue:i.value.heat.max,"onUpdate:modelValue":o[3]||(o[3]=s=>i.value.heat.max=s),min:i.value.heat.min,max:28,size:"small"},null,8,["modelValue","min"])]),_:1})]),_:1},8,["model"])])]),e("div",ae,[o[12]||(o[12]=e("h3",null,"空调控制",-1)),e("div",ne,[l(z,{modelValue:n.value.power,"onUpdate:modelValue":o[4]||(o[4]=s=>n.value.power=s),"active-text":"开机","inactive-text":"关机",onChange:v},null,8,["modelValue"]),l(h,{modelValue:n.value.mode,"onUpdate:modelValue":o[5]||(o[5]=s=>n.value.mode=s),placeholder:"工作模式",disabled:!n.value.power,style:{width:"120px"}},{default:u(()=>[l(V,{label:"制冷",value:"cool"}),l(V,{label:"制热",value:"heat"})]),_:1},8,["modelValue","disabled"]),l(h,{modelValue:n.value.fanSpeed,"onUpdate:modelValue":o[6]||(o[6]=s=>n.value.fanSpeed=s),placeholder:"风速",disabled:!n.value.power,style:{width:"120px"}},{default:u(()=>[l(V,{label:"低速",value:"1"}),l(V,{label:"中速",value:"2"}),l(V,{label:"高速",value:"3"})]),_:1},8,["modelValue","disabled"]),l(m,{modelValue:n.value.targetTemp,"onUpdate:modelValue":o[7]||(o[7]=s=>n.value.targetTemp=s),min:b.value.min,max:b.value.max,disabled:!n.value.power,size:"small",label:"目标温度"},null,8,["modelValue","min","max","disabled"])])]),e("div",ie,[l(S,{type:"primary",onClick:$},{default:u(()=>o[13]||(o[13]=[f("保存设置")])),_:1}),l(S,{onClick:k},{default:u(()=>o[14]||(o[14]=[f("重置")])),_:1})])])])}}},re=Q(ue,[["__scopeId","data-v-4f34b611"]]),de={class:"monitoring-panel"},me={class:"filter-section"},pe={class:"rooms-grid"},ce={class:"room-header"},ve={class:"room-info-header"},_e={class:"room-number"},fe={class:"room-info"},be={class:"info-row"},ge={class:"value"},we={class:"info-row"},Ve={class:"value"},Te={class:"info-row"},xe={class:"value"},ye={class:"info-row"},Ce={class:"value"},he={class:"info-row"},Se={class:"value cost"},$e={class:"room-actions"},ke={key:0,class:"room-details"},Ue={class:"details-section"},Me={class:"detail-item"},ze={class:"value"},Pe={class:"detail-item"},Fe={class:"value"},Oe={class:"detail-item"},Re={class:"value"},Ae={class:"details-section"},Be={class:"detail-item"},De={class:"value"},Ee={class:"detail-item"},Le={class:"value"},Ne={class:"detail-item"},je={class:"value"},Ie={class:"custom-title"},Qe={class:"title-text"},qe=1e3,Ge={__name:"MonitoringPanel",setup(y){Y();const c=_(""),i=_(""),n=_("");let b=null;_(!0);const v=_([{id:1,number:"101",type:"大床房",status:{power:2,mode:"cool",currentTemp:26,targetTemp:24,fanSpeed:2,cost:15.5,runningTime:7200,powerOnCount:3,reachedTarget:!0,currentSessionCost:5.5},activities:[{time:"2023-12-20 14:30",type:"primary",content:"开机，设置温度24°C"},{time:"2023-12-20 14:00",type:"info",content:"关机，累计费用¥10.00"}]},{id:2,number:"102",type:"大床房",status:{power:2,mode:"cool",currentTemp:28,targetTemp:24,fanSpeed:1,cost:8,runningTime:3600,powerOnCount:2,reachedTarget:!1,currentSessionCost:0},activities:[]},{id:3,number:"103",type:"双床房",status:{power:2,mode:"cool",currentTemp:25,targetTemp:23,fanSpeed:3,cost:20.5,runningTime:5400,powerOnCount:4,reachedTarget:!0,currentSessionCost:7.5},activities:[]},{id:4,number:"104",type:"双床房",status:{power:2,mode:"heat",currentTemp:20,targetTemp:24,fanSpeed:1,cost:5,runningTime:1800,powerOnCount:1,reachedTarget:!1,currentSessionCost:0},activities:[]},{id:5,number:"105",type:"大床房",status:{power:2,mode:"heat",currentTemp:22,targetTemp:25,fanSpeed:2,cost:12,runningTime:4500,powerOnCount:2,reachedTarget:!1,currentSessionCost:4},activities:[]}]),$=I(()=>v.value.filter(s=>{const t=s.number.toLowerCase().includes(c.value.toLowerCase()),T=!i.value||(i.value==="running"?s.status.power:!s.status.power),p=!n.value||s.status.mode===n.value;return t&&T&&p})),k=s=>({1:"低速",2:"中速",3:"高速"})[s]||"关闭",U=s=>{const t={1:.5,2:1,3:2};return s.status.power?t[s.status.fanSpeed]:0},w=s=>{const t=Math.floor(s/3600),T=Math.floor(s%3600/60);return`${t}小时${T}分钟`},o=_({visible:!1,room:null}),m=_({visible:!1,room:null}),C=s=>{o.value.room=s,o.value.visible=!0},M=s=>{m.value.room=s,m.value.visible=!0},z=async s=>{try{const t=await fetch("/api/get_room_status",{method:"GET",credentials:"include"});if(!t.ok)throw new Error(`HTTP error! status: ${t.status}`);const p=(await t.json())[s-1];console.log(p),v.value[s-1].status.power=p.status,v.value[s-1].status.mode=p.cool?"cool":"heat",v.value[s-1].status.currentTemp=p.curTemperature,v.value[s-1].status.targetTemp=p.tarTemperature,v.value[s-1].status.fanSpeed=p.acMode+1,v.value[s-1].status.cost=p.cost}catch(t){ElMessage.error("Failed to fetch status: "+t.message)}},V=async()=>{for(let s=1;s<=5;s++)await z(s)},h=()=>{b||(b=setInterval(V,qe))},S=()=>{b&&(clearInterval(b),b=null)};return j(()=>h()),W(()=>S()),(s,t)=>{var A;const T=d("el-input"),p=d("el-option"),F=d("el-select"),O=d("el-tag"),R=d("el-button"),q=d("el-card"),G=d("el-timeline-item"),H=d("el-timeline"),J=d("el-drawer"),K=d("el-dialog");return g(),x("div",de,[e("div",me,[l(T,{modelValue:c.value,"onUpdate:modelValue":t[0]||(t[0]=a=>c.value=a),placeholder:"搜索房间号","prefix-icon":"Search",clearable:"",class:"search-input"},null,8,["modelValue"]),l(F,{modelValue:i.value,"onUpdate:modelValue":t[1]||(t[1]=a=>i.value=a),placeholder:"运行状态",clearable:"",class:"filter-item"},{default:u(()=>[l(p,{label:"运行中",value:"running"}),l(p,{label:"关闭",value:"off"})]),_:1},8,["modelValue"]),l(F,{modelValue:n.value,"onUpdate:modelValue":t[2]||(t[2]=a=>n.value=a),placeholder:"工作模式",clearable:"",class:"filter-item"},{default:u(()=>[l(p,{label:"制冷",value:"cool"}),l(p,{label:"制热",value:"heat"})]),_:1},8,["modelValue"])]),e("div",pe,[(g(!0),x(D,null,E($.value,a=>(g(),x("div",{key:a.id,class:X(["room-card",{running:a.status.power===0}])},[l(q,null,{header:u(()=>[e("div",ce,[e("div",ve,[e("span",_e,"房间 "+r(a.number),1),l(O,{size:"small",type:"info",effect:"plain"},{default:u(()=>[f(r(a.type),1)]),_:2},1024)]),l(O,{type:a.status.power===0?"success":"info",size:"small"},{default:u(()=>[f(r(a.status.power===0?"运行中":a.status.power===1?"等待":"关闭"),1)]),_:2},1032,["type"])])]),default:u(()=>[e("div",fe,[e("div",be,[t[5]||(t[5]=e("span",{class:"label"},"工作模式:",-1)),e("span",ge,r(a.status.mode==="cool"?"制冷":"制热"),1)]),e("div",we,[t[6]||(t[6]=e("span",{class:"label"},"当前温度:",-1)),e("span",Ve,r(a.status.currentTemp)+"°C",1)]),e("div",Te,[t[7]||(t[7]=e("span",{class:"label"},"目标温度:",-1)),e("span",xe,r(a.status.targetTemp)+"°C",1)]),e("div",ye,[t[8]||(t[8]=e("span",{class:"label"},"风速:",-1)),e("span",Ce,r(k(a.status.fanSpeed)),1)]),e("div",he,[t[9]||(t[9]=e("span",{class:"label"},"累计费用:",-1)),e("span",Se,"¥"+r(a.status.cost.toFixed(2)),1)])]),e("div",$e,[l(R,{type:"primary",size:"small",onClick:P=>M(a)},{default:u(()=>t[10]||(t[10]=[f(" 控制 ")])),_:2},1032,["onClick"]),l(R,{type:"info",size:"small",onClick:P=>C(a)},{default:u(()=>t[11]||(t[11]=[f(" 详情 ")])),_:2},1032,["onClick"])])]),_:2},1024)],2))),128))]),l(J,{modelValue:o.value.visible,"onUpdate:modelValue":t[3]||(t[3]=a=>o.value.visible=a),title:"房间 "+(((A=o.value.room)==null?void 0:A.number)||"")+" 详细信息",direction:"rtl",size:"500px"},{default:u(()=>[o.value.room?(g(),x("div",ke,[t[18]||(t[18]=e("h3",null,"运行状态",-1)),e("div",Ue,[e("div",Me,[t[12]||(t[12]=e("span",{class:"label"},"运行时长:",-1)),e("span",ze,r(w(o.value.room.status.runningTime)),1)]),e("div",Pe,[t[13]||(t[13]=e("span",{class:"label"},"开机次数:",-1)),e("span",Fe,r(o.value.room.status.powerOnCount)+"次",1)]),e("div",Oe,[t[14]||(t[14]=e("span",{class:"label"},"达到目标:",-1)),e("span",Re,r(o.value.room.status.reachedTarget?"是":"否"),1)])]),t[19]||(t[19]=e("h3",null,"费用明细",-1)),e("div",Ae,[e("div",Be,[t[15]||(t[15]=e("span",{class:"label"},"当前费率:",-1)),e("span",De,"¥"+r(U(o.value.room))+"/1C°",1)]),e("div",Ee,[t[16]||(t[16]=e("span",{class:"label"},"本次费用:",-1)),e("span",Le,"¥"+r(o.value.room.status.currentSessionCost.toFixed(2)),1)]),e("div",Ne,[t[17]||(t[17]=e("span",{class:"label"},"总计费用:",-1)),e("span",je,"¥"+r(o.value.room.status.cost.toFixed(2)),1)])]),l(H,{class:"operation-timeline"},{default:u(()=>[(g(!0),x(D,null,E(o.value.room.activities,(a,P)=>(g(),L(G,{key:P,timestamp:a.time,type:a.type},{default:u(()=>[f(r(a.content),1)]),_:2},1032,["timestamp","type"]))),128))]),_:1})])):N("",!0)]),_:1},8,["modelValue","title"]),l(K,{modelValue:m.value.visible,"onUpdate:modelValue":t[4]||(t[4]=a=>m.value.visible=a),width:"800px",class:"control-dialog custom-dialog","modal-append-to-body":!1,"append-to-body":!0,"destroy-on-close":""},{title:u(()=>{var a;return[e("div",Ie,[t[20]||(t[20]=e("span",{class:"title-icon"},"⚡",-1)),e("span",Qe,"房间 "+r((a=m.value.room)==null?void 0:a.number)+" 控制面板",1)])]}),default:u(()=>[m.value.room?(g(),L(re,{key:0,room:m.value.room},null,8,["room"])):N("",!0)]),_:1},8,["modelValue"])])}}},Ke=Q(Ge,[["__scopeId","data-v-4af6e954"]]);export{Ke as default};