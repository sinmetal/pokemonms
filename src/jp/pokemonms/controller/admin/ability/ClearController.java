package jp.pokemonms.controller.admin.ability;

import jp.pokemonms.service.AdminService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * AdminAbilityClearController
 * @author Sinmetal
 *
 */
public class ClearController extends Controller {

    private AdminService service = new AdminService();

    /**
     * 全特性データ削除
     */
    @Override
    public Navigation run() throws Exception {
        service.clearAbility();
        return redirect(basePath);
    }
}
