package jp.pokemonms.controller.admin.ability;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * AdminAbilityInsertControllerTest
 * @author Sinmetal
 *
 */
public class InsertControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.param("abilityData", "しんりょく");
        tester.start("/admin/ability/insert");
        InsertController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/admin/ability/"));
    }
}
