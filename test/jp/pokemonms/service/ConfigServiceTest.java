package jp.pokemonms.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import jp.pokemonms.exception.ConfigRuntimeException;
import jp.pokemonms.model.config.TwitterConfig;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

/**
 * Config用サービステスト
 * @author Sinmetal
 *
 */
public class ConfigServiceTest extends AppEngineTestCase {

    private ConfigService service = new ConfigService();

    @Test
    public void test() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    @Test
    public void TwitterConfigMemcacheテスト() {
        service.setTwitterConfig("hoge", "fuga");
        TwitterConfig config = service.getTwitterConfig();
        assertThat(config.getConsumerKey(), is("hoge"));
        assertThat(config.getConsumerSecret(), is("fuga"));
    }

    @Test
    public void TwitterConfig後勝ちテスト() {
        service.setTwitterConfig("hoge", "fuga");
        TwitterConfig config = service.getTwitterConfig();
        assertThat(config.getConsumerKey(), is("hoge"));
        assertThat(config.getConsumerSecret(), is("fuga"));

        service.setTwitterConfig("hoge2", "fuga2");
        config = service.getTwitterConfig();
        assertThat(config.getConsumerKey(), is("hoge2"));
        assertThat(config.getConsumerSecret(), is("fuga2"));
    }

    @Test(expected = ConfigRuntimeException.class)
    public void TwitterConfig取得失敗例外テスト() {
        TwitterConfig config = service.getTwitterConfig();
        assertThat(config, is(nullValue()));
    }
}
