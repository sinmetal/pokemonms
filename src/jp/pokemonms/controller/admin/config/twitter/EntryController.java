package jp.pokemonms.controller.admin.config.twitter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * TwitterConfig登録画面表示コントローラ
 *
 * @author Sinmetal
 *
 */
public class EntryController extends Controller {

    /**
     * 登録画面表示
     *
     */
    @Override
    public Navigation run() throws Exception {
        return forward("/admin/config/twitter/entry.jsp");
    }
}
