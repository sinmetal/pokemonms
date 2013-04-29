package jp.pokemonms.controller.storage.box;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.json.storage.box.RookieBox;
import jp.pokemonms.service.MemberService;
import jp.pokemonms.service.RookieBoxService;
import jp.pokemonms.util.JsonUtil;

/**
 * Box List Controller
 * 
 * @author sinmetal
 * 
 */
public class ListController extends JsonController {

    /** MemberService */
    private final MemberService memberService = new MemberService();

    /** 育成前ポケモンBoxService */
    private final RookieBoxService rookieBoxService = new RookieBoxService();

    /**
     * ログインしているメンバーのBox一覧を返す
     */
    @Override
    protected Map<String, Object> handle() throws Exception {
        final Map<String, Object> ret = new HashMap<String, Object>();
        final Long twitterId = getTwitterId();
        final Member member = memberService.get(twitterId);

        List<RookieBox> rookieBoxes = rookieBoxService.get(member.getBoxKeys());
        ret.put("rookieBoxes", JsonUtil.createGson().toJson(rookieBoxes));
        return ret;
    }
}
