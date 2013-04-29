package jp.pokemonms.controller.authentication;

import jp.pokemonms.tester.LoginHelper;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * AuthenticationLogoutControllerTest
 * @author Sinmetal
 *
 */
public class LogoutControllerTest extends ControllerTestCase {

    @SuppressWarnings("unused")
    private LoginHelper loginHelper;

    /* (非 Javadoc)
     * @see org.slim3.tester.ControllerTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    /**
     * ログアウト
     * @throws Exception
     */
    @Test
    public void ログアウト() throws Exception {
        loginHelper = new LoginHelper();
        tester.start("/authentication/logout");
        LogoutController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/"));
        assertThat(tester.sessionScope("loginInfo"), is(nullValue()));
    }
}
