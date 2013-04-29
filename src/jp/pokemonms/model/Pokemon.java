package jp.pokemonms.model;

import java.io.Serializable;
import java.util.Date;

import jp.pokemonms.form.PokemonForm;
import jp.pokemonms.meta.PokemonMeta;
import jp.pokemonms.model.constant.EggGroupType;
import jp.pokemonms.model.constant.ElementType;
import jp.pokemonms.model.constant.StatusType;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;

/**
 * 図鑑モデル
 * 
 * @author Sinmetal
 * 
 */
@Model(schemaVersion = 1)
public class Pokemon implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主キー */
    @Attribute(primaryKey = true)
    private Key key;

    /** バージョン */
    @Attribute(version = true)
    private Long version;

    /** 全国図鑑ID */
    private Integer worldGuideNo;

    /** ポケモン名 */
    private String pokemonName;

    /** タイプ1 */
    private ElementType elementType1st;

    /** タイプ2 */
    private ElementType elementType2nd;

    /** 種族値H */
    private Integer breedH;

    /** 種族値A */
    private Integer breedA;

    /** 種族値B */
    private Integer breedB;

    /** 種族値C */
    private Integer breedC;

    /** 種族値D */
    private Integer breedD;

    /** 種族値S */
    private Integer breedS;

    /** タマゴグループ1st */
    private EggGroupType eggGroupType1st;

    /** タマゴグループ2nd */
    private EggGroupType eggGroupType2nd;

    /** 特性Key1st */
    private Key abilityKey1st;

    /** 特性名1st */
    private String abilityName1st;

    /** 特性1stが夢特性かどうか */
    private Boolean isAbilityDream1st;

    /** 特性Key2nd */
    private Key abilityKey2nd;

    /** 特性名2nd */
    private String abilityName2nd;

    /** 特性2ndが夢特性かどうか */
    private Boolean isAbilityDream2nd;

    /** 特性Key3rd */
    private Key abilityKey3rd;

    /** 特性名3rd */
    private String abilityName3rd;

    /** 特性3rdが夢特性かどうか */
    private Boolean isAbilityDream3rd;

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
     * @return worldGuideNo
     */
    public Integer getWorldGuideNo() {
        return worldGuideNo;
    }

    /**
     * @param worldGuideNo
     *            セットする worldGuideNo
     */
    public void setWorldGuideNo(Integer worldGuideNo) {
        this.worldGuideNo = worldGuideNo;
    }

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
     * @return elementType1st
     */
    public ElementType getElementType1st() {
        return elementType1st;
    }

    /**
     * @param elementType1st
     *            セットする elementType1st
     */
    public void setElementType1st(ElementType elementType1st) {
        this.elementType1st = elementType1st;
    }

    /**
     * @return elementType2nd
     */
    public ElementType getElementType2nd() {
        return elementType2nd;
    }

    /**
     * @param elementType2nd
     *            セットする elementType2nd
     */
    public void setElementType2nd(ElementType elementType2nd) {
        this.elementType2nd = elementType2nd;
    }

    /**
     * @return breedH
     */
    public Integer getBreedH() {
        return breedH;
    }

    /**
     * @param breedH
     *            セットする breedH
     */
    public void setBreedH(Integer breedH) {
        this.breedH = breedH;
    }

    /**
     * @return breedA
     */
    public Integer getBreedA() {
        return breedA;
    }

    /**
     * @param breedA
     *            セットする breedA
     */
    public void setBreedA(Integer breedA) {
        this.breedA = breedA;
    }

    /**
     * @return breedB
     */
    public Integer getBreedB() {
        return breedB;
    }

    /**
     * @param breedB
     *            セットする breedB
     */
    public void setBreedB(Integer breedB) {
        this.breedB = breedB;
    }

    /**
     * @return breedC
     */
    public Integer getBreedC() {
        return breedC;
    }

    /**
     * @param breedC
     *            セットする breedC
     */
    public void setBreedC(Integer breedC) {
        this.breedC = breedC;
    }

    /**
     * @return breedD
     */
    public Integer getBreedD() {
        return breedD;
    }

    /**
     * @param breedD
     *            セットする breedD
     */
    public void setBreedD(Integer breedD) {
        this.breedD = breedD;
    }

    /**
     * @return breedS
     */
    public Integer getBreedS() {
        return breedS;
    }

    /**
     * @param breedS
     *            セットする breedS
     */
    public void setBreedS(Integer breedS) {
        this.breedS = breedS;
    }

    /**
     * @return eggGroupType1st
     */
    public EggGroupType getEggGroupType1st() {
        return eggGroupType1st;
    }

    /**
     * @param eggGroupType1st
     *            セットする eggGroupType1st
     */
    public void setEggGroupType1st(EggGroupType eggGroupType1st) {
        this.eggGroupType1st = eggGroupType1st;
    }

    /**
     * @return eggGroupType2nd
     */
    public EggGroupType getEggGroupType2nd() {
        return eggGroupType2nd;
    }

    /**
     * @param eggGroupType2nd
     *            セットする eggGroupType2nd
     */
    public void setEggGroupType2nd(EggGroupType eggGroupType2nd) {
        this.eggGroupType2nd = eggGroupType2nd;
    }

    /**
     * @return abilityKey1st
     */
    public Key getAbilityKey1st() {
        return abilityKey1st;
    }

    /**
     * @param abilityKey1st
     *            セットする abilityKey1st
     */
    public void setAbilityKey1st(Key abilityKey1st) {
        this.abilityKey1st = abilityKey1st;
    }

    /**
     * @return abilityName1st
     */
    public String getAbilityName1st() {
        return abilityName1st;
    }

    /**
     * @param abilityName1st
     *            セットする abilityName1st
     */
    public void setAbilityName1st(String abilityName1st) {
        this.abilityName1st = abilityName1st;
    }

    /**
     * @return isAbilityDream1st
     */
    public Boolean getIsAbilityDream1st() {
        return isAbilityDream1st;
    }

    /**
     * @param isAbilityDream1st
     *            セットする isAbilityDream1st
     */
    public void setIsAbilityDream1st(Boolean isAbilityDream1st) {
        this.isAbilityDream1st = isAbilityDream1st;
    }

    /**
     * @return abilityKey2nd
     */
    public Key getAbilityKey2nd() {
        return abilityKey2nd;
    }

    /**
     * @param abilityKey2nd
     *            セットする abilityKey2nd
     */
    public void setAbilityKey2nd(Key abilityKey2nd) {
        this.abilityKey2nd = abilityKey2nd;
    }

    /**
     * @return abilityName2nd
     */
    public String getAbilityName2nd() {
        return abilityName2nd;
    }

    /**
     * @param abilityName2nd
     *            セットする abilityName2nd
     */
    public void setAbilityName2nd(String abilityName2nd) {
        this.abilityName2nd = abilityName2nd;
    }

    /**
     * @return isAbilityDream2nd
     */
    public Boolean getIsAbilityDream2nd() {
        return isAbilityDream2nd;
    }

    /**
     * @param isAbilityDream2nd
     *            セットする isAbilityDream2nd
     */
    public void setIsAbilityDream2nd(Boolean isAbilityDream2nd) {
        this.isAbilityDream2nd = isAbilityDream2nd;
    }

    /**
     * @return abilityKey3rd
     */
    public Key getAbilityKey3rd() {
        return abilityKey3rd;
    }

    /**
     * @param abilityKey3rd
     *            セットする abilityKey3rd
     */
    public void setAbilityKey3rd(Key abilityKey3rd) {
        this.abilityKey3rd = abilityKey3rd;
    }

    /**
     * @return abilityName3rd
     */
    public String getAbilityName3rd() {
        return abilityName3rd;
    }

    /**
     * @param abilityName3rd
     *            セットする abilityName3rd
     */
    public void setAbilityName3rd(String abilityName3rd) {
        this.abilityName3rd = abilityName3rd;
    }

    /**
     * @return isAbilityDream3rd
     */
    public Boolean getIsAbilityDream3rd() {
        return isAbilityDream3rd;
    }

    /**
     * @param isAbilityDream3rd
     *            セットする isAbilityDream3rd
     */
    public void setIsAbilityDream3rd(Boolean isAbilityDream3rd) {
        this.isAbilityDream3rd = isAbilityDream3rd;
    }

    /**
     * @return entryDate
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * @param entryDate
     *            セットする entryDate
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * @param statusType
     * @return 種族値
     */
    public int getBreed(StatusType statusType) {
        switch (statusType) {
        case H:
            return breedH;
        case A:
            return breedA;
        case B:
            return breedB;
        case C:
            return breedC;
        case D:
            return breedD;
        case S:
            return breedS;
        default:
            throw new IllegalArgumentException("有効なStatusType以外が指定されました。");
        }
    }

    /**
     * Key生成
     * 
     * @param worldGuideNo
     * @return
     */
    public static Key createKey(int worldGuideNo, String pokemonName) {
        String keyValue = String.format("%s-%s", worldGuideNo, pokemonName);
        return Datastore.createKey(PokemonMeta.get(), keyValue);
    }

    /**
     * インスタンス生成
     * 
     * @param form
     * @return
     */
    public static Pokemon getInstance(PokemonForm form) {
        Pokemon pokemon = new Pokemon();
        BeanUtil.copy(form, pokemon);
        return pokemon;
    }

    /**
     * PokemonModelKeyからポケモン名を取得
     * 
     * @param key
     *            the key is pokemon model key
     * @return ポケモン名
     */
    public static String getPokemonName(Key key) {
        if (key == null) {
            return "";
        }
        final String ERROR_MESSAGE = "PokemonKeyではありません。";
        if (!"Pokemon".equals(key.getKind())) {
            String error =
                String.format("%s:%s", ERROR_MESSAGE, key.toString());
            throw new IllegalArgumentException(error);
        }
        String keyValue = key.getName();
        String[] keyValueSplit = keyValue.split("-");
        if (keyValueSplit.length < 2) {
            String error =
                String.format("%s:%s", ERROR_MESSAGE, key.toString());
            throw new IllegalArgumentException(error);
        }
        return keyValueSplit[1];
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
        Pokemon other = (Pokemon) obj;
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
