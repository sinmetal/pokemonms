package jp.pokemonms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slim3.util.StringUtil;

/**
 * 個体値Util
 * @author Sinmetal
 *
 */
public class IndividualUtil {

    /** 不明時表示文字列 */
    public static String UNKNOWN_VIEW = "?";

    /** 不明時Datastore登録値 */
    public static Integer UNKNOWN_DATA = -1;

    /** 個体値MAX値 */
    public static Integer MAX_VALUE = 31;

    /** 個体値MIX値 */
    public static Integer MIN_VALUE = 0;

    /** ユーザ入力パターン */
    public static String USER_INPUT_PATTER = "^([0-9]{0,3})-([0-9]{0,3})$";

    /**
     * 個体値上限変換
     * @param status
     * @return
     */
    public static Integer parseUpper(String status) {
        return parseStatus(status, true);
    }

    /**
     * 個体値下限変換
     * @param status
     * @return
     */
    public static Integer parseLower(String status) {
        return parseStatus(status, false);
    }

    /**
     * 値をDatastore用に変換する
     *
     * @param value
     * @return
     */
    public static Integer parseInt(String value) {
        if (StringUtil.isEmpty(value)) {
            return UNKNOWN_DATA;
        }

        if (value.matches("^[0-9]+$")) {
            int intValue = Integer.parseInt(value);
            if (range(intValue)) {
                return intValue;
            }
        }

        return UNKNOWN_DATA;
    }

    /**
     * 値を表示用に変換する
     *
     * @param value
     * @return
     */
    public static String parseView(Integer value) {
        if (range(value)) {
            return value.toString();
        }
        return UNKNOWN_VIEW;
    }

    /**
     * ユーザ入力のmatcherを返す
     *
     * @param value
     * @return
     */
    private static Matcher matcher(String value) {
        Pattern pattern = Pattern.compile(USER_INPUT_PATTER);
        return pattern.matcher(value);
    }

    /**
     * 値が個体値の範囲内かどうか
     *
     * @param value
     * @return
     */
    private static boolean range(int value) {
        return (MIN_VALUE <= value && value <= MAX_VALUE);
    }

    /**
     * 入力値をデータ登録用個体値に変換
     *
     * @param status
     * @param isUpper
     * @return
     */
    private static Integer parseStatus(String status, boolean isUpper) {
        if (StringUtil.isEmpty(status)) {
            return IndividualUtil.UNKNOWN_DATA;
        }

        Matcher matcher = matcher(status);
        //"-"で区切られた文字列でない場合は、intに変換を試みる
        if (!matcher.find()) {
            return parseInt(status);
        }
        String lowerStr = matcher.group(1);
        String upperStr = matcher.group(2);

        int lower = parseInt(lowerStr);
        int upper = parseInt(upperStr);

        if (isUpper) {
            return upper;
        } else {
            return lower;
        }
    }
}
