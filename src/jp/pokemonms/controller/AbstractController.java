package jp.pokemonms.controller;

import jp.pokemonms.model.Member;
import jp.pokemonms.var.LoginInfo;

import org.slim3.controller.Controller;

/**
 * AbstractController
 * @author Sinmetal
 *
 */
public abstract class AbstractController extends Controller {

    /** ログイン情報 SessionKey */
    public final String LOGIN_INFO = "loginInfo";

    /**
     * ログイン状態かどうか
     * @return
     */
    public boolean isLogin() {
        LoginInfo loginInfo = sessionScope(LOGIN_INFO);
        return (loginInfo != null);
    }

    /**
     * Session から ログイン情報を取得
     * @return
     */
    public LoginInfo getLoginInfo2Session() {
        return sessionScope(LOGIN_INFO);
    }

    /**
     * Session に、ログイン情報を設定
     * @param member
     */
    public void setLoginInfo2Session(Member member) {
        LoginInfo loginInfo = LoginInfo.getInstance(member);
        sessionScope(LOGIN_INFO, loginInfo);
    }

    /**
     * ログイン情報から、TwitterIDを取得
     * @return
     */
    public long getTwitterId() {
        LoginInfo loginInfo =  getLoginInfo2Session();
        return loginInfo.getTwitterId();
    }

    /**
     * ログアウト
     */
    public void logout() {
        removeSessionScope(LOGIN_INFO);
    }
}
