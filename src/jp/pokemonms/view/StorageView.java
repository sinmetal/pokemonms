package jp.pokemonms.view;

import java.util.ArrayList;
import java.util.List;

import jp.pokemonms.model.Storage;
import jp.pokemonms.util.DateUtil;
import jp.pokemonms.util.KeyConverter;
import jp.pokemonms.util.ViewUtil;

import org.slim3.util.BeanUtil;
import org.slim3.util.CopyOptions;

/**
 * StorageView
 * 
 * @author sinmetal
 * 
 */
public class StorageView {

    // TODO
    // この辺りの値はModelにあった方が良い気がする。また、Datastoreに未入力だとnullになっているが、この辺りの値を入れてあげた方が良いかも
    private final Integer INDIVIDUAL_UPPER_NOT_INPUT_VALUE = -1;

    // TODO 個体値Maxは31のため、検索などを考慮し、振り切った値を設定
    private final Integer INDIVIDUAL_LOWER_NOT_INPUT_VALUE = 99;

    private final Integer EFFORT_NOT_INPUT_VALUE = -1;

    private final Integer LV50_NOT_INPUT_VALUE = -1;

    private String id = "";
    
    private String key = "";

    private Long version = 0L;

    private String memberKey = "";

    private String boxKey = "";

    private String pokemonKey = "";

    private String pokemonName = "";

    private String nickname = "";

    private String personName = "";

    private String genderName = "";

    private String abilityKey = "";

    private String abilityName = "";

    private Integer individualUpperH = INDIVIDUAL_UPPER_NOT_INPUT_VALUE;

    private Integer individualUpperA = INDIVIDUAL_UPPER_NOT_INPUT_VALUE;

    private Integer individualUpperB = INDIVIDUAL_UPPER_NOT_INPUT_VALUE;

    private Integer individualUpperC = INDIVIDUAL_UPPER_NOT_INPUT_VALUE;

    private Integer individualUpperD = INDIVIDUAL_UPPER_NOT_INPUT_VALUE;

    private Integer individualUpperS = INDIVIDUAL_UPPER_NOT_INPUT_VALUE;

    private Integer individualLowerH = INDIVIDUAL_LOWER_NOT_INPUT_VALUE;

    private Integer individualLowerA = INDIVIDUAL_LOWER_NOT_INPUT_VALUE;

    private Integer individualLowerB = INDIVIDUAL_LOWER_NOT_INPUT_VALUE;

    private Integer individualLowerC = INDIVIDUAL_LOWER_NOT_INPUT_VALUE;

    private Integer individualLowerD = INDIVIDUAL_LOWER_NOT_INPUT_VALUE;

    private Integer individualLowerS = INDIVIDUAL_LOWER_NOT_INPUT_VALUE;
    
    private String individualH;
    
    private String individualA;
    
    private String individualB;
    
    private String individualC;
    
    private String individualD;
    
    private String individualS;

    private Integer effortH = EFFORT_NOT_INPUT_VALUE;

    private Integer effortA = EFFORT_NOT_INPUT_VALUE;

    private Integer effortB = EFFORT_NOT_INPUT_VALUE;

    private Integer effortC = EFFORT_NOT_INPUT_VALUE;

    private Integer effortD = EFFORT_NOT_INPUT_VALUE;

    private Integer effortS = EFFORT_NOT_INPUT_VALUE;

    private Integer lv50H = LV50_NOT_INPUT_VALUE;

    private Integer lv50A = LV50_NOT_INPUT_VALUE;

    private Integer lv50B = LV50_NOT_INPUT_VALUE;

    private Integer lv50C = LV50_NOT_INPUT_VALUE;

    private Integer lv50D = LV50_NOT_INPUT_VALUE;

    private Integer lv50S = LV50_NOT_INPUT_VALUE;

    private String trick1stKey = "";

    private String trick2ndKey = "";

    private String trick3rdKey = "";

    private String trick4thKey = "";
    
    private String trick1stName = "";
    
    private String trick2ndName = "";
    
    private String trick3rdName = "";
    
    private String trick4thName = "";

    private String awakenPowerElementName = "";

    private Integer awakenPowerEdge = -1;

    private String remark;

    private String entryDate = "";

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     *            the key to set
     */
    public void setKey(String key) {
        this.key = ViewUtil.nullToDefaultValue(key);
    }

    /**
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public void setVersion(Long version) {
        this.version = ViewUtil.nullToDefaultValue(version);
    }

    /**
     * @return the memberKey
     */
    public String getMemberKey() {
        return memberKey;
    }

