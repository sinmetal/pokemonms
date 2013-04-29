package jp.pokemonms.controller.admin.pokemon;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import jp.pokemonms.controller.admin.pokemon.InsertController;
import jp.pokemonms.tester.generater.AbilityGenerater;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

/**
 * AdminPokemonInsertControllerTest
 * @author Sinmetal
 *
 */
public class InsertControllerTest extends ControllerTestCase {

    /**
     * ポケモン図鑑データ登録
     *
     * @throws Exception
     */
    @Test
    public void ポケモン図鑑データ登録() throws Exception {
        AbilityGenerater abilityGenerater = new AbilityGenerater();
        abilityGenerater.run();

        final String DRUDDIGON =
            "621,クリムガン,ドラゴン,,77,120,90,60,90,48,ドラゴン,かいじゅう,さめはだ,ちからずく,*かたやぶり";

        tester.param("pokemonData", DRUDDIGON);
        tester.start("/admin/pokemon/insert");
        InsertController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(true));
        assertThat(tester.getDestinationPath(), is("/admin/pokemon/"));
    }
}
