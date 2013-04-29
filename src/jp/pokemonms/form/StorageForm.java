package jp.pokemonms.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.pokemonms.model.constant.ElementType;
import jp.pokemonms.model.constant.GenderType;
import jp.pokemonms.model.constant.PersonType;
import jp.pokemonms.util.IndividualUtil;

import org.slim3.util.BeanUtil;
import org.slim3.util.StringUtil;

/**
 * ストレージフォーム
 *
 * @author Sinmetal
 *
 */
public class StorageForm {

    /** ポケモン名 */
    private String pokemonName;

    /** ニックネーム */
    private String nickname;

    /** 性格 */
    private PersonType person;

    /** 性別 */
    private GenderType gender;

    /** 特性 */
    private String abilityName;

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

    /** 技1 */
    private String trick1stName;

    /** 技2 */
    private String trick2ndName;

    /** 技3 */
    private String trick3rdName;

    /** 技4 */
    private String trick4thName;

    /** めざめるパワータイプ */
    private ElementType awakenPowerElement;

    /** めざめるパワー威力 */
    private Integer awakenPowerEdge;

    /** 備考 */
    private String remark;

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
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     *            セットする nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
     * @return gender
     */
    public GenderType getGender() {
        return gender;
    }

    /**
     * @param gender
     *            セットする gender
     */
    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    /**
     * @return abilityName
     */
    public String getAbilityName() {
        return abilityName;
    }

    /**
     * @param abilityName
     *            セットする abilityName
     */
    public void setAbilityName(String abilityName) {
        this.abilityName = abilityName;
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
     * @return trick1stName
     */
    public String getTrick1stName() {
        return trick1stName;
    }

    /**
     * @param trick1stName
     *            セットする trick1stName
     */
    public void setTrick1stName(String trick1stName) {
        this.trick1stName = trick1stName;
    }

    /**
     * @return trick2ndName
     */
    public String getTrick2ndName() {
        return trick2ndName;
    }

    /**
     * @param trick2ndName
     *            セットする trick2ndName
     */
    public void setTrick2ndName(String trick2ndName) {
        this.trick2ndName = trick2ndName;
    }

    /**
     * @return trick3rdName
     */
    public String getTrick3rdName() {
        return trick3rdName;
    }

    /**
     * @param trick3rdName
     *            セットする trick3rdName
     */
    public void setTrick3rdName(String trick3rdName) {
        this.trick3rdName = trick3rdName;
    }

    /**
     * @return trick4thName
     */
    public String getTrick4thName() {
        return trick4thName;
    }

    /**
     * @param trick4thName
     *            セットする trick4thName
     */
    public void setTrick4thName(String trick4thName) {
        this.trick4thName = trick4thName;
    }

    /**
     * @return awakenPowerElement
     */
    public ElementType getAwakenPowerElement() {
        return awakenPowerElement;
    }

    /**
     * @param awakenPowerElement
     *            セットする awakenPowerElement
     */
    public void setAwakenPowerElement(ElementType elementType) {
        this.awakenPowerElement = elementType;
    }

    /**
     * @return awakenPowerEdge
     */
    public Integer getAwakenPowerEdge() {
        return awakenPowerEdge;
    }

    /**
     * @param awakenPowerEdge
     *            セットする awakenPowerEdge
     */
    public void setAwakenPowerEdge(Integer awakenPowerEdge) {
        this.awakenPowerEdge = awakenPowerEdge;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     *            セットする remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return
     */
    public String getIndividualH() {
        return buildeIndividual(individualUpperH, individualLowerH);
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

    public String getIndividualA() {
        return buildeIndividual(individualUpperA, individualLowerA);
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

    public String getIndividualB() {
        return buildeIndividual(individualUpperB, individualLowerB);
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

    public String getIndividualC() {
        return buildeIndividual(individualUpperC, individualLowerC);
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

    public String getIndividualD() {
        return buildeIndividual(individualUpperD, individualLowerD);
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

    public String getIndividualS() {
        return buildeIndividual(individualUpperS, individualLowerS);
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
     * @return personName
     */
    public String getPersonName() {
        if (person == null) {
            return "";
        }
        return person.getName();
    }

    /**
     * @param person
     *            セットする person
     */
    public void setPersonName(String person) {
        this.person = PersonType.parseOrNull(person);
    }

    public Integer getGenderId() {
        return gender.getValue();
    }

    /**
     * @param gender
     *            セットする gender
     */
    public void setGenderId(Integer genderId) {
        this.gender = GenderType.parse(genderId);
    }

    public String getAwakenPowerElementName() {
        if (awakenPowerElement == null) {
            return "";
        }
        return awakenPowerElement.getName();
    }

    /**
     * @param awakenPowerElement
     *            セットする awakenPowerElement
     */
    public void setAwakenPowerElementName(String awakenPowerElementName) {
        this.awakenPowerElement =
            ElementType.parseOrNull(awakenPowerElementName);
    }

    /**
     * 技名一覧を返す
     *
     * また、空文字は排除する。<br>
     * そのため、Listのサイズは入力された技名の個数となる。
     *
     * @return
     */
    public List<String> getTrickNames() {
        List<String> trickNames = new ArrayList<String>();
        trickNames.add(trick1stName);
        trickNames.add(trick2ndName);
        trickNames.add(trick3rdName);
        trickNames.add(trick4thName);

        List<String> emptyExcludeList = new ArrayList<String>();
        for (String trickName : trickNames) {
            if (!StringUtil.isEmpty(trickName)) {
                emptyExcludeList.add(trickName);
            }
        }

        return emptyExcludeList;
    }

    /**
     * StorageFormを返す
     *
     * @param request
     * @return
     */
    public static StorageForm getInstance(Map<String, Object> request) {
        StorageForm form = new StorageForm();
        BeanUtil.copy(request, form);
        return form;
    }

    private String buildeIndividual(Integer upper, Integer lower) {
        if (upper == lower) {
            return upper.toString();
        }
        return String.format("%s-%s", upper, lower);
    }
}
