package jp.pokemonms.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import jp.pokemonms.form.storage.BoxForm;
import jp.pokemonms.meta.MemberMeta;
import jp.pokemonms.meta.json.storage.box.RookieBoxMeta;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.json.storage.box.RookieBox;
import jp.pokemonms.tester.AppEngineTestCase4HRD;
import jp.pokemonms.tester.LoginHelper;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

/**
 * ボックス用サービステスト
 * 
 * @author Sinmetal
 * 
 */
public class BoxServiceTest extends AppEngineTestCase4HRD {

    /** loginHelper */
    private LoginHelper loginHelper = new LoginHelper();

    /** BoxService */
    private BoxService service = new BoxService();

    /**
     * テスト前設定
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        loginHelper.init();
    }

    /**
     * 育成前ポケモン登録確認
     * 
     * @throws Exception
     */
    @Test
    public void 育成前ポケモン登録確認() throws Exception {
        final Key loginMemberKey = loginHelper.getLoginInfo().getMemberKey();
        final BoxForm testForm = new BoxForm();
        final String TEST_BOX_NAME = "テスト";
        testForm.setName(TEST_BOX_NAME);

        final Pair<Key, Key> memberKeyWithRookieBoxKey =
            service.put4RookieBox(loginMemberKey, testForm);
        final RookieBox rookieBox =
            Datastore.get(
                RookieBoxMeta.get(),
                memberKeyWithRookieBoxKey.getRight());
        assertThat(rookieBox, is(notNullValue()));

        final Member storedMember =
            Datastore.get(MemberMeta.get(), loginMemberKey);
        final List<Key> boxKeys = storedMember.getBoxKeys();
        assertThat(boxKeys.size(), is(1));
    }
}
