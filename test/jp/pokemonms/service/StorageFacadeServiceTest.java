package jp.pokemonms.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import jp.pokemonms.form.StorageForm;
import jp.pokemonms.model.Storage;
import jp.pokemonms.model.constant.ElementType;
import jp.pokemonms.model.constant.GenderType;
import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.tester.StorageRequestGenerater;
import jp.pokemonms.tester.generater.AbilityGenerater;
import jp.pokemonms.tester.generater.PokemonGenerater;
import jp.pokemonms.tester.generater.TrickGenerater;
import jp.pokemonms.util.IndividualUtil;
import jp.pokemonms.var.LoginInfo;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

/**
 * ストレージファサードサービステスト
 *
 * @author Sinmetal
 *
 */
public class StorageFacadeServiceTest extends AppEngineTestCase {

    private StorageFacadeService service = new StorageFacadeService();

    private PokemonGenerater pokemonGenerater = new PokemonGenerater();;

    private AbilityGenerater abilityGenerater = new AbilityGenerater();

    private TrickGenerater trickGenerater = new TrickGenerater();

    private StorageRequestGenerater requestGenerater =
        new StorageRequestGenerater();

    private LoginInfo loginInfo;

    /*
     * (非 Javadoc)
     *
     * @see org.slim3.tester.AppEngineTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        pokemonGenerater.run();
        abilityGenerater.run();
        trickGenerater.run();
        LoginHelper loginHelper = new LoginHelper();
        loginHelper.init();
        loginInfo = loginHelper.getLoginInfo();
    }

    /**
     * インスタンス生成
     *
     * @throws Exception
     */
    @Test
    public void インスタンス生成() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    /**
     * 全入力項目設定時の正常登録
     *
     * @throws Exception
     */
    @Test
    public void 全入力項目設定時の正常登録() throws Exception {
        Map<String, Object> completeRequest =
            requestGenerater.getInsertCompleteRequest();
        StorageForm form = StorageForm.getInstance(completeRequest);
        Storage storage = service.insertStorage(form, loginInfo.getTwitterId());

        assertTrue("pokemonName", "フシギダネ".equals(storage.getPokemonName()));
        assertTrue("nickName", "フッシー".equals(storage.getNickname()));
        assertTrue("gender", GenderType.MALE.equals(storage.getGender()));
        assertTrue("ability", "ようりょくそ".equals(storage.getAbilityName()));
        assertTrue("individualHUpper", 31 == storage.getIndividualUpperH());
        assertTrue("individualAUpper", 15 == storage.getIndividualUpperA());
        assertTrue("individualBUpper", 30 == storage.getIndividualUpperB());
        assertTrue("individualCUpper", 31 == storage.getIndividualUpperC());
        assertThat(
            storage.getIndividualUpperD(),
            is(IndividualUtil.UNKNOWN_DATA));
        assertTrue("individualSUpper", 27 == storage.getIndividualUpperS());
        assertTrue("individualHLower", 31 == storage.getIndividualLowerH());
        assertTrue("individualALower", 0 == storage.getIndividualLowerA());
        assertThat(
            storage.getIndividualLowerB(),
            is(IndividualUtil.UNKNOWN_DATA));
        assertTrue("individualCLower", 31 == storage.getIndividualLowerC());
        assertTrue("individualDLower", 28 == storage.getIndividualLowerD());
        assertTrue("individualSLower", 27 == storage.getIndividualLowerS());

        assertThat(storage.getTrick1stName(), is("たいあたり"));
        assertThat(storage.getTrick2ndName(), is("つるのムチ"));
        assertThat(storage.getTrick3rdName(), is("ソーラービーム"));
        assertThat(storage.getTrick4thName(), is("なきごえ"));

        assertTrue("awakenPowerElement", ElementType.FIRE.equals(storage
            .getAwakenPowerElement()));
        assertTrue("awakenPowerEdge", 69 == storage.getAwakenPowerEdge());
        assertTrue("remark", "かがくのちからってすげー".equals(storage.getRemark()));

        List<Storage> storages = service.getStorages(loginInfo.getTwitterId());
        assertTrue("storagesCount", storages.size() > 0);
    }

    /**
     * 最小入力項目設定時の正常登録
     *
     * @throws Exception
     */
    @Test
    public void 最小入力項目設定時の正常登録() throws Exception {
        Map<String, Object> imperfectionRequest =
            requestGenerater.getInsertImperfectionRequest();
        StorageForm form = StorageForm.getInstance(imperfectionRequest);
        Storage storage = service.insertStorage(form, loginInfo.getTwitterId());

        assertTrue("pokemonName", "フシギダネ".equals(storage.getPokemonName()));
    }
}
