package jp.pokemonms.twitter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import jp.pokemonms.service.ConfigService;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

public class Twitter4pkmsFactoryTest extends AppEngineTestCase {

    Twitter4pkmsFactory factory = new Twitter4pkmsFactory();

    @Test
    public void getInstance() {
        ConfigService service = new ConfigService();
        service.setTwitterConfig("hoge", "fuga");

        Twitter4pkms twitter = factory.getInstance();
        assertThat(twitter, is(notNullValue()));
    }
}
