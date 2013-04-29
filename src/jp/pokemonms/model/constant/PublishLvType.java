package jp.pokemonms.model.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 公開Lv
 * @author sin
 *
 */
public enum PublishLvType {
    ME(1, "自分のみ"),
    ALL(2, "全体");

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
    private PublishLvType(Integer id, String name) {
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
    public static PublishLvType parse(Integer id) {
        for (PublishLvType value : values()) {
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
    public static List<PublishLvType> getAll() {
        return Arrays.asList(values());
    }
}
