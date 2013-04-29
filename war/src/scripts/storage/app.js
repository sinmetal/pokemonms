goog.provide('storage.App');
goog.require('goog.events.EventHandler');
goog.require('goog.dom.forms');
goog.require('goog.object');
goog.require('goog.soy');
goog.require('templates.footer');
goog.require('templates.alerts');
goog.require('templates.storage');
goog.require('common.menu');
goog.require('common.ajax');
goog.require('storage.entry1');
goog.require('storage.entry2');
goog.require('dto.storage');

goog.scope(function(){
    var gdom = goog.dom;
    var gsoy = goog.soy;
    var gevents = goog.events;
    var EventType = goog.events.EventType;
    
    /** @constructor */
    storage.App = function(){
        this.initialize_();
    };
    goog.addSingletonGetter(storage.App);
    
    /**
     * initialize.
     * @private
     */
    storage.App.prototype.initialize_ = function(){
        this.eventHandler_ = new gevents.EventHandler(this);
        this.menu_ = new common.menu();
        this.getStorageList_();
        
        this.eventHandler_.listen(gdom.getElement('entry-btn'), EventType.CLICK, goog.bind(this.onClickEntryStorageButton_, this));
        this.eventHandler_.listen(gdom.getElement('entry-pokemoninfo-btn'), EventType.CLICK, goog.bind(this.onClickEntryPokemonInfoButton_, this));
        
        var entryPage1 = new storage.entry1();
        var entryPage2 = new storage.entry2();
    };
    
    /**
     * ajax storage list get.
     */
    storage.App.prototype.getStorageList_ = function(){
        common.ajax.getInstance().sendRequest('/storage/list', {}, goog.bind(this.onGetStorageListComplete_, this), 'GET', {});
    };
    
    /**
     * ajax storage list get complete.
     * @param {Object} e ajax response.
     */
    storage.App.prototype.onGetStorageListComplete_ = function(e){
    	var storages = dto.storage.getInstance().buildeStorages(goog.json.parse(e['storages']));
//        var data = {
//            pokemonList: []
//        };
//        for (var i = 0, len = storages.length; i < len; i++) {
//            data.pokemonList[i] = {
//                key: storages[i]['key'],
//                version: storages[i]['version'],
//                id: storages[i]['id'],
//                pokemonName: storages[i]['pokemonName'],
//                nickname: storages[i]['nickname'],
//                personName: storages[i]['personName'],
//                genderName: storages[i]['genderName'],
//                abilityName: storages[i]['abilityName'],
//                individualH: storages[i]['individualH'],
//                individualA: storages[i]['individualA'],
//                individualB: storages[i]['individualB'],
//                individualC: storages[i]['individualC'],
//                individualD: storages[i]['individualD'],
//                individualS: storages[i]['individualS'],
//                effortH: storages[i]['effortH'],
//                effortA: storages[i]['effortA'],
//                effortB: storages[i]['effortB'],
//                effortC: storages[i]['effortC'],
//                effortD: storages[i]['effortD'],
//                effortS: storages[i]['effortS'],
//                lv50H: storages[i]['lv50H'],
//                lv50A: storages[i]['lv50A'],
//                lv50B: storages[i]['lv50B'],
//                lv50C: storages[i]['lv50C'],
//                lv50D: storages[i]['lv50D'],
//                lv50S: storages[i]['lv50S'],
//                trick1stName: storages[i]['trick1stName'],
//                trick2ndName: storages[i]['trick2ndName'],
//                trick3rdName: storages[i]['trick3rdName'],
//                trick4thName: storages[i]['trick4thName'],
//                awakenPowerElementName: storages[i]['awakenPowerElementName'],
//                awakenPowerEdge: storages[i]['awakenPowerEdge'],
//                remark: storages[i]['remark']
//            };
//        }
        var storageTbody = gdom.getElement('storage-body');
        gdom.append(storageTbody, gsoy.renderAsElement(templates.storage.pokemonList, storages));
    };
    
    /**
     * entry storage button click.
     * @param {Object} e
     */
    storage.App.prototype.onClickEntryStorageButton_ = function(e){
        this.changePage('entry-page1');
    };
    
    /**
     * entry pokemon info button click.
     * @param {Object} e
     */
    storage.App.prototype.onClickEntryPokemonInfoButton_ = function(e){
        this.changePage('entry-page2');
    };
    
    /**
     * change view page.
     * @param {String} viewPageId
     */
    storage.App.prototype.changePage = function(viewPageId){
        var pageList = ['storages-page', 'entry-page1', 'entry-page2'];
        goog.object.forEach(pageList, function(value){
            if (viewPageId === value) {
                gdom.classes.remove(gdom.getElement(value), 'hide');
            } else {
                gdom.classes.add(gdom.getElement(value), 'hide');
            }
        }, this);
    };
    
    /**
     * storage page get instance.
     */
    storage.App.getInstance();
});
