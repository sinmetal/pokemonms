package jp.pokemonms.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.pokemonms.form.StorageForm;
import jp.pokemonms.meta.StorageMeta;
import jp.pokemonms.model.constant.ElementType;
import jp.pokemonms.model.constant.GenderType;
import jp.pokemonms.model.constant.PersonType;
import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.tester.StorageRequestGenerater;
import jp.pokemonms.tester.generater.AbilityGenerater;
import jp.pokemonms.tester.generater.PokemonGenerater;
import jp.pokemonms.tester.generater.TrickGenerater;
import jp.pokemonms.tester.generater.constract.PokemonName;
import jp.pokemonms.tester.generater.constract.TrickName;
import jp.pokemonms.util.DateUtil;
import jp.pokemonms.util.JsonUtil;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gson.reflect.TypeToken;

/**
 * ストレージモデルテスト
 * 
 * @author Sinmetal
 * 
 */
public class StrageTest extends AppEngineTestCase {

    private StorageMeta meta = StorageMeta.get();

    private Storage model = new Storage();

    private LoginHelper loginHelper = new LoginHelper();

    private PokemonGenerater pokemonGenerater = new PokemonGenerater();

    private TrickGenerater trickGenerater = new TrickGenerater();

    private AbilityGenerater abilityGenerater = new AbilityGenerater();

    private StorageRequestGenerater requestGenerater =
        new StorageRequestGenerater();

    /*
     * (非 Javadoc)
     * 
     * @see org.slim3.tester.AppEngineTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        loginHelper.init();
        trickGenerater.run();
        abilityGenerater.run();
        pokemonGenerater.run();
    }

    /**
     * コンストラクタ
     * 
     * @throws Exception
     */
    @Test
    public void コンストラクタ() throws Exception {
        assertThat(model, is(notNullValue()));
    }

    /**
     * KeyString取得
     * 
     * @throws Exception
     */
    @Test
    public void KeyString取得() throws Exception {
        Storage storage = new Storage();
        assertThat(storage.getKeyString(), is(""));
        Key key = Datastore.put(storage);
        Storage stored = Datastore.get(Storage.class, key);
        String keyString = KeyFactory.keyToString(stored.getKey());
        assertThat(stored.getKeyString(), is(keyString));
    }

    /**
     * インスタンス生成
     * 
     * @throws Exception
     */
    @Test
    public void インスタンス生成() throws Exception {
        StorageForm form =
            StorageForm
                .getInstance(requestGenerater.getInsertCompleteRequest());
        Storage model = Storage.getInstance(form);
        assertTrue("nickName", "フッシー".equals(model.getNickname()));
        assertTrue("person", PersonType.DEMURE.equals(model.getPerson()));
        assertTrue("gender", GenderType.MALE.equals(model.getGender()));
        assertThat(model.getIndividualUpperH(), is(31));
        assertThat(model.getIndividualUpperA(), is(15));
        assertThat(model.getIndividualUpperB(), is(30));
        assertThat(model.getIndividualUpperC(), is(31));
        assertThat(model.getIndividualUpperD(), is(-1));
        assertThat(model.getIndividualUpperS(), is(27));
        assertThat(model.getIndividualLowerH(), is(31));
        assertThat(model.getIndividualLowerA(), is(0));
        assertThat(model.getIndividualLowerB(), is(-1));
        assertThat(model.getIndividualLowerC(), is(31));
        assertThat(model.getIndividualLowerD(), is(28));
        assertThat(model.getIndividualLowerS(), is(27));
        assertTrue(
            "awakenPowerElement",
            ElementType.FIRE.equals(model.getAwakenPowerElement()));
        assertTrue(
            "awakenPowerEdge",
            new Integer(69).equals(model.getAwakenPowerEdge()));
        assertTrue("remark", "かがくのちからってすげー".equals(model.getRemark()));
    }

