package jp.pokemonms.controller.admin.pokemon;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class DeleteControllerTest extends ControllerTestCase {

    @Test
    public void run() throws Exception {
        tester.start("/admin/pokemon/delete");
        DeleteController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/admin/pokemon/"));
    }
}
