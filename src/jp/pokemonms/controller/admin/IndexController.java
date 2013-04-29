package jp.pokemonms.controller.admin;

import jp.pokemonms.exception.ConfigRuntimeException;
import jp.pokemonms.model.config.TwitterConfig;
import jp.pokemonms.service.AdminService;
import jp.pokemonms.service.ConfigService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

/**
 * 管理者用トップページ
 * @author Sinmetal
 *
 */
public class IndexController extends Controller {

    /** 管理用サービス */
    private AdminService adminService = new AdminService();

    /** 設定サービス */
    private ConfigService configService = new ConfigService();

    /**
     * 管理者用トップページ表示
     */
    @Override
    public Navigation run() throws Exception {
        TwitterConfig twitterConfig = getTwitterConfig();
        requestScope("twitterConsumerKey", twitterConfig.getConsumerKey());
        requestScope("twitterConsumerSecret", twitterConfig.getConsumerSecret());

        requestScope("pokemonCount", adminService.countPokemon());
        requestScope("abilityCount", adminService.countAbility());
        requestScope("trickCount", adminService.countTrick());

        requestScope("memberCount", adminService.countMember());
        return forward("index.jsp");
    }

    /**
     * TwitterConfig取得
     *
     * @return
     */
    private TwitterConfig getTwitterConfig() {
        TwitterConfig config;
        try {
            config = configService.getTwitterConfig();
        } catch (ConfigRuntimeException e) {
            config = new TwitterConfig();
            config.setConsumerKey("設定無し");
            config.setConsumerSecret("設定無し");
        }

        return config;
    }
}
