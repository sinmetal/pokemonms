package jp.pokemonms.service;

import java.util.List;
import java.util.Map;

import jp.pokemonms.meta.StorageMeta;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.Storage;
import jp.pokemonms.util.DateUtil;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

/**
 * ストレージサービス
 * 
 * @author Sinmetal
 * 
 */
public class StorageService {

    /** StorageMeta */
    private StorageMeta storageMeta = new StorageMeta();

    /**
     * TwitterIdからストレージ一覧を探す
     * 
     * @param twitterId
     * @return ストレージ一覧
     */
    public List<Storage> findByTwitterId(long twitterId) {
        Key key = Member.createKey(twitterId);
        return Datastore
            .query(storageMeta)
            .filter(storageMeta.memberKey.equal(key))
            .asList();
    }

    public Storage findById(int storageId) {
        Key key = Datastore.createKey(storageMeta, storageId);
        return Datastore.get(storageMeta, key);
    }

    public Storage get(Key key, Long version) {
        return Datastore.get(storageMeta, key, version);
    }

    /**
     * 挿入
     * 
     * @param input
     * @return storage
     */
    public Storage insert(Map<String, Object> input) {
        Storage storage = new Storage();
        BeanUtil.copy(input, storage);
        Datastore.put(storage);
        return storage;
    }

    /**
     * 挿入
     * 
     * @param storage
     * @return
     */
    public Storage insert(Storage storage) {
        storage.setEntryDate(DateUtil.getNow());
        Datastore.put(storage);
        return storage;
    }

    public void delete(Key key, Long version) {
        Transaction tx = Datastore.beginTransaction();
        Storage storage = Datastore.get(tx, storageMeta, key, version);
        Datastore.delete(tx, storage.getKey());
        tx.commit();
    }
}
