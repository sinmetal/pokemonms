package jp.pokemonms.controller.authentication;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Map;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.util.JsonUtil;
import jp.pokemonms.var.LoginInfo;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

/**
 * AuthenticationLoginInfoControllerTest
 *
 * @author Sinmetal
 *
 */
public class LoginInfoControllerTest extends ControllerTestCase {

    private LoginHelper loginHelper;

    /**
     * ログイン者の情報を取得
     *
     * @throws Exception
     */
    @Test
    public void ログイン者の情報を取得() throws Exception {
        loginHelper = new LoginHelper();
        loginHelper.init();
        tester.sessionScope(loginHelper.LOGIN_INFO, loginHelper.getLoginInfo());
        tester.start("/authentication/loginInfo");
        LoginInfoController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));

        String responseString = tester.response.getOutputAsString();
        assertTrue(responseString.length() > 0);

        Map<String, Object> jsonMap = JsonUtil.toMap(responseString);
        String status = jsonMap.get(JsonController.STATUS).toString();
        assertThat(status, is(JsonController.STATUS_OK));

        String loginInfoJson = JsonUtil.toJson(jsonMap.get("loginInfo"));
        LoginInfo loginInfo = JsonUtil.fromJson(loginInfoJson, LoginInfo.class);
        assertThat(loginInfo.getTwitterId(), is(loginHelper.TWITTER_ID));
    }
}
