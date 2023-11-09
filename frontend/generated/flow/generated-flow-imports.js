import { injectGlobalCss } from 'Frontend/generated/jar-resources/theme-util.js';

import { css, unsafeCSS, registerStyles } from '@vaadin/vaadin-themable-mixin';
import $cssFromFile_0 from 'Frontend/styles/vaadin-app-layout.css?inline';
const $css_0 = typeof $cssFromFile_0  === 'string' ? unsafeCSS($cssFromFile_0) : $cssFromFile_0;
registerStyles('vaadin-app-layout', $css_0, {moduleId: 'flow_css_mod_0'});
import $cssFromFile_1 from 'Frontend/generated/jar-resources/com/github/appreciated/apexcharts/apexcharts-wrapper-styles.css?inline';
const $css_1 = typeof $cssFromFile_1  === 'string' ? unsafeCSS($cssFromFile_1) : $cssFromFile_1;
registerStyles('', $css_1, {moduleId: 'apex-charts-style'});
import $cssFromFile_2 from 'Frontend/generated/jar-resources/styles/multiselect-cb-hide.css?inline';
const $css_2 = typeof $cssFromFile_2  === 'string' ? unsafeCSS($cssFromFile_2) : $cssFromFile_2;
registerStyles('vaadin-grid', $css_2, {moduleId: 'flow_css_mod_2'});
import $cssFromFile_3 from 'Frontend/generated/jar-resources/styles/twin-col-grid-button.css?inline';

injectGlobalCss($cssFromFile_3.toString(), 'CSSImport end', document);
import $cssFromFile_4 from 'Frontend/generated/jar-resources/styles/twincol-grid.css?inline';

injectGlobalCss($cssFromFile_4.toString(), 'CSSImport end', document);
import $cssFromFile_5 from 'Frontend/styles/tpc-grid-theme.css?inline';
const $css_5 = typeof $cssFromFile_5  === 'string' ? unsafeCSS($cssFromFile_5) : $cssFromFile_5;
registerStyles('vaadin-grid', $css_5, {moduleId: 'flow_css_mod_5'});
import $cssFromFile_6 from 'Frontend/styles/portfolioPlanning.css?inline';

injectGlobalCss($cssFromFile_6.toString(), 'CSSImport end', document);
import $cssFromFile_7 from 'Frontend/styles/baseMVCView2Wide.css?inline';

injectGlobalCss($cssFromFile_7.toString(), 'CSSImport end', document);
import $cssFromFile_8 from 'Frontend/styles/portfolioTracking.css?inline';

injectGlobalCss($cssFromFile_8.toString(), 'CSSImport end', document);
import $cssFromFile_9 from 'Frontend/styles/baseMVCViewVL.css?inline';

injectGlobalCss($cssFromFile_9.toString(), 'CSSImport end', document);
import $cssFromFile_10 from 'Frontend/styles/baseMVCView1Wide.css?inline';

injectGlobalCss($cssFromFile_10.toString(), 'CSSImport end', document);
import '@vaadin/polymer-legacy-adapter/style-modules.js';
import '@vaadin/app-layout/theme/lumo/vaadin-app-layout.js';
import '@vaadin/tooltip/theme/lumo/vaadin-tooltip.js';
import '@vaadin/login/theme/lumo/vaadin-login-overlay.js';
import '@vaadin/tabs/theme/lumo/vaadin-tab.js';
import '@vaadin/icon/theme/lumo/vaadin-icon.js';
import '@vaadin/context-menu/theme/lumo/vaadin-context-menu.js';
import 'Frontend/generated/jar-resources/flow-component-renderer.js';
import 'Frontend/generated/jar-resources/contextMenuConnector.js';
import 'Frontend/generated/jar-resources/contextMenuTargetConnector.js';
import '@vaadin/button/theme/lumo/vaadin-button.js';
import 'Frontend/generated/jar-resources/buttonFunctions.js';
import 'Frontend/generated/jar-resources/menubarConnector.js';
import '@vaadin/menu-bar/theme/lumo/vaadin-menu-bar.js';
import '@vaadin/icons/vaadin-iconset.js';
import '@vaadin/app-layout/theme/lumo/vaadin-drawer-toggle.js';
import '@vaadin/horizontal-layout/theme/lumo/vaadin-horizontal-layout.js';
import '@vaadin/tabs/theme/lumo/vaadin-tabs.js';
import '@vaadin/common-frontend/ConnectionIndicator.js';
import '@vaadin/vaadin-lumo-styles/color-global.js';
import '@vaadin/vaadin-lumo-styles/typography-global.js';
import '@vaadin/vaadin-lumo-styles/sizing.js';
import '@vaadin/vaadin-lumo-styles/spacing.js';
import '@vaadin/vaadin-lumo-styles/style.js';
import '@vaadin/vaadin-lumo-styles/vaadin-iconset.js';

