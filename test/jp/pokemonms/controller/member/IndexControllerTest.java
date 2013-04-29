package jp.pokemonms.controller.member;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jp.pokemonms.exception.NotFoundRuntimeException;
import jp.pokemonms.tester.LoginHelper;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

/**
 * MemberIndexControllerTest
 * @author Sinmetal
 *
 */
public class IndexControllerTest extends ControllerTestCase {

    /**
     * 存在するメンバーを指定
     * @throws Exception
     */
    @Test
    public void 存在するメンバーを指定() throws Exception {
        LoginHelper loginHelper = new LoginHelper();
        loginHelper.init();
        long twitterId = loginHelper.TWITTER_ID;

        tester.param("twitterId", twitterId);
        tester.start("/member/");
        IndexController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/member/index.jsp"));
    }

    /**
     * 存在しないメンバーを指定
     * @throws Exception
     */
    @Test(expected = NotFoundRuntimeException.class)
    public void 存在しないメンバーを指定() throws Exception {
        tester.param("twitterId", "1");
        tester.start("/member/");
        IndexController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
    }
}
