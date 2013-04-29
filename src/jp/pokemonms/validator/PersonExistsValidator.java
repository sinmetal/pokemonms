package jp.pokemonms.validator;

import java.util.Map;

import jp.pokemonms.model.constant.PersonType;

import org.slim3.controller.validator.AbstractValidator;
import org.slim3.util.ApplicationMessage;

/**
 * 存在するせいかくであるかをチェック
 * @author Sinmetal
 *
 */
public class PersonExistsValidator  extends AbstractValidator  {

    /**
     * Constructor.
     */
    public PersonExistsValidator() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param message
     *          the error message
     */
    public PersonExistsValidator(String message) {
        super(message);
    }

    public String validate(Map<String, Object> parameters, String name) {
        Object value = parameters.get(name);
        if (value == null || "".equals(value)) {
            return null;
        }

        if (PersonType.parseOrNull(value.toString()) != null) {
            return null;
        }
        return ApplicationMessage.get(
            getMessageKey(),
            getLabel(name),
            value);
    }

    @Override
    protected String getMessageKey() {
        return "validator.personExists";
    }

}
