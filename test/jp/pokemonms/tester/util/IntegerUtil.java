package jp.pokemonms.tester.util;

/**
 * UnitTest用のIntegerUtil
 * 
 * @author sinmetal
 * 
 */
public class IntegerUtil {

    /**
     * 小数点第一位に0を付与した値を返す
     * 
     * @param value
     *            値
     * @return 10 → 10.0
     */
    public static String toDoubleString(Integer value) {
        if (value == null) {
            return "";
        }
        return String.format("%s.0", value);
    }
}
