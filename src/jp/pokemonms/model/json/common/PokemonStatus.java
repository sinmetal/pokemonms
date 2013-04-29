package jp.pokemonms.model.json.common;


/**
 * ポケモンステータス
 * 
 * @author sinmetal
 *
 */
public class PokemonStatus {

    /** HP */
    private Integer h;
    
    /** こうげき */
    private Integer a;
    
    /** ぼうぎょ */
    private Integer b;
    
    /** とくこう */
    private Integer c;
    
    /** とくぼう */
    private Integer d;
    
    /** すばやさ */
    private Integer s;

    /**
     * 初期値を代入して、インスタンスを作成
     * 
     * @param h HP
     * @param a こうげき
     * @param b ぼうぎょ
     * @param c とくこう
     * @param d とくぼう
     * @param s すばやさ
     */
    public PokemonStatus(Integer h, Integer a, Integer b,
            Integer c, Integer d, Integer s) {
        this.h = h;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.s = s;
    }
    
    /**
     * @return the h
     */
    public Integer getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(Integer h) {
        this.h = h;
    }

    /**
     * @return the a
     */
    public Integer getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Integer a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public Integer getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(Integer b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public Integer getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Integer c) {
        this.c = c;
    }

    /**
     * @return the d
     */
    public Integer getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(Integer d) {
        this.d = d;
    }

    /**
     * @return the s
     */
    public Integer getS() {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(Integer s) {
        this.s = s;
    }

    /**
     * 全ステータスが同値かどうかを判定する
     * 
     * @param obj オブジェクト
     * @return 全ステータスが同値:true <br>
     *         そうでない:false
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PokemonStatus)) {
            return false;
        }
        PokemonStatus arg = (PokemonStatus) obj;
        if (this.h != arg.getH()) return false;
        if (this.a != arg.getA()) return false;
        if (this.b != arg.getB()) return false;
        if (this.c != arg.getC()) return false;
        if (this.d != arg.getD()) return false;
        if (this.s != arg.getS()) return false;
        
        return true;
    }
}
