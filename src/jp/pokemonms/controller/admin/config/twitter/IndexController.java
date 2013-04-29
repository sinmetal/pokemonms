package jp.pokemonms.controller.admin.config.twitter;

import jp.pokemonms.exception.ConfigRuntimeException;
import jp.pokemonms.model.config.TwitterConfig;
import jp.pokemonms.service.ConfigService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * AdminTwitterConfigIndexコントローラ
 *
 * @author Sinmetal
 *
 */
public class IndexController extends Controller {

    /** ConfigService */
    private ConfigService service = new ConfigService();

    /**
     * 設定情報画面表示
     *
     */
    @Override
    public Navigation run() throws Exception {
        String consumerKey = "";
        String consumerSecret = "";

        try {
            TwitterConfig config = service.getTwitterConfig();
            consumerKey = config.getConsumerKey();
            consumerSecret = config.getConsumerSecret();
        } catch (ConfigRuntimeException e) {
            consumerKey = "設定無し";
            consumerSecret = "設定無し";
        }
        requestScope("consumerKey", consumerKey);
        requestScope("consumerSecret",consumerSecret);
        return forward("index.jsp");
    }
}