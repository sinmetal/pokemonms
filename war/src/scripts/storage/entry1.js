goog.provide('storage.entry1');
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
    storage.entry1 = function(){
        this.initialize_();
    };
    
    /**
     * initialize.
     *
     * @private
     */
    storage.entry1.prototype.initialize_ = function(){
        this.eventHandler_ = new gevents.EventHandler(this);
        this.eventHandler_.listen(gdom.getElement('back2storages-btn'), EventType.CLICK, goog.bind(this.onClickBack2StoragesButton_, this));
        this.eventHandler_.listen(gdom.getElement('calculate-btn'), EventType.CLICK, goog.bind(this.onClickCalculateButton_, this));
    };
    
    /**
     * back storages page view button click.
     * @param {Object} e
     */
    storage.entry1.prototype.onClickBack2StoragesButton_ = function(e){
        storage.App.getInstance().changePage('storages-page');
    };
    
    /**
     * individual calculate button click
     * @param {Object} e
     */
    storage.entry1.prototype.onClickCalculateButton_ = function(e){
        var form = gdom.getElement('entry-form1');
        var param = gdom.forms.getFormDataMap(form).toObject();
        common.ajax.getInstance().sendRequest('/storage/individual', param, goog.bind(this.onCalculateIndividualComplete_, this));
    };
    
    /**
     * ajax individual calculate complate.
     * @param {Object} e
     */
    storage.entry1.prototype.onCalculateIndividualComplete_ = function(e){
        if (e.status == 'NG') {
            var errors = e.error;
            goog.object.forEach(errors || {}, function(value, key){
                gdom.classes.add(gdom.getElement(key + 'Container'), 'error');
                var ancestor = gdom.getAncestor(gdom.getElement(key), common.funcUtil.getInstance().getTrueFunc);
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
            var individual = e['individual'];
            goog.object.forEach(individual || {}, function(value, key){
                gdom.getElement('individual' + key).value = value;
            });
        }
    };
});
