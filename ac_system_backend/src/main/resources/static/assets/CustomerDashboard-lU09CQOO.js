import{r as w,D as C,R as j,c as g,a as o,w as n,b as l,o as i,f as k,u as s,S as R,d as t,v as h,B as x,T as B,L as P,t as z,i as H,H as q,n as F,y as G,P as J}from"./index-BE7gfLc4.js";import{_ as K}from"./_plugin-vue_export-helper-DlAUqK2U.js";const Q={class:"customer-dashboard"},W={class:"header-content"},X={class:"user-info"},Y={class:"user-dropdown"},Z={key:0,class:"welcome-page"},ee={class:"welcome-content"},oe={class:"feature-cards"},ne={__name:"CustomerDashboard",setup(te){const u=G(),d=J(),r=w("room-entry"),N=w("张三"),f=C(()=>d.name==="RoomControl"),D=()=>{switch(d.name){case"RoomEntry":r.value="room-entry";break;case"RoomBooking":r.value="room-booking";break;case"PersonalCenter":r.value="my-profile";break;case"OrderHistory":r.value="order-history";break}};j(()=>d.name,()=>{D()});const E=C(()=>{switch(d.name){case"RoomEntry":return"房间入住";case"RoomBooking":return"预订房间";case"PersonalCenter":return"个人信息";case"OrderHistory":return"订单历史";case"RoomControl":return"房间控制";default:return"客户中心"}}),m=c=>{switch(r.value=c,c){case"room-entry":u.push({name:"RoomEntry"});break;case"room-booking":u.push({name:"RoomBooking"});break;case"my-profile":u.push({name:"PersonalCenter"});break;case"order-history":u.push({name:"OrderHistory"});break}},S=()=>{r.value="my-profile",u.push({name:"PersonalCenter"})},T=()=>{u.push("/")};return(c,e)=>{const a=l("el-icon"),p=l("el-menu-item"),V=l("el-menu"),$=l("el-aside"),M=l("el-avatar"),y=l("el-dropdown-item"),O=l("el-dropdown-menu"),A=l("el-dropdown"),L=l("el-header"),_=l("el-card"),I=l("router-view"),U=l("el-main"),b=l("el-container");return i(),g("div",Q,[o(b,null,{default:n(()=>[f.value?P("",!0):(i(),k($,{key:0,width:"200px"},{default:n(()=>[o(V,{"default-active":r.value,class:"customer-menu",onSelect:m},{default:n(()=>[o(p,{index:"room-entry"},{default:n(()=>[o(a,null,{default:n(()=>[o(s(R))]),_:1}),e[4]||(e[4]=t("span",null,"房间入住",-1))]),_:1}),o(p,{index:"room-booking"},{default:n(()=>[o(a,null,{default:n(()=>[o(s(h))]),_:1}),e[5]||(e[5]=t("span",null,"预订房间",-1))]),_:1}),o(p,{index:"my-profile"},{default:n(()=>[o(a,null,{default:n(()=>[o(s(x))]),_:1}),e[6]||(e[6]=t("span",null,"个人信息",-1))]),_:1}),o(p,{index:"order-history"},{default:n(()=>[o(a,null,{default:n(()=>[o(s(B))]),_:1}),e[7]||(e[7]=t("span",null,"订单历史",-1))]),_:1})]),_:1},8,["default-active"])]),_:1})),o(b,null,{default:n(()=>[f.value?P("",!0):(i(),k(L,{key:0,class:"dashboard-header"},{default:n(()=>[t("div",W,[t("h2",null,z(E.value),1),t("div",X,[o(A,null,{dropdown:n(()=>[o(O,null,{default:n(()=>[o(y,{onClick:S},{default:n(()=>e[8]||(e[8]=[H("个人信息")])),_:1}),o(y,{onClick:T},{default:n(()=>e[9]||(e[9]=[H("退出登录")])),_:1})]),_:1})]),default:n(()=>[t("span",Y,[o(M,{size:32,src:"https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"}),t("span",null,z(N.value),1),o(a,null,{default:n(()=>[o(s(q))]),_:1})])]),_:1})])])]),_:1})),o(U,{class:F({"no-padding":f.value})},{default:n(()=>[!s(d).name||s(d).name==="Customer"?(i(),g("div",Z,[t("div",ee,[e[18]||(e[18]=t("h1",null,"欢迎来到BUPT Affordable Hotel",-1)),e[19]||(e[19]=t("p",null,"我们为您提供舒适的住宿体验",-1)),t("div",oe,[o(_,{class:"feature-card",shadow:"hover",onClick:e[0]||(e[0]=v=>m("room-entry"))},{default:n(()=>[o(a,{size:"24"},{default:n(()=>[o(s(R))]),_:1}),e[10]||(e[10]=t("h3",null,"房间入住",-1)),e[11]||(e[11]=t("p",null,"快速办理入住",-1))]),_:1}),o(_,{class:"feature-card",shadow:"hover",onClick:e[1]||(e[1]=v=>m("room-booking"))},{default:n(()=>[o(a,{size:"24"},{default:n(()=>[o(s(h))]),_:1}),e[12]||(e[12]=t("h3",null,"预订房间",-1)),e[13]||(e[13]=t("p",null,"提前预定房间",-1))]),_:1}),o(_,{class:"feature-card",shadow:"hover",onClick:e[2]||(e[2]=v=>m("my-profile"))},{default:n(()=>[o(a,{size:"24"},{default:n(()=>[o(s(x))]),_:1}),e[14]||(e[14]=t("h3",null,"个人信息",-1)),e[15]||(e[15]=t("p",null,"管理您的账户",-1))]),_:1}),o(_,{class:"feature-card",shadow:"hover",onClick:e[3]||(e[3]=v=>m("order-history"))},{default:n(()=>[o(a,{size:"24"},{default:n(()=>[o(s(B))]),_:1}),e[16]||(e[16]=t("h3",null,"订单历史",-1)),e[17]||(e[17]=t("p",null,"查看历史订单",-1))]),_:1})])])])):(i(),k(I,{key:1}))]),_:1},8,["class"])]),_:1})]),_:1})])}}},ae=K(ne,[["__scopeId","data-v-d99c559b"]]);export{ae as default};
