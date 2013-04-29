goog.provide('dto.storage');

goog.scope(function() {
	
	/** @constructor */
    dto.storage = function(){
    };
    goog.addSingletonGetter(dto.storage);
	
	/**
	 * StorageTemplete用のStorageデータを作成
	 * 
	 * @param storage
	 */
	dto.storage.prototype.buildeStorage = function(storage) {
	    return {
	        key: storage['key'],
	        version: storage['version'],
	        id: storage['id'],
	        pokemonName: storage['pokemonName'],
	        nickname: storage['nickname'],
	        personName: storage['personName'],
	        genderName: storage['genderName'],
	        abilityName: storage['abilityName'],
	        individualH: storage['individualH'],
	        individualA: storage['individualA'],
	        individualB: storage['individualB'],
	        individualC: storage['individualC'],
	        individualD: storage['individualD'],
	        individualS: storage['individualS'],
	        effortH: storage['effortH'],
	        effortA: storage['effortA'],
	        effortB: storage['effortB'],
	        effortC: storage['effortC'],
	        effortD: storage['effortD'],
	        effortS: storage['effortS'],
	        lv50H: storage['lv50H'],
	        lv50A: storage['lv50A'],
	        lv50B: storage['lv50B'],
	        lv50C: storage['lv50C'],
	        lv50D: storage['lv50D'],
	        lv50S: storage['lv50S'],
	        trick1stName: storage['trick1stName'],
	        trick2ndName: storage['trick2ndName'],
	        trick3rdName: storage['trick3rdName'],
	        trick4thName: storage['trick4thName'],
	        awakenPowerElementName: storage['awakenPowerElementName'],
	        awakenPowerEdge: storage['awakenPowerEdge'],
	        remark: storage['remark']
	    }
	}
	
	/**
	 * StorageTemplete用のStorage一覧データを作成
	 * 
	 * @param storages
	 */
	dto.storage.prototype.buildeStorages = function(storages) {
	    var data = {
	        pokemonList: []
	    };
	    for (var i = 0, len = storages.length; i < len; i++) {
	        data.pokemonList[i] = dto.storage.getInstance().buildeStorage(storages[i]);
	    }
	    return data;
	}
	
	dto.storage.getInstance();
});