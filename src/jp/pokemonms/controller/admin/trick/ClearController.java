package jp.pokemonms.controller.admin.trick;

import jp.pokemonms.service.AdminService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * AdminTrickClearController
 *
 * @author Sinmetal
 *
 */
public class ClearController extends Controller {

    private AdminService service = new AdminService();

    /**
     * 技データを全て削除
     */
    @Override
    public Navigation run() throws Exception {
        service.clearTrick();
        return redirect(basePath);
    }
}
