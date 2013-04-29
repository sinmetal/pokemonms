package jp.pokemonms.controller.storage.box;

import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.form.storage.BoxForm;
import jp.pokemonms.service.BoxService;
import jp.pokemonms.var.LoginInfo;

import org.slim3.util.RequestMap;

import com.google.appengine.api.datastore.Key;

/**
 * StorageBoxEntryController
 * 
 * @author sinmetal
 * 
 */
public class EntryController extends JsonController {

    /** BoxService */
    private final BoxService boxService = new BoxService();

    /**
     * ログインユーザのBoxを登録
     */
    @Override
    protected Map<String, Object> handle() throws Exception {
        final Map<String, Object> ret = new HashMap<String, Object>();
        final LoginInfo loginInfo = getLoginInfo2Session();
        final Key loginMemberKey = loginInfo.getMemberKey();

        final RequestMap requestMap = new RequestMap(request);
        final BoxForm form = BoxForm.getInstance(requestMap);
        boxService.put4RookieBox(loginMemberKey, form);
        return ret;
    }
}
