package jp.pokemonms.tester;

import jp.pokemonms.model.Member;
import jp.pokemonms.service.MemberService;
import jp.pokemonms.var.LoginInfo;

/**
 * ログイン状態を擬似的に作り出すヘルパー
 *
 * @author Sinmetal
 *
 */
public class LoginHelper {

    /** ログイン情報 SessionKey */
    public final String LOGIN_INFO = "loginInfo";

    /** Twitter内部ID */
    public final Long TWITTER_ID = Long.MAX_VALUE;

    /** 名前(例：真) */
    public final String TWITTER_NAME = "真";

    /** ID(例：sinmetal) */
    public final String TWITTER_SCREEN_NAME = "sinmetal";

    /** Twitterプロフィール画像URL */
    public final String TWITTER_PROFILE_IMAGE_URL =
        "http://a2.twimg.com/profile_images/1042264867/1277990403846_bigger.png";

    /** ログイン者MemberModel */
    private Member member = null;

    /** メンバーサービス */
    private MemberService memberService = new MemberService();

    /**
     * テスト用のデフォルトメンバー情報を初期化
     */
    public void init() {
        if (member == null) {
            member = new Member();
            member.setKey(Member.createKey(TWITTER_ID));
            member.setTwitterId(TWITTER_ID);
            member.setTwitterName(TWITTER_NAME);
            member.setTwitterScreenName(TWITTER_SCREEN_NAME);
            member.setTwitterProfileImageUrl(TWITTER_PROFILE_IMAGE_URL);
            memberService.insert(member);
        }
    }

    /**
     * ログイン者Session情報取得
     *
     * @return
     */
    public LoginInfo getLoginInfo() {
        if (member == null) {
            return null;
        }
        return LoginInfo.getInstance(member);
    }

    /**
     * ログイン者MemberModel取得
     *
     * @return
     */
    public Member getMember() {
        return member;
    }
}
