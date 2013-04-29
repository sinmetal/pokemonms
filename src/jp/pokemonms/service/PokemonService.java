package jp.pokemonms.service;

import java.util.List;

import jp.pokemonms.meta.PokemonMeta;
import jp.pokemonms.model.Pokemon;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

/**
 * 図鑑サービス
 * 
 * @author Sinmetal
 * 
 */
public class PokemonService {

    /** Memcache用文字列 */
    private final String MEMCACHE = "PokemonService";

    /** PokemonMeta */
    private PokemonMeta pokemonMeta = PokemonMeta.get();

    /**
     * ポケモン図鑑取得
     * 
     * @param id
     * @return
     */
    public Pokemon getById(int worldGuideNo, String pokemonName) {
        Key key = Pokemon.createKey(worldGuideNo, pokemonName);
        return Datastore.get(pokemonMeta, key);
    }

    /**
     * ポケモン図鑑取得
     * 
     * @param pokemonName
     * @return
     */
    public Pokemon getByPokemonName(String pokemonName) {
        String memcacheKey = MEMCACHE + pokemonName;
        if (Memcache.contains(memcacheKey)) {
            return Memcache.get(memcacheKey);
        }

        Pokemon pokemon =
            Datastore
                .query(pokemonMeta)
                .filter(pokemonMeta.pokemonName.equal(pokemonName))
                .asSingle();
        Memcache.put(memcacheKey, pokemon);
        return pokemon;
    }

    /**
     * ポケモン図鑑一覧取得
     * 
     * @param
     * @return
     */
    public List<Pokemon> findAll() {
        return Datastore.query(pokemonMeta).asList();
    }

    /**
     * pokemonNameが図鑑に存在するかを返す
     * 
     * @param pokemonName
     * @return
     */
    public boolean existsPokemon(String pokemonName) {
        if (StringUtil.isEmpty(pokemonName)) {
            return false;
        }

        Pokemon pokemon = getByPokemonName(pokemonName);
        return (pokemon != null);
    }

    /**
     * ポケモン図鑑の数を取得
     * 
     * @return
     */
    public Integer count() {
        return Datastore.query(pokemonMeta).count();
    }

    /**
     * 挿入
     * 
     * @param pokemon
     * @return
     */
    public Pokemon insert(Pokemon pokemon) {
        Transaction tx = Datastore.beginTransaction();
        Datastore.put(pokemon);
        tx.commit();
        return pokemon;
    }

    /**
     * 全データ削除 <br>
     * 全てのデータを削除するため、ポケモン図鑑全入れ替えの時ぐらいしか使うべきではない
     */
    public void deleteAll() {
        List<Key> keys = Datastore.query(pokemonMeta).asKeyList();
        Datastore.delete(keys);
    }
}
