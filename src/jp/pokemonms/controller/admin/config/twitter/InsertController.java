package jp.pokemonms.controller.admin.config.twitter;

import jp.pokemonms.service.ConfigService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

/**
 * TwitterConfig登録コントローラ
 *
 * @author Sinmetal
 *
 */
public class InsertController extends Controller {

    /** ConfigService */
    private ConfigService service = new ConfigService();

    /**
     * TwitterConfig登録
     *
     */
    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        String consumerKey = requestMap.get("consumerKey").toString();
        String consumerSecret = requestMap.get("consumerSecret").toString();
        service.setTwitterConfig(consumerKey, consumerSecret);
        return redirect(basePath);
    }
}