    /**
     * 技4つ設定
     * 
     * 技モデルのKeyをMax個受け渡した場合、全て設定されること。
     * 
     * @throws Exception
     */
    @Test
    public void 技4つ設定() throws Exception {
        Storage storage = new Storage();
        Trick tackle = trickGenerater.get(TrickName.TACKLE);
        Trick grow = trickGenerater.get(TrickName.GROWL);
        Trick solarbeam = trickGenerater.get(TrickName.SOLARBEAM);
        Trick vineWhip = trickGenerater.get(TrickName.VINE_WHIP);
        storage.setTrickKeys(
            tackle.getKey(),
            grow.getKey(),
            solarbeam.getKey(),
            vineWhip.getKey());

        assertThat(storage.getTrick1stKey(), is(tackle.getKey()));
        assertThat(storage.getTrick2ndKey(), is(grow.getKey()));
        assertThat(storage.getTrick3rdKey(), is(solarbeam.getKey()));
        assertThat(storage.getTrick4thKey(), is(vineWhip.getKey()));
        assertThat(storage.getTrick1stName(), is(tackle.getTrickName()));
        assertThat(storage.getTrick2ndName(), is(grow.getTrickName()));
        assertThat(storage.getTrick3rdName(), is(solarbeam.getTrickName()));
        assertThat(storage.getTrick4thName(), is(vineWhip.getTrickName()));
    }

    /**
     * 技1つ設定
     * 
     * 技モデルのKeyを1つ受け渡した場合、1つは設定され、それ以外はnullであること
     * 
     * @throws Exception
     */
    @Test
    public void 技1つ設定() throws Exception {
        Storage storage = new Storage();
        Trick tackle = trickGenerater.get(TrickName.TACKLE);

        storage.setTrickKeys(tackle.getKey());

        assertThat(storage.getTrick1stKey(), is(tackle.getKey()));
        assertThat(storage.getTrick2ndKey(), is(nullValue()));
        assertThat(storage.getTrick3rdKey(), is(nullValue()));
        assertThat(storage.getTrick4thKey(), is(nullValue()));
    }

    /**
     * nullを含んだ技設定
     * 
     * 技モデルにnullを含んだ配列を渡した場合、有効な値のみが登録されること。
     * 
     * @throws Exception
     */
    @Test
    public void nullを含んだ技設定() throws Exception {
        Storage storage = new Storage();
        Trick tackle = trickGenerater.get(TrickName.TACKLE);
        Trick vineWhip = trickGenerater.get(TrickName.VINE_WHIP);

        storage.setTrickKeys(null, tackle.getKey(), null, vineWhip.getKey());

        assertThat(storage.getTrick1stKey(), is(tackle.getKey()));
        assertThat(storage.getTrick2ndKey(), is(vineWhip.getKey()));
        assertThat(storage.getTrick3rdKey(), is(nullValue()));
        assertThat(storage.getTrick4thKey(), is(nullValue()));
    }

    /**
     * 技上書きテスト
     * 
     * 元々技が設定されているモデルに技設定した場合に、上書きされるか。
     * 
     * @throws Exception
     */
    @Test
    public void 技上書きテスト() throws Exception {
        Storage storage = new Storage();
        Trick tackle = trickGenerater.get(TrickName.TACKLE);
        Trick grow = trickGenerater.get(TrickName.GROWL);
        Trick solarbeam = trickGenerater.get(TrickName.SOLARBEAM);
        Trick vineWhip = trickGenerater.get(TrickName.VINE_WHIP);

        storage.setTrickKeys(
            tackle.getKey(),
            grow.getKey(),
            solarbeam.getKey(),
            vineWhip.getKey());
        storage.setTrickKeys(null, tackle.getKey(), null, vineWhip.getKey());

        assertThat(storage.getTrick1stKey(), is(tackle.getKey()));
        assertThat(storage.getTrick2ndKey(), is(vineWhip.getKey()));
        assertThat(storage.getTrick3rdKey(), is(nullValue()));
        assertThat(storage.getTrick4thKey(), is(nullValue()));
    }

