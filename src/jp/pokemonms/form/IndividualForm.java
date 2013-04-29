package jp.pokemonms.form;

import java.util.Map;

import org.slim3.util.BeanUtil;

import jp.pokemonms.model.constant.PersonType;
import jp.pokemonms.util.IndividualUtil;
import jp.pokemonms.var.PokemonStatus;

/**
 * 個体値計算用フォーム
 * 
 * ポケモンの種類、せいかく、ステータスなどを受け取り、個体値を算出するためのフォーム</br>
 * 個体値は99-99などの形式で入力されるため、それを吸収している
 * 
 * @author Sinmetal
 * 
 */
public class IndividualForm {

    /** ポケモン名 */
    private String pokemonName;

    /** 性格 */
    private PersonType person;

    /** Lv */
    private Integer nowLv;

    /** 個体値H上限 */
    private Integer individualUpperH;

    /** 個体値H下限 */
    private Integer individualLowerH;

    /** 個体値A上限 */
    private Integer individualUpperA;

    /** 個体値A下限 */
    private Integer individualLowerA;

    /** 個体値B上限 */
    private Integer individualUpperB;

    /** 個体値B下限 */
    private Integer individualLowerB;

    /** 個体値C上限 */
    private Integer individualUpperC;

    /** 個体値C下限 */
    private Integer individualLowerC;

    /** 個体値D上限 */
    private Integer individualUpperD;

    /** 個体値D下限 */
    private Integer individualLowerD;

    /** 個体値S上限 */
    private Integer individualUpperS;

    /** 個体値S下限 */
    private Integer individualLowerS;

    /** 努力値H */
    private Integer effortH;

    /** 努力値A */
    private Integer effortA;

    /** 努力値B */
    private Integer effortB;

    /** 努力値C */
    private Integer effortC;

    /** 努力値D */
    private Integer effortD;

    /** 努力値S */
    private Integer effortS;

    /** Lv50H */
    private Integer lv50H;

    /** Lv50A */
    private Integer lv50A;

    /** Lv50B */
    private Integer lv50B;

    /** Lv50C */
    private Integer lv50C;

    /** Lv50D */
    private Integer lv50D;

    /** Lv50S */
    private Integer lv50S;

    private Integer effort[];

    /**
     * @return pokemonName
     */
    public String getPokemonName() {
        return pokemonName;
    }

    /**
     * @param pokemonName
     *            セットする pokemonName
     */
    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    /**
     * @return person
     */
    public PersonType getPerson() {
        return person;
    }

    /**
     * @param person
     *            セットする person
     */
    public void setPerson(PersonType person) {
        this.person = person;
    }

    /**
     * @return nowLv
     */
    public Integer getNowLv() {
        return nowLv;
    }

    /**
     * @param nowLv
     *            セットする nowLv
     */
    public void setNowLv(Integer nowLv) {
        this.nowLv = nowLv;
    }

    /**
     * @return individualUpperH
     */
    public Integer getIndividualUpperH() {
        return individualUpperH;
    }

    /**
     * @param individualUpperH
     *            セットする individualUpperH
     */
    public void setIndividualUpperH(Integer individualUpperH) {
        this.individualUpperH = individualUpperH;
    }

    /**
     * @return individualLowerH
     */
    public Integer getIndividualLowerH() {
        return individualLowerH;
    }

    /**
     * @param individualLowerH
     *            セットする individualLowerH
     */
    public void setIndividualLowerH(Integer individualLowerH) {
        this.individualLowerH = individualLowerH;
    }

    /**
     * @return individualUpperA
     */
    public Integer getIndividualUpperA() {
        return individualUpperA;
    }

    /**
     * @param individualUpperA
     *            セットする individualUpperA
     */
    public void setIndividualUpperA(Integer individualUpperA) {
        this.individualUpperA = individualUpperA;
    }

    /**
     * @return individualLowerA
     */
    public Integer getIndividualLowerA() {
        return individualLowerA;
    }

    /**
     * @param individualLowerA
     *            セットする individualLowerA
     */
    public void setIndividualLowerA(Integer individualLowerA) {
        this.individualLowerA = individualLowerA;
    }

    /**
     * @return individualUpperB
     */
    public Integer getIndividualUpperB() {
        return individualUpperB;
    }

