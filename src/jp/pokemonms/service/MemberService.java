package jp.pokemonms.service;

import java.util.List;

import jp.pokemonms.meta.MemberMeta;
import jp.pokemonms.model.Member;
import jp.pokemonms.util.DateUtil;

import org.slim3.datastore.Datastore;
import org.slim3.memcache.Memcache;

import com.google.appengine.api.datastore.Key;

/**
 * メンバーに関するサービス
 *
 * @author Sinmetal
 *
 */
public class MemberService {

    /** MemberMeta */
    private MemberMeta memberMeta = MemberMeta.get();

    /**
     * メンバー取得
     * 
     * @param key
     * @return entity
     */
    public Member get(Key key) {
        return Datastore.get(memberMeta, key);
    }
    
    /**
     * メンバー取得
     *
     * @param twitterId
     * @return entity
     */
    public Member get(long twitterId) {
        Key key = Member.createKey(twitterId);
        return Datastore.get(memberMeta, key);
    }

    /**
     * メンバー取得
     *
     * @param twitterId
     * @return entity
     */
    public Member getOrNull(long twitterId) {
        Key key = Member.createKey(twitterId);
        return Datastore.getOrNull(memberMeta, key);
    }

    /**
     * メンバー一覧取得
     *
     * @return 全メンバー
     */
    public List<Member> findAll() {
        return Datastore
            .query(memberMeta)
            .sort(memberMeta.entryDate.desc)
            .asList();
    }

    /**
     * メンバー取得
     *
     * @param twitterName
     * @return entity
     */
    public Member findByTwitterName(String twitterName) {
        String memcacheKey = this.getClass().getCanonicalName() + twitterName;
        if (Memcache.contains(memcacheKey)) {
            return Memcache.get(memcacheKey);
        }

        Member member =
            Datastore
                .query(memberMeta)
                .filter(memberMeta.twitterName.equal(twitterName))
                .asSingle();
        Memcache.put(memcacheKey, member);
        return member;
    }

    /**
     * メンバー数取得
     *
     * @return
     */
    public int count() {
        return Datastore.query(memberMeta).count();
    }

    /**
     * 挿入
     *
     * @param member
     * @return
     */
    public Member insert(Member member) {
        Member storeMember = getOrNull(member.getTwitterId());
        if (storeMember != null) {
            return storeMember;
        }

        Key key = Member.createKey(member.getTwitterId());
        member.setKey(key);
        member.setEntryDate(DateUtil.getNow());

        Datastore.put(member);
        return member;
    }

    /**
     * 更新
     *
     * @param member
     * @return
     */
    public Member update(Member member) {
        Datastore.put(member);
        return member;
    }
}
