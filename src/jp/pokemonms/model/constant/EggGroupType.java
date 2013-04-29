package jp.pokemonms.model.constant;

import java.util.Arrays;
import java.util.List;

/**
 * タマゴグループ列挙体
 *
 * @author Sinmetal
 *
 */
public enum EggGroupType {
    /** みはっけん */
    UNFOUND(1, "みはっけん"),
    /** しょくぶつ */
    GRASS(2, "しょくぶつ"),
    /** むし */
    BUG(3, "むし"),
    /** ひこう */
    FLYING(4, "ひこう"),
    /** ひとがた */
    HUMANLIKE(5, "ひとがた"),
    /** こうぶつ */
    MINERAL(6, "こうぶつ"),
    /** かいじゅう */
    MONSTER(7, "かいじゅう"),
    /** ようせい */
    FAIRY(8, "ようせい"),
    /** ドラゴン */
    DRAGON(9, "ドラゴン"),
    /** ふていけい */
    AMORPHOUS(10, "ふていけい"),
    /** りくじょう */
    FIELD(11, "りくじょう"),
    /** すいちゅう1 */
    WATER1(12, "すいちゅう1"),
    /** すいちゅう2 */
    WATER2(13, "すいちゅう2"),
    /** すいちゅう3 */
    WATER3(14, "すいちゅう3"),
    /** せいべつふめい */
    UNISEXED(15, "せいべつふめい"),
    /** メタモン */
    DITTO(16, "メタモン");

    /** ID */
    private Integer id;

    /** Name */
    private String name;

    /**
     * コンストラクタ
     *
     * @param id
     * @param name
     */
    private EggGroupType(Integer id, String name) {
        this.id = id;
        this.name = name;
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
     * 指定したIDの列挙体を返す
     *
     * @param id
     * @return
     */
    public static EggGroupType parse(Integer id) {
        for (EggGroupType value : values()) {
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
    public static EggGroupType parse(String name) {
        for (EggGroupType value : values()) {
            if (value.getName().equals(name)) {
                return value;
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
    public static EggGroupType parseOrNull(Integer id) {
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
    public static EggGroupType parseOrNull(String name) {
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
    public static List<EggGroupType> getAll() {
        return Arrays.asList(values());
    }
}
