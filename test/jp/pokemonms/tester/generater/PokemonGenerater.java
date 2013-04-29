package jp.pokemonms.tester.generater;

import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.model.Pokemon;
import jp.pokemonms.service.PokemonService;
import jp.pokemonms.tester.generater.constract.PokemonName;

/**
 * ポケモン図鑑ジェネレーター
 *
 * @author Sinmetal
 *
 */
public class PokemonGenerater {

    /** ポケモン図鑑サービス */
    private PokemonService pokemonService = new PokemonService();

    private Map<PokemonName, Pokemon> pokemonMap =
        new HashMap<PokemonName, Pokemon>();

    /**
     * テストデータをDatastoreに登録
     */
    public void run() {
        pokemonMap.put(PokemonName.BULBASAUR, createBulbasaur());
        pokemonMap.put(PokemonName.TYPHLOSION, createTyphlosion());
        pokemonMap.put(PokemonName.LEAFEON, createLeafeon());
    }

    /**
     * 指定したポケモン図鑑Modelを取得
     *
     * @param pokemonName
     * @return
     */
    public Pokemon get(PokemonName pokemonName) {
        return pokemonMap.get(pokemonName);
    }

    /**
     * 作成したポケモンの数を取得
     *
     * @return
     */
    public int count() {
        return pokemonMap.size();
    }

    /**
     * フシギダネの図鑑Modelを作成
     *
     * @return
     */
    private Pokemon createBulbasaur() {
        final PokemonName BULBASAUR = PokemonName.BULBASAUR;

        Pokemon pokemon = new Pokemon();
        pokemon.setWorldGuideNo(BULBASAUR.getValue());
        pokemon.setPokemonName(BULBASAUR.getName());
        pokemon.setBreedH(45);
        pokemon.setBreedA(49);
        pokemon.setBreedB(49);
        pokemon.setBreedC(65);
        pokemon.setBreedD(65);
        pokemon.setBreedS(45);
        pokemon.setKey(Pokemon.createKey(BULBASAUR.getValue(), BULBASAUR.getName()));
        return pokemonService.insert(pokemon);
    }

    /**
     * バクフーンの図鑑Modelを作成
     *
     * @return
     */
    private Pokemon createTyphlosion() {
        final PokemonName TYPHLOSION = PokemonName.TYPHLOSION;

        Pokemon pokemon = new Pokemon();
        pokemon.setWorldGuideNo(TYPHLOSION.getValue());
        pokemon.setPokemonName(TYPHLOSION.getName());
        pokemon.setBreedH(78);
        pokemon.setBreedA(84);
        pokemon.setBreedB(78);
        pokemon.setBreedC(109);
        pokemon.setBreedD(85);
        pokemon.setBreedS(100);
        pokemon.setKey(Pokemon.createKey(TYPHLOSION.getValue(), TYPHLOSION.getName()));
        return pokemonService.insert(pokemon);
    }

    /**
     * リーフィアの図鑑Modelを作成
     *
     * @return
     */
    private Pokemon createLeafeon() {
        final PokemonName LEAFEON = PokemonName.LEAFEON;

        Pokemon pokemon = new Pokemon();
        pokemon.setWorldGuideNo(LEAFEON.getValue());
        pokemon.setPokemonName(LEAFEON.getName());
        pokemon.setBreedH(65);
        pokemon.setBreedA(110);
        pokemon.setBreedB(130);
        pokemon.setBreedC(60);
        pokemon.setBreedD(65);
        pokemon.setBreedS(95);
        pokemon.setKey(Pokemon.createKey(LEAFEON.getValue(), LEAFEON.getName()));
        return pokemonService.insert(pokemon);
    }
}
