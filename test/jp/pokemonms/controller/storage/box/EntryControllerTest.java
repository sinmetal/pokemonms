package jp.pokemonms.controller.storage.box;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jp.pokemonms.meta.MemberMeta;
import jp.pokemonms.meta.json.storage.box.RookieBoxMeta;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.constant.PublishLvType;
import jp.pokemonms.model.json.storage.box.RookieBox;
import jp.pokemonms.tester.ControllerTestCase4HRD;
import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.var.LoginInfo;

import org.junit.Before;
import org.junit.Test;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;

/**
 * StorageBoxEntryControllerTest
 * 
 * @author sinmetal
 */
public class EntryControllerTest extends ControllerTestCase4HRD {

    /** テスト用ログインヘルパー */
    private LoginHelper loginHelper = new LoginHelper();
    
    /**
     * テスト前設定
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        loginHelper.init();
    }
    
    /**
     * 全部入力して登録できることをテスト
     * 
     * @throws Exception
     */
    @Test
    public void 全部入力して登録できることをテスト() throws Exception {
        final String TEST_BOX_NAME = "てすと";
        final LoginInfo loginInfo = loginHelper.getLoginInfo();        
        
        tester.sessionScope("loginInfo", loginInfo);
        tester.requestScope("name", TEST_BOX_NAME);
        tester.requestScope("publishLvType", "1");
        
        tester.start("/storage/box/entry");
        EntryController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.response.getStatus(), is(HttpServletResponse.SC_OK));
        
        Member member = Datastore.get(MemberMeta.get(), loginInfo.getMemberKey());
        List<Key> boxKeys = member.getBoxKeys();
        assertThat(boxKeys, is(notNullValue()));
        assertThat(boxKeys.size(), is(1));
        assertThat(RookieBox.keyToName(boxKeys.get(0)), is(TEST_BOX_NAME));
        
        final RookieBox rookieBox = Datastore.get(RookieBoxMeta.get(), boxKeys.get(0));
        assertThat(rookieBox.getName(), is(TEST_BOX_NAME));
        assertThat(rookieBox.getPublishLvType(), is(PublishLvType.ME));
    }
}