const loadOnDemand = (key) => {
  const pending = [];
  if (key === '3209c7a4893b48b62d43902e6dfafb39388ae2ad6b6304bf84ff752f0e3075ce') {
    pending.push(import('./chunks/chunk-208bac8692609adb3c4d57024e028e9b2c23107ff8fc0cedc90f2bffc5d336bd.js'));
  }
  if (key === '1b580bb6f86d2e83d9df4f13f41bd4b861ae03df41d19e2bff2c1c66ce97d188') {
    pending.push(import('./chunks/chunk-aa77fe5f493ffe8ab24ff6720ba2bcd8777440ca34729d9d532c95e699a42ee8.js'));
  }
  if (key === 'b5c936c4486461206d710ca2d88c857652a836ef7f112bbd20cf4aa298394132') {
    pending.push(import('./chunks/chunk-208bac8692609adb3c4d57024e028e9b2c23107ff8fc0cedc90f2bffc5d336bd.js'));
  }
  if (key === 'b282b37d61017a4df664e4f53d6d46cc36898ebbaec2f51d37a04be1974ba18a') {
    pending.push(import('./chunks/chunk-0943f050e82313cb50e589c383a058956609cd4018b388e9d70bf3857337e023.js'));
  }
  if (key === '317b7eb329af513c71e506c751ac5e33fd117de8b300c202ca1210bf450240c4') {
    pending.push(import('./chunks/chunk-9eb16cade2a437e86c15bad564e48e977896907314ff68273e7db11292cc611d.js'));
  }
  if (key === '63e6edd8b675a9db7bca208cfdbfe4dc51b798ecccc9bf82db4d8bcfe6b212de') {
    pending.push(import('./chunks/chunk-70b4433f1616008b40f02e1c6b3285036c3cd266377203c38605ba5e76a1b26a.js'));
  }
  if (key === 'e82c21b2ed44d8fa5745757a423ec4715b370a9640377f30013014b70d4c4969') {
    pending.push(import('./chunks/chunk-32726eb2b713cae7dd8c43fcba747780583df598043ddf7886ecba1bdda27fc0.js'));
  }
  if (key === 'b74a3783930a3c9f83a04722e9b2d45655b3a5160b921d150a8115b584e087e9') {
    pending.push(import('./chunks/chunk-0943f050e82313cb50e589c383a058956609cd4018b388e9d70bf3857337e023.js'));
  }
  if (key === '0fc34485b057ff1686102fee4b5247e557ab75e0bbe276267bcca6c14b629eb2') {
    pending.push(import('./chunks/chunk-0943f050e82313cb50e589c383a058956609cd4018b388e9d70bf3857337e023.js'));
  }
  if (key === 'bc217595484ab529e741483f841b5dcb8a7365510f24b40fcf4b7f477b31af22') {
    pending.push(import('./chunks/chunk-208bac8692609adb3c4d57024e028e9b2c23107ff8fc0cedc90f2bffc5d336bd.js'));
  }
  if (key === 'e243981e22086cb563817309b55135c433bceca478f4e40a256489d2a79ff6b1') {
    pending.push(import('./chunks/chunk-51993fb2376ade9b660c716bf0abcbd13d2a1129ea28ae917c729c214391e82c.js'));
  }
  if (key === '44de2b4ab763844c6d8c7ea8f5d681c1f7d09a655081cba69e2b59083dbeb62e') {
    pending.push(import('./chunks/chunk-51993fb2376ade9b660c716bf0abcbd13d2a1129ea28ae917c729c214391e82c.js'));
  }
  if (key === 'bc274a8acaf8c2742e603f3bd46402601c316f64a0c942b840cdee8c32f80cbc') {
    pending.push(import('./chunks/chunk-208bac8692609adb3c4d57024e028e9b2c23107ff8fc0cedc90f2bffc5d336bd.js'));
  }
  if (key === '01398b6696057815be6f999109d4c1a9f48d49768a5ae6c2ed2902bb047bb69d') {
    pending.push(import('./chunks/chunk-90b803da1e5c4ac2c3ddd0252ff8310b2313c5b5b564c578d17f693cd208f139.js'));
  }
  if (key === 'f119d509f0360b84b2fd1a52faaa0d74a1a396d63d0cfd7ba3715f266215ff66') {
    pending.push(import('./chunks/chunk-5105412cff4889c8e36f234b71f0c61e4ca12926315fc46085e28c798ba3fb02.js'));
  }
  if (key === 'ad16f638ac717f1b6dd1ec7463068ee2862c54eddae75f970175abb82605b6d1') {
    pending.push(import('./chunks/chunk-32726eb2b713cae7dd8c43fcba747780583df598043ddf7886ecba1bdda27fc0.js'));
  }
  if (key === '63ae58e87e1bf8dc9965bf79356b409a9b1b49bdb44c051c0914286a3258066c') {
    pending.push(import('./chunks/chunk-aa77fe5f493ffe8ab24ff6720ba2bcd8777440ca34729d9d532c95e699a42ee8.js'));
  }
  if (key === 'd5582e1a7fd6c383d58758d14595c6ca96109b35395478d6f0ade22bfdb273dc') {
    pending.push(import('./chunks/chunk-6ed2d715a8b5cc74ee224c77c09c652fa43545c34062f6030fc3052c8063b46a.js'));
  }
  if (key === '60a72a3ff23b55fd9fbc42ae5ce74715ac1e3a616111121f1ad9ea853b01eb18') {
    pending.push(import('./chunks/chunk-51993fb2376ade9b660c716bf0abcbd13d2a1129ea28ae917c729c214391e82c.js'));
  }
  if (key === 'e65f97494cefdad9b8731ff26a2c00f9c9b8ce9f89af356ed8c941ac8f65252e') {
    pending.push(import('./chunks/chunk-97d140cee9ce42aae494494e9564cde71be93fe62d71be1c9170344302325487.js'));
  }
  if (key === 'a951de171b65918d4ed043e6502a9e049306c0b45b6fd52ae4e1238097ebc5fa') {
    pending.push(import('./chunks/chunk-4fc1b7e1d167b910978b5687a36e2049d32f48c48abc06dbeff64cc11bb5eb31.js'));
  }
  if (key === '7c184e18c034f8b782a1b062dc7132fa0bb608c6469fa86629d8e56d24746386') {
    pending.push(import('./chunks/chunk-0943f050e82313cb50e589c383a058956609cd4018b388e9d70bf3857337e023.js'));
  }
  if (key === 'abf1dca65324ff53236b043de9b66b54a8eb222c3e67b89221fa41c51a858eac') {
    pending.push(import('./chunks/chunk-208bac8692609adb3c4d57024e028e9b2c23107ff8fc0cedc90f2bffc5d336bd.js'));
  }
  if (key === '793a4a8073c422cd0aa8e3682eccdcb63bf5b9e94b01c75348a3dd8ba7571c91') {
    pending.push(import('./chunks/chunk-bd50998f6462514980bf2ac2fc7230001bebd87993a71c1fe316632c31c4b5b2.js'));
  }
  if (key === '567174646040f5c00096e37f94afb13e54e4c78a92432caac77381451463f048') {
    pending.push(import('./chunks/chunk-36413dc27daaccb940be1a30743dc91105cd89a86cb121d74bdfd8c58269a916.js'));
  }
  if (key === 'cbb515446f97b0e7720bdb280b2cfa59169ccdb935e134feed39cd55a97a8d34') {
    pending.push(import('./chunks/chunk-0943f050e82313cb50e589c383a058956609cd4018b388e9d70bf3857337e023.js'));
  }
  if (key === 'f5baea6d0c90b7fe229a2c0f71fb262c7bd101a85e96b59e4594b149b482ef65') {
    pending.push(import('./chunks/chunk-90b803da1e5c4ac2c3ddd0252ff8310b2313c5b5b564c578d17f693cd208f139.js'));
  }
  if (key === 'e7989907a652e246d9a44c0b6952ce2b7ccccab52e049305f3c7ebf34889de9c') {
    pending.push(import('./chunks/chunk-51993fb2376ade9b660c716bf0abcbd13d2a1129ea28ae917c729c214391e82c.js'));
  }
  if (key === 'b3dea8ccdb80f456d8b627514345c563cf3c783e10ec351784802233bd68581c') {
    pending.push(import('./chunks/chunk-4fe60037af65e92de5012cb66997bab76ac824c42bc1b715855c83e35bbd3ff9.js'));
  }
  if (key === '4bced82f4d0cc2b3b5317bdf63b99db1bc48aeaf62c3b07613de81dca39b4670') {
    pending.push(import('./chunks/chunk-97d140cee9ce42aae494494e9564cde71be93fe62d71be1c9170344302325487.js'));
  }
  if (key === 'eea25ceeb03809589bafb94fe9b8916246cee4f94f30140363feaffb69fa0078') {
    pending.push(import('./chunks/chunk-70b4433f1616008b40f02e1c6b3285036c3cd266377203c38605ba5e76a1b26a.js'));
  }
  if (key === '3a264d14eb6aef1408492cd0f1e9c08fef5228bc10658ccf59492ed7413146aa') {
    pending.push(import('./chunks/chunk-0943f050e82313cb50e589c383a058956609cd4018b388e9d70bf3857337e023.js'));
  }
  if (key === '3b51ed3c7836da8cdcfc05639c57f993e9a6bf6467a8377c6330a244ccf670f4') {
    pending.push(import('./chunks/chunk-51993fb2376ade9b660c716bf0abcbd13d2a1129ea28ae917c729c214391e82c.js'));
  }
  if (key === 'e4e2c41406008b217336629b8434ca083321f05123809b4caecb8ba8d4f10f7e') {
    pending.push(import('./chunks/chunk-208bac8692609adb3c4d57024e028e9b2c23107ff8fc0cedc90f2bffc5d336bd.js'));
  }
  if (key === 'cbac71dbfecab5d2946789aa3ebeed23681a06d350b2196206c76bc3ae78fe37') {
    pending.push(import('./chunks/chunk-aa77fe5f493ffe8ab24ff6720ba2bcd8777440ca34729d9d532c95e699a42ee8.js'));
  }
  if (key === '710af811b4f9f2c449411d89004bd084c4ecd202d457947bc8c5a11ad83f9eb8') {
    pending.push(import('./chunks/chunk-8823e7124938d4159755da03e7610fec3e5037b7904dc7c110f4b26507968ba6.js'));
  }
  if (key === '4135a5a013fc5241e020bdf8ec78a1755cea6dc7ed42de07b17e51246dd553df') {
    pending.push(import('./chunks/chunk-5105412cff4889c8e36f234b71f0c61e4ca12926315fc46085e28c798ba3fb02.js'));
  }
  if (key === 'c11b27b31ecbab8ba926e3374f78cb149e793082831bf8a7b6a6530848629a20') {
    pending.push(import('./chunks/chunk-208bac8692609adb3c4d57024e028e9b2c23107ff8fc0cedc90f2bffc5d336bd.js'));
  }
  if (key === '90eef976ff822a7b3e9ec48eab0e2d6d720c73165d6c7840445ab755d129e2db') {
    pending.push(import('./chunks/chunk-5105412cff4889c8e36f234b71f0c61e4ca12926315fc46085e28c798ba3fb02.js'));
  }
  if (key === '3a9f5c9791c470d0209cccc11582e9ef7c0ba1b2bbec30db19af15e6ae6f7ef2') {
    pending.push(import('./chunks/chunk-97d140cee9ce42aae494494e9564cde71be93fe62d71be1c9170344302325487.js'));
  }
  if (key === '3adbae728b9ac926299252ae91bcb117a475b4f58ad514c64f39eb7b4a5c9dab') {
    pending.push(import('./chunks/chunk-97d140cee9ce42aae494494e9564cde71be93fe62d71be1c9170344302325487.js'));
  }
  if (key === '4c6e7d067ade30a5f39b396b57fe9eeea40b32b8fc63ad0de9d12e28f289e51a') {
    pending.push(import('./chunks/chunk-51993fb2376ade9b660c716bf0abcbd13d2a1129ea28ae917c729c214391e82c.js'));
  }
  if (key === 'c96393139226e43590fd5104b314d682135fadc729d9d5ea34befeec6b53feef') {
    pending.push(import('./chunks/chunk-51993fb2376ade9b660c716bf0abcbd13d2a1129ea28ae917c729c214391e82c.js'));
  }
  if (key === '535e210615ff741f51075dac9c0854cfddaaf151553183d94a52dd823f2745c6') {
    pending.push(import('./chunks/chunk-208bac8692609adb3c4d57024e028e9b2c23107ff8fc0cedc90f2bffc5d336bd.js'));
  }
  if (key === '9a94f39762d5f2a7a4d0fbbf814040beadd8441e1d86d851578b3f7355043ab4') {
    pending.push(import('./chunks/chunk-0943f050e82313cb50e589c383a058956609cd4018b388e9d70bf3857337e023.js'));
  }
  if (key === '1f9bdfd5dda6c03d0c1cea8c5d5f29101e9c9e8710f7fdd1ff22d1532b7e1f49') {
    pending.push(import('./chunks/chunk-b38083ed0c8860f34e7ba08187fae6019d7e4d3fec85c02280ea7ef39398211f.js'));
  }
  return Promise.all(pending);
}

window.Vaadin = window.Vaadin || {};
window.Vaadin.Flow = window.Vaadin.Flow || {};
window.Vaadin.Flow.loadOnDemand = loadOnDemand;