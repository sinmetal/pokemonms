package jp.pokemonms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jp.pokemonms.model.constant.AuthorityType;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import twitter4j.User;
import twitter4j.auth.AccessToken;

import com.google.appengine.api.datastore.Key;

/**
 * メンバーモデル
 *
 * @author Sinmetal
 *
 */
@Model(schemaVersion = 1)
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主キー */
    @Attribute(primaryKey = true)
    private Key key;

    /** バージョン */
    @Attribute(version = true)
    private Long version;

    /** Twitter内部で使用されているID */
    private Long twitterId;

    /** 名前(例：真) */
    private String twitterName;

    /** ID(例：sinmetal) */
    private String twitterScreenName;

    /** OAuth用Token */
    @Attribute(unindexed = true)
    private String twitterToken;

    /** OAuth用TokenSecret */
    @Attribute(unindexed = true)
    private String twitterTokenSecret;

    /** Twitterプロフィール画像URL */
    @Attribute(unindexed = true)
    private String twitterProfileImageUrl;

    /** ともだちコード */
    @Attribute(unindexed = true)
    private List<String> friendCodes;

    /** 活動時間帯 */
    @Attribute(unindexed = true)
    private String activeTime;

    /** 権限 */
    @Attribute(unindexed = true)
    private AuthorityType authorityType;
    
    /** BoxList */
    @Attribute(unindexed = true)
    private List<Key> boxKeys;

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
     * Twitter内部で使用されているID
     *
     * @return
     */
    public Long getTwitterId() {
        return twitterId;
    }

    /**
     * Twitter内部で使用されているID
     *
     * @param twitterId
     */
    public void setTwitterId(Long twitterId) {
        this.twitterId = twitterId;
    }

    /**
     * 名前(例：真)
     *
     * @return
     */
    public String getTwitterName() {
        return twitterName;
    }

    /**
     * 名前(例：真)
     *
     * @param twitterName
     */
    public void setTwitterName(String twitterName) {
        this.twitterName = twitterName;
    }

    /**
     * ID(例：sinmetal)
     *
     * @return
     */
    public String getTwitterScreenName() {
        return twitterScreenName;
    }

    /**
     * ID(例：sinmetal)
     *
     * @param twitterScreenName
     */
    public void setTwitterScreenName(String twitterScreenName) {
        this.twitterScreenName = twitterScreenName;
    }

    /**
     * OAuth用Token
     *
     * @return
     */
    public String getTwitterToken() {
        return twitterToken;
    }

    /**
     * OAuth用Token
     *
     * @param twitterToken
     */
    public void setTwitterToken(String twitterToken) {
        this.twitterToken = twitterToken;
    }

    /**
     * OAuth用TokenSecret
     *
     * @return
     */
    public String getTwitterTokenSecret() {
        return twitterTokenSecret;
    }

    /**
     * OAuth用TokenSecret
     *
     * @param twitterTokenSecret
     */
    public void setTwitterTokenSecret(String twitterTokenSecret) {
        this.twitterTokenSecret = twitterTokenSecret;
    }

    /**
     * Twitterプロフィール画像URL
     *
     * @return
     */
    public String getTwitterProfileImageUrl() {
        return twitterProfileImageUrl;
    }

    /**
     * Twitterプロフィール画像URL
     *
     * @param twitterProfileImageUrl
     */
    public void setTwitterProfileImageUrl(String twitterProfileImageUrl) {
        this.twitterProfileImageUrl = twitterProfileImageUrl;
    }

    /**
     * ともだちコード
     *
     * @return
     */
    public List<String> getFriendCodes() {
        return friendCodes;
    }

    /**
     * ともだちコード
     *
     * @param friendCodes
     */
    public void setFriendCodes(List<String> friendCodes) {
        this.friendCodes = friendCodes;
    }

    /**
     * 活動時間帯
     *
     * @return
     */
    public String getActiveTime() {
        return activeTime;
    }

    /**
     * 活動時間帯
     *
     * @param communicationTime
     */
    public void setActiveTime(String communicationTime) {
        this.activeTime = communicationTime;
    }

    /**
     * @return authorityType
     */
    public AuthorityType getAuthorityType() {
        return authorityType;
    }

    /**
     * @param authorityType
     *            セットする authorityType
     */
    public void setAuthorityType(AuthorityType authorityType) {
        this.authorityType = authorityType;
    }

    /**
     * @return the boxKeys
     */
    public List<Key> getBoxKeys() {
        return boxKeys;
    }

    /**
     * @param boxKeys the boxKeys to set
     */
    public void setBoxKeys(List<Key> boxKeys) {
        this.boxKeys = boxKeys;
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
     * add box key
     * 
     * @param key boxsに追加するboxModelのKey
     */
    public void addBoxKey(Key key) {
        boxKeys.add(key);
    }

    /**
     * TwitterIDを元にKeyを生成
     *
     * @param twitterId
     * @return
     */
    public static Key createKey(Long twitterId) {
        String id = "Twitter=" + twitterId.toString();
        return Datastore.createKey(Member.class, id);
    }

    /**
     * Twitter情報を元にインスタンスを生成
     *
     * @param user
     * @param accessToken
     */
    public static Member getInstance(User user, AccessToken accessToken) {
        Member member = new Member();
        member.setTwitterId(user.getId());
        member.setTwitterName(user.getName());
        member.setTwitterScreenName(user.getScreenName());
        member.setTwitterProfileImageUrl(user.getProfileImageURL().toString());
        member.setTwitterToken(accessToken.getToken());
        member.setTwitterTokenSecret(accessToken.getTokenSecret());
        return member;
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
        Member other = (Member) obj;
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