    /**
     * @param memberKey
     *            the memberKey to set
     */
    public void setMemberKey(String memberKey) {
        this.memberKey = ViewUtil.nullToDefaultValue(memberKey);
    }

    /**
     * @return the boxKey
     */
    public String getBoxKey() {
        return boxKey;
    }

    /**
     * @param boxKey
     *            the boxKey to set
     */
    public void setBoxKey(String boxKey) {
        this.boxKey = ViewUtil.nullToDefaultValue(boxKey);
    }

    /**
     * @return the pokemonKey
     */
    public String getPokemonKey() {
        return pokemonKey;
    }

    /**
     * @param pokemonKey
     *            the pokemonKey to set
     */
    public void setPokemonKey(String pokemonKey) {
        this.pokemonKey = ViewUtil.nullToDefaultValue(pokemonKey);
    }

    /**
     * @return the pokemonName
     */
    public String getPokemonName() {
        return pokemonName;
    }

    /**
     * @param pokemonName
     *            the pokemonName to set
     */
    public void setPokemonName(String pokemonName) {
        this.pokemonName = ViewUtil.nullToDefaultValue(pokemonName);
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     *            the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = ViewUtil.nullToDefaultValue(nickname);
    }

    /**
     * @return the personName
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * @param personName
     *            the personName to set
     */
    public void setPersonName(String personName) {
        this.personName = ViewUtil.nullToDefaultValue(personName);
    }

    /**
     * @return the genderName
     */
    public String getGenderName() {
        return genderName;
    }

    /**
     * @param genderName
     *            the genderName to set
     */
    public void setGenderName(String genderName) {
        this.genderName = ViewUtil.nullToDefaultValue(genderName);
    }

    /**
     * @return the abilityKey
     */
    public String getAbilityKey() {
        return abilityKey;
    }

    /**
     * @param abilityKey
     *            the abilityKey to set
     */
    public void setAbilityKey(String abilityKey) {
        this.abilityKey = ViewUtil.nullToDefaultValue(abilityKey);
    }

    /**
     * @return the abilityName
     */
    public String getAbilityName() {
        return abilityName;
    }

    /**
     * @param abilityName
     *            the abilityName to set
     */
    public void setAbilityName(String abilityName) {
        this.abilityName = ViewUtil.nullToDefaultValue(abilityName);
    }

    /**
     * @return the individualUpperH
     */
    public Integer getIndividualUpperH() {
        return individualUpperH;
    }

    /**
     * @param individualUpperH
     *            the individualUpperH to set
     */
    public void setIndividualUpperH(Integer individualUpperH) {
        this.individualUpperH = nullToNotInputIndividualUpper(individualUpperH);
    }

    /**
     * @return the individualUpperA
     */
    public Integer getIndividualUpperA() {
        return individualUpperA;
    }

    /**
     * @param individualUpperA
     *            the individualUpperA to set
     */
    public void setIndividualUpperA(Integer individualUpperA) {
        this.individualUpperA = nullToNotInputIndividualUpper(individualUpperA);
    }

    /**
     * @return the individualUpperB
     */
    public Integer getIndividualUpperB() {
        return individualUpperB;
    }

    /**
     * @param individualUpperB
     *            the individualUpperB to set
     */
    public void setIndividualUpperB(Integer individualUpperB) {
        this.individualUpperB = nullToNotInputIndividualUpper(individualUpperB);
    }

    /**
     * @return the individualUpperC
     */
    public Integer getIndividualUpperC() {
        return individualUpperC;
    }

    /**
     * @param individualUpperC
     *            the individualUpperC to set
     */
    public void setIndividualUpperC(Integer individualUpperC) {
        this.individualUpperC = nullToNotInputIndividualUpper(individualUpperC);
    }

    /**
     * @return the individualUpperD
     */
    public Integer getIndividualUpperD() {
        return individualUpperD;
    }

    /**
     * @param individualUpperD
     *            the individualUpperD to set
     */
    public void setIndividualUpperD(Integer individualUpperD) {
        this.individualUpperD = nullToNotInputIndividualUpper(individualUpperD);
    }

    /**
     * @return the individualUpperS
     */
    public Integer getIndividualUpperS() {
        return individualUpperS;
    }

    /**
     * @param individualUpperS
     *            the individualUpperS to set
     */
    public void setIndividualUpperS(Integer individualUpperS) {
        this.individualUpperS = nullToNotInputIndividualUpper(individualUpperS);
    }

