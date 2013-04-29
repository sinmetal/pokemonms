package jp.pokemonms.controller.admin.trick;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * AdminTrickClearTestController
 * @author Sinmetal
 *
 */
public class ClearControllerTest extends ControllerTestCase {

    /**
     * 全削除
     * @throws Exception
     */
    @Test
    public void 全削除() throws Exception {
        tester.start("/admin/trick/clear");
        ClearController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/admin/trick/"));
    }
}
