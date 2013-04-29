package jp.pokemonms.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.tester.LoginHelper;
import jp.pokemonms.var.LoginInfo;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * JsonUtilTest
 * 
 * @author Sinmetal
 * 
 */
public class JsonUtilTest extends AppEngineTestCase {

    /**
     * テスト用にLoginInfoを取得するために使用
     */
    private LoginHelper loginHelper = new LoginHelper();

    /*
     * (非 Javadoc)
     * 
     * @see org.slim3.tester.AppEngineTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        loginHelper.init();
    }

    /**
     * MapにPOJOを格納して取り出す
     * 
     * @throws Exception
     */
    @Test
    public void MapにPOJOを格納して取り出す() throws Exception {
        final String POJO = "pojo";
        Map<String, String> map = new HashMap<String, String>();
        LoginInfo before = loginHelper.getLoginInfo();
        Gson gson = JsonUtil.createGson();
        map.put(POJO, gson.toJson(before));
        String json = JsonUtil.toJson(map);

        Map<String, Object> afterMap = JsonUtil.toMap(json);
        LoginInfo after = JsonUtil.fromJson(afterMap.get(POJO).toString(), LoginInfo.class);
        assertThat(after.getTwitterId(), is(before.getTwitterId()));
        assertThat(after.getTwitterName(), is(before.getTwitterName()));
    }

    /**
     * GsonのDate型のformatをテスト<br />
     * 
     * gsonにDate型のformatを指定した場合の挙動を確認
     * 
     * @throws Exception
     */
    @Test
    public void GsonのDate型のformatをテスト() throws Exception {
        Gson gson = JsonUtil.createGson();

        Date testDate = new Date();
        String testDateText = gson.toJson(testDate);
        Date ansDate = gson.fromJson(testDateText, Date.class);
        SimpleDateFormat format =
            new SimpleDateFormat(DateUtil.DATE_FORMAT_PATTERN);
        assertThat(format.format(ansDate), is(format.format(testDate)));
    }
    
    /**
     * GsonでJsonに変換後Mapに入れた場合のテスト
     * @throws Exception
     */
    @Test
    public void GsonでJsonに変換後Mapに入れた場合のテスト() throws Exception {
        Gson gson = JsonUtil.createGson();

        Map<String, String> jsonMap = new HashMap<String, String>();
        
        Date testDate = new Date();
        jsonMap.put("testDate", gson.toJson(testDate));
        String testMapJson = gson.toJson(jsonMap);
        
        Type mapType = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> reverseMap = gson.fromJson(testMapJson, mapType);
        Date ansDate = gson.fromJson(reverseMap.get("testDate"), Date.class);
        SimpleDateFormat format =
            new SimpleDateFormat(DateUtil.DATE_FORMAT_PATTERN);
        assertThat(format.format(ansDate), is(format.format(testDate)));
    }
}