    /**
     * @return the individualLowerH
     */
    public Integer getIndividualLowerH() {
        return individualLowerH;
    }

    /**
     * @param individualLowerH
     *            the individualLowerH to set
     */
    public void setIndividualLowerH(Integer individualLowerH) {
        this.individualLowerH = nullToNotInputIndividualLower(individualLowerH);
    }

    /**
     * @return the individualLowerA
     */
    public Integer getIndividualLowerA() {
        return individualLowerA;
    }

    /**
     * @param individualLowerA
     *            the individualLowerA to set
     */
    public void setIndividualLowerA(Integer individualLowerA) {
        this.individualLowerA = nullToNotInputIndividualLower(individualLowerA);
    }

    /**
     * @return the individualLowerB
     */
    public Integer getIndividualLowerB() {
        return individualLowerB;
    }

    /**
     * @param individualLowerB
     *            the individualLowerB to set
     */
    public void setIndividualLowerB(Integer individualLowerB) {
        this.individualLowerB = nullToNotInputIndividualLower(individualLowerB);
    }

    /**
     * @return the individualLowerC
     */
    public Integer getIndividualLowerC() {
        return individualLowerC;
    }

    /**
     * @param individualLowerC
     *            the individualLowerC to set
     */
    public void setIndividualLowerC(Integer individualLowerC) {
        this.individualLowerC = nullToNotInputIndividualLower(individualLowerC);
    }

    /**
     * @return the individualLowerD
     */
    public Integer getIndividualLowerD() {
        return individualLowerD;
    }

    /**
     * @param individualLowerD
     *            the individualLowerD to set
     */
    public void setIndividualLowerD(Integer individualLowerD) {
        this.individualLowerD = nullToNotInputIndividualLower(individualLowerD);
    }

    /**
     * @return the individualLowerS
     */
    public Integer getIndividualLowerS() {
        return individualLowerS;
    }

    /**
     * @param individualLowerS
     *            the individualLowerS to set
     */
    public void setIndividualLowerS(Integer individualLowerS) {
        this.individualLowerS = nullToNotInputIndividualLower(individualLowerS);
    }

    /**
     * @return the individualH
     */
    public String getIndividualH() {
        return individualH;
    }

    /**
     * @param individualH the individualH to set
     */
    public void setIndividualH(String individualH) {
        this.individualH = individualH;
    }

    /**
     * @return the individualA
     */
    public String getIndividualA() {
        return individualA;
    }

    /**
     * @param individualA the individualA to set
     */
    public void setIndividualA(String individualA) {
        this.individualA = individualA;
    }

    /**
     * @return the individualB
     */
    public String getIndividualB() {
        return individualB;
    }

    /**
     * @param individualB the individualB to set
     */
    public void setIndividualB(String individualB) {
        this.individualB = individualB;
    }

    /**
     * @return the individualC
     */
    public String getIndividualC() {
        return individualC;
    }

    /**
     * @param individualC the individualC to set
     */
    public void setIndividualC(String individualC) {
        this.individualC = individualC;
    }

    /**
     * @return the individualD
     */
    public String getIndividualD() {
        return individualD;
    }

    /**
     * @param individualD the individualD to set
     */
    public void setIndividualD(String individualD) {
        this.individualD = individualD;
    }

    /**
     * @return the individualS
     */
    public String getIndividualS() {
        return individualS;
    }

    /**
     * @param individualS the individualS to set
     */
    public void setIndividualS(String individualS) {
        this.individualS = individualS;
    }

    /**
     * @return the effortH
     */
    public Integer getEffortH() {
        return effortH;
    }

    /**
     * @param effortH
     *            the effortH to set
     */
    public void setEffortH(Integer effortH) {
        this.effortH = nullToNotInputEffort(effortH);
    }

    /**
     * @return the effortA
     */
    public Integer getEffortA() {
        return effortA;
    }

    /**
     * @param effortA
     *            the effortA to set
     */
    public void setEffortA(Integer effortA) {
        this.effortA = nullToNotInputEffort(effortA);
    }

    /**
     * @return the effortB
     */
    public Integer getEffortB() {
        return effortB;
    }

    /**
     * @param effortB
     *            the effortB to set
     */
    public void setEffortB(Integer effortB) {
        this.effortB = nullToNotInputEffort(effortB);
    }

    /**
     * @return the effortC
     */
    public Integer getEffortC() {
        return effortC;
    }

    /**
     * @param effortC
     *            the effortC to set
     */
    public void setEffortC(Integer effortC) {
        this.effortC = nullToNotInputEffort(effortC);
    }

