package jp.pokemonms.service;

import jp.pokemonms.exception.ConfigRuntimeException;
import jp.pokemonms.meta.config.TwitterConfigMeta;
import jp.pokemonms.model.config.TwitterConfig;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

/**
 * Config用サービス
 *
 * @author Sinmetal
 *
 */
public class ConfigService {

    /** TwitterConfigMeta */
    private TwitterConfigMeta twitterConfigMeta = new TwitterConfigMeta();

    /**
     * TwitterConfig取得
     *
     * @return TwitterConfig
     */
    public TwitterConfig getTwitterConfig() {
        String twitterConfigKey = TwitterConfig.getKeyName();
        String memcacheKey = this.getClass().getCanonicalName() + twitterConfigKey;
        if (Memcache.contains(memcacheKey)) {
            return Memcache.get(memcacheKey);
        }

        Key key = Datastore.createKey(twitterConfigMeta, twitterConfigKey);
        try {
            TwitterConfig config = Datastore.get(twitterConfigMeta, key);
            Memcache.put(memcacheKey, config);
            return config;
        } catch(Exception e) {
            throw new ConfigRuntimeException(e);
        }
    }

    /**
     * TwitterConfig設定
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public TwitterConfig setTwitterConfig(String consumerKey, String consumerSecret) {
        String twitterConfigKey = TwitterConfig.getKeyName();
        String memcacheKey = this.getClass().getCanonicalName() + twitterConfigKey;

        Key key = Datastore.createKey(twitterConfigMeta, twitterConfigKey);
        TwitterConfig config =TwitterConfig.getInstance(key, consumerKey, consumerSecret);

        Transaction tx = Datastore.beginTransaction();
        Datastore.put(config);
        tx.commit();

        Memcache.put(memcacheKey, config);

        return config;
    }
}
