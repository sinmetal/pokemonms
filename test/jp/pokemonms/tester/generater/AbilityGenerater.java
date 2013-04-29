package jp.pokemonms.tester.generater;

import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.model.Ability;
import jp.pokemonms.service.AbilityService;
import jp.pokemonms.tester.generater.constract.AbilityName;

import com.google.appengine.api.datastore.Key;

/**
 * 特性ジェネレーター
 *
 * @author Sinmetal
 *
 */
public class AbilityGenerater {

    /** 特性サービス */
    private AbilityService abilityService = new AbilityService();

    /** 作成した特性Map */
    private Map<AbilityName, Ability> abilityMap =
        new HashMap<AbilityName, Ability>();

    /**
     * テストデータをDatastoreに登録
     */
    public void run() {
        abilityMap.put(AbilityName.CHLOROPHYLL, createChlorophyll());
        abilityMap.put(AbilityName.ROUGHSKIN, createRoughSkin());
        abilityMap.put(AbilityName.SHEERFORCE, createSheerForce());
        abilityMap.put(AbilityName.MOLDBREAKER, createMoldBreaker());
        abilityMap.put(AbilityName.IRONFIST, createIronFist());
        abilityMap.put(AbilityName.KLUTZ, createKlutz());
        abilityMap.put(AbilityName.NOGUARD, createNoGuard());
        abilityMap.put(AbilityName.HUSTLE, createHustle());
        abilityMap.put(AbilityName.LEAFGUARD, createLeafGuard());
    }

    /**
     * 指定した特性Modelを取得
     *
     * @param abilityName
     * @return
     */
    public Ability get(AbilityName abilityName) {
        return abilityMap.get(abilityName);
    }

    /**
     * 作成した特性の数を取得
     *
     * @return
     */
    public int count() {
        return abilityMap.size();
    }

    /**
     * ようりょくその特性Modelを作成
     *
     * @return
     */
    private Ability createChlorophyll() {
        final AbilityName CHLOROPHYLL = AbilityName.CHLOROPHYLL;

        Ability chlorophyll = new Ability();
        chlorophyll.setAbilityName(CHLOROPHYLL.getName());
        return insert(chlorophyll);
    }

    /**
     * さめはだの特性Modelを作成
     *
     * @return
     */
    private Ability createRoughSkin() {
        final AbilityName ROUGHSKIN = AbilityName.ROUGHSKIN;

        Ability roughSkin = new Ability();
        roughSkin.setAbilityName(ROUGHSKIN.getName());
        return insert(roughSkin);
    }

    /**
     * ちからずくの特性Modelを作成
     *
     * @return
     */
    private Ability createSheerForce() {
        final AbilityName SHEERFORCE = AbilityName.SHEERFORCE;

        Ability sheerForce = new Ability();
        sheerForce.setAbilityName(SHEERFORCE.getName());
        return insert(sheerForce);
    }

    /**
     * かたやぶりの特性Modelを作成
     *
     * @return
     */
    private Ability createMoldBreaker() {
        final AbilityName MOLDBREAKER = AbilityName.MOLDBREAKER;

        Ability moldBreaker = new Ability();
        moldBreaker.setAbilityName(MOLDBREAKER.getName());
        return insert(moldBreaker);
    }

    /**
     * てつのこぶしの特性Modelを作成
     *
     * @return
     */
    private Ability createIronFist() {
        final AbilityName IRONFIST = AbilityName.IRONFIST;

        Ability ironFist = new Ability();
        ironFist.setAbilityName(IRONFIST.getName());
        return insert(ironFist);
    }

    /**
     * ぶきようの特性Modelを作成
     *
     * @return
     */
    private Ability createKlutz() {
        final AbilityName KLUTZ = AbilityName.KLUTZ;

        Ability klutz = new Ability();
        klutz.setAbilityName(KLUTZ.getName());
        return insert(klutz);
    }

    /**
     * ノーガードの特性Modelを作成
     *
     * @return
     */
    private Ability createNoGuard() {
        final AbilityName NOGUARD = AbilityName.NOGUARD;

        Ability noGuard = new Ability();
        noGuard.setAbilityName(NOGUARD.getName());
        return insert(noGuard);
    }

    /**
     * はりきりの特性Modelを作成
     *
     * @return
     */
    private Ability createHustle() {
        final AbilityName HUSTLE = AbilityName.HUSTLE;

        Ability hustle = new Ability();
        hustle.setAbilityName(HUSTLE.getName());
        return insert(hustle);
    }
    
    /**
     * リーフガードの特性Modelを作成
     * 
     * @return リーフガードの特性Model
     */
    private Ability createLeafGuard() {
        final AbilityName LEAF_GUARD = AbilityName.LEAFGUARD;
        
        Ability leafGuard = new Ability();
        leafGuard.setAbilityName(LEAF_GUARD.getName());
        return insert(leafGuard);
    }

    /**
     * Datastoreに特性を登録
     *
     * @param ability
     * @return
     */
    private Ability insert(Ability ability) {
        Key key = Ability.createKey(ability.getAbilityName());
        ability.setKey(key);
        return abilityService.insert(ability);
    }
}
