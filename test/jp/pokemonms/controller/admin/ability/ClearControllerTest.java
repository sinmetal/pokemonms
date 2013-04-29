package jp.pokemonms.controller.admin.ability;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * AdminAbilityClearController
 * @author Sinmetal
 *
 */
public class ClearControllerTest extends ControllerTestCase {

    /**
     * 全特性削除
     *
     * @throws Exception
     */
    @Test
    public void 全特性削除() throws Exception {
        tester.start("/admin/ability/clear");
        ClearController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/admin/ability/"));
    }
}
