package jp.pokemonms.controller.storage;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.model.Ability;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.Pokemon;
import jp.pokemonms.model.Trick;
import jp.pokemonms.model.constant.GenderType;
import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.tester.StorageRequestGenerater;
import jp.pokemonms.tester.generater.AbilityGenerater;
import jp.pokemonms.tester.generater.PokemonGenerater;
import jp.pokemonms.tester.generater.TrickGenerater;
import jp.pokemonms.util.JsonUtil;
import jp.pokemonms.view.StorageView;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

import com.google.appengine.api.datastore.KeyFactory;

/**
 * ストレージ登録画面表示コントローラテスト
 * 
 * @author Sinmetal
 * 
 */
public class EntryControllerTest extends ControllerTestCase {

    private AbilityGenerater abilityGenerater = new AbilityGenerater();

    private TrickGenerater trickGenerater = new TrickGenerater();

    private PokemonGenerater pokemonGenerater = new PokemonGenerater();

    private LoginHelper loginHelper = new LoginHelper();

    private StorageRequestGenerater storageRequestGenerater;

    /*
     * (非 Javadoc)
     * 
     * @see org.slim3.tester.ControllerTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        loginHelper.init();
        abilityGenerater.run();
        trickGenerater.run();
        pokemonGenerater.run();
        storageRequestGenerater = new StorageRequestGenerater();
    }

    /**
     * validateエラー
     * 
     * @throws Exception
     */
    @Test
    public void validateエラー() throws Exception {
        tester.sessionScope(loginHelper.LOGIN_INFO, loginHelper.getLoginInfo());
        tester.start("/storage/entry");
        EntryController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));

        assertThat(
            tester.response.getStatus(),
            is(equalTo(HttpServletResponse.SC_OK)));

        Map<String, Object> map =
            JsonUtil.toMap(tester.response.getOutputAsString());
        assertThat(
            map.get(JsonController.STATUS).toString(),
            is(equalTo(JsonController.STATUS_NG)));
        assertThat(map.get("errors"), is(notNullValue()));
    }

    /**
     * 未ログインエラー
     * 
     * @throws Exception
     */
    @Test
    public void 未ログインエラー() throws Exception {
        tester.start("/storage/entry");
        EntryController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }

    /**
     * Validateを通る最小構成入力値で登録
     * 
     * @throws Exception
     */
    @Test
    public void 最小入力テスト() throws Exception {
        tester.sessionScope(loginHelper.LOGIN_INFO, loginHelper.getLoginInfo());
        Map<String, Object> requestMap =
            storageRequestGenerater.getInsertImperfectionRequest();
        for (String key : requestMap.keySet()) {
            tester.requestScope(key, requestMap.get(key));
        }

        tester.start("/storage/entry");
        EntryController controller = tester.getController();

        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));

        assertThat(
            tester.response.getStatus(),
            is(equalTo(HttpServletResponse.SC_OK)));
        Map<String, Object> map =
            JsonUtil.toMap(tester.response.getOutputAsString());
        assertThat(
            map.get(JsonController.STATUS).toString(),
            is(equalTo(JsonController.STATUS_OK)));

        final String RESPONSE_PUT_STORAGE = "storage";
        assertThat(map.get(RESPONSE_PUT_STORAGE), is(notNullValue()));
        String storageJson = map.get(RESPONSE_PUT_STORAGE).toString();
        assertTrue(storageJson.length() > 0);
        StorageView view = JsonUtil.createGson().fromJson(storageJson, StorageView.class);
        assertThat(
            view.getMemberKey(),
            is(KeyFactory.keyToString(Member.createKey(loginHelper.TWITTER_ID))));
        assertThat(view.getPokemonName(), is(requestMap.get("pokemonName")));
    }

    /**
     * 全項目入力して登録
     * 
     * @throws Exception
     */
    @Test
    public void 全項目入力して登録() throws Exception {
        tester.sessionScope(loginHelper.LOGIN_INFO, loginHelper.getLoginInfo());
        Map<String, Object> requestMap =
            storageRequestGenerater.getInsertCompleteRequest();
        for (String key : requestMap.keySet()) {
            tester.requestScope(key, requestMap.get(key));
        }

        tester.start("/storage/entry");
        EntryController controller = tester.getController();

        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));

        assertThat(
            tester.response.getStatus(),
            is(equalTo(HttpServletResponse.SC_OK)));
        Map<String, Object> map =
            JsonUtil.toMap(tester.response.getOutputAsString());
        assertThat(
            map.get(JsonController.STATUS).toString(),
            is(equalTo(JsonController.STATUS_OK)));

        final String RESPONSE_PUT_STORAGE = "storage";
        assertThat(map.get(RESPONSE_PUT_STORAGE), is(notNullValue()));
        String storageJson = map.get(RESPONSE_PUT_STORAGE).toString();
        assertTrue(storageJson.length() > 0);
        StorageView view = JsonUtil.createGson().fromJson(storageJson, StorageView.class);
        assertThat(
            view.getMemberKey(),
            is(KeyFactory.keyToString(Member.createKey(loginHelper.TWITTER_ID))));
        assertThat(view.getKey(), is(notNullValue()));
        assertThat(view.getPokemonName(), is(requestMap.get("pokemonName")));
        // TODO Box機能実装後に修正
        assertThat(view.getBoxKey(), is(""));
        assertThat(
            view.getPokemonKey(),
            is(KeyFactory.keyToString(Pokemon.createKey(1, requestMap.get("pokemonName").toString()))));
        assertThat(view.getNickname(), is(requestMap.get("nickname")));
        String personName = requestMap.get("personName").toString();
        assertThat(view.getPersonName(), is(personName));
        assertThat(view.getGenderName(), is(GenderType.MALE.getName()));
        String abilityName = requestMap.get("abilityName").toString();
        assertThat(view.getAbilityKey(), is(KeyFactory.keyToString(Ability.createKey(abilityName))));
        assertThat(view.getAbilityName(), is(abilityName));

        // TODO ステータスなども追加する
        String trick1stName = requestMap.get("trick1stName").toString();
        assertThat(view.getTrick1stKey(), is(KeyFactory.keyToString(Trick.createKey(trick1stName))));
        assertThat(view.getTrick1stName(), is(trick1stName));
    }
}
