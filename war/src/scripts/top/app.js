goog.provide('top.App');
goog.require('goog.events.EventHandler');
goog.require('templates.menu');
goog.require('templates.footer');
goog.require('templates.alerts');
goog.require('common.menu');

goog.scope(function(){
    var gdom = goog.dom;
    var gsoy = goog.soy;
    var gevents = goog.events;
    var EventType = goog.events.EventType;
    
    /** @constructor */
    top.App = function(){
        this.initialize_();
    };
    goog.addSingletonGetter(top.App);
    
    /**
     * initialize.
     * @private
     */
    top.App.prototype.initialize_ = function(){
        this.menu_ = new common.menu();
    };
    
    /**
     * top page get instance.
     */
    top.App.getInstance();
});
