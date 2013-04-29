goog.provide('authentication.App');
goog.require('goog.soy');
goog.require('templates.menu');
goog.require('templates.footer');
goog.require('templates.alerts');

goog.scope(function(){
    var gdom = goog.dom;
    var gsoy = goog.soy;
    
    /** @constructor */
    authentication.App = function(){
        this.initialize_();
    };
    goog.addSingletonGetter(authentication.App);
    
    /**
     * initialize.
     * @private
     */
    authentication.App.prototype.initialize_ = function(){
        var menu = gdom.getElement('menu');
        gdom.append(menu, gsoy.renderAsElement(templates.menu.topMenu));
        
        var footer = gdom.getElement('footer');
        gdom.append(footer, gsoy.renderAsElement(templates.footer.footer));
    };
    
    /**
     * authentication page get instance.
     */
    authentication.App.getInstance();
});
