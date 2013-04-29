package jp.pokemonms.tester.generater.model.json.storage;

import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.model.json.storage.Rookie;
import jp.pokemonms.tester.generater.constract.PokemonName;
import jp.pokemonms.var.LoginInfo;

/**
 * テスト用の育成前ポケモンデータ作成
 * 
 * @author sinmetal
 * 
 */
public class RookieGenerater {

    /** 作成した育成前ポケモンデータMap */
    private final Map<PokemonName, Rookie> rookieMap =
        new HashMap<PokemonName, Rookie>();

    /**
     * テスト用育成前ポケモンデータ登録
     * 
     * @param info
     *            ログイン情報
     */
    public void run(LoginInfo info) {
        rookieMap.put(PokemonName.LEAFEON, createLeafeon(info));
    }

    /**
     * 作成されている育成前ポケモンデータ数を返す
     * 
     * @return 作成されている育成前ポケモンデータの数
     */
    public int count() {
        return rookieMap.size();
    }

    /**
     * 指定したポケモンを取得
     * 
     * @param pokemonName
     *            ポケモン名
     * @return 育成前ポケモンModel
     */
    public Rookie get(PokemonName pokemonName) {
        return rookieMap.get(pokemonName);
    }

    /**
     * リーフィアの実際のデータでModelを作成
     * 
     * @param info
     *            ログイン情報
     * @return リーフィアの実際のデータのModel
     */
    private Rookie createLeafeon(LoginInfo info) {
        final Rookie rookie = new Rookie();
        return rookie;
    }
}
