goog.provide('storage.entry2');
goog.require('goog.events.EventHandler');
goog.require('goog.dom');
goog.require('goog.dom.forms');
goog.require('goog.dom.query');
goog.require('goog.soy');
goog.require('common.ajax');
goog.require('common.funcUtil');

goog.scope(function(){
    var gdom = goog.dom;
    var gsoy = goog.soy;
    var gevents = goog.events;
    var EventType = goog.events.EventType;
    
    /** @constructor */
    storage.entry2 = function(){
        this.initialize_();
    };
    
    /**
     * initialize.
     *
     * @private
     */
    storage.entry2.prototype.initialize_ = function(){
        this.eventHandler_ = new gevents.EventHandler(this);
        this.eventHandler_.listen(gdom.getElement('back2entry1-btn'), EventType.CLICK,
            goog.bind(this.onClickBack2Entry1Button_, this));
        this.eventHandler_.listen(gdom.getElement('entry-storage-btn'), EventType.CLICK,
            goog.bind(this.onClickEntryStorageButton_, this));
    };
    
    /**
     * back entry1 page view button click.
     * @param {Object} e
     */
    storage.entry2.prototype.onClickBack2Entry1Button_ = function(e){
        storage.App.getInstance().changePage('entry-page1');
    };
    
    /**
     * storage entry button click
     * @param {Object} e
     */
    storage.entry2.prototype.onClickEntryStorageButton_ = function(e){
        var form1 = gdom.getElement('entry-form1');
        var form2 = gdom.getElement('entry-form2');
        var param1 = gdom.forms.getFormDataMap(form1);
        var param2 = gdom.forms.getFormDataMap(form2);
        param1.addAll(param2);
        common.ajax.getInstance().sendRequest('/storage/entry', param1.toObject(), 
            goog.bind(this.onStorageEntryComplete_, this));
    };
    
    /**
     * ajax storage entry complate.
     * @param {Object} e
     */
    storage.entry2.prototype.onStorageEntryComplete_ = function(e){
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
        	var pokemon = goog.json.parse(e['storage']);
            var data = {
                pokemon: []
            };
            var pokemon = {
                key: pokemon['key'],
                version: pokemon['version'],
                id: pokemon['id'],
                pokemonName: pokemon['pokemonName'],
                nickname: pokemon['nickname'],
                personName: pokemon['personName'],
                genderName: pokemon['genderName'],
                abilityName: pokemon['abilityName'],
                individualH: pokemon['individualH'],
                individualA: pokemon['individualA'],
                individualB: pokemon['individualB'],
                individualC: pokemon['individualC'],
                individualD: pokemon['individualD'],
                individualS: pokemon['individualS'],
                effortH: pokemon['effortH'],
                effortA: pokemon['effortA'],
                effortB: pokemon['effortB'],
                effortC: pokemon['effortC'],
                effortD: pokemon['effortD'],
                effortS: pokemon['effortS'],
                lv50H: pokemon['lv50H'],
                lv50A: pokemon['lv50A'],
                lv50B: pokemon['lv50B'],
                lv50C: pokemon['lv50C'],
                lv50D: pokemon['lv50D'],
                lv50S: pokemon['lv50S'],
                trick1stName: pokemon['trick1stName'],
                trick2ndName: pokemon['trick2ndName'],
                trick3rdName: pokemon['trick3rdName'],
                trick4thName: pokemon['trick4thName'],
                awakenPowerElementName: pokemon['awakenPowerElementName'],
                awakenPowerEdge: pokemon['awakenPowerEdge'],
                remark: pokemon['remark']
            }
            var storageBody = gdom.getElement('storage-body');
            gdom.append(storageBody, gsoy.renderAsElement(templates.storage.pokemon, pokemon));
            storage.App.getInstance().changePage('storages-page');
            
            var form1 = gdom.getElement('entry-form1');
            var form2 = gdom.getElement('entry-form2');
            form1.reset();
            form2.reset();
        }
    };
});
