package jp.pokemonms.service;

import jp.pokemonms.form.storage.BoxForm;
import jp.pokemonms.meta.json.storage.box.RookieBoxMeta;
import jp.pokemonms.model.json.storage.box.RookieBox;
import jp.pokemonms.tester.LoginHelper;

import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.junit.Before;
import org.junit.Test;

import com.google.appengine.api.datastore.Key;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * 育成前ポケモンBoxサービステスト
 * @author sinmetal
 *
 */
public class RookieBoxServiceTest extends AppEngineTestCase {

    private RookieBoxService service = new RookieBoxService();

    /**
     * Datasotreへの登録テスト
     * @author sinmetal
     *
     */
    public static class Datastoreへの登録テスト extends AppEngineTestCase {
    
        private LoginHelper loginHelper;
        
        @Before
        public void setUp() throws Exception {
            super.setUp();
            loginHelper = new LoginHelper();
            loginHelper.init();
        }
        
        /**
         * putできることを確認
         */
        @Test
        public void putできることを確認() {
            final Key testMemberKey = loginHelper.getMember().getKey();
            final String testBoxName = "エリート";
            final BoxForm boxForm = new BoxForm();
            boxForm.setName(testBoxName);
            final RookieBox testInstance = 
                    RookieBox.getInstance(testMemberKey, boxForm);
            Key storeKey = Datastore.put(testInstance);
            RookieBox store = Datastore.get(RookieBoxMeta.get(), storeKey);
            assertThat(store.getKey(), is(testInstance.getKey()));
        }
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
}
