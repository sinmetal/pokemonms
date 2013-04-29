package jp.pokemonms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日付に関するUtil
 * 
 * @author Sinmetal
 * 
 */
public class DateUtil {

    public static final String DATE_FORMAT_PATTERN = "yyyy/mm/dd HH:MM:ss";

    /**
     * 現在日時を返す
     * 
     * @author Sinmetal
     * 
     * @return
     */
    public static Date getNow() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 文字列をDateに変換する
     * 
     * @param text
     *            日付文字列
     * @param pattern
     *            日付文字列のパターン
     * @return 日付文字列をDateに変換したもの
     */
    public static Date toDate(String text, String pattern) {
        return org.slim3.util.DateUtil.toDate(text, pattern);
    }

    /**
     * 文字列をDateに変換する
     * 
     * @param text
     *            日付文字列
     * @return 既定のフォーマットに従って日付文字列をDateに変換したもの
     */
    public static Date toDate(String text) {
        return org.slim3.util.DateUtil.toDate(text, DATE_FORMAT_PATTERN);
    }

    /**
     * Dateをパターンにフォーマットする
     * 
     * @param value
     *            日付
     * @param pattern
     *            パターン
     * @return パターンにフォーマットされた日付文字列
     */
    public static String toString(Date value, String pattern) {
        return org.slim3.util.DateUtil.toString(value, pattern);
    }

    /**
     * Dateを既定パターンにフォーマットする
     * 
     * @param value
     *            日付
     * @return 既定のパターンにフォーマットされた日付文字列
     */
    public static String toString(Date value) {
        return org.slim3.util.DateUtil.toString(value, DATE_FORMAT_PATTERN);
    }

    /**
     * yyyy/mm/dd hh:MM:ss レベルで一致すればtrue
     * 
     * @param date1
     * @param date2
     * @return yyyy/mm/dd hh:MM:ss レベルで一致すればtrue
     */
    public static boolean compareYYYYMMDD_HHMMSS(Date date1, Date date2) {
        return compare(date1, date2, DATE_FORMAT_PATTERN);
    }

    /**
     * 指定した書式のレベルで日付が一致するか
     * 
     * @param date1
     *            日付
     * @param date2
     *            日付
     * @param pattern
     *            フォーマットパターン
     * @return 指定した書式のレベルで日付が一致すればtrue
     */
    public static boolean compare(Date date1, Date date2, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String date1Text = format.format(date1);
        String date2Text = format.format(date2);
        return date1Text.equals(date2Text);
    }
}
