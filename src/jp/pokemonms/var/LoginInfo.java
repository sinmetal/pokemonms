package jp.pokemonms.var;

import java.io.Serializable;

import jp.pokemonms.model.Member;

import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;

/**
 * Sessionに格納するログイン者の情報
 * @author Sinmetal
 *
 */
public class LoginInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** MemberKey */
    private Key memberKey;
    
    /** Twitter内部で使用されているID */
    private Long twitterId;

    /** 名前(例：真) */
    private String twitterName;

    /** ID(例：sinmetal) */
    private String twitterScreenName;

    /** Twitterプロフィール画像URL */
    private String twitterProfileImageUrl;

    /**
     * @return the memberKey
     */
    public Key getMemberKey() {
        return memberKey;
    }

    /**
     * @param memberKey the memberKey to set
     */
    public void setMemberKey(Key memberKey) {
        this.memberKey = memberKey;
    }

    /**
     * @return twitterId
     */
    public long getTwitterId() {
        return twitterId;
    }

    /**
     * @param twitterId セットする twitterId
     */
    public void setTwitterId(long twitterId) {
        this.twitterId = twitterId;
    }

    /**
     * @return twitterName
     */
    public String getTwitterName() {
        return twitterName;
    }

    /**
     * @param twitterName セットする twitterName
     */
    public void setTwitterName(String twitterName) {
        this.twitterName = twitterName;
    }

    /**
     * @return twitterScreenName
     */
    public String getTwitterScreenName() {
        return twitterScreenName;
    }

    /**
     * @param twitterScreenName セットする twitterScreenName
     */
    public void setTwitterScreenName(String twitterScreenName) {
        this.twitterScreenName = twitterScreenName;
    }

    /**
     * @return twitterProfileImageUrl
     */
    public String getTwitterProfileImageUrl() {
        return twitterProfileImageUrl;
    }

    /**
     * @param twitterProfileImageUrl セットする twitterProfileImageUrl
     */
    public void setTwitterProfileImageUrl(String twitterProfileImageUrl) {
        this.twitterProfileImageUrl = twitterProfileImageUrl;
    }

    /**
     * インスタンス生成
     *
     * @param Member 
     * @return LoginInfo
     */
    public static LoginInfo getInstance(Member member) {
        LoginInfo instance = new LoginInfo();
        BeanUtil.copy(member, instance);
        instance.setMemberKey(member.getKey());
        return instance;
    }
}
