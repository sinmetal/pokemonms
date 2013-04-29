package jp.pokemonms.util;

/**
 * 表示用Beanに関するUtil
 * 
 * @author sinmetal
 * 
 */
public class ViewUtil {

    public static Integer nullToDefaultValue(Integer value) {
        if (value == null) {
            return 0;
        }
        return value;
    }

    public static Integer nullToDefaultValue(Integer value, Integer defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return value;
    }

    public static Long nullToDefaultValue(Long value) {
        if (value == null) {
            return 0L;
        }
        return value;
    }

    public static String nullToDefaultValue(String value) {
        if (value == null) {
            return "";
        }
        return value;
    }
}
