package jp.pokemonms.controller.admin.member;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    @Override
    public Navigation run() throws Exception {
        return forward("/admin/member/index.jsp");
    }
}
