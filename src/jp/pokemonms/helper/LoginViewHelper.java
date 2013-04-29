package jp.pokemonms.helper;

import org.apache.commons.lang3.StringEscapeUtils;

import jp.pokemonms.var.LoginInfo;

/**
 * ログイン情報表示ヘルパー
 * @author Sinmetal
 *
 */
public class LoginViewHelper {

    /** ログイン情報 */
    private LoginInfo loginInfo;

    /**
     * コンストラクタ
     *
     * @param loginInfo
     */
    private LoginViewHelper(LoginInfo loginInfo) {
        this.loginInfo = loginInfo;
    }

    /**
     * トップメニューのログイン者名取得
     *
     * @return
     */
    public String getTopMenuViewName() {
        if (loginInfo == null) {
            return "<a href=/authntication/>ログイン</a>";
        } else {
            return String.format("<a href=\"#\" class=\"menu\">%s</a>",
                StringEscapeUtils.escapeHtml4(loginInfo.getTwitterScreenName()));
        }
    }

    /**
     * @return
     * @see jp.pokemonms.var.LoginInfo#getTwitterId()
     */
    public long getTwitterId() {
        return loginInfo.getTwitterId();
    }

    /**
     * @return
     * @see jp.pokemonms.var.LoginInfo#getTwitterName()
     */
    public String getTwitterName() {
        return loginInfo.getTwitterName();
    }

    /**
     * @return
     * @see jp.pokemonms.var.LoginInfo#getTwitterProfileImageUrl()
     */
    public String getTwitterProfileImageUrl() {
        return loginInfo.getTwitterProfileImageUrl();
    }

    /**
     * @return
     * @see jp.pokemonms.var.LoginInfo#getTwitterScreenName()
     */
    public String getTwitterScreenName() {
        return loginInfo.getTwitterScreenName();
    }

    /**
     * インスタンス生成
     *
     * @param loginInfo
     * @return
     */
    public static LoginViewHelper getInstance(LoginInfo loginInfo) {
        return new LoginViewHelper(loginInfo);
    }
}
