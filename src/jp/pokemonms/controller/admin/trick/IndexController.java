package jp.pokemonms.controller.admin.trick;

import java.util.List;

import jp.pokemonms.model.Trick;
import jp.pokemonms.service.TrickService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private TrickService trickService = new TrickService();

    @Override
    public Navigation run() throws Exception {
        List<Trick> tricks = trickService.findAll();
        requestScope("tricks", tricks);
        return forward("/admin/trick/index.jsp");
    }
}
