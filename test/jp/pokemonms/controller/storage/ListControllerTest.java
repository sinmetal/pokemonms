package jp.pokemonms.controller.storage;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.model.Pokemon;
import jp.pokemonms.model.constant.GenderType;
import jp.pokemonms.model.constant.PersonType;
import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.tester.generater.AbilityGenerater;
import jp.pokemonms.tester.generater.PokemonGenerater;
import jp.pokemonms.tester.generater.StorageGenerater;
import jp.pokemonms.tester.generater.TrickGenerater;
import jp.pokemonms.util.JsonUtil;
import jp.pokemonms.view.StorageView;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.gson.reflect.TypeToken;

/**
 * StorageListControllerTest
 * 
 * @author Sinmetal
 * 
 */
public class ListControllerTest extends ControllerTestCase {
    /** テスト用ログインヘルパー */
    private LoginHelper loginHelper = new LoginHelper();
    /** テスト用技ジェネレーター */
    private TrickGenerater trickGenerater = new TrickGenerater();
    /** テスト用特性ジェネレーター */
    private AbilityGenerater abilityGenerater = new AbilityGenerater();
    /** テスト用ポケモンジェネレーター */
    private PokemonGenerater pokemonGenerater = new PokemonGenerater();
    /** テスト用ストレージジェネレーター */
    private StorageGenerater storageGenerater = new StorageGenerater();

    /**
     * setUp
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        loginHelper.init();
        trickGenerater.run();
        abilityGenerater.run();
        pokemonGenerater.run();
        storageGenerater.run(loginHelper.getLoginInfo());
    }

    /**
     * 登録されているポケモン一覧取得
     * 
     * @throws Exception
     */
    @Test
    public void 登録されているポケモン一覧取得() throws Exception {
        tester.sessionScope("loginInfo", loginHelper.getLoginInfo());

        tester.start("/storage/list");
        assertThat(
            tester.response.getStatus(),
            is(equalTo(HttpServletResponse.SC_OK)));
        Map<String, Object> map =
            JsonUtil.toMap(tester.response.getOutputAsString());

        assertThat(
            map.get(JsonController.STATUS).toString(),
            is(JsonController.STATUS_OK));

        String storagesJson = map.get("storages").toString();
        assertThat(storagesJson, is(notNullValue()));

        Type storageViewListType = new TypeToken<List<StorageView>>() {
        }.getType();
        List<StorageView> storageViews =
            JsonUtil.createGson().fromJson(storagesJson, storageViewListType);
        assertThat(storageViews, is(notNullValue()));
        // TODO EntryControllerTestに全項目入力テストを作成したら、なぜか件数が増えた
        assertThat(storageViews.size(), is(storageGenerater.count()));
        StorageView ans = storageViews.get(0);
        // TODO 現状、keyはalocadkeyだが、変えた方が良いか？
        assertThat(ans.getKey(), is(notNullValue()));
        assertThat(ans.getVersion(), is(1L));
        assertThat(KeyFactory.stringToKey(ans.getMemberKey()), is(loginHelper
            .getMember()
            .getKey()));
        // TODO Box機能実装後は値が入るはずなので、その時に直す
        assertThat(ans.getBoxKey(), is(""));
        assertThat(
            KeyFactory.stringToKey(ans.getPokemonKey()),
            is(Pokemon.createKey(470, "リーフィア")));
        assertThat(ans.getPokemonName(), is("リーフィア"));
        assertThat(ans.getNickname(), is("フィア"));
        assertThat(ans.getPersonName(), is(PersonType.BRAT.getName()));
        assertThat(ans.getGenderName(), is(GenderType.MALE.getName()));
        final String ABILITY_NAME = "リーフガード";
        assertThat(ans.getAbilityKey(), is(notNullValue()));
        assertThat(ans.getAbilityName(), is(ABILITY_NAME));
        assertThat(ans.getIndividualUpperH(), is(1));
        assertThat(ans.getIndividualLowerH(), is(0));
        assertThat(ans.getIndividualUpperA(), is(6));
        assertThat(ans.getIndividualLowerA(), is(5));
        assertThat(ans.getIndividualUpperB(), is(31));
        assertThat(ans.getIndividualLowerB(), is(31));
        assertThat(ans.getIndividualUpperC(), is(15));
        assertThat(ans.getIndividualLowerC(), is(14));
        assertThat(ans.getIndividualUpperD(), is(23));
        assertThat(ans.getIndividualLowerD(), is(22));
        assertThat(ans.getIndividualUpperS(), is(27));
        assertThat(ans.getIndividualLowerS(), is(26));
        assertThat(ans.getEffortH(), is(0));
        assertThat(ans.getEffortA(), is(255));
        assertThat(ans.getEffortB(), is(255));
        assertThat(ans.getEffortC(), is(0));
        assertThat(ans.getEffortD(), is(0));
        assertThat(ans.getEffortS(), is(0));
        assertThat(ans.getLv50H(), is(125));
        assertThat(ans.getLv50A(), is(149));
        assertThat(ans.getLv50B(), is(200));
        assertThat(ans.getLv50C(), is(64));
        assertThat(ans.getLv50D(), is(81));
        assertThat(ans.getLv50S(), is(113));
        final String TRICK_NAME_1ST = "リーフブレード";
        assertThat(ans.getTrick1stName(), is(TRICK_NAME_1ST));
    }

}
