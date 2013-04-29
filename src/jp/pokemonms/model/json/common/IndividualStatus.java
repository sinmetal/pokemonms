package jp.pokemonms.model.json.common;


/**
 * 個体値ステータス
 * 
 * @author sinmetal
 *
 */
public class IndividualStatus {

    /** 上限値 */
    private PokemonStatus upper;
    
    /** 下限値 */
    private PokemonStatus lower;

    /**
     * 初期値設定
     * 
     * @param upper 上限値
     * @param lower 下限値
     */
    public IndividualStatus(PokemonStatus upper, PokemonStatus lower) {
        this.upper = upper;
        this.lower = lower;
    }
    
    /**
     * @return the upper
     */
    public PokemonStatus getUpper() {
        return upper;
    }

    /**
     * @param upper the upper to set
     */
    public void setUpper(PokemonStatus upper) {
        this.upper = upper;
    }

    /**
     * @return the lower
     */
    public PokemonStatus getLower() {
        return lower;
    }

    /**
     * @param lower the lower to set
     */
    public void setLower(PokemonStatus lower) {
        this.lower = lower;
    }

    /**
     * 上限値と下限値が同一であるかを判定
     * 
     * @param obj 個体値
     * @return 上限値と下限値が同一(null同士も同一とみなす):true <br>
     *         そうでない:false
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IndividualStatus)) {
            return false;
        }
        IndividualStatus arg = (IndividualStatus)obj;
        return (equals4PokemonStatus(this.upper, arg.getUpper()) && 
                equals4PokemonStatus(this.lower, arg.getLower()));
    }
    
    /**
     * ポケモンステータスが同一であるかを判定
     * 
     * @param arg1 同一かを判定する１つ目のポケモンステータス
     * @param arg2 同一かを判定する２つ目のポケモンステータス
     * @return 同一である(null同士も同一とみなす):true <br>
     *         そうでない:false
     */
    private boolean equals4PokemonStatus(PokemonStatus arg1,
            PokemonStatus arg2) {
        if (arg1 == null) {
            return (arg2 == null);
        }
        return arg1.equals(arg2);
    }
}
