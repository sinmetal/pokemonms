package jp.pokemonms.validator;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slim3.controller.validator.Validators;

/**
 * カスタムバリデーター
 * @author Sinmetal
 *
 */
public class ExtValidators extends Validators {

    public ExtValidators(HttpServletRequest request) {
        super(request);
    }

    public ExtValidators(Map<String, Object> parameters) {
        super(parameters);
    }

    /**
     * ポケモン存在チェック
     * @return
     */
    public PokemonExistsValidator existsPokemon() {
        return new PokemonExistsValidator();
    }

    /**
     * せいかく存在チェック
     * @return
     */
    public PersonExistsValidator existsPerson() {
        return new PersonExistsValidator();
    }

}
