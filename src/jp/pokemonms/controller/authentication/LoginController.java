package jp.pokemonms.controller.authentication;

import jp.pokemonms.controller.AbstractController;
import jp.pokemonms.twitter.Twitter4pkms;
import jp.pokemonms.twitter.Twitter4pkmsFactory;

import org.slim3.controller.Navigation;

import twitter4j.auth.RequestToken;

/**
 * AuthnticationLoginController
 *
 * @author Sinmetal
 *
 */
public class LoginController extends AbstractController {

    /**
     * Twitterへ認証・承認を要求
     */
    @Override
    public Navigation run() throws Exception {
        if ("127.0.0.1".equals(request.getRemoteHost())) {
            return forward(String.format("%s%s", basePath, "callback"));
        }

        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/callback");

        Twitter4pkms twitter = new Twitter4pkmsFactory().getInstance();
        RequestToken requestToken = twitter.createRequestToken(callbackURL.toString());
        sessionScope("requestToken", requestToken);
        response.sendRedirect(requestToken.getAuthorizationURL());
        return null;
    }
}
