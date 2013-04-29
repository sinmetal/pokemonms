// This file was automatically generated from menu.soy.
// Please don't edit this file by hand.

goog.provide('templates.menu');

goog.require('soy');
goog.require('soy.StringBuilder');


templates.menu.topMenu = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="topbar" data-dropdown="dropdown"><div class="navbar navbar-fixed-top"><div class="navbar-inner"><div class="container-fluid"><a class="brand" href="/">PokemonMS α</a><div class="nav-collapse"><ul class="nav"><li><a href="/storage/">Home</a></li><li><a href="#about">About</a></li><li><a href="#localTradeStation">LTS</a></li><li><a href="#tournament">Tournament</a></li><li><a href="#battle">Battle</a></li></ul><ul id="login-menu" class="nav pull-right"></ul></div></div></div></div></div>');
  return opt_sb ? '' : output.toString();
};


templates.menu.myInfo = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">', soy.$$escapeHtml(opt_data.twitterScreenName), '<b class="caret"></b></a><ul class="dropdown-menu"><li><a href="#">Secondary link</a></li><li><a href="#">Something else here</a></li><li class="divider"></li><li><a href="/authentication/logout">ログアウト</a></li></ul></li>');
  return opt_sb ? '' : output.toString();
};


templates.menu.loginLink = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<li><a href="/authentication/">ログイン</a></li>');
  return opt_sb ? '' : output.toString();
};


templates.menu.loginLinkLoading = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<li><a href="#">Loading...</a></li>');
  return opt_sb ? '' : output.toString();
};

;
// This file was automatically generated from footer.soy.
// Please don't edit this file by hand.

goog.provide('templates.footer');

goog.require('soy');
goog.require('soy.StringBuilder');


templates.footer.footer = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<footer><p>Copyright &copy;&nbsp;2011&nbsp;-&nbsp;2012&nbsp;<a href="http://twitter.com/#!/sinmetal">sinmetal</a>&nbsp;All&nbsp;rights&nbsp;reserved.</p></footer>');
  return opt_sb ? '' : output.toString();
};

;
// This file was automatically generated from alerts.soy.
// Please don't edit this file by hand.

goog.provide('templates.alerts');

goog.require('soy');
goog.require('soy.StringBuilder');


templates.alerts.error = function(opt_data, opt_sb) {
  var output = opt_sb || new soy.StringBuilder();
  output.append('<div class="alert alert-error"><button class="close" data-dismiss="alert">×</button><strong>Error!</strong>', (! opt_data.errorMessage) ? '時間をおいて再度試してみてください。' : soy.$$escapeHtml(opt_data.errorMessage) + '時間をおいて再度試してみてください。', '</div>');
  return opt_sb ? '' : output.toString();
};
