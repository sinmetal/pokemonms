package jp.pokemonms.controller.admin.ability;

import java.util.List;

import jp.pokemonms.model.Ability;
import jp.pokemonms.service.AbilityService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * AdminAbilityIndexController
 * @author Sinmetal
 *
 */
public class IndexController extends Controller {

    private AbilityService abilityService = new AbilityService();

    @Override
    public Navigation run() throws Exception {
        List<Ability> abilitys = abilityService.findAll();
        requestScope("abilitys", abilitys);
        return forward("/admin/ability/index.jsp");
    }
}
