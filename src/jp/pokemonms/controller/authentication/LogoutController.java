package jp.pokemonms.controller.authentication;

import jp.pokemonms.controller.AbstractController;

import org.slim3.controller.Navigation;

/**
 * AuthenticationLogoutController
 * @author Sinmetal
 *
 */
public class LogoutController extends AbstractController {

    /**
     * ログアウトを行う
     */
    @Override
    public Navigation run() throws Exception {
        logout();
        return redirect("/");
    }
}
