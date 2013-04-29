package jp.pokemonms.model.config;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

/**
 * TwitterConfig
 * @author Sinmetal
 *
 */
@Model(schemaVersion = 1)
public class TwitterConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /** ConsumerKey */
    private String consumerKey;

    /** ConsumerSecret */
    private String consumerSecret;

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
     * @return consumerKey
     */
    public String getConsumerKey() {
        return consumerKey;
    }

    /**
     * @param consumerKey セットする consumerKey
     */
    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    /**
     * @return consumerSecret
     */
    public String getConsumerSecret() {
        return consumerSecret;
    }

    /**
     * @param consumerSecret セットする consumerSecret
     */
    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }

    /**
     * DatastoreのKeyに利用するNameを返す
     *
     * @return
     */
    public static String getKeyName() {
        return TwitterConfig.class.getCanonicalName();
    }

    /**
     * インスタンスを返す
     *
     * @param key
     * @param consumerKey
     * @param consumerSecret
     * @return
     */
    public static TwitterConfig getInstance(Key key, String consumerKey, String consumerSecret) {
        TwitterConfig config = new TwitterConfig();
        config.setKey(key);
        config.setConsumerKey(consumerKey);
        config.setConsumerSecret(consumerSecret);
        return config;
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
        TwitterConfig other = (TwitterConfig) obj;
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
