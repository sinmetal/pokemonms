package jp.pokemonms.controller.authentication;

import jp.pokemonms.controller.AbstractController;
import jp.pokemonms.model.Member;
import jp.pokemonms.service.MemberService;
import jp.pokemonms.twitter.Twitter4pkms;
import jp.pokemonms.twitter.Twitter4pkmsFactory;

import org.slim3.controller.Navigation;

import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 * AuthenticationCallbackController
 * @author Sinmetal
 *
 */
public class CallbackController extends AbstractController {

    private MemberService memberService = new MemberService();

    /**
     * TwitterからのCallbackを受け取る
     */
    @Override
    public Navigation run() throws Exception {
        final String STORAGE_PAGE = "/storage/";
        if ("127.0.0.1".equals(request.getRemoteHost())) {
            Member testMember = createTestMember();
            saveMember(testMember);
            return redirect(STORAGE_PAGE);
        }

        Twitter4pkms twitter = new Twitter4pkmsFactory().getInstance();
        RequestToken requestToken = (RequestToken) sessionScope("requestToken");
        String verifier = requestScope("oauth_verifier");

        // TODO 認証を取り消した場合、ここでぬるぽが出る
        AccessToken accessToken =
            twitter.getOAuthAccessToken(requestToken, verifier);
        removeSessionScope("requestToken");

        Member member = Member.getInstance(twitter.getUser(), accessToken);
        saveMember(member);
        return redirect(STORAGE_PAGE);
    }

    /**
     * メンバー保存
     *
     * @param member
     * @return
     */
    protected Member saveMember(Member member) {
        if (member == null) {
            return null;
        }
        Member store = memberService.insert(member);
        setLoginInfo2Session(store);
        return store;
    }

    /**
     * Local実行時のテスト用に擬似メンバー情報を作成
     *
     * @return
     */
    protected Member createTestMember() {
        Member member = new Member();
        member.setTwitterId(1L);
        member.setTwitterName("真");
        member.setTwitterScreenName("sinmetal");
        member
            .setTwitterProfileImageUrl("http://a2.twimg.com/profile_images/1042264867/1277990403846_bigger.png");
        return member;
    }
}