    /**
     * @return the effortD
     */
    public Integer getEffortD() {
        return effortD;
    }

    /**
     * @param effortD
     *            the effortD to set
     */
    public void setEffortD(Integer effortD) {
        this.effortD = nullToNotInputEffort(effortD);
    }

    /**
     * @return the effortS
     */
    public Integer getEffortS() {
        return effortS;
    }

    /**
     * @param effortS
     *            the effortS to set
     */
    public void setEffortS(Integer effortS) {
        this.effortS = nullToNotInputEffort(effortS);
    }

    /**
     * @return the lv50H
     */
    public Integer getLv50H() {
        return lv50H;
    }

    /**
     * @param lv50h
     *            the lv50H to set
     */
    public void setLv50H(Integer lv50h) {
        lv50H = nullToNotInputLv50(lv50h);
    }

    /**
     * @return the lv50A
     */
    public Integer getLv50A() {
        return lv50A;
    }

    /**
     * @param lv50a
     *            the lv50A to set
     */
    public void setLv50A(Integer lv50a) {
        lv50A = nullToNotInputLv50(lv50a);
    }

    /**
     * @return the lv50B
     */
    public Integer getLv50B() {
        return lv50B;
    }

    /**
     * @param lv50b
     *            the lv50B to set
     */
    public void setLv50B(Integer lv50b) {
        lv50B = nullToNotInputLv50(lv50b);
    }

    /**
     * @return the lv50C
     */
    public Integer getLv50C() {
        return lv50C;
    }

    /**
     * @param lv50c
     *            the lv50C to set
     */
    public void setLv50C(Integer lv50c) {
        lv50C = nullToNotInputLv50(lv50c);
    }

    /**
     * @return the lv50D
     */
    public Integer getLv50D() {
        return lv50D;
    }

    /**
     * @param lv50d
     *            the lv50D to set
     */
    public void setLv50D(Integer lv50d) {
        lv50D = nullToNotInputLv50(lv50d);
    }

    /**
     * @return the lv50S
     */
    public Integer getLv50S() {
        return lv50S;
    }

    /**
     * @param lv50s
     *            the lv50S to set
     */
    public void setLv50S(Integer lv50s) {
        lv50S = nullToNotInputLv50(lv50s);
    }

    /**
     * @return the trick1stKey
     */
    public String getTrick1stKey() {
        return trick1stKey;
    }

    /**
     * @param trick1stKey
     *            the trick1stKey to set
     */
    public void setTrick1stKey(String trick1stKey) {
        this.trick1stKey = ViewUtil.nullToDefaultValue(trick1stKey);
    }

    /**
     * @return the trick2ndKey
     */
    public String getTrick2ndKey() {
        return trick2ndKey;
    }

    /**
     * @param trick2ndKey
     *            the trick2ndKey to set
     */
    public void setTrick2ndKey(String trick2ndKey) {
        this.trick2ndKey = ViewUtil.nullToDefaultValue(trick2ndKey);
    }

    /**
     * @return the trick3rdKey
     */
    public String getTrick3rdKey() {
        return trick3rdKey;
    }

    /**
     * @param trick3rdKey
     *            the trick3rdKey to set
     */
    public void setTrick3rdKey(String trick3rdKey) {
        this.trick3rdKey = ViewUtil.nullToDefaultValue(trick3rdKey);
    }

    /**
     * @return the trick4thKey
     */
    public String getTrick4thKey() {
        return trick4thKey;
    }

    /**
     * @param trick4thKey
     *            the trick4thKey to set
     */
    public void setTrick4thKey(String trick4thKey) {
        this.trick4thKey = ViewUtil.nullToDefaultValue(trick4thKey);
    }

    /**
     * @return the trick1stName
     */
    public String getTrick1stName() {
        return trick1stName;
    }

    /**
     * @param trick1stName the trick1stName to set
     */
    public void setTrick1stName(String trick1stName) {
        this.trick1stName = trick1stName;
    }

    /**
     * @return the trick2ndName
     */
    public String getTrick2ndName() {
        return trick2ndName;
    }

    /**
     * @param trick2ndName the trick2ndName to set
     */
    public void setTrick2ndName(String trick2ndName) {
        this.trick2ndName = trick2ndName;
    }

    /**
     * @return the trick3rdName
     */
    public String getTrick3rdName() {
        return trick3rdName;
    }

    /**
     * @param trick3rdName the trick3rdName to set
     */
    public void setTrick3rdName(String trick3rdName) {
        this.trick3rdName = trick3rdName;
    }

