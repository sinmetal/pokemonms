package jp.pokemonms.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.pokemonms.form.StorageForm;
import jp.pokemonms.model.Storage;
import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.tester.StorageRequestGenerater;
import jp.pokemonms.tester.generater.PokemonGenerater;
import jp.pokemonms.tester.generater.TrickGenerater;
import jp.pokemonms.var.LoginInfo;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

/**
 * ストレージサービステスト
 *
 * @author Sinmetal
 *
 */
public class StorageServiceTest extends AppEngineTestCase {

    private StorageService service = new StorageService();

    private PokemonGenerater pokemonGenerater = new PokemonGenerater();

    private TrickGenerater trickGenerater = new TrickGenerater();

    private StorageRequestGenerater storageRequestGenerater =
        new StorageRequestGenerater();

    /** ログイン情報 */
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
     * TwitterIDからストレージを探す
     */
    @Test
    public void findByTwitterId() {
        Map<String, Object> input =
            storageRequestGenerater.getInsertCompleteRequest();

        StorageForm form = StorageForm.getInstance(input);
        new StorageFacadeService()
            .insertStorage(form, loginInfo.getTwitterId());

        List<Storage> storages =
            service.findByTwitterId(loginInfo.getTwitterId());
        assertThat(storages.size(), is(1));
    }

    @Test
    public void insert() {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("pokemonName", "フシギダネ");
        input.put("nickname", "ふしぎだね");
        input.put("attribute", "1");
        input.put("personName", "さみしがり");
        input.put("individuaH", "1");
        input.put("individuaA", "1");
        input.put("individuaB", "1");
        input.put("individuaC", "1");
        input.put("individuaD", "1");
        input.put("individuaS", "1");
        input.put("effortH", "1");
        input.put("effortA", "1");
        input.put("effortB", "1");
        input.put("effortC", "1");
        input.put("effortD", "1");
        input.put("effortS", "1");
        input.put("lv50H", "1");
        input.put("lv50A", "1");
        input.put("lv50B", "1");
        input.put("lv50C", "1");
        input.put("lv50D", "1");
        input.put("lv50S", "1");
        input.put("trick1st", "1");
        input.put("trick2nd", "2");
        input.put("trick3rd", "3");
        input.put("trick4th", "4");
        input.put("awakenPowerType", "1");
        input.put("awakenPowerEdge", "10");
        input.put("remark", "びこう");

        StorageForm form = StorageForm.getInstance(input);
        Storage storage = service.insert(Storage.getInstance(form));
        assertThat(storage, is(notNullValue()));
    }
}
