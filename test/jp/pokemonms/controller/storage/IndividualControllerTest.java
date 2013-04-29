package jp.pokemonms.controller.storage;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.model.constant.StatusType;
import jp.pokemonms.tester.generater.PokemonGenerater;
import jp.pokemonms.util.JsonUtil;

import org.junit.Test;
import org.slim3.tester.ControllerTestCase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 個体値計算コントローラテスト
 * 
 * @author Sinmetal
 * 
 */
public class IndividualControllerTest extends ControllerTestCase {

    private PokemonGenerater pokemonGenerater = new PokemonGenerater();

    /*
     * (非 Javadoc)
     * 
     * @see org.slim3.tester.ControllerTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        tester.setUp();
        pokemonGenerater.run();
    }

    /**
     * 正常系
     * 
     * @throws Exception
     */
    @Test
    public void 正常系() throws Exception {
        tester.param("pokemonName", "リーフィア");
        tester.param("personName", "わんぱく");
        tester.param("nowLv", "50");
        tester.param("effortH", "0");
        tester.param("effortA", "255");
        tester.param("effortB", "255");
        tester.param("effortC", "0");
        tester.param("effortD", "0");
        tester.param("effortS", "0");
        tester.param("lv50H", "125");
        tester.param("lv50A", "149");
        tester.param("lv50B", "200");
        tester.param("lv50C", "64");
        tester.param("lv50D", "81");
        tester.param("lv50S", "113");

        tester.start("/storage/individual");
        assertThat(
            tester.response.getStatus(),
            is(equalTo(HttpServletResponse.SC_OK)));
        Map<String, Object> map =
            JsonUtil.toMap(tester.response.getOutputAsString());

        assertThat(
            map.get(JsonController.STATUS).toString(),
            is(JsonController.STATUS_OK));

        String individualMapJson = map.get("individual").toString();

        final Gson gson = new Gson();
        final Type mapType = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> individual =
            gson.fromJson(individualMapJson, mapType);
        assertThat(individual.get(StatusType.H.getSign()), is("0-1"));
        assertThat(individual.get(StatusType.A.getSign()), is("5-6"));
        assertThat(individual.get(StatusType.B.getSign()), is("31"));
        assertThat(individual.get(StatusType.C.getSign()), is("14-15"));
        assertThat(individual.get(StatusType.D.getSign()), is("22-23"));
        assertThat(individual.get(StatusType.S.getSign()), is("26-27"));
    }
}
