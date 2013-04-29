package jp.pokemonms.service;

import java.util.ArrayList;
import java.util.List;

import jp.pokemonms.meta.TrickMeta;
import jp.pokemonms.model.Trick;

import org.slim3.datastore.Datastore;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

/**
 * 技サービス
 *
 * @author Sinmetal
 *
 */
public class TrickService {

    /** 技メタ */
    private TrickMeta trickMeta = new TrickMeta();

    /**
     * 技一覧取得
     *
     * @return
     */
    public List<Trick> findAll() {
        return Datastore
            .query(trickMeta)
            .sort(trickMeta.trickName.asc)
            .asList();
    }

    /**
     * 渡された技名に該当する技モデルを返す
     *
     * @param trickName
     * @return
     */
    public Trick findByTrickName(String trickName) {
        if (StringUtil.isEmpty(trickName)) {
            return null;
        }
        Key key = Trick.createKey(trickName);
        return Datastore.getOrNull(trickMeta, key);
    }

    /**
     * 渡された技名に該当する技モデルのKey一覧を返す
     *
     * @param trickNames
     * @return
     */
    public List<Key> getKeys(String[] trickNames) {
        if (trickNames.length < 1) {
            return new ArrayList<Key>();
        }
        return Datastore.query(trickMeta).filter(
            trickMeta.trickName.in(trickNames)).asKeyList();
    }

    /**
     * 渡された技名に該当する技モデルのKey一覧を返す
     *
     * @param trickNames
     * @return
     */
    public List<Key> getKeys(List<String> trickNames) {
        return getKeys(trickNames.toArray(new String[0]));
    }

    /**
     * 技の数を取得
     *
     * @return
     */
    public Integer count() {
        return Datastore.query(trickMeta).count();
    }

    /**
     * 挿入
     *
     * @param trick
     * @return
     */
    public Trick insert(Trick trick) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(trick);
        tx.commit();
        return trick;
    }
}
