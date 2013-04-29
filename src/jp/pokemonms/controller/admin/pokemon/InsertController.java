package jp.pokemonms.controller.admin.pokemon;

import java.util.List;

import jp.pokemonms.form.PokemonForm;
import jp.pokemonms.service.AdminService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

/**
 * 管理用ポケモン図鑑登録Controller
 * @author Sinmetal
 *
 */
public class InsertController extends Controller {

    private AdminService adminService = new AdminService();

    /**
     * ポケモン図鑑登録
     *
     */
    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        List<PokemonForm> forms = PokemonForm.getInstances(requestMap.get("pokemonData").toString());
        adminService.insertBatch4Pokemon(forms);
        return redirect(basePath);
    }
}
