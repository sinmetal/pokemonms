package jp.pokemonms.controller.admin.config.twitter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import jp.pokemonms.service.ConfigService;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

/**
 * AdminTwitterConfigIndexControllerTest
 * @author Sinmetal
 *
 */
public class IndexControllerTest extends ControllerTestCase {

    @Test
    public void 正常系() throws Exception {
        ConfigService service = new ConfigService();
        service.setTwitterConfig("hoge", "huga");

        tester.start("/admin/config/twitter/");
        IndexController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/admin/config/twitter/index.jsp"));
    }

    @Test
    public void TwitterConfig無し() throws Exception {
        tester.start("/admin/config/twitter/");
        IndexController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/admin/config/twitter/index.jsp"));
    }
}
