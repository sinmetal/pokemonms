goog.provide('common.funcUtil');

goog.scope(function(){
    var gdom = goog.dom;
    var gsoy = goog.soy;
    
    /** @constructor */
    common.funcUtil = function(){
        this.initialize_();
    };
    goog.addSingletonGetter(common.funcUtil);
    
    /**
     * initialize.
     *
     * @private
     */
    common.funcUtil.prototype.initialize_ = function(){
    };
    
    /**
     * getTrueFunc.
     *
     * return true function.
     */
    common.funcUtil.prototype.getTrueFunc = function(){
        return true;
    };
    
    /**
     * common funcUtil instance.
     */
    common.funcUtil.getInstance();
});
