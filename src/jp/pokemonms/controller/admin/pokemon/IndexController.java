package jp.pokemonms.controller.admin.pokemon;

import java.util.List;

import jp.pokemonms.model.Pokemon;
import jp.pokemonms.service.PokemonService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * ポケモン図鑑管理IndexController
 * @author Sinmetal
 *
 */
public class IndexController extends Controller {

    /** ポケモン図鑑サービス */
    private PokemonService pokemonService = new PokemonService();

    @Override
    public Navigation run() throws Exception {
        List<Pokemon> pokemons = pokemonService.findAll();
        requestScope("pokemons", pokemons);
        return forward("/admin/pokemon/index.jsp");
    }
}
