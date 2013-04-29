package jp.pokemonms.validator;

import java.util.Map;

import jp.pokemonms.service.PokemonService;

import org.slim3.controller.validator.AbstractValidator;
import org.slim3.util.ApplicationMessage;

/**
 * ポケモン図鑑に登録されているポケモンであるかをチェック
 *
 * @author Sinmetal
 *
 */
public class PokemonExistsValidator extends AbstractValidator {

    protected PokemonService service = new PokemonService();

    /**
     * Constructor.
     */
    public PokemonExistsValidator() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param message
     *          the error message
     */
    public PokemonExistsValidator(String message) {
        super(message);
    }

    public String validate(Map<String, Object> parameters, String name) {
        Object value = parameters.get(name);
        if (value == null || "".equals(value)) {
            return null;
        }

        if (service.existsPokemon(value.toString())) {
            return null;
        }
        return ApplicationMessage.get(
            getMessageKey(),
            getLabel(name),
            value);
    }

    @Override
    protected String getMessageKey() {
        return "validator.pokemonExists";
    }

}
