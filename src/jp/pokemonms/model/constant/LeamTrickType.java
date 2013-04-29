package jp.pokemonms.model.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 覚える技の種類
 * @author sin
 *
 */
public enum LeamTrickType {
    LV(1, "Lv"),
    MACHINE(2, "わざマシン"),
    EGG(3, "遺伝"),
    LESSON(4, "教え技");

    /**
     * ID
     * @author sin
     */
    private Integer id;

    /**
     * Name
     * @author sin
     */
    private String name;

    /**
     * コンストラクタ
     * @param id
     * @param name
     */
    private LeamTrickType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * IDを返す
     * @author sin
     *
     * @return
     */
    public Integer getValue() {
        return id;
    }

    /**
     * 名前を返す
     * @author sin
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 指定したIDの列挙体を返す
     * @author sin
     *
     * @param id
     * @return
     */
    public static LeamTrickType parse(Integer id) {
        for (LeamTrickType value : values()) {
            if (value.getValue().equals(id)) {
                return value;
            }
        }
        throw new IllegalArgumentException(id + "は有効なタイプを表すIDとして認識されません");
    }

    /**
     * 一覧を返す
     * @return
     */
    public static List<LeamTrickType> getAll() {
        return Arrays.asList(values());
    }
}
