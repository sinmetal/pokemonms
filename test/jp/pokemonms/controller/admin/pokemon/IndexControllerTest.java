package jp.pokemonms.controller.admin.pokemon;

import jp.pokemonms.controller.admin.pokemon.IndexController;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * 管理用ポケモン図鑑IndexControllerTest
 * @author Sinmetal
 *
 */
public class IndexControllerTest extends ControllerTestCase {

    /**
     * ポケモン図鑑一覧表示テスト
     *
     * @throws Exception
     */
    @Test
    public void ポケモン図鑑一覧表示テスト() throws Exception {
        tester.start("/admin/pokemon/");
        IndexController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/admin/pokemon/index.jsp"));
    }
}
