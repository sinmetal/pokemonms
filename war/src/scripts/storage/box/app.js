goog.provide('storage.box.App');
goog.require('goog.events.EventHandler');
goog.require('goog.dom.forms');
goog.require('goog.object');
goog.require('goog.soy');
goog.require('templates.footer');
goog.require('templates.alerts');
goog.require('common.menu');
goog.require('common.ajax');
goog.require('storage.box.entry');

goog.scope(function(){
    var gdom = goog.dom;
    var gsoy = goog.soy;
    var gevents = goog.events;
    var EventType = goog.events.EventType;
    
    /** @constructor */
    storage.box.App = function(){
        this.initialize_();
    };
    goog.addSingletonGetter(storage.box.App);
    
    /**
     * initialize.
     * @private
     */
    storage.box.App.prototype.initialize_ = function(){
        this.eventHandler_ = new gevents.EventHandler(this);
        this.menu_ = new common.menu();
        this.getStorageList_();
        
        this.eventHandler_.listen(gdom.getElement('entry-btn'), EventType.CLICK,
        		goog.bind(this.onClickBoxEntryButton_, this));
        this.eventHandler_.listen(gdom.getElement('back2boxes-btn'), EventType.CLICK,
        		goog.bind(this.onClickBack2boxesButton_, this));
        
        var entryPage = new storage.box.entry();
    };
    
    /**
     * ajax storage list get.
     */
    storage.box.App.prototype.getStorageList_ = function(){
        common.ajax.getInstance().sendRequest('/storage/box/list', {},
        		goog.bind(this.onGetBoxListComplete_, this), 'GET', {});
    };
    
    /**
     * ajax box list get complete.
     * @param {Object} e ajax response.
     */
    storage.box.App.prototype.onGetBoxListComplete_ = function(e){
    	var rookieBoxes = goog.json.parse(e['rookieBoxes']);
    	console.log(rookieBoxes);
    	console.log(rookieBoxes[0].name);
//    	var storages = dto.storage.getInstance().buildeStorages(goog.json.parse(e['storages']));
//        var storageTbody = gdom.getElement('storage-body');
//        gdom.append(storageTbody, gsoy.renderAsElement(templates.storage.pokemonList, storages));
    };
    
    /**
     * entry box button click.
     * @param {Object} e
     */
    storage.box.App.prototype.onClickBoxEntryButton_ = function(e){
        this.changePage('entry-page');
    };
    
    /**
     * back2boxes button click.
     * @param {Object} e
     */
    storage.box.App.prototype.onClickBack2boxesButton_ = function(e){
    	this.changePage('boxes-page');
    }
    
    /**
     * change view page.
     * @param {String} viewPageId
     */
    storage.box.App.prototype.changePage = function(viewPageId){
        var pageList = ['boxes-page', 'entry-page'];
        goog.object.forEach(pageList, function(value){
            if (viewPageId === value) {
                gdom.classes.remove(gdom.getElement(value), 'hide');
            } else {
                gdom.classes.add(gdom.getElement(value), 'hide');
            }
        }, this);
    };
    
    /**
     * box page get instance.
     */
    storage.box.App.getInstance();
});
