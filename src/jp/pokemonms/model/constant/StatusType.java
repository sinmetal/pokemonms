package jp.pokemonms.model.constant;

import java.util.Arrays;
import java.util.List;

/**
 * StatusType
 * 
 * @author Sinmetal
 * 
 */
public enum StatusType {
    /** HP */
    H(1, "H", "HP"),
    /** こうげき */
    A(2, "A", "こうげき"),
    /** ぼうぎょ */
    B(3, "B", "ぼうぎょ"),
    /** とくこう */
    C(4, "C", "とくこう"),
    /** とくぼう */
    D(5, "D", "とくぼう"),
    /** すばやさ */
    S(6, "S", "すばやさ");

    /** ID */
    private Integer id;

    /** 記号 */
    private String sign;

    /** Name */
    private String name;

    /**
     * コンストラクタ
     * 
     * @param id
     * @param sing
     * @param name
     */
    private StatusType(Integer id, String sign, String name) {
        this.id = id;
        this.sign = sign;
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
     * 記号を返す
     * 
     * @return
     */
    public String getSign() {
        return sign;
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
    public static StatusType parse(Integer id) {
        for (StatusType value : values()) {
            if (value.getValue().equals(id)) {
                return value;
            }
        }
        throw new IllegalArgumentException(id + "は有効なタイプを表すIDとして認識されません");
    }

    /**
     * 一覧を返す
     * 
     * @return
     */
    public static List<StatusType> getAll() {
        return Arrays.asList(values());
    }
}
