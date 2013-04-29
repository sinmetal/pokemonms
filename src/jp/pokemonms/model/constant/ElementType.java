package jp.pokemonms.model.constant;

import java.util.Arrays;
import java.util.List;

/**
 * タイプ列挙体
 *
 * @author Sinmetal
 *
 */
public enum ElementType {
    /** ノーマル */
    NORMAL(1, "ノーマル", "無", "無"),
    /** ほのお */
    FIRE(2, "ほのお", "炎", "炎"),
    /** みず */
    WATER(3, "みず", "水", "水"),
    /** でんき */
    ELECTRIC(4, "でんき", "電気", "電"),
    /** くさ */
    GRASS(5, "くさ", "草", "草"),
    /** こおり */
    ICE(6, "こおり", "氷", "氷"),
    /** かくとう */
    FIGHT(7, "かくとう", "格闘", "格"),
    /** どく */
    POISON(8, "どく", "毒", "毒"),
    /** じめん */
    GROUND(9, "じめん", "地面", "地"),
    /** ひこう */
    FLYING(10, "ひこう", "飛行", "飛"),
    /** エスパー */
    PSYCHIC(11, "エスパー", "超能力", "超"),
    /** むし */
    BUG(12, "むし", "虫", "虫"),
    /** いわ */
    ROCK(13, "いわ", "岩", "岩"),
    /** ゴースト */
    GHOST(14, "ゴースト", "霊", "霊"),
    /** ドラゴン */
    DRAGON(15, "ドラゴン", "竜", "竜"),
    /** あく */
    DARK(16, "あく", "悪", "悪"),
    /** はがね */
    STEEL(17, "はがね", "鋼", "鋼");

    /** ID */
    private Integer id;

    /** Name */
    private String name;

    /** 漢字名 */
    private String kanjiName;

    /** 略称 */
    private String abbreviatedName;

    /**
     * コンストラクタ
     *
     * @param id
     * @param name
     * @param kanjiName
     * @param abbreviatedName
     */
    private ElementType(Integer id, String name, String kanjiName,
            String abbreviatedName) {
        this.id = id;
        this.name = name;
        this.kanjiName = kanjiName;
        this.abbreviatedName = abbreviatedName;
    }

    /**
     * IDを返す
     *
     * @return
     */
    public Integer getValue() {
        return id;
    }

    /**
     * 名前を返す
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return kanjiName
     */
    public String getKanjiName() {
        return kanjiName;
    }

    /**
     * @return abbreviatedName
     */
    public String getAbbreviatedName() {
        return abbreviatedName;
    }

    /**
     * 指定したIDの列挙体を返す
     *
     * @param id
     * @return
     */
    public static ElementType parse(Integer id) {
        for (ElementType value : values()) {
            if (value.getValue().equals(id)) {
                return value;
            }
        }
        throw new IllegalArgumentException(id + "は有効なタイプを表すIDとして認識されません");
    }

    /**
     * 指定したNameの列挙体を返す
     *
     * @param name
     * @return
     */
    public static ElementType parse(String name) {
        for (ElementType value : values()) {
            String[] names =
                new String[] {
                    value.name,
                    value.kanjiName,
                    value.abbreviatedName };
            for (String valueName : names) {
                if (valueName.equals(name)) {
                    return value;
                }
            }
        }
        throw new IllegalArgumentException(name + "は有効なタイプを表すNameとして認識されません");
    }

    /**
     * 指定したIDの列挙体を返す
     *
     * @param id
     * @return 列挙体 or Null
     */
    public static ElementType parseOrNull(Integer id) {
        try {
            return parse(id);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * 指定したNameの列挙体を返す
     *
     * @param name
     * @return 列挙体 or Null
     */
    public static ElementType parseOrNull(String name) {
        try {
            return parse(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * 一覧を返す
     *
     * @return
     */
    public static List<ElementType> getAll() {
        return Arrays.asList(values());
    }
}
