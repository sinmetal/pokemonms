package jp.pokemonms.controller.admin.member;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class InsertControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.param("twitterId", "1");
        tester.param("twitterName", "sinmetal");
        tester.param("twitterScreenName", "真");
        tester.param("twitterToken", "1");
        tester.param("twitterTokenSecret", "1");
        tester.param("twitterProfileImageUrl", "http://a2.twimg.com/profile_images/1042264867/1277990403846_bigger.png");
        tester.param("friendCode", "3997 2016 5307");
        tester.param("activeTime","");
        tester.start("/admin/member/insert");
        InsertController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/admin/member/"));
    }
}
