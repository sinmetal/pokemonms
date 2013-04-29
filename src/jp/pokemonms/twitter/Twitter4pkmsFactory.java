package jp.pokemonms.twitter;

import jp.pokemonms.model.config.TwitterConfig;
import jp.pokemonms.service.ConfigService;

/**
 *
 * PokemonMS用TwitterAPIFactory
 *
 * @author Sinmetal
 *
 */
public class Twitter4pkmsFactory {

    /**
     * PokemonMS用TwitterAPIオブジェクト生成
     *
     * @return
     */
    public Twitter4pkms getInstance() {
        ConfigService service = new ConfigService();
        TwitterConfig config = service.getTwitterConfig();
        return new Twitter4pkms(config.getConsumerKey(), config.getConsumerSecret());
    }
}
