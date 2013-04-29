package jp.pokemonms.logic.pokemon;

import jp.pokemonms.model.Pokemon;
import jp.pokemonms.model.constant.PersonType;
import jp.pokemonms.model.constant.StatusType;
import jp.pokemonms.var.PokemonStatus;
import jp.pokemonms.var.PokemonStatus4Individual;

import org.slim3.util.BeanUtil;

/**
 * 個体値計算ロジック
 * 
 * @author Sinmetal
 * 
 */
public class Individual {

    /** 最大Lv */
    private final int MAX_LV = 100;

    /** 個体値最大値 */
    private final int MAX_INDIVIDUAL = 31;

    /** ポケモン図鑑 */
    private Pokemon pokemon;

    /** 現在のLv */
    private Integer nowLv;

    /** 性格 */
    private PersonType person;

    /** ステータス */
    private PokemonStatus lvStatus;

    /** 努力値 */
    private PokemonStatus effortStatus;

    /** 個体値 */
    private PokemonStatus4Individual individual =
        new PokemonStatus4Individual();

    /**
     * @return pokemon
     */
    public Pokemon getPokemon() {
        return pokemon;
    }

    /**
     * @param pokemon
     *            セットする pokemon
     */
    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    /**
     * @return nowLv
     */
    public Integer getNowLv() {
        return nowLv;
    }

    /**
     * @param nowLv
     *            セットする nowLv
     */
    public void setNowLv(Integer nowLv) {
        this.nowLv = nowLv;
    }

    /**
     * @return person
     */
    public PersonType getPerson() {
        return person;
    }

    /**
     * @param person
     *            セットする person
     */
    public void setPerson(PersonType person) {
        this.person = person;
    }

    /**
     * @return lvStatus
     */
    public PokemonStatus getLvStatus() {
        return lvStatus;
    }

    /**
     * @param lvStatus
     *            セットする lvStatus
     */
    public void setLvStatus(PokemonStatus lvStatus) {
        this.lvStatus = lvStatus;
    }

    /**
     * @return effortStatus
     */
    public PokemonStatus getEffortStatus() {
        return effortStatus;
    }

    /**
     * @param effortStatus
     *            セットする effortStatus
     */
    public void setEffortStatus(PokemonStatus effortStatus) {
        this.effortStatus = effortStatus;
    }

    /**
     * @return individual
     */
    public PokemonStatus4Individual getIndividual() {
        return individual;
    }

    /**
     * @param individual
     *            セットする individual
     */
    public void setIndividual(PokemonStatus4Individual individual) {
        this.individual = individual;
    }

    /**
     * 実行処理
     * 
     * 全ステータスに対して、想定される全個体値を算出し、現在Lvのステータスを照合
     */
    public void run() {
        for (StatusType statusType : StatusType.getAll()) {
            if (!isRequired(statusType)) {
                continue;
            }
            // 個体値MAXの廃人用のツールなので、上から計る
            for (int i = MAX_INDIVIDUAL; i >= 0; i--) {
                int status = calculateStatus(statusType, i);
                if (status == lvStatus.get(statusType)) {
                    individual.set(statusType, i);
                }
            }
        }
    }

    /**
     * 必須項目を判定
     * 
     * @param statusType
     * @return
     */
    private boolean isRequired(StatusType statusType) {
        return (lvStatus.isExist(statusType) && effortStatus
            .isExist(statusType));
    }

    /**
     * ステータスを計算
     * 
     * @param type
     *            status type (HABCDS)
     * @param predictionIndividual
     *            予想個体値
     * @return
     */
    private int calculateStatus(StatusType type, int predictionIndividual) {
        if (StatusType.H.equals(type)) {
            return calculateStatusH(predictionIndividual);
        } else {
            return calculateStatusABCDS(predictionIndividual, type);
        }
    }

    /**
     * ステータスHを計算
     * 
     * 予想される個体値を引数に受け取り、現在Lvのステータスを返す<br />
     * ロジックはポケモン固有のもの
     * 
     * @param individualH
     *            予想される個体値H
     * @return
     */
    private int calculateStatusH(int individualH) {
        double nowLvPerMaxLv = (double) nowLv / MAX_LV;
        int status = pokemon.getBreedH() * 2;
        status = status + individualH + effortStatus.getH() / 4;
        status = (int) (status * nowLvPerMaxLv);
        status = status + 10 + nowLv;
        return status;
    }

    /**
     * ステータスABCDS計算
     * 
     * 予想される個体値を引数に受け取り、現在Lvのステータスを返す<br />
     * ロジックはポケモン固有のもの
     * 
     * @param individual
     *            予想される個体値ABCDS
     * @param statusType
     *            ステータスタイプ(ABCDS)
     * @return
     */
    private int calculateStatusABCDS(int individual, StatusType statusType) {
        double nowLvPerMaxLv = (double) nowLv / MAX_LV;
        int status = pokemon.getBreed(statusType) * 2;
        status = status + individual + effortStatus.get(statusType) / 4;
        status = (int) (status * nowLvPerMaxLv + 5);
        status = (int) (status * person.getWeight(statusType));
        return status;
    }

    /**
     * インスタンス生成
     * 
     * @param form
     * @param pokemon
     * @return
     */
    public static Individual getInstance(Object form, Pokemon pokemon) {
        Individual instance = new Individual();
        BeanUtil.copy(form, instance);
        instance.setPokemon(pokemon);
        instance.run();
        return instance;
    }
}
