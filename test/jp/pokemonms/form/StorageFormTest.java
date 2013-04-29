package jp.pokemonms.form;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.pokemonms.model.constant.ElementType;
import jp.pokemonms.model.constant.GenderType;
import jp.pokemonms.model.constant.PersonType;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

/**
 * ストレージフォームテスト
 * @author Sinmetal
 *
 */
public class StorageFormTest extends AppEngineTestCase {
    
    /**
     * インスタンス生成
     *
     */
    @Test
    public void インスタンス生成() throws Exception {
        StorageForm instance = StorageForm.getInstance(createRequestMap());
        assertTrue("pokemonName", "フシギダネ".equals(instance.getPokemonName()));
        assertTrue("nickName", "フッシー".equals(instance.getNickname()));
        assertTrue("person", PersonType.DEMURE.equals(instance.getPerson()));
        assertTrue("gender", GenderType.MALE.equals(instance.getGender()));
        assertTrue("ability", "ようりょくそ".equals(instance.getAbilityName()));
        assertTrue("individualHUpper", new Integer(31).equals(instance.getIndividualUpperH()));
        assertTrue("individualAUpper", new Integer(30).equals(instance.getIndividualUpperA()));
        assertTrue("individualBUpper", new Integer(30).equals(instance.getIndividualUpperB()));
        assertTrue("individualCUpper", new Integer(31).equals(instance.getIndividualUpperC()));
        assertTrue("individualDUpper", new Integer(28).equals(instance.getIndividualUpperD()));
        assertTrue("individualSUpper", new Integer(27).equals(instance.getIndividualUpperS()));
        assertTrue("individualHLower", new Integer(31).equals(instance.getIndividualLowerH()));
        assertTrue("individualALower", new Integer(30).equals(instance.getIndividualLowerA()));
        assertTrue("individualBLower", new Integer(30).equals(instance.getIndividualLowerB()));
        assertTrue("individualCLower", new Integer(31).equals(instance.getIndividualLowerC()));
        assertTrue("individualDLower", new Integer(28).equals(instance.getIndividualLowerD()));
        assertTrue("individualSLower", new Integer(27).equals(instance.getIndividualLowerS()));
        assertTrue("trick1stName", "たいあたり".equals(instance.getTrick1stName()));
        assertTrue("trick2ndName", "つるのむち".equals(instance.getTrick2ndName()));
        assertTrue("trick3rdName", "ソーラービーム".equals(instance.getTrick3rdName()));
        assertTrue("trick4thName", "なきごえ".equals(instance.getTrick4thName()));
        assertTrue("awakenPowerElement", ElementType.FIRE.equals(instance.getAwakenPowerElement()));
        assertTrue("awakenPowerEdge", new Integer(69).equals(instance.getAwakenPowerEdge()));
        assertTrue("remark", "かがくのちからってすげー".equals(instance.getRemark()));
    }

    /**
     * 技名一覧取得
     *
     * @throws Exception
     */
    @Test
    public void 技名一覧取得MIN() throws Exception {
        final String TACKLE = "たいあたり";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("trick1stName", TACKLE);

        StorageForm form = StorageForm.getInstance(map);
        List<String> trickNames = form.getTrickNames();
        assertThat(trickNames.size(), is(1));
        assertThat(trickNames.get(0), is(TACKLE));
    }

    /**
     * 技名一覧取得
     *
     * @throws Exception
     */
    @Test
    public void 技名一覧取得MAX() throws Exception {
        final String TACKLE = "たいあたり";
        final String VINE_WHIP = "つるのムチ";
        final String SOLARBEAM = "ソーラービーム";
        final String GROWL = "なきごえ";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("trick1stName", TACKLE);
        map.put("trick2ndName", VINE_WHIP);
        map.put("trick3rdName", SOLARBEAM);
        map.put("trick4thName", GROWL);

        StorageForm form = StorageForm.getInstance(map);
        List<String> trickNames = form.getTrickNames();
        assertThat(trickNames.size(), is(4));
        assertThat(trickNames.get(0), is(TACKLE));
        assertThat(trickNames.get(1), is(VINE_WHIP));
        assertThat(trickNames.get(2), is(SOLARBEAM));
        assertThat(trickNames.get(3), is(GROWL));
    }

    /**
     * テストデータ作成
     *
     * @return
     */
    protected Map<String, Object> createRequestMap() {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("pokemonName", "フシギダネ");
        request.put("nickname", "フッシー");
        request.put("personName", "ひかえめ");
        request.put("genderId", "1");
        request.put("abilityName", "ようりょくそ");
        request.put("individualH", "31");
        request.put("individualA", "30");
        request.put("individualB", "30");
        request.put("individualC", "31");
        request.put("individualD", "28");
        request.put("individualS", "27");
        request.put("effortH", "10");
        request.put("effortA", "11");
        request.put("effortB", "12");
        request.put("effortC", "13");
        request.put("effortD", "14");
        request.put("effortS", "15");
        request.put("lv50A", "51");
        request.put("lv50B", "52");
        request.put("lv50C", "53");
        request.put("lv50D", "54");
        request.put("lv50S", "55");
        request.put("trick1stName", "たいあたり");
        request.put("trick2ndName", "つるのむち");
        request.put("trick3rdName", "ソーラービーム");
        request.put("trick4thName", "なきごえ");
        request.put("awakenPowerElementName", "ほのお");
        request.put("awakenPowerEdge", "69");
        request.put("remark", "かがくのちからってすげー");
        return request;
    }
}
