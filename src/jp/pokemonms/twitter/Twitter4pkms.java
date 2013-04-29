package jp.pokemonms.twitter;

import jp.pokemonms.exception.TwitterRuntimeException;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 *
 * PokemonMS用TwitterAPI
 *
 * @author Sinmetal
 *
 */
public class Twitter4pkms {

    /** Twitter */
    private Twitter twitter;

    @SuppressWarnings("unused")
    private Twitter4pkms() {};

    /**
     * コンストラクタ
     */
    public Twitter4pkms(String consumerKey, String consumerSecret) {
        twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
    }

    /**
     * アクセストークン取得
     *
     * @return
     */
    public AccessToken getOAuthAccessToken() {
        try {
            return twitter.getOAuthAccessToken();
        } catch (TwitterException e) {
            throw new TwitterRuntimeException(e);
        }
    }

    /**
     * アクセストークン取得
     *
     * @param requestToken
     * @return
     */
    public AccessToken getOAuthAccessToken(RequestToken requestToken, String oauthVerifier) {
        try {
            return twitter.getOAuthAccessToken(requestToken, oauthVerifier);
        } catch (TwitterException e) {
            throw new TwitterRuntimeException(e);
        }
    }

    /**
     * User取得
     *
     * @return
     */
    public User getUser() {
        try {
            return twitter.verifyCredentials();
        } catch (TwitterException e) {
            throw new TwitterRuntimeException(e);
        }
    }

    /**
     * リクエストトークン作成
     *
     * @return
     */
    public RequestToken createRequestToken(String callbackURL) {
        try {
            return twitter.getOAuthRequestToken(callbackURL);
        } catch (TwitterException e) {
            throw new TwitterRuntimeException(e);
        }
    }
}
