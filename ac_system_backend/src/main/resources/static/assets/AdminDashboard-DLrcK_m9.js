import{r as V,C as A,D as E,c as f,a as n,w as o,b as l,o as i,u as a,E as v,d as t,G as g,t as P,i as R,H as T,f as $,g as G,y as H}from"./index-BE7gfLc4.js";import I from"./MonitoringPanel-B-G_JHxl.js";import L from"./PricingSettings-tmngg-2v.js";import{_ as j}from"./_plugin-vue_export-helper-DlAUqK2U.js";const q={class:"admin-dashboard"},F={class:"header-content"},J={class:"user-info"},K={class:"user-dropdown"},O={key:0,class:"welcome-page"},Q={class:"welcome-content"},U={class:"feature-cards"},W={__name:"AdminDashboard",setup(X){const w=H(),d=V(""),_=A(null),b={monitoring:I,pricing:L},h=E(()=>{switch(d.value){case"monitoring":return"空调监控中心";case"pricing":return"计费规则管理";default:return"管理员控制台"}}),r=u=>{d.value=u,_.value=b[u]},x=()=>{w.push("/")};return(u,e)=>{const s=l("el-icon"),c=l("el-menu-item"),C=l("el-menu"),k=l("el-aside"),y=l("el-avatar"),D=l("el-dropdown-item"),B=l("el-dropdown-menu"),M=l("el-dropdown"),S=l("el-header"),m=l("el-card"),z=l("el-main"),p=l("el-container");return i(),f("div",q,[n(p,null,{default:o(()=>[n(k,{width:"200px"},{default:o(()=>[n(C,{"default-active":d.value,class:"admin-menu",onSelect:r},{default:o(()=>[n(c,{index:"monitoring"},{default:o(()=>[n(s,null,{default:o(()=>[n(a(v))]),_:1}),e[2]||(e[2]=t("span",null,"空调监控",-1))]),_:1}),n(c,{index:"pricing"},{default:o(()=>[n(s,null,{default:o(()=>[n(a(g))]),_:1}),e[3]||(e[3]=t("span",null,"计费规则",-1))]),_:1})]),_:1},8,["default-active"])]),_:1}),n(p,null,{default:o(()=>[n(S,{class:"dashboard-header"},{default:o(()=>[t("div",F,[t("h2",null,P(h.value),1),t("div",J,[n(M,null,{dropdown:o(()=>[n(B,null,{default:o(()=>[n(D,{onClick:x},{default:o(()=>e[5]||(e[5]=[R("退出登录")])),_:1})]),_:1})]),default:o(()=>[t("span",K,[n(y,{size:32,src:"https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"}),e[4]||(e[4]=t("span",null,"管理员",-1)),n(s,null,{default:o(()=>[n(a(T))]),_:1})])]),_:1})])])]),_:1}),n(z,null,{default:o(()=>[d.value?(i(),$(G(_.value),{key:1})):(i(),f("div",O,[t("div",Q,[e[10]||(e[10]=t("h1",null,"酒店管理系统 - 管理员控制台",-1)),e[11]||(e[11]=t("p",null,"高效管理，智能监控",-1)),t("div",U,[n(m,{class:"feature-card",shadow:"hover",onClick:e[0]||(e[0]=N=>r("monitoring"))},{default:o(()=>[n(s,{size:"24"},{default:o(()=>[n(a(v))]),_:1}),e[6]||(e[6]=t("h3",null,"空调监控",-1)),e[7]||(e[7]=t("p",null,"实时监控所有房间空调状态",-1))]),_:1}),n(m,{class:"feature-card",shadow:"hover",onClick:e[1]||(e[1]=N=>r("pricing"))},{default:o(()=>[n(s,{size:"24"},{default:o(()=>[n(a(g))]),_:1}),e[8]||(e[8]=t("h3",null,"计费规则",-1)),e[9]||(e[9]=t("p",null,"设置和管理空调计费标准",-1))]),_:1})])])]))]),_:1})]),_:1})]),_:1})])}}},oe=j(W,[["__scopeId","data-v-c156e923"]]);export{oe as default};