    /**
     * 技モデル上書きテスト
     * 
     * 元々技が設定されているモデルに技設定した場合に、上書きされるか。
     * 
     * @throws Exception
     */
    @Test
    public void 技モデル上書きテスト() throws Exception {
        Storage storage = new Storage();
        Trick tackle = trickGenerater.get(TrickName.TACKLE);
        Trick grow = trickGenerater.get(TrickName.GROWL);
        Trick solarbeam = trickGenerater.get(TrickName.SOLARBEAM);
        Trick vineWhip = trickGenerater.get(TrickName.VINE_WHIP);

        storage.setTricks(tackle, grow, solarbeam, vineWhip);
        storage.setTrickKeys(null, tackle.getKey(), null, vineWhip.getKey());

        assertThat(storage.getTrick1stKey(), is(tackle.getKey()));
        assertThat(storage.getTrick2ndKey(), is(vineWhip.getKey()));
        assertThat(storage.getTrick3rdKey(), is(nullValue()));
        assertThat(storage.getTrick4thKey(), is(nullValue()));
    }

    /**
     * JSON変換テスト
     * 
     * @throws Exception
     */
    @Test
    public void JSON変換テスト() throws Exception {
        Storage before = new Storage();
        Pokemon bulbasaur = pokemonGenerater.get(PokemonName.BULBASAUR);
        before.setPokemonKey(bulbasaur.getKey());

        Key key = Datastore.put(before);
        Storage stored = Datastore.get(meta, key);
        assertThat(stored, is(notNullValue()));

        String json = JsonUtil.createGson().toJson(stored, Storage.class);
        assertTrue(json.length() > 0);

        Storage after = JsonUtil.createGson().fromJson(json, Storage.class);
        assertThat(after.getPokemonName(), is("フシギダネ"));
    }

    /**
     * StorageListをJSONに変換
     * 
     * @throws Exception
     */
    @Test
    public void StorageListをJSONに変換() throws Exception {
        final PokemonName TEST_POKEMON = PokemonName.BULBASAUR;
        Storage before = new Storage();
        Pokemon bulbasaur = pokemonGenerater.get(TEST_POKEMON);
        before.setPokemonKey(bulbasaur.getKey());
        Date testDate = new Date();
        before.setEntryDate(testDate);

        Key key = Datastore.put(before);
        List<Key> keys = new ArrayList<Key>();
        keys.add(key);
        List<Storage> stored = Datastore.get(meta, keys);

        String json = JsonUtil.createGson().toJson(stored);
        assertTrue(json.length() > 0);

        Type storageListType = new TypeToken<List<Storage>>() {
        }.getType();
        List<Storage> afterList =
            JsonUtil.createGson().fromJson(json, storageListType);
        assertThat(afterList.size(), is(1));
        Storage after = afterList.get(0);
        assertThat(after.getPokemonName(), is(TEST_POKEMON.getName()));
        assertTrue(DateUtil.compareYYYYMMDD_HHMMSS(
            after.getEntryDate(),
            testDate));
    }

    /**
     * テスト用リクエストマップ作成
     * 
     * @return
     */
    protected Map<String, Object> createRequestMap() {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("pokemonName", "フシギダネ");
        request.put("nickname", "フッシー");
        request.put("personName", "ひかえめ");
        request.put("genderId", "1");
        request.put("ability", "ようりょくそ");
        request.put("individualH", "31");
        request.put("individualA", "30");
        request.put("individualB", "30");
        request.put("individualC", "31");
        request.put("individualD", "28");
        request.put("individualS", "27");
        request.put("effortH", "10");
        request.put("effortA", "11");
        request.put("effortB", "12");
        request.put("effortC", "13");
        request.put("effortD", "14");
        request.put("effortS", "15");
        request.put("lv50A", "51");
        request.put("lv50B", "52");
        request.put("lv50C", "53");
        request.put("lv50D", "54");
        request.put("lv50S", "55");
        request.put("trick1stName", "たいあたり");
        request.put("trick2ndName", "つるのむち");
        request.put("trick3rdName", "ソーラービーム");
        request.put("trick4thName", "なきごえ");
        request.put("awakenPowerElementName", "ほのお");
        request.put("awakenPowerEdge", "69");
        request.put("remark", "かがくのちからってすげー");
        return request;
    }
}
