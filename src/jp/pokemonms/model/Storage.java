package jp.pokemonms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.pokemonms.meta.StorageMeta;
import jp.pokemonms.model.constant.ElementType;
import jp.pokemonms.model.constant.GenderType;
import jp.pokemonms.model.constant.PersonType;
import jp.pokemonms.util.StringUtil;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * ストレージモデル
 * 
 * @author Sinmetal
 * 
 */
@Model(schemaVersion = 1)
public class Storage implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 技数 */
    @Attribute(persistent = false)
    private final int TRICK_COUNT = 4;

    /** 主キー */
    @Attribute(primaryKey = true)
    private Key key;

    /** バージョン */
    @Attribute(version = true)
    private Long version;

    /** メンバーKey */
    private Key memberKey;

    /** ボックスKey */
    private Key boxKey;

    /** ポケモン図鑑Key */
    private Key pokemonKey;

    /** ニックネーム */
    @Attribute(unindexed = true)
    private String nickname;

    /** 性格 */
    private PersonType person;

    /** 性別 */
    private GenderType gender;

    /** 特性Key */
    private Key abilityKey;

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
    private Key trick1stKey;

    /** 技2 */
    private Key trick2ndKey;

    /** 技3 */
    private Key trick3rdKey;

    /** 技4 */
    private Key trick4thKey;

    /** めざめるパワータイプ */
    private ElementType awakenPowerElement;

    /** めざめるパワー威力 */
    private Integer awakenPowerEdge;

    /** 備考 */
    @Attribute(lob = true, unindexed = true)
    private String remark;

    /** 登録日時 */
    private Date entryDate;

    /**
     * Returns the key.
     * 
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     * 
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     * 
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     * 
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return memberKey
     */
    public Key getMemberKey() {
        return memberKey;
    }

    /**
     * @param memberKey
     *            セットする memberKey
     */
    public void setMemberKey(Key memberKey) {
        this.memberKey = memberKey;
    }

    /**
     * @return boxKey
     */
    public Key getBoxKey() {
        return boxKey;
    }

    /**
     * @param boxKey
     *            セットする boxKey
     */
    public void setBoxKey(Key boxKey) {
        this.boxKey = boxKey;
    }

    /**
     * @return pokemonKey
     */
    public Key getPokemonKey() {
        return pokemonKey;
    }

    /**
     * @param pokemonKey
     *            セットする pokemonKey
     */
    public void setPokemonKey(Key pokemonKey) {
        this.pokemonKey = pokemonKey;
    }

    /**
     * @return pokemonName
     */
    public String getPokemonName() {
        return Pokemon.getPokemonName(this.pokemonKey);
    }

    /**
     * ニックネーム
     * 
     * @return
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * ニックネーム
     * 
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 性格
     * 
     * @return
     */
    public PersonType getPerson() {
        return person;
    }

    /**
     * 性格
     * 
     * @param person
     */
    public void setPerson(PersonType person) {
        this.person = person;
    }

    /**
     * 性別
     * 
     * @return
     */
    public GenderType getGender() {
        return gender;
    }

    /**
     * 性別
     * 
     * @param gender
     */
    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    /**
     * @return abilityKey
     */
    public Key getAbilityKey() {
        return abilityKey;
    }

    /**
     * @param abilityKey
     *            セットする abilityKey
     */
    public void setAbilityKey(Key abilityKey) {
        this.abilityKey = abilityKey;
    }

    /**
     * @return abilityName
     */
    public String getAbilityName() {
        return Ability.getAbilityName(abilityKey);
    }

    /**
     * 個体値H上限
     * 
     * @return
     */
    public Integer getIndividualUpperH() {
        return individualUpperH;
    }

    /**
     * 個体値H上限
     * 
     * @param individualUpperH
     */
    public void setIndividualUpperH(Integer individualUpperH) {
        this.individualUpperH = individualUpperH;
    }

    /**
     * 個体値H下限
     * 
     * @return
     */
    public Integer getIndividualLowerH() {
        return individualLowerH;
    }

    /**
     * 個体値H下限
     * 
     * @param individualLowerH
     */
    public void setIndividualLowerH(Integer individualLowerH) {
        this.individualLowerH = individualLowerH;
    }

    /**
     * 個体値A上限
     * 
     * @return
     */
    public Integer getIndividualUpperA() {
        return individualUpperA;
    }

    /**
     * 個体値A上限
     * 
     * @param individualUpperA
     */
    public void setIndividualUpperA(Integer individualUpperA) {
        this.individualUpperA = individualUpperA;
    }

    /**
     * 個体値A下限
     * 
     * @return
     */
    public Integer getIndividualLowerA() {
        return individualLowerA;
    }

    /**
     * 個体値A下限
     * 
     * @param individualLowerA
     */
    public void setIndividualLowerA(Integer individualLowerA) {
        this.individualLowerA = individualLowerA;
    }

    /**
     * 個体値B上限
     * 
     * @return
     */
    public Integer getIndividualUpperB() {
        return individualUpperB;
    }

    /**
     * 個体値B上限
     * 
     * @param individualUpperB
     */
    public void setIndividualUpperB(Integer individualUpperB) {
        this.individualUpperB = individualUpperB;
    }

    /**
     * 個体値B下限
     * 
     * @return
     */
    public Integer getIndividualLowerB() {
        return individualLowerB;
    }

    /**
     * 個体値B下限
     * 
     * @param individualLowerB
     */
    public void setIndividualLowerB(Integer individualLowerB) {
        this.individualLowerB = individualLowerB;
    }

    /**
     * 個体値C上限
     * 
     * @return
     */
    public Integer getIndividualUpperC() {
        return individualUpperC;
    }

    /**
     * 個体値C上限
     * 
     * @param individualUpperC
     */
    public void setIndividualUpperC(Integer individualUpperC) {
        this.individualUpperC = individualUpperC;
    }

    /**
     * 個体値C下限
     * 
     * @return
     */
    public Integer getIndividualLowerC() {
        return individualLowerC;
    }

    /**
     * 個体値C下限
     * 
     * @param individualLowerC
     */
    public void setIndividualLowerC(Integer individualLowerC) {
        this.individualLowerC = individualLowerC;
    }

    /**
     * 個体値D上限
     * 
     * @return
     */
    public Integer getIndividualUpperD() {
        return individualUpperD;
    }

    /**
     * 個体値D上限
     * 
     * @param individualUpperD
     */
    public void setIndividualUpperD(Integer individualUpperD) {
        this.individualUpperD = individualUpperD;
    }

    /**
     * 個体値D下限
     * 
     * @return
     */
    public Integer getIndividualLowerD() {
        return individualLowerD;
    }

    /**
     * 個体値D下限
     * 
     * @param individualLowerD
     */
    public void setIndividualLowerD(Integer individualLowerD) {
        this.individualLowerD = individualLowerD;
    }

    /**
     * 個体値S上限
     * 
     * @return
     */
    public Integer getIndividualUpperS() {
        return individualUpperS;
    }

    /**
     * 個体値S上限
     * 
     * @param individualUpperS
     */
    public void setIndividualUpperS(Integer individualUpperS) {
        this.individualUpperS = individualUpperS;
    }

    /**
     * 個体値S下限
     * 
     * @return
     */
    public Integer getIndividualLowerS() {
        return individualLowerS;
    }

    /**
     * 個体値S下限
     * 
     * @param individualLowerS
     */
    public void setIndividualLowerS(Integer individualLowerS) {
        this.individualLowerS = individualLowerS;
    }

    /**
     * 努力値H
     * 
     * @return
     */
    public Integer getEffortH() {
        return effortH;
    }

    /**
     * 努力値H
     * 
     * @param effortH
     */
    public void setEffortH(Integer effortH) {
        this.effortH = effortH;
    }

    /**
     * 努力値A
     * 
     * @return
     */
    public Integer getEffortA() {
        return effortA;
    }

    /**
     * 努力値A
     * 
     * @param effortA
     */
    public void setEffortA(Integer effortA) {
        this.effortA = effortA;
    }

    /**
     * 努力値B
     * 
     * @return
     */
    public Integer getEffortB() {
        return effortB;
    }

    /**
     * 努力値B
     * 
     * @param effortB
     */
    public void setEffortB(Integer effortB) {
        this.effortB = effortB;
    }

    /**
     * 努力値C
     * 
     * @return
     */
    public Integer getEffortC() {
        return effortC;
    }

    /**
     * 努力値C
     * 
     * @param effortC
     */
    public void setEffortC(Integer effortC) {
        this.effortC = effortC;
    }

    /**
     * 努力値D
     * 
     * @return
     */
    public Integer getEffortD() {
        return effortD;
    }

    /**
     * 努力値D
     * 
     * @param effortD
     */
    public void setEffortD(Integer effortD) {
        this.effortD = effortD;
    }

    /**
     * 努力値S
     * 
     * @return
     */
    public Integer getEffortS() {
        return effortS;
    }

    /**
     * 努力値S
     * 
     * @param effortS
     */
    public void setEffortS(Integer effortS) {
        this.effortS = effortS;
    }

    /**
     * Lv50H
     * 
     * @return
     */
    public Integer getLv50H() {
        return lv50H;
    }

    /**
     * Lv50H
     * 
     * @param lv50h
     */
    public void setLv50H(Integer lv50h) {
        lv50H = lv50h;
    }

    /**
     * Lv50A
     * 
     * @return
     */
    public Integer getLv50A() {
        return lv50A;
    }

    /**
     * Lv50A
     * 
     * @param lv50a
     */
    public void setLv50A(Integer lv50a) {
        lv50A = lv50a;
    }

    /**
     * Lv50B
     * 
     * @return
     */
    public Integer getLv50B() {
        return lv50B;
    }

    /**
     * Lv50B
     * 
     * @param lv50b
     */
    public void setLv50B(Integer lv50b) {
        lv50B = lv50b;
    }

    /**
     * Lv50C
     * 
     * @return
     */
    public Integer getLv50C() {
        return lv50C;
    }

    /**
     * Lv50C
     * 
     * @param lv50c
     */
    public void setLv50C(Integer lv50c) {
        lv50C = lv50c;
    }

    /**
     * Lv50D
     * 
     * @return
     */
    public Integer getLv50D() {
        return lv50D;
    }

    /**
     * Lv50D
     * 
     * @param lv50d
     */
    public void setLv50D(Integer lv50d) {
        lv50D = lv50d;
    }

    /**
     * Lv50S
     * 
     * @return
     */
    public Integer getLv50S() {
        return lv50S;
    }

    /**
     * Lv50S
     * 
     * @param lv50s
     */
    public void setLv50S(Integer lv50s) {
        lv50S = lv50s;
    }

    /**
     * @return trick1stKey
     */
    public Key getTrick1stKey() {
        return trick1stKey;
    }

    /**
     * @param trick1stKey
     *            セットする trick1stKey
     */
    public void setTrick1stKey(Key trick1stKey) {
        this.trick1stKey = trick1stKey;
    }

    /**
     * @return trick2ndKey
     */
    public Key getTrick2ndKey() {
        return trick2ndKey;
    }

    /**
     * @param trick2ndKey
     *            セットする trick2ndKey
     */
    public void setTrick2ndKey(Key trick2ndKey) {
        this.trick2ndKey = trick2ndKey;
    }

    /**
     * @return trick3rdKey
     */
    public Key getTrick3rdKey() {
        return trick3rdKey;
    }

    /**
     * @param trick3rdKey
     *            セットする trick3rdKey
     */
    public void setTrick3rdKey(Key trick3rdKey) {
        this.trick3rdKey = trick3rdKey;
    }

    /**
     * @return trick4thKey
     */
    public Key getTrick4thKey() {
        return trick4thKey;
    }

    /**
     * @param trick4thKey
     *            セットする trick4thKey
     */
    public void setTrick4thKey(Key trick4thKey) {
        this.trick4thKey = trick4thKey;
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
    public void setAwakenPowerElement(ElementType awakenPowerElement) {
        this.awakenPowerElement = awakenPowerElement;
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
     * @param remark
     *            セットする remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 登録日時
     * 
     * @return
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * 登録日時
     * 
     * @param entryDate
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * IDを返す
     * 
     * @return
     */
    public String getId() {
        if (key == null) {
            return "";
        }
        return String.valueOf(key.getId());
    }

    /**
     * 性格名を設定
     * 
     * @param personName
     */
    public void setPersonName(String personName) {
        if (StringUtil.isEmpty(personName)) {
            return;
        }
        this.person = PersonType.parse(personName);
    }

    /**
     * 性格名を返す
     * 
     * @return
     */
    public String getPersonName() {
        if (person == null) {
            return "";
        }
        return person.getName();
    }

    public void setGenderName(String genderName) {

    }

    /**
     * 性別名を返す
     * 
     * @return
     */
    public String getGenderName() {
        if (gender == null) {
            return "";
        }
        return gender.getName();
    }

    /**
     * 個体値Hを返す
     * 
     * @return
     */
    public String getIndividualH() {
        return buildeIndividual(individualUpperH, individualLowerH);
    }

    /**
     * 個体値Aを返す
     * 
     * @return
     */
    public String getIndividualA() {
        return buildeIndividual(individualUpperA, individualLowerA);
    }

    /**
     * 個体値Bを返す
     * 
     * @return
     */
    public String getIndividualB() {
        return buildeIndividual(individualUpperB, individualLowerB);
    }

    /**
     * 個体値Cを返す
     * 
     * @return
     */
    public String getIndividualC() {
        return buildeIndividual(individualUpperC, individualLowerC);
    }

    /**
     * 個体値Dを返す
     * 
     * @return
     */
    public String getIndividualD() {
        return buildeIndividual(individualUpperD, individualLowerD);
    }

    /**
     * 個体値Sを返す
     * 
     * @return
     */
    public String getIndividualS() {
        return buildeIndividual(individualUpperS, individualLowerS);
    }

    /**
     * @return trick1stName
     */
    public String getTrick1stName() {
        return buildeKeyName(trick1stKey);
    }

    /**
     * @return trick2ndName
     */
    public String getTrick2ndName() {
        return buildeKeyName(trick2ndKey);
    }

    /**
     * @return trick3rdName
     */
    public String getTrick3rdName() {
        return buildeKeyName(trick3rdKey);
    }

    /**
     * @return trick4thName
     */
    public String getTrick4thName() {
        return buildeKeyName(trick4thKey);
    }

    /**
     * KeyをBase64変換して返す
     * 
     * @return Keyがnullの場合は、空文字
     */
    public String getKeyString() {
        if (key == null) {
            return "";
        }
        return KeyFactory.keyToString(key);
    }

    /**
     * めざパタイプ名を返す
     * 
     * @return
     */
    public String getAwakenPowerElementName() {
        if (awakenPowerElement == null) {
            return "";
        }
        return awakenPowerElement.getName();
    }

    /**
     * 技初期化
     */
    public void initializeTricks() {
        trick1stKey = null;
        trick2ndKey = null;
        trick3rdKey = null;
        trick4thKey = null;
    }

    /**
     * TrickKeyを設定する。<br>
     * 既定値を超えた個数のKeyを渡した場合は、例外を投げる。<br>
     * また、引数がnullの場合、無視する
     * 
     * @param trickKeys
     */
    public void setTrickKeys(Key... trickKeys) {
        int trickCount = trickKeys.length;
        if (trickCount > TRICK_COUNT) {
            String message = String.format("引数の数が%dを超えています。", TRICK_COUNT);
            throw new IllegalArgumentException(message);
        }

        initializeTricks();

        ArrayList<Key> availableList = new ArrayList<Key>();
        for (int i = 0; i < trickCount; i++) {
            if (trickKeys[i] != null) {
                availableList.add(trickKeys[i]);
            }
        }

        for (int i = 0; i < availableList.size(); i++) {
            switch (i) {
            case 0:
                setTrick1stKey(availableList.get(i));
                break;
            case 1:
                setTrick2ndKey(availableList.get(i));
                break;
            case 2:
                setTrick3rdKey(availableList.get(i));
                break;
            case 3:
                setTrick4thKey(availableList.get(i));
                break;
            default:
                break;
            }
        }
    }

    /**
     * TrickKeyを設定する。<br>
     * 既定値を超えた個数のKeyを渡した場合は、例外を投げる。<br>
     * また、引数がnullの場合、無視する
     * 
     * @param trickKeys
     */
    public void setTrickKeys(List<Key> trickKeys) {
        setTrickKeys(trickKeys.toArray(new Key[0]));
    }

    /**
     * 渡された技modelのKeyを、技1～xに設定する<br>
     * 引数の数が規定値を超えていた場合は、例外を投げる<br>
     * また、引数がnullの場合、無視する
     * 
     * @param trick
     */
    public void setTricks(Trick... tricks) {
        ArrayList<Key> trickKeys = new ArrayList<Key>();
        for (int i = 0; i < tricks.length; i++) {
            if (tricks[i] != null) {
                trickKeys.add(tricks[i].getKey());
            }
        }
        setTrickKeys(trickKeys.toArray(new Key[0]));
    }

    /**
     * Key生成
     * 
     * @return 生成したKey
     */
    public static Key createKey() {
        return Datastore.allocateId(StorageMeta.get());
    }

    /**
     * インスタンスを返す
     * 
     * @param obj
     * @return
     */
    public static Storage getInstance(Object obj) {
        Storage storage = new Storage();
        BeanUtil.copy(obj, storage);
        return storage;
    }

    /**
     * 個体値作成
     * 
     * @param upper
     * @param lower
     * @return
     */
    protected String buildeIndividual(Integer upper, Integer lower) {
        if (upper == null) {
            return "";
        }
        if (upper == lower) {
            return upper.toString();
        }
        return String.format("%s-%s", upper, lower);
    }

    /**
     * KeyNameを返す Keyがnullの場合は、空文字を返す
     * 
     * @param trick
     * @return
     */
    protected String buildeKeyName(Key key) {
        if (key == null) {
            return "";
        }
        return key.getName();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Storage other = (Storage) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
}
