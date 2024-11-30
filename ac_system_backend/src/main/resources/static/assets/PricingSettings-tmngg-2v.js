import{_ as w}from"./_plugin-vue_export-helper-DlAUqK2U.js";import{r as S,D as h,c as y,M as C,d as p,a,w as l,b as o,o as V,i as d,J as c}from"./index-BE7gfLc4.js";const F={class:"pricing-settings"},k={class:"pricing-form"},P={class:"form-actions"},E={class:"pricing-preview"},B={__name:"PricingSettings",setup(M){const t=S({lowSpeed:.5,mediumSpeed:1,highSpeed:2}),v=h(()=>[{type:"低速风",rate:t.value.lowSpeed,example:`${(t.value.lowSpeed*5).toFixed(2)}元 (温差5°C)`},{type:"中速风",rate:t.value.mediumSpeed,example:`${(t.value.mediumSpeed*5).toFixed(2)}元 (温差5°C)`},{type:"高速风",rate:t.value.highSpeed,example:`${(t.value.highSpeed*5).toFixed(2)}元 (温差5°C)`}]),f=async()=>{try{await g("savePricingRules",t.value),c.success("计费规则已更新")}catch{c.error("保存失败")}},_=()=>{t.value={lowSpeed:.5,mediumSpeed:1,highSpeed:2}},g=async(r,e)=>(console.log("API Call:",r,e),new Promise(i=>setTimeout(i,1e3)));return(r,e)=>{const i=o("el-input-number"),n=o("el-form-item"),u=o("el-button"),x=o("el-form"),m=o("el-table-column"),b=o("el-table");return V(),y("div",F,[e[9]||(e[9]=C('<div class="decoration-image" data-v-6c2aa2b0><svg width="500" height="500" viewBox="0 0 200 200" fill="none" xmlns="http://www.w3.org/2000/svg" data-v-6c2aa2b0><circle cx="100" cy="100" r="90" fill="#ECF5FF" opacity="0.2" data-v-6c2aa2b0></circle><text x="100" y="120" font-size="100" font-family="Arial" fill="#409EFF" text-anchor="middle" opacity="0.4" data-v-6c2aa2b0>¥</text><path d="M40,100 Q100,40 160,100" stroke="#409EFF" stroke-width="4" fill="none" opacity="0.05" data-v-6c2aa2b0></path><path d="M40,120 Q100,180 160,120" stroke="#409EFF" stroke-width="4" fill="none" opacity="0.05" data-v-6c2aa2b0></path></svg></div><h2 data-v-6c2aa2b0>空调计费规则设置</h2>',2)),p("div",k,[a(x,{model:t.value,"label-width":"120px"},{default:l(()=>[a(n,{label:"低速风费率"},{default:l(()=>[a(i,{modelValue:t.value.lowSpeed,"onUpdate:modelValue":e[0]||(e[0]=s=>t.value.lowSpeed=s),min:.1,max:10,step:.1,precision:2},{suffix:l(()=>e[3]||(e[3]=[d("元/1C°")])),_:1},8,["modelValue"])]),_:1}),a(n,{label:"中速风费率"},{default:l(()=>[a(i,{modelValue:t.value.mediumSpeed,"onUpdate:modelValue":e[1]||(e[1]=s=>t.value.mediumSpeed=s),min:.1,max:10,step:.1,precision:2},{suffix:l(()=>e[4]||(e[4]=[d("元/1C°")])),_:1},8,["modelValue"])]),_:1}),a(n,{label:"高速风费率"},{default:l(()=>[a(i,{modelValue:t.value.highSpeed,"onUpdate:modelValue":e[2]||(e[2]=s=>t.value.highSpeed=s),min:.1,max:10,step:.1,precision:2},{suffix:l(()=>e[5]||(e[5]=[d("元/1C°")])),_:1},8,["modelValue"])]),_:1}),a(n,null,{default:l(()=>[p("div",P,[a(u,{type:"primary",onClick:f},{default:l(()=>e[6]||(e[6]=[d("保存设置")])),_:1}),a(u,{onClick:_},{default:l(()=>e[7]||(e[7]=[d("恢复默认")])),_:1})])]),_:1})]),_:1},8,["model"])]),p("div",E,[e[8]||(e[8]=p("h3",null,"费率预览",-1)),a(b,{data:v.value,border:"",style:{width:"100%"}},{default:l(()=>[a(m,{prop:"type",label:"风速类型",width:"180"}),a(m,{prop:"rate",label:"费率(元/1C°)",width:"180"}),a(m,{prop:"example",label:"示例(每小时费用)"})]),_:1},8,["data"])])])}}},A=w(B,[["__scopeId","data-v-6c2aa2b0"]]);export{A as default};