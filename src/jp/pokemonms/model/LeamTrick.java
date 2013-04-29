package jp.pokemonms.model;

import java.io.Serializable;

import jp.pokemonms.model.constant.LeamTrickType;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * 覚える技
 * @author sin
 *
 */

@Model(schemaVersion = 1)
public class LeamTrick implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /** 図鑑Key */
    private Key pokemonGuideKey;

    /** 技Key */
    private Key trickKey;

    /** 覚える技の種類 */
    private LeamTrickType leamTrickType;

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
     * @return pokemonGuideKey
     */
    public Key getPokemonGuideKey() {
        return pokemonGuideKey;
    }

    /**
     * @param pokemonGuideKey セットする pokemonGuideKey
     */
    public void setPokemonGuideKey(Key pokemonGuideKey) {
        this.pokemonGuideKey = pokemonGuideKey;
    }

    /**
     * @return trickKey
     */
    public Key getTrickKey() {
        return trickKey;
    }

    /**
     * @param trickKey セットする trickKey
     */
    public void setTrickKey(Key trickKey) {
        this.trickKey = trickKey;
    }

    /**
     * @return leamTrickType
     */
    public LeamTrickType getLeamTrickType() {
        return leamTrickType;
    }

    /**
     * @param leamTrickType セットする leamTrickType
     */
    public void setLeamTrickType(LeamTrickType leamTrickType) {
        this.leamTrickType = leamTrickType;
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
        LeamTrick other = (LeamTrick) obj;
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
