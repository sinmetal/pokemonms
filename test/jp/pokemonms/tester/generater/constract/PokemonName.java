package jp.pokemonms.tester.generater.constract;

/**
 * テスト用ポケモン図鑑名
 * @author Sinmetal
 *
 */
public enum PokemonName {
    /** フシギダネ */
    BULBASAUR(1, "フシギダネ"),
    /** バクフーン */
    TYPHLOSION(157, "バクフーン"),
    /** リーフィア */
    LEAFEON(470, "リーフィア");

    /** ID */
    private Integer id;

    /** ポケモン名 */
    private String name;

    /**
     * コンストラクタ
     *
     * @param id
     * @param name
     */
    private PokemonName(Integer id, String name) {
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
     * ポケモン名を返す
     *
     * @return
     */
    public String getName() {
        return name;
    }
}
