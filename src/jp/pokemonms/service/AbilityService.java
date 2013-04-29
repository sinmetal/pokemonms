package jp.pokemonms.service;

import java.util.List;
import java.util.Map;

import jp.pokemonms.meta.AbilityMeta;
import jp.pokemonms.model.Ability;
import jp.pokemonms.util.StringUtil;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

/**
 * 特性サービス
 * @author Sinmetal
 *
 */
public class AbilityService {

    /**
     * 特性メタ
     */
    private AbilityMeta abilityMeta = new AbilityMeta();

    /**
     * 特性取得
     *
     * @param id
     * @return
     */
    public Ability findById(int id) {
        Key key = Datastore.createKey(abilityMeta, id);
        return Datastore.get(abilityMeta, key);
    }

    /**
     * 特性取得
     *
     * @param abilityName
     * @return
     */
    public Ability findByAbilityName(String abilityName) {
        if (StringUtil.isEmpty(abilityName)) {
            return null;
        }
        return Datastore.query(abilityMeta)
            .filter(abilityMeta.abilityName.equal(abilityName))
            .asSingle();
    }

    /**
     * 特性一覧取得
     *
     * @param
     * @return
     */
    public List<Ability> findAll() {
        return Datastore.query(abilityMeta).asList();
    }

    /**
     * 特性の数を取得
     *
     * @return
     */
    public int count() {
        return Datastore.query(abilityMeta).count();
    }

    /**
     * 挿入
     *
     * @param input
     * @return
     */
    public Ability insert(Map<String, Object> input) {
        Ability ability = new Ability();
        BeanUtil.copy(input, ability);
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(ability);
        tx.commit();
        return ability;
    }

    /**
     * 挿入
     *
     * @param ability
     * @return
     */
    public Ability insert(Ability ability) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(ability);
        tx.commit();
        return ability;
    }

}
