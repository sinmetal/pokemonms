package jp.pokemonms.controller.storage;

import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.form.IndividualForm;
import jp.pokemonms.logic.pokemon.Individual;
import jp.pokemonms.model.Pokemon;
import jp.pokemonms.service.PokemonService;
import jp.pokemonms.validator.ExtValidators;

import org.slim3.util.RequestMap;

/**
 * 個体値計算コントローラ
 * 
 * @author Sinmetal
 * 
 */
public class IndividualController extends JsonController {

    /** ポケモン図鑑サービス */
    private PokemonService pokemonService = new PokemonService();

    /**
     * 個体値計算
     */
    @Override
    protected Map<String, Object> handle() throws Exception {
        Map<String, Object> ret = new HashMap<String, Object>();
        RequestMap requestMap = new RequestMap(request);
        ExtValidators v = createValidators(requestMap);
        if (!v.validate()) {
            ret.put(STATUS, STATUS_NG);
            ret.put("error", v.getErrors());
            return ret;
        }

        IndividualForm form = IndividualForm.getInstance(requestMap);
        Pokemon pokemon =
            pokemonService.getByPokemonName(form.getPokemonName());
        Individual individual = Individual.getInstance(form, pokemon);
        ret.put("individual", individual.getIndividual().asMap());
        return ret;
    }

    /**
     * Validators作成
     * 
     * @param request
     * @return
     */
    protected ExtValidators createValidators(RequestMap requestMap) {
        ExtValidators v = new ExtValidators(requestMap);
        v.add("pokemonName", v.required(), v.existsPokemon());
        v.add("personName", v.required(), v.existsPerson());
        v.add("lv50H", v.integerType());
        v.add("", v.regexp("^([0-9]{0,3})-?([0-9]{0,3})$"));
        return v;
    }
}
