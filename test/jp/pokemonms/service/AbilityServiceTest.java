package jp.pokemonms.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import jp.pokemonms.model.Ability;
import jp.pokemonms.tester.generater.AbilityGenerater;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

/**
 * 特性サービステスト
 * @author Sinmetal
 *
 */
public class AbilityServiceTest extends AppEngineTestCase {

    private AbilityService service = new AbilityService();

    private AbilityGenerater abilityGenerater = new AbilityGenerater();

    /* (非 Javadoc)
     * @see org.slim3.tester.AppEngineTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        abilityGenerater.run();
    }

    /**
     * インスタンス生成
     *
     * @throws Exception
     */
    @Test
    public void インスタンス生成() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    /**
     * 存在しない特性を指定した場合はnull取得
     *
     * @throws Exception
     */
    @Test
    public void 存在しない特性を指定した場合はnull取得() throws Exception {
        Ability ability = service.findByAbilityName("hoge");
        assertThat(ability, is(nullValue()));
    }

    /**
     * 存在する特性を指定した場合はModel取得
     *
     * @throws Exception
     */
    @Test
    public void 存在する特性を指定した場合はModel取得() throws Exception {
        final String NAME = "ようりょくそ";

        Ability ability = service.findByAbilityName(NAME);
        assertThat(ability, is(notNullValue()));
        assertThat(ability.getAbilityName(), is(NAME));
    }

    /**
     * 全アビリティ数を取得
     *
     * @throws Exception
     */
    @Test
    public void 全アビリティ数を取得() throws Exception {
        assertThat(service.count(), is(abilityGenerater.count()));
    }
}
