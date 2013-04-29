package jp.pokemonms.controller.admin.pokemon;

import jp.pokemonms.service.PokemonService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * AdminPokemonDeleteController
 * 
 * @author sinmetal
 * 
 */
public class DeleteController extends Controller {

    private PokemonService pokemonService = new PokemonService();
    
    /**
     * ポケモン図鑑マスタデータ全削除 <br>
     * 完全に削除するため、マスタデータを全入れ替えする時しか、使うべきではない
     */
    @Override
    public Navigation run() throws Exception {
        pokemonService.deleteAll();
        return redirect(basePath);
    }
}
