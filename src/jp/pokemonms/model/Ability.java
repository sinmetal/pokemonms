package jp.pokemonms.model;

import java.io.Serializable;

import jp.pokemonms.util.StringUtil;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 特性モデル
 * 
 * @author Sinmetal
 * 
 */
@Model(schemaVersion = 1)
public class Ability implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /** 特性名 */
    private String abilityName;

    /** 並び替え用特性名(ひらがな) */
    private String abilityName4Sort;

    /** 説明 */
    private String contents;

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
        this.abilityName4Sort =
            StringUtil.zenkakuKatakanaToZenkakuHiragana(abilityName);
    }

    /**
     * @return abilityName4Sort
     */
    public String getAbilityName4Sort() {
        return abilityName4Sort;
    }

    /**
     * @param abilityName4Sort
     *            セットする abilityName4Sort
     */
    public void setAbilityName4Sort(String abilityName4Sort) {
        this.abilityName4Sort = abilityName4Sort;
    }

    /**
     * @return contents
     */
    public String getContents() {
        return contents;
    }

    /**
     * @param contents
     *            セットする contents
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * 特性名からKeyを生成する
     * 
     * @param abilityName
     * @return
     */
    public static Key createKey(String abilityName) {
        if (StringUtil.isEmpty(abilityName)) {
            throw new IllegalArgumentException("abilityName is null or empty");
        }
        return Datastore.createKey(Ability.class, abilityName);
    }

    /**
     * keyからとくせい名を取得
     * 
     * @param key
     *            the key is ability model key
     * @return とくせい名
     */
    public static String getAbilityName(Key key) {
        if (key == null) {
            return "";
        }
        final String ERROR_MESSAGE = "AbilityKeyではありません。";
        if (!"Ability".equals(key.getKind())) {
            String error =
                String.format("%s:%s", ERROR_MESSAGE, key.toString());
            throw new IllegalArgumentException(error);
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
        Ability other = (Ability) obj;
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
