import{r as _,D as L,c as f,d as l,a as e,w as t,F as h,e as x,t as a,n as B,b as d,o as i,i as n,u as b,h as M,G as O,k as T,j as q,U as A,f as H,y as J}from"./index-BE7gfLc4.js";import{_ as Q}from"./_plugin-vue_export-helper-DlAUqK2U.js";const W={class:"room-entry"},X={class:"entry-container"},Y={key:0,class:"room-selection"},Z={class:"room-grid"},ee={class:"room-header"},se={class:"room-number"},te={class:"room-info"},le={class:"step-buttons"},oe={key:1,class:"password-step"},ne={class:"selected-room-info"},ae={class:"door-frame"},de={class:"door-panel"},ue={class:"keypad"},ie={class:"keypad-screen"},re={class:"keypad-buttons"},ce={class:"dialog-footer"},pe={__name:"RoomEntry",setup(_e){const N=J(),m=_(0),r=_(""),c=_(""),p=_(!1),y=_(!1),V=_(""),P=[{number:"1001",type:"大床房",beds:1,price:299,floor:"10",status:"空闲"},{number:"1002",type:"双床房",beds:2,price:299,floor:"10",status:"空闲"},{number:"1003",type:"大床房",beds:1,price:299,floor:"10",status:"空闲"},{number:"1004",type:"双床房",beds:2,price:299,floor:"10",status:"空闲"},{number:"1005",type:"大床房",beds:1,price:299,floor:"10",status:"空闲"}],D=L(()=>"*".repeat(c.value.length)),E=[["1","2","3"],["4","5","6"],["7","8","9"]],S=k=>{r.value=k},F=()=>{r.value&&(m.value=1)},w=k=>{c.value.length<6&&(c.value+=k)},U=()=>{c.value=""},j=()=>{c.value==="1234"?(p.value=!0,N.push(`/customer/room-control/${r.value}`)):(V.value="密码错误，请重试",y.value=!0,c.value="")};return(k,s)=>{const R=d("el-step"),z=d("el-steps"),G=d("el-tag"),v=d("el-icon"),I=d("el-card"),u=d("el-button"),g=d("el-col"),$=d("el-row"),K=d("el-dialog");return i(),f("div",W,[s[11]||(s[11]=l("div",{class:"hotel-background"},null,-1)),l("div",X,[e(z,{active:m.value,"finish-status":"success",class:"entry-steps"},{default:t(()=>[e(R,{title:"选择房间",description:"请选择您要入住的房间"}),e(R,{title:"输入密码",description:"输入房间密码完成入住"})]),_:1},8,["active"]),m.value===0?(i(),f("div",Y,[s[5]||(s[5]=l("h2",null,"选择房间",-1)),l("div",Z,[(i(),f(h,null,x(P,o=>e(I,{key:o.number,class:B(["room-card",{selected:r.value===o.number}]),onClick:C=>S(o.number)},{header:t(()=>[l("div",ee,[l("span",se,a(o.number),1),e(G,{type:o.type==="大床房"?"info":"success"},{default:t(()=>[n(a(o.type),1)]),_:2},1032,["type"])])]),default:t(()=>[l("div",te,[l("p",null,[e(v,null,{default:t(()=>[e(b(M))]),_:1}),n(" "+a(o.beds)+"张床",1)]),l("p",null,[e(v,null,{default:t(()=>[e(b(O))]),_:1}),n(" ¥"+a(o.price)+"/晚",1)]),l("p",null,[e(v,null,{default:t(()=>[e(b(T))]),_:1}),n(" "+a(o.floor)+"层",1)])])]),_:2},1032,["class","onClick"])),64))]),l("div",le,[e(u,{type:"primary",disabled:!r.value,onClick:F},{default:t(()=>[s[4]||(s[4]=n(" 下一步 ")),e(v,{class:"el-icon--right"},{default:t(()=>[e(b(q))]),_:1})]),_:1},8,["disabled"])])])):(i(),f("div",oe,[l("div",ne,[l("h3",null,"房间号: "+a(r.value),1),e(u,{text:"",onClick:s[0]||(s[0]=o=>m.value=0)},{default:t(()=>[e(v,null,{default:t(()=>[e(b(A))]),_:1}),s[6]||(s[6]=n(" 重新选择 "))]),_:1})]),l("div",{class:B(["door",{"door-open":p.value}])},[l("div",ae,[l("div",de,[l("div",ue,[l("div",ie,a(D.value),1),l("div",re,[(i(),f(h,null,x(E,o=>e($,{key:o[0]},{default:t(()=>[(i(!0),f(h,null,x(o,C=>(i(),H(g,{span:8,key:C},{default:t(()=>[e(u,{class:"keypad-button",onClick:fe=>w(C),disabled:p.value},{default:t(()=>[n(a(C),1)]),_:2},1032,["onClick","disabled"])]),_:2},1024))),128))]),_:2},1024)),64)),e($,null,{default:t(()=>[e(g,{span:8},{default:t(()=>[e(u,{class:"keypad-button clear-btn",onClick:U,disabled:p.value},{default:t(()=>s[7]||(s[7]=[n(" 清除 ")])),_:1},8,["disabled"])]),_:1}),e(g,{span:8},{default:t(()=>[e(u,{class:"keypad-button number-btn",onClick:s[1]||(s[1]=o=>w("0")),disabled:p.value},{default:t(()=>s[8]||(s[8]=[n(" 0 ")])),_:1},8,["disabled"])]),_:1}),e(g,{span:8},{default:t(()=>[e(u,{class:"keypad-button enter-btn",onClick:j,disabled:p.value},{default:t(()=>s[9]||(s[9]=[n(" 确认 ")])),_:1},8,["disabled"])]),_:1})]),_:1})])])])])],2)]))]),e(K,{modelValue:y.value,"onUpdate:modelValue":s[3]||(s[3]=o=>y.value=o),title:"提示",width:"300px"},{footer:t(()=>[l("span",ce,[e(u,{onClick:s[2]||(s[2]=o=>y.value=!1)},{default:t(()=>s[10]||(s[10]=[n("确定")])),_:1})])]),default:t(()=>[l("p",null,a(V.value),1)]),_:1},8,["modelValue"])])}}},me=Q(pe,[["__scopeId","data-v-0fa19a78"]]);export{me as default};