    /**
     * @return the trick4thName
     */
    public String getTrick4thName() {
        return trick4thName;
    }

    /**
     * @param trick4thName the trick4thName to set
     */
    public void setTrick4thName(String trick4thName) {
        this.trick4thName = trick4thName;
    }

    /**
     * @return the awakenPowerElementName
     */
    public String getAwakenPowerElementName() {
        return awakenPowerElementName;
    }

    /**
     * @param awakenPowerElementName
     *            the awakenPowerElementName to set
     */
    public void setAwakenPowerElementName(String awakenPowerElementName) {
        this.awakenPowerElementName =
            ViewUtil.nullToDefaultValue(awakenPowerElementName);
    }

    /**
     * @return the awakenPowerEdge
     */
    public Integer getAwakenPowerEdge() {
        return awakenPowerEdge;
    }

    /**
     * @param awakenPowerEdge
     *            the awakenPowerEdge to set
     */
    public void setAwakenPowerEdge(Integer awakenPowerEdge) {
        this.awakenPowerEdge = ViewUtil.nullToDefaultValue(awakenPowerEdge, -1);
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     *            the remark to set
     */
    public void setRemark(String remark) {
        this.remark = ViewUtil.nullToDefaultValue(remark);
    }

    /**
     * @return the entryDate
     */
    public String getEntryDate() {
        return entryDate;
    }

    /**
     * @param entryDate
     *            the entryDate to set
     */
    public void setEntryDate(String entryDate) {
        this.entryDate = ViewUtil.nullToDefaultValue(entryDate);
    }

    /**
     * 個体値上限値がnullの場合は、未入力値を返す
     * 
     * @param individualUpper
     *            個体値上限値
     * @return 個体値上限値がnullの場合は、未入力値。そうでない場合は、個体値上限値
     */
    private Integer nullToNotInputIndividualUpper(Integer individualUpper) {
        return ViewUtil.nullToDefaultValue(
            individualUpper,
            INDIVIDUAL_UPPER_NOT_INPUT_VALUE);
    }

    /**
     * Lv50ステータスのnullの場合は、未入力値を返す
     * 
     * @param lv50
     *            Lv50ステータス
     * @return Lv50ステータスがnullの場合は、未入力値。そうでない場合は、Lv50ステータス
     */
    private Integer nullToNotInputLv50(Integer lv50) {
        return ViewUtil.nullToDefaultValue(lv50, LV50_NOT_INPUT_VALUE);
    }

    /**
     * 個体値下限値がnullの場合は、未入力値を返す
     * 
     * @param individualLower
     *            個体値下限値
     * @return 個体値下限値がnullの場合は、未入力値。そうでない場合は、渡された個体値下限値
     */
    private Integer nullToNotInputIndividualLower(Integer individualLower) {
        return ViewUtil.nullToDefaultValue(
            individualLower,
            INDIVIDUAL_LOWER_NOT_INPUT_VALUE);
    }

    /**
     * 努力値がnullの場合は、未入力値を返す
     * 
     * @param effort
     *            努力値
     * @return 努力値がnullの場合は、未入力値。そうでない場合は、渡された努力値
     */
    private Integer nullToNotInputEffort(Integer effort) {
        return ViewUtil.nullToDefaultValue(effort, EFFORT_NOT_INPUT_VALUE);
    }

    /**
     * インスタンス生成
     * 
     * @param storage
     *            the storage is storage model
     * @return storageを設定したStorageView
     */
    public static StorageView getInstance(Storage storage) {
        StorageView instance = new StorageView();
        CopyOptions options = new CopyOptions();
        options.converter(
            new KeyConverter(),
            "key",
            "memberKey",
            "boxKey",
            "pokemonKey",
            "abilityKey",
            "trick1stKey",
            "trick2ndKey",
            "trick3rdKey",
            "trick4thKey");
        options.dateConverter(DateUtil.DATE_FORMAT_PATTERN, "entryDate");
        BeanUtil.copy(storage, instance, options);
        return instance;
    }

    /**
     * インスタンスリスト生成
     * 
     * @param storages
     *            the storages is storage model list
     * @return storagesをstorageViewに変換して、リストを返す
     */
    public static List<StorageView> getInstances(List<Storage> storages) {
        ArrayList<StorageView> result = new ArrayList<StorageView>();
        if (storages == null) {
            return result;
        }
        for (Storage storage : storages) {
            result.add(StorageView.getInstance(storage));
        }
        return result;
    }
}
