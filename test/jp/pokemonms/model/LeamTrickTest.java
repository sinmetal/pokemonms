package jp.pokemonms.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LeamTrickTest extends AppEngineTestCase {

    private LeamTrick model = new LeamTrick();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
