package jp.pokemonms.model.constant;

import java.util.Arrays;
import java.util.List;

/**
 * ボックス列挙体
 * @author Sinmetal
 *
 */
public enum BoxType {
    BATTLE(1, "BattleBox"),
    KIDS(2, "KidsBox"),
    TRADE(3, "TradeBox");

    /** ID */
    private Integer id;

    /** Name */
    private String name;

    /**
     * コンストラクタ
     * @param id
     * @param name
     */
    private BoxType(Integer id, String name) {
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
    public static BoxType parse(Integer id) {
        for (BoxType value : values()) {
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
    public static List<BoxType> getAll() {
        return Arrays.asList(values());
    }
}
