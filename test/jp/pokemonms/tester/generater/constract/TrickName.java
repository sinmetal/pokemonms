package jp.pokemonms.tester.generater.constract;

/**
 * テスト用技名
 * @author Sinmetal
 *
 */
public enum TrickName {
    /** たいあたり */
    TACKLE(1, "たいあたり"),
    /** つるのムチ */
    VINE_WHIP(2, "つるのムチ"),
    /** ソーラービーム */
    SOLARBEAM(3, "ソーラービーム"),
    /** なきごえ */
    GROWL(4, "なきごえ"),
    /** リーフブレード */
    LEAF_BLADE(5, "リーフブレード"),
    /** まもる */
    PROTECT(6, "まもる"),
    /** にほんばれ */
    SUNNY_DAY(7, "にほんばれ"),
    /** つるぎのまい */
    SWORDS_DANCE(8, "つるぎのまい");

    /** ID */
    private Integer id;

    /** 技名 */
    private String name;

    /**
     * コンストラクタ
     *
     * @param id
     * @param name
     */
    private TrickName(Integer id, String name) {
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
     * 技名を返す
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
