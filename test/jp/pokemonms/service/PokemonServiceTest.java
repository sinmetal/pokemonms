package jp.pokemonms.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jp.pokemonms.model.Pokemon;
import jp.pokemonms.tester.generater.PokemonGenerater;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

/**
 * ポケモン図鑑サービステスト
 *
 * @author Sinmetal
 *
 */
public class PokemonServiceTest extends AppEngineTestCase {

    private PokemonService service = new PokemonService();

    private PokemonGenerater pokemonGenerater = new PokemonGenerater();

    /*
     * (非 Javadoc)
     *
     * @see org.slim3.tester.AppEngineTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        pokemonGenerater.run();
    }

    /**
     * インスタンス生成
     *
     * @throws Exception
     */
    @Test
    public void インスタンス生成() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    /**
     * 図鑑取得正常
     */
    @Test
    public void 図鑑取得正常() {
        final String pokemonName = "フシギダネ";

        Pokemon store = service.getByPokemonName(pokemonName);
        assertTrue("図鑑", store.getPokemonName().equals(pokemonName));
    }

    /**
     * 存在しないポケモンを指定した場合はnull
     */
    @Test
    public void 存在しないポケモンを指定した場合はnull() {
        final String pokemonName = "そんな子いないよ";

        Pokemon store = service.getByPokemonName(pokemonName);
        assertTrue("図鑑", store == null);
    }

    /**
     * 全ポケモン図鑑数を取得
     *
     * @throws Exception
     */
    @Test
    public void 全ポケモン図鑑数を取得() throws Exception {
        assertThat(service.count(), is(pokemonGenerater.count()));
    }
}
