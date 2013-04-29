package jp.pokemonms.tester.generater.constract;

/**
 * テスト用特性名
 * @author Sinmetal
 *
 */
public enum AbilityName {
    /** ようりょくそ */
    CHLOROPHYLL(1, "ようりょくそ"),
    /** さめはだ */
    ROUGHSKIN(2, "さめはだ"),
    /** ちからずく */
    SHEERFORCE(3, "ちからずく"),
    /** かたやぶり */
    MOLDBREAKER(4, "かたやぶり"),
    /** てつのこぶし */
    IRONFIST(5, "てつのこぶし"),
    /** ぶきよう */
    KLUTZ(6, "ぶきよう"),
    /** ノーガード */
    NOGUARD(7, "ノーガード"),
    /** はりきり */
    HUSTLE(8, "はりきり"),
    /** リーフガード */
    LEAFGUARD(9, "リーフガード");

    /** ID */
    private Integer id;

    /** 特性名 */
    private String name;

    /**
     * コンストラクタ
     *
     * @param id
     * @param name
     */
    private AbilityName(Integer id, String name) {
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
     * 特性名を返す
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
