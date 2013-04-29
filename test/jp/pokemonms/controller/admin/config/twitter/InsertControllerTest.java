package jp.pokemonms.controller.admin.config.twitter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import jp.pokemonms.model.config.TwitterConfig;
import jp.pokemonms.service.ConfigService;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

/**
 * TwitterConfig登録テスト
 *
 * @author Sinmetal
 *
 */
public class InsertControllerTest extends ControllerTestCase {

    /**
     * 正常登録テスト
     *
     * @throws Exception
     */
    @Test
    public void 正常登録() throws Exception {
        tester.param("consumerKey", "hoge");
        tester.param("consumerSecret", "fuga");

        tester.start("/admin/config/twitter/insert");

        ConfigService service = new ConfigService();
        TwitterConfig config = service.getTwitterConfig();
        assertThat(config, is(notNullValue()));
        assertThat(config.getConsumerKey(), is("hoge"));
        assertThat(config.getConsumerSecret(), is("fuga"));

        InsertController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/admin/config/twitter/"));
    }
}
