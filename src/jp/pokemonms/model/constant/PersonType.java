package jp.pokemonms.model.constant;

import java.util.Arrays;
import java.util.List;

/**
 * 性格列挙体
 * @author sin
 *
 */
public enum PersonType {
    /** さみしがり */
    LONELY(1, "さみしがり", StatusType.A, StatusType.B),
    /** いじっぱり */
    OBSTINATE(2, "いじっぱり", StatusType.A, StatusType.C),
    /** やんちゃ */
    RUDENESS(3, "やんちゃ", StatusType.A, StatusType.D),
    /** ゆうかん */
    COURAGE(4, "ゆうかん", StatusType.A, StatusType.S),
    /** ずぶとい */
    NERVE(5, "ずぶとい", StatusType.B, StatusType.A),
    /** わんぱく */
    BRAT(6, "わんぱく", StatusType.B, StatusType.C),
    /** のうてんき */
    CAREFREE(7, "のうてんき", StatusType.B, StatusType.D),
    /** のんき */
    ROSES(8, "のんき", StatusType.B, StatusType.S),
    /** ひかえめ */
    DEMURE(9, "ひかえめ", StatusType.C, StatusType.A),
    /** おっとり */
    UNFUSSY(10, "おっとり", StatusType.C, StatusType.B),
    /** うっかりや */
    BLUNDERING(11, "うっかりや", StatusType.C, StatusType.D),
    /** れいせい */
    APLOMB(12, "れいせい", StatusType.C, StatusType.S),
    /** おだやか */
    GENTLENESS(13, "おだやか", StatusType.D, StatusType.A),
    /** おとなしい */
    TAME(14, "おとなしい", StatusType.D, StatusType.B),
    /** しんちょう */
    CHARINESS(15,"しんちょう", StatusType.D, StatusType.C),
    /** なまいき */
    COCKINESS(16, "なまいき", StatusType.D, StatusType.S),
    /** おくびょう */
    COWARDICE(17, "おくびょう", StatusType.S, StatusType.A),
    /** せっかち */
    FESTINATE(18, "せっかち", StatusType.S, StatusType.B),
    /** ようき */
    BLITHE(19, "ようき", StatusType.S, StatusType.C),
    /** むじゃき */
    INNOCENCE(20, "むじゃき", StatusType.S, StatusType.D),
    /** てれや */
    BASHFUL(21, "てれや", null, null),
    /** がんばりや */
    OVERACHIEVER(22, "がんばりや", null, null),
    /** すなお */
    AMIABLE(23, "すなお", null, null),
    /** きまぐれ */
    WHIMSY(24, "きまぐれ", null, null),
    /** まじめ */
    EARNEST(25, "まじめ", null, null);

    /** ID */
    private Integer id;

    /** Name */
    private String name;

    /** 上昇ステータス */
    private StatusType upStatus;

    /** 下降ステータス */
    private StatusType downStatus;

    /**
     * コンストラクタ
     * @param id
     * @param name
     */
    private PersonType(Integer id, String name, StatusType upStatus, StatusType downStatus) {
        this.id = id;
        this.name = name;
        this.upStatus = upStatus;
        this.downStatus = downStatus;
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
     * @return 上昇ステータス 無い場合はnull
     */
    public StatusType getUpStatus() {
        return upStatus;
    }

    /**
     * @return 下降ステータス 無い場合はnull
     */
    public StatusType getDownStatus() {
        return downStatus;
    }

    /**
     * @param statusType
     * @return ステータスの重み
     */
    public double getWeight(StatusType statusType) {
        final double UP_STATUS_WEIGHT = 1.1;
        final double DOWN_STATUS_WEIGHT = 0.9;

        if (upStatus == statusType) {
            return UP_STATUS_WEIGHT;
        }
        if (downStatus == statusType) {
            return DOWN_STATUS_WEIGHT;
        }
        return 1;
    }

    /**
     * 指定したIDの列挙体を返す
     *
     * @param id
     * @return
     */
    public static PersonType parse(Integer id) {
        for (PersonType value : values()) {
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
    public static PersonType parse(String name) {
        for (PersonType value : values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        throw new IllegalArgumentException(name + "は有効なタイプを表すNameとして認識されません");
    }

    /**
     * 指定したIDの列挙体を返す
     * @param id
     * @return 列挙体 or Null
     */
    public static PersonType parseOrNull(Integer id) {
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
    public static PersonType parseOrNull(String name) {
        try {
            return parse(name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * 一覧を返す
     * @return
     */
    public static List<PersonType> getAll() {
        return Arrays.asList(values());
    }
}
