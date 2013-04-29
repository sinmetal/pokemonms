package jp.pokemonms.service;

import java.util.List;

import jp.pokemonms.form.StorageForm;
import jp.pokemonms.meta.StorageMeta;
import jp.pokemonms.model.Ability;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.Pokemon;
import jp.pokemonms.model.Storage;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

/**
 * ストレージファサードサービス
 * 
 * @author Sinmetal
 * 
 */
public class StorageFacadeService {

    /** ポケモン図鑑Service */
    private PokemonService pokemonService = new PokemonService();

    /** 特性Service */
    private AbilityService abilityService = new AbilityService();

    /** 技Service */
    private TrickService trickService = new TrickService();

    /** StorageService */
    private StorageService storageService = new StorageService();

    private StorageMeta storageMeta = new StorageMeta();

    /**
     * Storage一覧を取得
     * 
     * @param twitterId
     * @return
     */
    public List<Storage> getStorages(long twitterId) {
        return storageService.findByTwitterId(twitterId);
    }

    /**
     * trickNameがTrickに存在するかを返す
     * 
     * @param trickName
     * @return
     */
    public boolean existsTrick(String trickName) {
        if (StringUtil.isEmpty(trickName)) {
            return false;
        }

        return (trickService.findByTrickName(trickName) != null);
    }

    /**
     * ストレージ登録
     * 
     * @param form
     * @param twitterId
     * @return 登録したストレージModel
     */
    public Storage insertStorage(StorageForm form, Long twitterId) {
        Storage entity = Storage.getInstance(form);
        entity.setKey(Datastore.allocateId(storageMeta));
        entity.setMemberKey(Member.createKey(twitterId));
        Pokemon pokemon =
            pokemonService.getByPokemonName(form.getPokemonName());
        entity.setPokemonKey(pokemon.getKey());
        List<Key> trickKeys = trickService.getKeys(form.getTrickNames());
        entity.setTrickKeys(trickKeys);
        Ability ability =
            abilityService.findByAbilityName(form.getAbilityName());
        if (ability != null) {
            entity.setAbilityKey(ability.getKey());
        }
        return storageService.insert(entity);
    }

    /**
     * ストレージ更新
     * 
     * @param key
     * @param version
     * @param form
     * @return
     */
    public Storage updateStorage(Key key, Long version, StorageForm form) {
        Transaction tx = Datastore.beginTransaction();
        Storage storage = Datastore.get(tx, storageMeta, key, version);
        BeanUtil.copy(form, storage);
        Pokemon pokemon =
            pokemonService.getByPokemonName(form.getPokemonName());
        storage.setPokemonKey(pokemon.getKey());
        Ability ability =
            abilityService.findByAbilityName(form.getAbilityName());
        if (ability != null) {
            storage.setAbilityKey(ability.getKey());
        }
        Datastore.put(tx, storage);
        tx.commit();
        return storage;
    }
}
