goog.provide('common.menu');
goog.require('common.ajax');
goog.require('goog.soy');
goog.require('templates.menu');
goog.require('templates.alerts');

goog.scope(function(){
    var gdom = goog.dom;
    var gsoy = goog.soy;
    
    /** @constructor */
    common.menu = function(){
        this.initialize_();
    };
    
    /**
     * initialize.
     *
     * @private
     */
    common.menu.prototype.initialize_ = function(){
        var menu = gdom.getElement('menu');
        gdom.append(menu, gsoy.renderAsElement(templates.menu.topMenu));
        
        var footer = gdom.getElement('footer');
        gdom.append(footer, gsoy.renderAsElement(templates.footer.footer));
        
        this.getLoginUser();
    };
    
    /**
     * ajax get login user
     */
    common.menu.prototype.getLoginUser = function(){
        var loginMenu = gdom.getElement('login-menu');
        gdom.append(loginMenu, gsoy.renderAsElement(templates.menu.loginLinkLoading));
        common.ajax.getInstance().sendRequest('/authentication/loginInfo', {}, goog.bind(this.onGetLoginUserComplete_, this), 'GET', {});
    };
    
    /**
     * ajax get login user compete.
     *
     * @param {Object}
     *            e the ajax response.
     */
    common.menu.prototype.onGetLoginUserComplete_ = function(e){
        var loginMenu = gdom.getElement('login-menu');
        gdom.removeChildren(loginMenu);
        var loginInfo = e['loginInfo'];
        if (loginInfo) {
            var data = {
                twitterScreenName: loginInfo['twitterScreenName']
            };
            gdom.append(loginMenu, gsoy.renderAsElement(templates.menu.myInfo, data));
        } else {
            gdom.append(loginMenu, gsoy.renderAsElement(templates.menu.loginLink));
        }
        
    };
});
