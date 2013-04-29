package jp.pokemonms.tester;

import java.util.HashMap;
import java.util.Map;

/**
 * テスト用のリクエストデータを作成
 * 
 * @author Sinmetal
 * 
 */
public class StorageRequestGenerater {

    /** 全パラメータ入力リクエストMap */
    private Map<String, Object> insertCompleteRequestMap;

    /** 不完全パラメータ入力リクエストMap */
    private Map<String, Object> insertImperfectionRequestMap;

    /** 実際のデータを利用したリクエストMap1 */
    private Map<String, Object> realDataRequestMap1;

    /** 実際のデータを利用したリクエストMap2 */
    private Map<String, Object> realDataRequestMap2;

    /** 実際のデータを利用したリクエストMap3 */
    private Map<String, Object> realDataRequestMap3;

    /**
     * コンストラクタ
     */
    public StorageRequestGenerater() {
        insertCompleteRequestMap = createInsertCompleteRequest();
        insertImperfectionRequestMap = createInsertImperfectionRequest();
        realDataRequestMap1 = createTestCase1();
        realDataRequestMap2 = createTestCase2();
        realDataRequestMap3 = createTestCase3();
    }

    /**
     * 全パラメータ入力リクエスト取得
     * 
     * @return
     */
    public Map<String, Object> getInsertCompleteRequest() {
        return insertCompleteRequestMap;
    }

    /**
     * パラメータが揃っていないリクエストを取得
     * 
     * @return
     */
    public Map<String, Object> getInsertImperfectionRequest() {
        return insertImperfectionRequestMap;
    }

    /**
     * 実際のデータ1を利用したリクエストを取得
     * 
     * @return
     */
    public Map<String, Object> getRealData1Request() {
        return realDataRequestMap1;
    }

    /**
     * 実際のデータ2を利用したリクエストを取得
     * 
     * @return
     */
    public Map<String, Object> getRealData2Request() {
        return realDataRequestMap2;
    }

    /**
     * 実際のデータ3を利用したリクエストを取得
     * 
     * @return
     */
    public Map<String, Object> getRealData3Request() {
        return realDataRequestMap3;
    }

    /**
     * 全パラメータ入力リクエスト作成
     * 
     * @return
     */
    private Map<String, Object> createInsertCompleteRequest() {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("pokemonName", "フシギダネ");
        request.put("nickname", "フッシー");
        request.put("personName", "ひかえめ");
        request.put("genderId", "1");
        request.put("abilityName", "ようりょくそ");
        request.put("gradeId", "1");
        request.put("individualH", "31");
        request.put("individualA", "0-15");
        request.put("individualB", "-30");
        request.put("individualC", "31");
        request.put("individualD", "28-");
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
        request.put("trick2ndName", "つるのムチ");
        request.put("trick3rdName", "ソーラービーム");
        request.put("trick4thName", "なきごえ");
        request.put("awakenPowerElementName", "ほのお");
        request.put("awakenPowerEdge", "69");
        request.put("remark", "かがくのちからってすげー");
        return request;
    }

    /**
     * パラメータが揃っていないリクエストを取得
     * 
     * @return
     */
    private Map<String, Object> createInsertImperfectionRequest() {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("pokemonName", "フシギダネ");
        return request;
    }

    /**
     * 実際のデータを元にしたリクエスト
     * 
     * @return
     */
    private Map<String, Object> createTestCase1() {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("pokemonName", "リーフィア");
        request.put("nickname", "フィア");
        request.put("nowLv", 50);
        request.put("personName", "わんぱく");
        request.put("genderId", "1");
        request.put("abilityName", "リーフガード");
        request.put("effortH", 0);
        request.put("effortA", 255);
        request.put("effortB", 255);
        request.put("effortC", 0);
        request.put("effortD", 0);
        request.put("effortS", 0);
        request.put("lv50H", 125);
        request.put("lv50A", 149);
        request.put("lv50B", 200);
        request.put("lv50C", 64);
        request.put("lv50D", 81);
        request.put("lv50S", 113);
        request.put("individualH", "0-1");
        request.put("individualA", "5-6");
        request.put("individualB", "31");
        request.put("individualC", "14-15");
        request.put("individualD", "22-23");
        request.put("individualS", "26-27");
        request.put("trick1stName", "リーフブレード");
        return request;
    }

    /**
     * 実際のデータを元にしたリクエスト
     * 
     * @return
     */
    private Map<String, Object> createTestCase2() {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("pokemonName", "バクフーン");
        request.put("nowLv", 50);
        request.put("personName", "ひかえめ");
        request.put("effortH", 0);
        request.put("effortA", 0);
        request.put("effortB", 0);
        request.put("effortC", 255);
        request.put("effortD", 0);
        request.put("effortS", 255);
        request.put("Lv50H", 146);
        request.put("Lv50A", 91);
        request.put("Lv50B", 86);
        request.put("Lv50C", 177);
        request.put("Lv50D", 105);
        request.put("Lv50S", 152);
        return request;
    }

    /**
     * 実際のデータを元にしたリクエスト
     * 
     * @return
     */
    private Map<String, Object> createTestCase3() {
        Map<String, Object> request = new HashMap<String, Object>();
        request.put("pokemonName", "バクフーン");
        request.put("nowLv", 50);
        request.put("personName", "ひかえめ");
        request.put("effortH", null);
        request.put("effortA", null);
        request.put("effortB", null);
        request.put("effortC", null);
        request.put("effortD", null);
        request.put("effortS", null);
        request.put("Lv50H", 146);
        request.put("Lv50A", 91);
        request.put("Lv50B", 86);
        request.put("Lv50C", 177);
        request.put("Lv50D", 105);
        request.put("Lv50S", 152);
        return request;
    }
}
