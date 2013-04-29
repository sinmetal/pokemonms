package jp.pokemonms.controller.member;

import jp.pokemonms.exception.NotFoundRuntimeException;
import jp.pokemonms.model.Member;
import jp.pokemonms.service.MemberService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;

/**
 * MemberIndexController
 * @author Sinmetal
 *
 */
public class IndexController extends Controller {

    private MemberService memberService = new MemberService();

    /**
     * メンバー詳細ページ表示
     */
    @Override
    public Navigation run() throws Exception {
        long twitterId = getRequestTwitterId();
        Member member = memberService.getOrNull(twitterId);
        if (member == null) {
            throw new NotFoundRuntimeException();
        }

        requestScope("member", member);
        return forward("/member/index.jsp");
    }

    /**
     * リクエストパラメータからTwitterIDを取得
     * @return
     */
    private long getRequestTwitterId() {
        final String PARAMETER = "twitterId";

        Validators v = new Validators(request);
        v.add(PARAMETER, v.required(), v.longType(), v.longRange(1, Long.MAX_VALUE));
        if (v.validate()) {
            return Long.parseLong(requestScope(PARAMETER).toString());
        } else {
            throw new NotFoundRuntimeException();
        }
    }
}
