package jp.pokemonms.helper;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.var.LoginInfo;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

/**
 * ログイン表示ヘルパーテスト
 * @author Sinmetal
 *
 */
public class LoginViewHelperTest extends AppEngineTestCase {

    /** LoginInfo */
    private LoginInfo loginInfo;

    /* (非 Javadoc)
     * @see org.slim3.tester.ControllerTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
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
        LoginViewHelper helper = LoginViewHelper.getInstance(loginInfo);
        assertThat(helper,is(notNullValue()));
    }

    /**
     * ログイン状態でのログイン者名表示
     *
     * @throws Exception
     */
    @Test
    public void ログイン状態でのログイン者名表示() throws Exception {
        LoginViewHelper helper = LoginViewHelper.getInstance(loginInfo);
        String ans = String.format("<a href=\"#\" class=\"menu\">%s</a>",
            StringEscapeUtils.escapeHtml4(new LoginHelper().TWITTER_SCREEN_NAME));
        assertThat(helper.getTopMenuViewName(), is(ans));
    }

    /**
     * 未ログイン状態でのログイン者名表示
     *
     * @throws Exception
     */
    @Test
    public void 未ログイン状態でのログイン者名表示() throws Exception {
        LoginViewHelper helper = LoginViewHelper.getInstance(null);
        String ans = "<a href=/authntication/>ログイン</a>";
        assertThat(helper.getTopMenuViewName(), is(ans));
    }
}
