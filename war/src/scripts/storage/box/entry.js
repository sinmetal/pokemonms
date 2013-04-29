goog.provide('storage.box.entry');
goog.require('goog.events.EventHandler');
goog.require('goog.dom');
goog.require('goog.dom.forms');
goog.require('goog.dom.query');
goog.require('common.ajax');
goog.require('common.funcUtil');

goog.scope(function(){
    var gdom = goog.dom;
    var gevents = goog.events;
    var EventType = goog.events.EventType;
    
    /** @constructor */
    storage.box.entry = function(){
        this.initialize_();
    };
    
    /**
     * initialize.
     *
     * @private
     */
    storage.box.entry.prototype.initialize_ = function(){
        this.eventHandler_ = new gevents.EventHandler(this);
        this.eventHandler_.listen(gdom.getElement('back2boxes-btn'), EventType.CLICK,
        		goog.bind(this.onClickBack2BoxesButton_, this));
        this.eventHandler_.listen(gdom.getElement('entry-box-btn'), EventType.CLICK,
        		goog.bind(this.onClickEntryBoxButton_, this));
    };
    
    /**
     * back boxes page view button click.
     * @param {Object} e
     */
    storage.box.entry.prototype.onClickBack2BoxesButton_ = function(e){
        storage.box.App.getInstance().changePage('boxes-page');
    };
    
    /**
     * entry box button click
     * @param {Object} e
     */
    storage.box.entry.prototype.onClickEntryBoxButton_ = function(e){
        var form = gdom.getElement('entry-form');
        var param = gdom.forms.getFormDataMap(form).toObject();
        common.ajax.getInstance().sendRequest('/storage/box/entry', param,
        		goog.bind(this.onEntryBoxComplete_, this));
    };
    
    /**
     * ajax box entry complate.
     * @param {Object} e
     */
    storage.box.entry.prototype.onEntryBoxComplete_ = function(e){
        if (e.status == 'NG') {
            var errors = e.error;
            goog.object.forEach(errors || {}, function(value, key){
                gdom.classes.add(gdom.getElement(key + 'Container'), 'error');
                var ancestor = gdom.getAncestor(gdom.getElement(key),
                		common.funcUtil.getInstance().getTrueFunc);
                var inputErrorMessage = gdom.findNode(ancestor, function(n){
                    return n.nodeType == goog.dom.NodeType.ELEMENT && n.className == 'help-inline';
                });
                if (inputErrorMessage) {
                    gdom.setTextContent(inputErrorMessage, value);
                } else {
                    gdom.append(ancestor, gdom.createDom('span', {
                        'class': 'help-inline'
                    }, value));
                }
            }, this);
        } else {
            //TODO 完了時はどうしよう？
        	console.log("entry box complete");
        }
    };
});