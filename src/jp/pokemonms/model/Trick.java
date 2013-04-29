package jp.pokemonms.model;

import java.io.Serializable;
import java.util.Map;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;
import org.slim3.util.BeanUtil;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;

/**
 * 技モデル
 * @author Sinmetal
 *
 */

@Model(schemaVersion = 1)
public class Trick implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /** 技名 */
    private String trickName;

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
     * @return trickName
     */
    public String getTrickName() {
        return trickName;
    }

    /**
     * @param trickName セットする trickName
     */
    public void setTrickName(String trickName) {
        this.trickName = trickName;
    }

    /**
     * 技名からKeyを生成する
     *
     * @param trickName
     * @return
     */
    public static Key createKey(String trickName) {
        if (StringUtil.isEmpty(trickName)) {
            throw new IllegalArgumentException("trickName is null or empty");
        }
        return Datastore.createKey(Trick.class, trickName);
    }

    /**
     * 渡されたObjctを元に、インスタンスを生成する。
     * TrickNameを元にKeyを生成するため、TrickNameが必須
     *
     * @param obj
     * @return
     */
    public static Trick getInstance(Map<String, Object> map) {
        Trick trick = new Trick();
        BeanUtil.copy(map, trick);
        trick.setKey(Trick.createKey(trick.trickName));
        return trick;
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
        Trick other = (Trick) obj;
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
