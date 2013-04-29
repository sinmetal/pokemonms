package jp.pokemonms.util;

import java.util.List;

/**
 * StringUtil
 *
 * @author Sinmetal
 *
 */
public class StringUtil {

    /**
     * 全角カタカナを全角ひらがなに変換
     * @param s
     * @return
     */
    public static String zenkakuKatakanaToZenkakuHiragana(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c >= 'ァ' && c <= 'ン') {
                sb.setCharAt(i, (char) (c - 'ァ' + 'ぁ'));
            } else if (c == 'ヵ') {
                sb.setCharAt(i, 'か');
            } else if (c == 'ヶ') {
                sb.setCharAt(i, 'け');
            } else if (c == 'ヴ') {
                sb.setCharAt(i, 'う');
                sb.insert(i + 1, '゛');
                i++;
            }
        }
        return sb.toString();
    }

    /**
     * 全角ひらがなを全角カタカナに変換
     * @param s
     * @return
     */
    public static String zenkakuHiraganaToZenkakuKatakana(String s) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
          char c = sb.charAt(i);
          if (c >= 'ぁ' && c <= 'ん') {
            sb.setCharAt(i, (char)(c - 'ぁ' + 'ァ'));
          }
        }
        return sb.toString();
      }

    public static boolean isEmpty(String text) {
        return org.slim3.util.StringUtil.isEmpty(text);
    }

    public static String join(String[] array) {
        return org.slim3.util.StringUtil.join(array);
    }

    public static String join(List<String> list) {
        return org.slim3.util.StringUtil.join(list.toArray(new String[0]));
    }

    public static String join(List<String> array, char separator) {
        return org.apache.commons.lang3.StringUtils.join(array, separator);
    }

    public static String join(List<String> array, String separator) {
        return org.apache.commons.lang3.StringUtils.join(array, separator);
    }

    public static String join(String[] array, String separator) {
        return org.apache.commons.lang3.StringUtils.join(array, separator);
    }
}
