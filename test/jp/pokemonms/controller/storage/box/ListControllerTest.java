package jp.pokemonms.controller.storage.box;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.form.storage.BoxForm;
import jp.pokemonms.meta.MemberMeta;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.json.storage.box.RookieBox;
import jp.pokemonms.service.RookieBoxService;
import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.util.JsonUtil;
import jp.pokemonms.var.LoginInfo;

import org.junit.Before;
import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.ControllerTestCase;

import com.google.appengine.api.datastore.Key;
import com.google.gson.reflect.TypeToken;

/**
 * BoxListControllerTest
 * 
 * @author sinmetal
 * 
 */
public class ListControllerTest extends ControllerTestCase {

    /** テスト用ログインヘルパー */
    private LoginHelper loginHelper = new LoginHelper();

    /** 育成前ポケモンBoxService */
    private final RookieBoxService rookieBoxService = new RookieBoxService();

    @Before
    public void setUp() throws Exception {
        super.setUp();
        loginHelper.init();
    }

    /**
     * ログイン中のユーザのBox一覧が取得できることをテスト
     * 
     * @throws Exception
     */
    @Test
    public void ログイン中のユーザのBox一覧が取得できることをテスト() throws Exception {
        final String TEST_BOX_NAME = "てすと";
        final LoginInfo loginInfo = loginHelper.getLoginInfo();
        final BoxForm boxForm = new BoxForm();
        boxForm.setName(TEST_BOX_NAME);
        final RookieBox box =
            RookieBox.getInstance(loginInfo.getMemberKey(), boxForm);
        final Key rookieBoxKey = rookieBoxService.put(box);
        assertThat(rookieBoxKey, is(notNullValue()));

        final Member member =
            Datastore.get(MemberMeta.get(), loginInfo.getMemberKey());
        member.addBoxKey(rookieBoxKey);
        Datastore.put(member);
        
        tester.sessionScope("loginInfo", loginInfo);
        tester.start("/storage/box/list");
        ListController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.response.getStatus(), is(HttpServletResponse.SC_OK));

        Map<String, Object> map =
            JsonUtil.toMap(tester.response.getOutputAsString());
        assertThat(
            map.get(JsonController.STATUS).toString(),
            is(JsonController.STATUS_OK));
        final String rookieBoxesJson = map.get("rookieBoxes").toString();
        assertThat(rookieBoxesJson, is(notNullValue()));

        Type rookieBoxsType = new TypeToken<List<RookieBox>>() {
        }.getType();
        List<RookieBox> boxes =
            JsonUtil.createGson().fromJson(rookieBoxesJson, rookieBoxsType);
        assertThat(boxes.size(), is(1));
        final RookieBox storedEntity = boxes.get(0);
        assertThat(storedEntity.getName(), is(TEST_BOX_NAME));
    }
}
