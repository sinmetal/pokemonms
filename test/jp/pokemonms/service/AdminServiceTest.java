package jp.pokemonms.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.pokemonms.form.PokemonForm;
import jp.pokemonms.model.Ability;
import jp.pokemonms.model.Pokemon;
import jp.pokemonms.tester.generater.AbilityGenerater;
import jp.pokemonms.util.StringUtil;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Key;

/**
 * 管理用サービステスト
 *
 * @author Sinmetal
 *
 */
public class AdminServiceTest extends AppEngineTestCase {

    /** 管理用サービス */
    private AdminService service = new AdminService();

    /**
     * コンストラクタ
     *
     * @throws Exception
     */
    @Test
    public void コンストラクタ() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    /**
     * 特性データバッチ登録
     *
     * @throws Exception
     */
    @Test
    public void 特性データバッチ登録() throws Exception {
        final String ABILITY_NAME = "のろわれボディ";
        Map<String, Object> requestMap = new HashMap<String, Object>();
        String abilityData = ABILITY_NAME;
        requestMap.put("abilityData", abilityData);

        List<Key> keys = service.insertBatch4Ability(requestMap);
        assertThat(keys, is(notNullValue()));
        Ability stored = Datastore.get(Ability.class, keys.get(0));
        assertThat(stored.getKey().getName(), is(ABILITY_NAME));
        assertThat(stored.getAbilityName(), is(ABILITY_NAME));
    }

    /**
     * ポケモン図鑑データバッチ登録
     *
     * @throws Exception
     */
    @Test
    public void ポケモン図鑑データバッチ登録() throws Exception {
        AbilityGenerater abilityGenerater = new AbilityGenerater();
        abilityGenerater.run();

        final String inputPokemon1 =
            "621,クリムガン,ドラゴン,,77,120,90,60,90,48,ドラゴン,かいじゅう,さめはだ,ちからずく,*かたやぶり";
        final String inputPokemon2 =
            "622,ゴビット,じめん,ゴースト,59,74,50,35,50,35,こうぶつ,,てつのこぶし,ぶきよう,*ノーガード";
        final String inputPokemon3 =
            "633,モノズ,あく,ドラゴン,52,65,50,45,50,38,ドラゴン,,はりきり,,";
        List<String> inputStrings = new ArrayList<String>();
        inputStrings.add(inputPokemon1);
        inputStrings.add(inputPokemon2);
        inputStrings.add(inputPokemon3);

        String input = StringUtil.join(inputStrings, "\r\n");

        List<PokemonForm> forms = PokemonForm.getInstances(input);
        List<Key> keys = service.insertBatch4Pokemon(forms);
        assertThat(keys, is(notNullValue()));
        assertThat(keys.size(), is(inputStrings.size()));
        Pokemon stored = Datastore.get(Pokemon.class, keys.get(0));
        assertThat(stored.getWorldGuideNo(), is(621));
    }
}
