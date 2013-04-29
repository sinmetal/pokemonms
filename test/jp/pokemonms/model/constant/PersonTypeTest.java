package jp.pokemonms.model.constant;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

public class PersonTypeTest extends AppEngineTestCase {

    @Test
    public void perse() {
        assertTrue(PersonType.DEMURE.equals(PersonType.parse("ひかえめ")));
    }
}
