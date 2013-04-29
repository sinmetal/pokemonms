package jp.pokemonms.form;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import jp.pokemonms.model.constant.EggGroupType;
import jp.pokemonms.model.constant.ElementType;
import jp.pokemonms.util.StringUtil;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

/**
 * PokemonFormTest
 * @author Sinmetal
 *
 */
public class PokemonFormTest extends AppEngineTestCase {

    /**
     * インスタンス生成
     *
     * @throws Exception
     */
    @Test
    public void インスタンス生成() throws Exception {
        final String DRUDDIGON =
            "621,クリムガン,ドラゴン,,77,120,90,60,90,48,ドラゴン,かいじゅう,さめはだ,ちからずく,*かたやぶり";
        final String GOLETT =
            "622,ゴビット,じめん,ゴースト,59,74,50,35,50,35,こうぶつ,,てつのこぶし,ぶきよう,*ノーガード";
        final String DEINO =
            "633,モノズ,あく,ドラゴン,52,65,50,45,50,38,ドラゴン,,はりきり,,";
        List<String> inputStrings = new ArrayList<String>();
        inputStrings.add(DRUDDIGON);
        inputStrings.add(GOLETT);
        inputStrings.add(DEINO);

        String input = StringUtil.join(inputStrings, "\r\n");

        List<PokemonForm> instances = PokemonForm.getInstances(input);

        PokemonForm druddigonForm = instances.get(0);
        assertThat(druddigonForm.getWorldGuideNo(), is(621));
        assertThat(druddigonForm.getPokemonName(), is("クリムガン"));
        assertThat(druddigonForm.getElementType1st(), is(ElementType.DRAGON));
        assertThat(druddigonForm.getElementType2nd(), is(nullValue()));
        assertThat(druddigonForm.getBreedH(), is(77));
        assertThat(druddigonForm.getBreedA(), is(120));
        assertThat(druddigonForm.getBreedB(), is(90));
        assertThat(druddigonForm.getBreedC(), is(60));
        assertThat(druddigonForm.getBreedD(), is(90));
        assertThat(druddigonForm.getBreedS(), is(48));
        assertThat(druddigonForm.getEggGroupType1st(), is(EggGroupType.DRAGON));
        assertThat(druddigonForm.getEggGroupType2nd(), is(EggGroupType.MONSTER));
        assertThat(druddigonForm.getAbilityName1st(), is("さめはだ"));
        assertThat(druddigonForm.getIsAbilityDream1st(), is(false));
        assertThat(druddigonForm.getAbilityName2nd(), is("ちからずく"));
        assertThat(druddigonForm.getIsAbilityDream2nd(), is(false));
        assertThat(druddigonForm.getAbilityName3rd(), is("かたやぶり"));
        assertThat(druddigonForm.getIsAbilityDream3rd(), is(true));

        PokemonForm golettForm = instances.get(1);
        assertThat(golettForm.getWorldGuideNo(), is(622));
        assertThat(golettForm.getPokemonName(), is("ゴビット"));
        assertThat(golettForm.getElementType1st(), is(ElementType.GROUND));
        assertThat(golettForm.getElementType2nd(), is(ElementType.GHOST));
        assertThat(golettForm.getBreedH(), is(59));
        assertThat(golettForm.getBreedA(), is(74));
        assertThat(golettForm.getBreedB(), is(50));
        assertThat(golettForm.getBreedC(), is(35));
        assertThat(golettForm.getBreedD(), is(50));
        assertThat(golettForm.getBreedS(), is(35));
        assertThat(golettForm.getEggGroupType1st(), is(EggGroupType.MINERAL));
        assertThat(golettForm.getEggGroupType2nd(), is(nullValue()));
        assertThat(golettForm.getAbilityName1st(), is("てつのこぶし"));
        assertThat(golettForm.getIsAbilityDream1st(), is(false));
        assertThat(golettForm.getAbilityName2nd(), is("ぶきよう"));
        assertThat(golettForm.getIsAbilityDream2nd(), is(false));
        assertThat(golettForm.getAbilityName3rd(), is("ノーガード"));
        assertThat(golettForm.getIsAbilityDream3rd(), is(true));

        PokemonForm deinoForm = instances.get(2);
        assertThat(deinoForm.getWorldGuideNo(), is(633));
        assertThat(deinoForm.getPokemonName(), is("モノズ"));
        assertThat(deinoForm.getElementType1st(), is(ElementType.DARK));
        assertThat(deinoForm.getElementType2nd(), is(ElementType.DRAGON));
        assertThat(deinoForm.getBreedH(), is(52));
        assertThat(deinoForm.getBreedA(), is(65));
        assertThat(deinoForm.getBreedB(), is(50));
        assertThat(deinoForm.getBreedC(), is(45));
        assertThat(deinoForm.getBreedD(), is(50));
        assertThat(deinoForm.getBreedS(), is(38));
        assertThat(deinoForm.getEggGroupType1st(), is(EggGroupType.DRAGON));
        assertThat(deinoForm.getEggGroupType2nd(), is(nullValue()));
        assertThat(deinoForm.getAbilityName1st(), is("はりきり"));
        assertThat(deinoForm.getIsAbilityDream1st(), is(false));
        assertThat(deinoForm.getAbilityName2nd(), is(""));
        assertThat(deinoForm.getIsAbilityDream2nd(), is(false));
        assertThat(deinoForm.getAbilityName3rd(), is(""));
        assertThat(deinoForm.getIsAbilityDream3rd(), is(false));
    }

}
