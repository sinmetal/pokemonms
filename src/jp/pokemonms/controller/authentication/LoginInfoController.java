package jp.pokemonms.controller.authentication;

import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.var.LoginInfo;

/**
 * AuthenticationLoginInfoController
 * 
 * @author Sinmetal
 * 
 */
public class LoginInfoController extends JsonController {

    /**
     * ログイン中のユーザの情報を返す
     */
    @Override
    protected Map<String, Object> handle() throws Exception {
        Map<String, Object> ret = new HashMap<String, Object>();

        if (isLogin()) {
            LoginInfo loginInfo = getLoginInfo2Session();
            ret.put("loginInfo", loginInfo);
        }
        return ret;
    }
}