    /**
     * @param individualUpperB
     *            セットする individualUpperB
     */
    public void setIndividualUpperB(Integer individualUpperB) {
        this.individualUpperB = individualUpperB;
    }

    /**
     * @return individualLowerB
     */
    public Integer getIndividualLowerB() {
        return individualLowerB;
    }

    /**
     * @param individualLowerB
     *            セットする individualLowerB
     */
    public void setIndividualLowerB(Integer individualLowerB) {
        this.individualLowerB = individualLowerB;
    }

    /**
     * @return individualUpperC
     */
    public Integer getIndividualUpperC() {
        return individualUpperC;
    }

    /**
     * @param individualUpperC
     *            セットする individualUpperC
     */
    public void setIndividualUpperC(Integer individualUpperC) {
        this.individualUpperC = individualUpperC;
    }

    /**
     * @return individualLowerC
     */
    public Integer getIndividualLowerC() {
        return individualLowerC;
    }

    /**
     * @param individualLowerC
     *            セットする individualLowerC
     */
    public void setIndividualLowerC(Integer individualLowerC) {
        this.individualLowerC = individualLowerC;
    }

    /**
     * @return individualUpperD
     */
    public Integer getIndividualUpperD() {
        return individualUpperD;
    }

    /**
     * @param individualUpperD
     *            セットする individualUpperD
     */
    public void setIndividualUpperD(Integer individualUpperD) {
        this.individualUpperD = individualUpperD;
    }

    /**
     * @return individualLowerD
     */
    public Integer getIndividualLowerD() {
        return individualLowerD;
    }

    /**
     * @param individualLowerD
     *            セットする individualLowerD
     */
    public void setIndividualLowerD(Integer individualLowerD) {
        this.individualLowerD = individualLowerD;
    }

    /**
     * @return individualUpperS
     */
    public Integer getIndividualUpperS() {
        return individualUpperS;
    }

    /**
     * @param individualUpperS
     *            セットする individualUpperS
     */
    public void setIndividualUpperS(Integer individualUpperS) {
        this.individualUpperS = individualUpperS;
    }

    /**
     * @return individualLowerS
     */
    public Integer getIndividualLowerS() {
        return individualLowerS;
    }

    /**
     * @param individualLowerS
     *            セットする individualLowerS
     */
    public void setIndividualLowerS(Integer individualLowerS) {
        this.individualLowerS = individualLowerS;
    }

    /**
     * @return effortH
     */
    public Integer getEffortH() {
        return effortH;
    }

    /**
     * @param effortH
     *            セットする effortH
     */
    public void setEffortH(Integer effortH) {
        if (effortH == null) {
            effortH = 0;
        }
        this.effortH = effortH;
    }

    /**
     * @return effortA
     */
    public Integer getEffortA() {
        return effortA;
    }

    /**
     * @param effortA
     *            セットする effortA
     */
    public void setEffortA(Integer effortA) {
        if (effortA == null) {
            effortA = 0;
        }
        this.effortA = effortA;
    }

    /**
     * @return effortB
     */
    public Integer getEffortB() {
        return effortB;
    }

    /**
     * @param effortB
     *            セットする effortB
     */
    public void setEffortB(Integer effortB) {
        if (effortB == null) {
            effortB = 0;
        }
        this.effortB = effortB;
    }

    /**
     * @return effortC
     */
    public Integer getEffortC() {
        return effortC;
    }

    /**
     * @param effortC
     *            セットする effortC
     */
    public void setEffortC(Integer effortC) {
        if (effortC == null) {
            effortC = 0;
        }
        this.effortC = effortC;
    }

    /**
     * @return effortD
     */
    public Integer getEffortD() {
        return effortD;
    }

    /**
     * @param effortD
     *            セットする effortD
     */
    public void setEffortD(Integer effortD) {
        if (effortD == null) {
            effortD = 0;
        }
        this.effortD = effortD;
    }

    /**
     * @return effortS
     */
    public Integer getEffortS() {
        return effortS;
    }

    /**
     * @param effortS
     *            セットする effortS
     */
    public void setEffortS(Integer effortS) {
        if (effortS == null) {
            effortS = 0;
        }
        this.effortS = effortS;
    }

