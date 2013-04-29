package jp.pokemonms.tester.generater;

import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.model.Trick;
import jp.pokemonms.service.TrickService;
import jp.pokemonms.tester.generater.constract.TrickName;

/**
 * 技ジェネレーター
 * 
 * @author Sinmetal
 * 
 */
public class TrickGenerater {

    /** 技サービス */
    private TrickService trickService = new TrickService();

    /** 作成した技Map */
    private Map<TrickName, Trick> trickMap = new HashMap<TrickName, Trick>();

    /**
     * テストデータをDatastoreに登録
     */
    public void run() {
        trickMap.put(TrickName.TACKLE, createTackle());
        trickMap.put(TrickName.VINE_WHIP, createVineWhip());
        trickMap.put(TrickName.SOLARBEAM, createSolarbeam());
        trickMap.put(TrickName.GROWL, createGrowl());
        trickMap.put(TrickName.LEAF_BLADE, createLeafBlade());
        trickMap.put(TrickName.PROTECT, createProtect());
        trickMap.put(TrickName.SUNNY_DAY, createSunnyDay());
        trickMap.put(TrickName.SWORDS_DANCE,createSwordsDance());
    }

    /**
     * 指定された技を取得
     * 
     * @param trickName
     * @return
     */
    public Trick get(TrickName trickName) {
        return trickMap.get(trickName);
    }

    /**
     * 作成した技の数を取得
     * 
     * @return
     */
    public int count() {
        return trickMap.size();
    }

    /**
     * たいあたりの技Modelを作成
     * 
     * @return
     */
    private Trick createTackle() {
        final TrickName TACKLE = TrickName.TACKLE;

        TrickForm form = new TrickForm();
        form.setTrickName(TACKLE.getName());
        return createTrick(form.getMap());
    }

    /**
     * つるのムチの技Modelを作成
     * 
     * @return
     */
    private Trick createVineWhip() {
        final TrickName VINE_WHIP = TrickName.VINE_WHIP;

        TrickForm form = new TrickForm();
        form.setTrickName(VINE_WHIP.getName());
        return createTrick(form.getMap());
    }

    /**
     * ソーラービームの技Modelを作成
     * 
     * @return
     */
    private Trick createSolarbeam() {
        final TrickName SOLARBEAM = TrickName.SOLARBEAM;

        TrickForm form = new TrickForm();
        form.setTrickName(SOLARBEAM.getName());
        return createTrick(form.getMap());
    }

    /**
     * なきごえの技Modelを作成
     * 
     * @return
     */
    private Trick createGrowl() {
        final TrickName GROWL = TrickName.GROWL;

        TrickForm form = new TrickForm();
        form.setTrickName(GROWL.getName());
        return createTrick(form.getMap());
    }

    /**
     * リーフブレードの技Modelを作成
     * 
     * @return リーフブレードの技Model
     */
    private Trick createLeafBlade() {
        final TrickName LEAF_BLADE = TrickName.LEAF_BLADE;

        TrickForm form = new TrickForm();
        form.setTrickName(LEAF_BLADE.getName());
        return createTrick(form.getMap());
    }

    /**
     * まもるの技Modelを作成
     * 
     * @return まもるの技Model
     */
    private Trick createProtect() {
        final TrickName PROTECT = TrickName.PROTECT;

        TrickForm form = new TrickForm();
        form.setTrickName(PROTECT.getName());
        return createTrick(form.getMap());
    }

    /**
     * にほんばれの技Modelを作成
     * 
     * @return にほんばれの技Model
     */
    private Trick createSunnyDay() {
        final TrickName SUNNY_DAY = TrickName.SUNNY_DAY;

        TrickForm form = new TrickForm();
        form.setTrickName(SUNNY_DAY.getName());
        return createTrick(form.getMap());
    }

    /**
     * つるぎのまいの技Modelを作成
     * 
     * @return つるぎのまいの技Model
     */
    private Trick createSwordsDance() {
        final TrickName SWORDS_DANCE = TrickName.SWORDS_DANCE;

        TrickForm form = new TrickForm();
        form.setTrickName(SWORDS_DANCE.getName());
        return createTrick(form.getMap());
    }

    /**
     * Datastoreに技を登録
     * 
     * @param trick
     * @return
     */
    private Trick createTrick(Map<String, Object> map) {
        Trick trick = Trick.getInstance(map);
        return trickService.insert(trick);
    }

    /**
     * 技用の入力フォーム 本体には、管理用の登録しかないため、テスト用に簡易で作った。
     * 
     * @author Sinmetal
     * 
     */
    private class TrickForm {
        private HashMap<String, Object> map = new HashMap<String, Object>();

        public Map<String, Object> getMap() {
            return map;
        }

        public void setTrickName(String trickName) {
            map.put("trickName", trickName);
        }
    }
}
