package jp.pokemonms.model.json.storage;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jp.pokemonms.model.constant.GenderType;
import jp.pokemonms.model.constant.PersonType;
import jp.pokemonms.model.json.common.AwakenPower;
import jp.pokemonms.model.json.common.IndividualStatus;
import jp.pokemonms.model.json.common.PokemonStatus;
import jp.pokemonms.util.JsonUtil;

import com.google.appengine.api.datastore.Key;
import com.google.gson.Gson;

/**
 * 育成前のポケモンストレージ
 * 
 * @author sinmetal
 *
 */
public class Rookie implements Serializable {

    /** SerialVersionID */
    private static final long serialVersionUID = 1L;

    /** ID */
    private Integer id;

    /** メンバーKey */
    private Key memberKey;

    /** ポケモン図鑑Key */
    private Key pokemonKey;

    /** ニックネーム */
    private String nickname;

    /** 性格 */
    private PersonType person;

    /** 性別 */
    private GenderType gender;

    /** 特性Key */
    private Key abilityKey;

    /** 個体値 */
    private IndividualStatus individual;
    
    /** 努力値 */
    private PokemonStatus effort;
    
    /** 能力値 */
    private PokemonStatus power;
    
    /** 技Key一覧 */
    private List<Key> trickKeys;

    /** めざめるパワー */
    private AwakenPower awakenPower;

    /** 備考 */
    private String remark;

    /** 登録日時 */
    private Date entryDate;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * @return the memberKey
     */
    public Key getMemberKey() {
        return memberKey;
    }

    /**
     * @param memberKey the memberKey to set
     */
    public void setMemberKey(Key memberKey) {
        this.memberKey = memberKey;
    }

    /**
     * @return the pokemonKey
     */
    public Key getPokemonKey() {
        return pokemonKey;
    }

    /**
     * @param pokemonKey the pokemonKey to set
     */
    public void setPokemonKey(Key pokemonKey) {
        this.pokemonKey = pokemonKey;
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the person
     */
    public PersonType getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(PersonType person) {
        this.person = person;
    }

    /**
     * @return the gender
     */
    public GenderType getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    /**
     * @return the abilityKey
     */
    public Key getAbilityKey() {
        return abilityKey;
    }

    /**
     * @param abilityKey the abilityKey to set
     */
    public void setAbilityKey(Key abilityKey) {
        this.abilityKey = abilityKey;
    }

    /**
     * @return the individual
     */
    public IndividualStatus getIndividual() {
        return individual;
    }

    /**
     * @param individual the individual to set
     */
    public void setIndividual(IndividualStatus individual) {
        this.individual = individual;
    }

    /**
     * @return the effort
     */
    public PokemonStatus getEffort() {
        return effort;
    }

    /**
     * @param effort the effort to set
     */
    public void setEffort(PokemonStatus effort) {
        this.effort = effort;
    }

    /**
     * @return the power
     */
    public PokemonStatus getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(PokemonStatus power) {
        this.power = power;
    }

    /**
     * @return the trickKeys
     */
    public List<Key> getTrickKeys() {
        return trickKeys;
    }

    /**
     * @param trickKeys the trickKeys to set
     */
    public void setTrickKeys(List<Key> trickKeys) {
        this.trickKeys = trickKeys;
    }

    /**
     * @return the awakenPower
     */
    public AwakenPower getAwakenPower() {
        return awakenPower;
    }

    /**
     * @param awakenPower the awakenPower to set
     */
    public void setAwakenPower(AwakenPower awakenPower) {
        this.awakenPower = awakenPower;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the entryDate
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * @param entryDate the entryDate to set
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * JSONに変換する
     * 
     * @param rookie 育成前ポケモン
     * @return rookieをJSONに変換した値
     */
    public static String toJson(Rookie rookie) {
        Gson gson = JsonUtil.createGson();
        return gson.toJson(rookie, Rookie.class);
    }
    
    /**
     * JSONを変換する
     * 
     * @param json RookieのJSON
     * @return Rookieインスタンス
     */
    public static Rookie fromJson(String json) {
        Gson gson = JsonUtil.createGson();
        return gson.fromJson(json, Rookie.class);
    }
}
