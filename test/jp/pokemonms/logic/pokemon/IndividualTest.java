package jp.pokemonms.logic.pokemon;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Map;

import jp.pokemonms.form.IndividualForm;
import jp.pokemonms.model.Pokemon;
import jp.pokemonms.model.constant.StatusType;
import jp.pokemonms.tester.StorageRequestGenerater;
import jp.pokemonms.tester.generater.PokemonGenerater;
import jp.pokemonms.tester.generater.constract.PokemonName;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

/**
 * 個体値測定テスト
 * 
 * @author Sinmetal
 * 
 */
public class IndividualTest extends AppEngineTestCase {

    /** ポケモン図鑑ジェネレーター */
    private PokemonGenerater pokemonGenerater = new PokemonGenerater();

    /** ストレージリクエストジェネレーター */
    private StorageRequestGenerater storageRequestGenerater;

    /*
     * (非 Javadoc)
     * 
     * @see org.slim3.tester.AppEngineTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        pokemonGenerater.run();
        storageRequestGenerater = new StorageRequestGenerater();
    }

    /**
     * 最小入力値でのインスタンス生成
     * 
     * @throws Exception
     */
    @Test
    public void 最小入力値でのインスタンス生成() throws Exception {
        Map<String, Object> request =
            storageRequestGenerater.getInsertImperfectionRequest();
        IndividualForm form = IndividualForm.getInstance(request);
        Pokemon bulbasaur = pokemonGenerater.get(PokemonName.BULBASAUR);
        Individual individual = Individual.getInstance(form, bulbasaur);
        assertThat(individual, notNullValue());
    }

    /**
     * 実際のデータを利用した個体値H測定テスト
     * 
     * @throws Exception
     */
    @Test
    public void testIndividualH4Case1() throws Exception {
        Map<String, Object> request =
            storageRequestGenerater.getRealData1Request();

        IndividualForm form = IndividualForm.getInstance(request);
        Pokemon leafeon = pokemonGenerater.get(PokemonName.LEAFEON);
        Individual individual = Individual.getInstance(form, leafeon);

        Map<String, String> individualMap = individual.getIndividual().asMap();
        assertTrue(individualMap.get(StatusType.H.getSign()).equals("0-1"));
    }

    /**
     * 実際のデータを利用した個体値ABCDS測定テスト
     * 
     * @throws Exception
     */
    @Test
    public void testIndividualABCDS4Case1() throws Exception {
        Map<String, Object> request =
            storageRequestGenerater.getRealData1Request();

        IndividualForm form = IndividualForm.getInstance(request);
        Pokemon leafeon = pokemonGenerater.get(PokemonName.LEAFEON);
        Individual individual = Individual.getInstance(form, leafeon);

        Map<String, String> individualMap = individual.getIndividual().asMap();
        assertTrue(individualMap.get(StatusType.A.getSign()).equals("5-6"));
        assertTrue(individualMap.get(StatusType.B.getSign()).equals("31"));
        assertTrue(individualMap.get(StatusType.C.getSign()).equals("14-15"));
        assertTrue(individualMap.get(StatusType.D.getSign()).equals("22-23"));
        assertTrue(individualMap.get(StatusType.S.getSign()).equals("26-27"));
    }

    /**
     * 実際のデータを利用した個体値H測定テスト
     * 
     * @throws Exception
     */
    @Test
    public void testIndividualH4Case2() throws Exception {
        Map<String, Object> request =
            storageRequestGenerater.getRealData2Request();

        IndividualForm form = IndividualForm.getInstance(request);
        Pokemon typhlosion = pokemonGenerater.get(PokemonName.TYPHLOSION);
        Individual individual = Individual.getInstance(form, typhlosion);

        Map<String, String> individualMap = individual.getIndividual().asMap();
        assertTrue(individualMap.get(StatusType.H.getSign()).equals("16-17"));
    }

    /**
     * 実際のデータを利用した個体値ABCDS測定テスト
     * 
     * @throws Exception
     */
    @Test
    public void testIndividualABCDS4Case2() throws Exception {
        Map<String, Object> request =
            storageRequestGenerater.getRealData2Request();

        IndividualForm form = IndividualForm.getInstance(request);
        Pokemon typhlosion = pokemonGenerater.get(PokemonName.TYPHLOSION);
        Individual individual = Individual.getInstance(form, typhlosion);

        Map<String, String> individualMap = individual.getIndividual().asMap();
        assertTrue(individualMap.get(StatusType.A.getSign()).equals("26-27"));
        assertTrue(individualMap.get(StatusType.B.getSign()).equals("6-7"));
        assertTrue(individualMap.get(StatusType.C.getSign()).equals("31"));
        assertTrue(individualMap.get(StatusType.D.getSign()).equals("30-31"));
        assertTrue(individualMap.get(StatusType.S.getSign()).equals("31"));
    }

    /**
     * 実際のデータを利用した個体値H測定テスト
     * 
     * @throws Exception
     */
    @Test
    public void testIndividualH4Case3() throws Exception {
        Map<String, Object> request =
            storageRequestGenerater.getRealData3Request();

        IndividualForm form = IndividualForm.getInstance(request);
        Pokemon typhlosion = pokemonGenerater.get(PokemonName.TYPHLOSION);
        Individual individual = Individual.getInstance(form, typhlosion);

        Map<String, String> individualMap = individual.getIndividual().asMap();
        assertTrue(individualMap.get(StatusType.H.getSign()).equals("16-17"));
    }

    /**
     * 実際のデータを利用した個体値ABCDS測定テスト
     * 
     * @throws Exception
     */
    @Test
    public void testIndividualABCDS4Case4() throws Exception {
        Map<String, Object> request =
            storageRequestGenerater.getRealData2Request();

        IndividualForm form = IndividualForm.getInstance(request);
        Pokemon typhlosion = pokemonGenerater.get(PokemonName.TYPHLOSION);
        Individual individual = Individual.getInstance(form, typhlosion);

        Map<String, String> individualMap = individual.getIndividual().asMap();
        assertThat(individualMap.get(StatusType.A.getSign()), is("26-27"));
        assertThat(individualMap.get(StatusType.B.getSign()), is("6-7"));
        assertThat(individualMap.get(StatusType.C.getSign()), is("31"));
        assertThat(individualMap.get(StatusType.D.getSign()), is("30-31"));
        assertThat(individualMap.get(StatusType.S.getSign()), is("31"));
    }
}
