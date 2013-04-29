package jp.pokemonms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.pokemonms.form.PokemonForm;
import jp.pokemonms.model.Ability;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.Pokemon;
import jp.pokemonms.model.Trick;
import jp.pokemonms.util.DateUtil;

import org.slim3.datastore.Datastore;
import org.slim3.util.StringUtil;

import com.google.appengine.api.datastore.Key;

/**
 * 管理用サービス
 * 
 * @author Sinmetal
 * 
 */
public class AdminService {

    /** ポケモン図鑑サービス */
    private PokemonService pokemonService = new PokemonService();

    /** 特性サービス */
    private AbilityService abilityService = new AbilityService();

    /** 技サービス */
    private TrickService trickService = new TrickService();

    /** メンバーサービス */
    private MemberService memberService = new MemberService();

    /**
     * ポケモン図鑑の数を返す
     * 
     * @return
     */
    public int countPokemon() {
        return pokemonService.count();
    }

    /**
     * 特性の数を返す
     * 
     * @return
     */
    public int countAbility() {
        return abilityService.count();
    }

    /**
     * 技の数を返す
     * 
     * @return
     */
    public int countTrick() {
        return trickService.count();
    }

    /**
     * メンバーの数を取得
     * 
     * @return
     */
    public int countMember() {
        return memberService.count();
    }

    /**
     * メンバー登録
     * 
     * @param member
     * @return
     */
    public Member insertMember(Member member) {
        return memberService.insert(member);
    }

    /**
     * メンバー更新
     * 
     * @param member
     * @return
     */
    public Member updateMember(Member member) {
        return memberService.update(member);
    }

    /**
     * 技バッチ挿入
     * 
     * @param input
     * @return
     */
    public List<Key> insertBatch4Trick(Map<String, Object> input) {
        String trickData = input.get("trickData").toString();

        String[] lines = trickData.split("\r\n");

        List<Trick> tricks = new ArrayList<Trick>();
        for (String line : lines) {
            Trick trick = new Trick();
            trick.setKey(Trick.createKey(line));
            trick.setTrickName(line); // 現状、入力データは技名のみ
            tricks.add(trick);
        }

        return Datastore.put(tricks);
    }

    /**
     * 技データ全削除
     */
    public void clearTrick() {
        List<Key> allTrickKeys = Datastore.query(Trick.class).asKeyList();
        Datastore.delete(allTrickKeys);
    }

    /**
     * 特性バッチ挿入
     * 
     * @param input
     * @return
     */
    public List<Key> insertBatch4Ability(Map<String, Object> input) {
        String abilityData = input.get("abilityData").toString();

        String[] lines = abilityData.split("\r\n");

        List<Ability> abilitys = new ArrayList<Ability>();
        for (String line : lines) {
            Ability ability = new Ability();
            ability.setKey(Ability.createKey(line));
            ability.setAbilityName(line); // 現状、入力データは特性名のみ
            abilitys.add(ability);
        }

        return Datastore.put(abilitys);
    }

    /**
     * 特性データ全削除
     */
    public void clearAbility() {
        List<Key> allAbilityKeys = Datastore.query(Ability.class).asKeyList();
        Datastore.delete(allAbilityKeys);
    }

    /**
     * 図鑑バッチ挿入
     * 
     * @param forms
     * @return
     */
    public List<Key> insertBatch4Pokemon(List<PokemonForm> forms) {
        AbilityList abilityList = new AbilityList();
        List<Pokemon> pokemons = new ArrayList<Pokemon>();

        for (PokemonForm form : forms) {
            Pokemon pokemon = Pokemon.getInstance(form);
            Key key =
                Pokemon.createKey(
                    pokemon.getWorldGuideNo(),
                    pokemon.getPokemonName());
            pokemon.setKey(key);
            pokemon.setAbilityKey1st(abilityList.getKey(form
                .getAbilityName1st()));
            pokemon.setAbilityKey2nd(abilityList.getKey(form
                .getAbilityName2nd()));
            pokemon.setAbilityKey3rd(abilityList.getKey(form
                .getAbilityName3rd()));
            pokemon.setEntryDate(DateUtil.getNow());

            pokemons.add(pokemon);
        }

        return Datastore.put(pokemons);
    }

    /**
     * 特性一覧クラス
     * 
     */
    private class AbilityList {
        List<Ability> abilitys;

        public AbilityList() {
            AbilityService abilityService = new AbilityService();
            abilitys = abilityService.findAll();
        }

        public Key getKey(String abilityName) {
            Ability ability = findByAbilityName(abilityName);
            if (ability == null) {
                return null;
            }
            return ability.getKey();
        }

        private Ability findByAbilityName(String abilityName) {
            if (StringUtil.isEmpty(abilityName)) {
                return null;
            }

            for (Ability ability : abilitys) {
                if (abilityName.equals(ability.getAbilityName())) {
                    return ability;
                }
            }

            String errMsg =
                String.format("指定された特性が見つかりませんでした。(%s)", abilityName);
            throw new IllegalArgumentException(errMsg);
        }
    }
}
