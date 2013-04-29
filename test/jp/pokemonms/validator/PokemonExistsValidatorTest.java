package jp.pokemonms.validator;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Locale;
import java.util.Map;

import jp.pokemonms.tester.generater.PokemonGenerater;

import org.junit.Before;
import org.junit.Test;
import org.slim3.controller.ControllerConstants;
import org.slim3.tester.AppEngineTestCase;
import org.slim3.util.ApplicationMessage;
import org.slim3.util.ArrayMap;

/**
 * ポケモン図鑑存在チェックテスト
 * @author Sinmetal
 *
 */
public class PokemonExistsValidatorTest extends AppEngineTestCase {

    /** Domのinputのname */
    private final String key = "pokemonName";

    private PokemonExistsValidator validator = new PokemonExistsValidator();

    private PokemonGenerater pokemonGenerater = new PokemonGenerater();

    /**
     * setUp()
     */
    @Override
    public void setUp() throws Exception{
        super.setUp();
        pokemonGenerater.run();
    }

    /**
     * before()
     */
    @Before
    public void before() {
        //ロケールを先に指定しなければ、<project>/src/application[_locale].properties が見つからない
        ApplicationMessage.setBundle(
            ControllerConstants.DEFAULT_LOCALIZATION_CONTEXT,
            new Locale("ja"));
    }

    /**
     * 図鑑に存在しているポケモンはOK()
     */
    @Test
    public void 図鑑に存在しているポケモンはOK() {
        final String pokemonName = "リーフィア";

        String message = validate(pokemonName);
        assertThat(message, is(nullValue()));
    }

    /**
     * 図鑑に存在しないポケモンはエラー()
     */
    @Test
    public void 図鑑に存在しないポケモンはエラー() {
        final String pokemonName = "ずかんにいないよ";

        String message = validate(pokemonName);
        assertThat(message, is("ポケモンは図鑑に登録されていません。"));
    }

    /**
     * 値がnullの場合は無視する
     */
    @Test
    public void 値が空の場合は無視する() {
        final String pokemonName = null;

        String message = validate(pokemonName);
        assertThat(message, is(nullValue()));
    }

    /**
     * 値が空文字の場合は無視する
     */
    @Test
    public void 値が空文字の場合は無視する() {
        final String pokemonName = "";

        String message = validate(pokemonName);
        assertThat(message, is(nullValue()));
    }

    /**
     * validate 実行
     *
     * @param value
     * @return
     */
    private String validate(String value) {
        Map<String, Object> request = new ArrayMap<String, Object>();
        request.put(key, value);

        return validator.validate(request, key);
    }
}
