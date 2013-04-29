package jp.pokemonms.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

/**
 * StringUtilTest
 * @author Sinmetal
 *
 */
public class StringUtilTest extends AppEngineTestCase  {

    /**
     * 全角カタカナを全角ひらがなに変換
     * @throws Exception
     */
    @Test
    public void 全角カタカナを全角ひらがなに変換() throws Exception {
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("あいうえお", "あいうえお");
        testMap.put("カキクケコ", "かきくけこ");
        testMap.put("ヴァヴィヴヴェヴォ", "う゛ぁう゛ぃう゛う゛ぇう゛ぉ");

        for (String key : testMap.keySet()) {
            String hiragana = StringUtil.zenkakuKatakanaToZenkakuHiragana(key);
            assertThat(hiragana, is(testMap.get(key)));
        }
    }

    /**
     * 全角ひらがなを全角カタカナに変換
     * @throws Exception
     */
    @Test
    public void 全角ひらがなを全角カタカナに変換() throws Exception {
        Map<String, String> testMap = new HashMap<String, String>();
        testMap.put("アイウエオ", "アイウエオ");
        testMap.put("かきくけこ", "カキクケコ");
        testMap.put("う゛ぁう゛ぃう゛う゛ぇう゛ぉ", "ウ゛ァウ゛ィウ゛ウ゛ェウ゛ォ");

        for (String key : testMap.keySet()) {
            String katakana = StringUtil.zenkakuHiraganaToZenkakuKatakana(key);
            assertThat(katakana, is(testMap.get(key)));
        }
    }
}
