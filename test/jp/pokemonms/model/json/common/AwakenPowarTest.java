package jp.pokemonms.model.json.common;

import jp.pokemonms.model.constant.ElementType;
import jp.pokemonms.model.json.common.AwakenPower;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/**
 * めざめるパワーテスト
 * 
 * @author sinmetal
 *
 */
public class AwakenPowarTest extends AppEngineTestCase {
    
    /**
     * 初期値を設定しインスタンスを作る
     */
    @Test
    public void 初期値を設定しインスタンスを作る() {
        final ElementType TEST_TYPE = ElementType.FIRE;
        final Integer TEST_EDGE = 80;
        
        AwakenPower power = new AwakenPower(TEST_TYPE, TEST_EDGE);
        assertThat(power, is(notNullValue()));
        assertThat(power.getElement(), is(TEST_TYPE));
        assertThat(power.getEdge(), is(TEST_EDGE));
    }
}