    /**
     * @return lv50H
     */
    public Integer getLv50H() {
        return lv50H;
    }

    /**
     * @param lv50h
     *            セットする lv50H
     */
    public void setLv50H(Integer lv50h) {
        lv50H = lv50h;
    }

    /**
     * @return lv50A
     */
    public Integer getLv50A() {
        return lv50A;
    }

    /**
     * @param lv50a
     *            セットする lv50A
     */
    public void setLv50A(Integer lv50a) {
        lv50A = lv50a;
    }

    /**
     * @return lv50B
     */
    public Integer getLv50B() {
        return lv50B;
    }

    /**
     * @param lv50b
     *            セットする lv50B
     */
    public void setLv50B(Integer lv50b) {
        lv50B = lv50b;
    }

    /**
     * @return lv50C
     */
    public Integer getLv50C() {
        return lv50C;
    }

    /**
     * @param lv50c
     *            セットする lv50C
     */
    public void setLv50C(Integer lv50c) {
        lv50C = lv50c;
    }

    /**
     * @return lv50D
     */
    public Integer getLv50D() {
        return lv50D;
    }

    /**
     * @param lv50d
     *            セットする lv50D
     */
    public void setLv50D(Integer lv50d) {
        lv50D = lv50d;
    }

    /**
     * @return lv50S
     */
    public Integer getLv50S() {
        return lv50S;
    }

    /**
     * @param lv50s
     *            セットする lv50S
     */
    public void setLv50S(Integer lv50s) {
        lv50S = lv50s;
    }

    /**
     * @return effort
     */
    public Integer[] getEffort() {
        return effort;
    }

    /**
     * @param effort
     *            セットする effort
     */
    public void setEffort(Integer[] effort) {
        this.effort = effort;
    }

    /**
     * 個体値H設定
     * 
     * @param individualH
     */
    public void setIndividualH(String individualH) {
        individualUpperH = IndividualUtil.parseUpper(individualH);
        individualLowerH = IndividualUtil.parseLower(individualH);
    }

    /**
     * 個体値A設定
     * 
     * @param individualA
     */
    public void setIndividualA(String individualA) {
        individualUpperA = IndividualUtil.parseUpper(individualA);
        individualLowerA = IndividualUtil.parseLower(individualA);
    }

    /**
     * 個体値B設定
     * 
     * @param individualB
     */
    public void setIndividualB(String individualB) {
        individualUpperB = IndividualUtil.parseUpper(individualB);
        individualLowerB = IndividualUtil.parseLower(individualB);
    }

    /**
     * 個体値C設定
     * 
     * @param individualC
     */
    public void setIndividualC(String individualC) {
        individualUpperC = IndividualUtil.parseUpper(individualC);
        individualLowerC = IndividualUtil.parseLower(individualC);
    }

    /**
     * 個体値D設定
     * 
     * @param individualD
     */
    public void setIndividualD(String individualD) {
        individualUpperD = IndividualUtil.parseUpper(individualD);
        individualLowerD = IndividualUtil.parseLower(individualD);
    }

    /**
     * 個体値S設定
     * 
     * @param individualS
     */
    public void setIndividualS(String individualS) {
        individualUpperS = IndividualUtil.parseUpper(individualS);
        individualLowerS = IndividualUtil.parseLower(individualS);
    }

    /**
     * @param personName
     *            セットする personName
     */
    public void setPersonName(String personName) {
        this.person = PersonType.parseOrNull(personName);
    }

    /**
     * Lv50Status
     * 
     * @return
     */
    public PokemonStatus getLvStatus() {
        PokemonStatus status =
            new PokemonStatus(lv50H, lv50A, lv50B, lv50C, lv50D, lv50S);
        return status;
    }

    /**
     * 努力値Status
     * 
     * @return
     */
    public PokemonStatus getEffortStatus() {
        PokemonStatus status =
            new PokemonStatus(
                effortH,
                effortA,
                effortB,
                effortC,
                effortD,
                effortS);
        return status;
    }

    /**
     * インスタンス生成
     * 
     * @param request
     * @return
     */
    public static IndividualForm getInstance(Map<String, Object> request) {
        IndividualForm form = new IndividualForm();
        BeanUtil.copy(request, form);
        return form;
    }

}
