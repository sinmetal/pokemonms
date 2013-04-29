package jp.pokemonms.tester.generater;

import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.form.StorageForm;
import jp.pokemonms.model.Storage;
import jp.pokemonms.service.StorageFacadeService;
import jp.pokemonms.tester.StorageRequestGenerater;
import jp.pokemonms.tester.generater.constract.PokemonName;
import jp.pokemonms.var.LoginInfo;

/**
 * ストレージジェネレーター
 * 
 * @author sinmetal
 * 
 */
public class StorageGenerater {

    /** ストレージファサードサービス */
    private StorageFacadeService storaeFacadeService =
        new StorageFacadeService();

    /** 作成したストレージMap */
    private Map<PokemonName, Storage> storageMap =
        new HashMap<PokemonName, Storage>();

    /**
     * テスト用ストレージをDatastoreに登録
     * 
     * @param info
     *            ログイン情報
     */
    public void run(LoginInfo info) {
        storageMap.put(PokemonName.LEAFEON, createLeafeon(info));
    }

    /**
     * 作成されているストレージの数を返す
     * 
     * @return 作成されているストレージの数
     */
    public int count() {
        return storageMap.size();
    }

    /**
     * 指定されたポケモンを取得
     * 
     * @param pokemonName
     * @return ストレージModel
     */
    public Storage get(PokemonName pokemonName) {
        return storageMap.get(pokemonName);
    }

    /**
     * リーフィアの実際のデータでのModelを作成
     * 
     * @param info
     *            ログイン情報
     * @return リーフィアの実際のデータのModel
     */
    private Storage createLeafeon(LoginInfo info) {
        StorageRequestGenerater storageRequestGenerater =
            new StorageRequestGenerater();
        Map<String, Object> storageRequestMap =
            storageRequestGenerater.getRealData1Request();
        StorageForm form = StorageForm.getInstance(storageRequestMap);
        return storaeFacadeService.insertStorage(form, info.getTwitterId());
    }
}
