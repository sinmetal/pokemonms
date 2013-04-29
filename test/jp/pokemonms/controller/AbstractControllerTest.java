package jp.pokemonms.controller;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.var.LoginInfo;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

/**
 * ベースコントローラテスト
 * @author Sinmetal
 *
 */
public class AbstractControllerTest extends ControllerTestCase {

    /** loginHelper */
    private LoginHelper loginHelper;

    /* (非 Javadoc)
     * @see org.slim3.tester.ControllerTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        loginHelper = new LoginHelper();
    }

    /**
     * Sessionログイン情報テスト
     *
     * @throws Exception
     */
    @Test
    public void Sessionログイン情報テスト() throws Exception {
        tester.start("/");
        LoginInfo loginInfo = tester.sessionScope(loginHelper.LOGIN_INFO);
        assertThat(loginInfo, is(nullValue()));
    }
}
