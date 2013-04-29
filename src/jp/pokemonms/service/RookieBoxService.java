package jp.pokemonms.service;

import java.util.List;

import jp.pokemonms.meta.json.storage.box.RookieBoxMeta;
import jp.pokemonms.model.json.storage.box.RookieBox;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

/**
 * 育成前ポケモンBoxサービス
 * @author sinmetal
 *
 */
public class RookieBoxService {
    
    /** Meta */
    private final RookieBoxMeta meta = RookieBoxMeta.get();
    
    /**
     * put entity
     * 
     * @param entity
     * @return putしたentityのKey
     */
    public Key put(RookieBox entity) {
        return put(null, entity);
    }
    
    /**
     * put entity
     * 
     * @param tx トランザクション
     * @param entity putするentity
     * @return putしたentityのkey
     */
    public Key put(Transaction tx, RookieBox entity) {
        if (tx == null) {
            return Datastore.put(entity);
        }
        return Datastore.put(tx, entity);
    }
    
    /**
     * get entity
     * 
     * @param key getしたいentityのKey
     * @return entity
     */
    public RookieBox get(Key key) {
        return Datastore.get(meta, key);
    }
    
    /**
     * get entitys
     * 
     * @param keys getしたいentityのKeyのList
     * @return entityList
     */
    public List<RookieBox> get(List<Key> keys) {
        return Datastore.get(meta, keys);
    }
}
