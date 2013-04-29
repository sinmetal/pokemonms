package jp.pokemonms.view;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.model.Ability;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.Pokemon;
import jp.pokemonms.model.Storage;
import jp.pokemonms.model.constant.ElementType;
import jp.pokemonms.model.constant.PersonType;
import jp.pokemonms.tester.util.IntegerUtil;
import jp.pokemonms.util.DateUtil;
import jp.pokemonms.util.JsonUtil;
import jp.pokemonms.util.KeyUtil;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.KeyFactory;
import com.google.gson.reflect.TypeToken;

/**
 * ストレージViewTest
 * 
 * @author sinmetal
 * 
 */
public class StorageViewTest extends AppEngineTestCase {

    /**
     * インスタンス生成
     * 
     * StorageModelからインスタンスを生成し、値が正常であることを確認
     */
    @Test
    public void インスタンス作成() {
        Storage storage = createTestStorage();

        StorageView view = StorageView.getInstance(storage);
        assertThat(view, is(notNullValue()));
        assertThat(view.getKey(), is(KeyFactory.keyToString(storage.getKey())));
        assertThat(view.getVersion(), is(storage.getVersion()));
        assertThat(
            view.getMemberKey(),
            is(KeyFactory.keyToString(storage.getMemberKey())));
        // TODO Box実装後に入れる
        assertThat(view.getBoxKey(), is(""));
        assertThat(
            view.getPokemonKey(),
            is(KeyFactory.keyToString(storage.getPokemonKey())));
        assertThat(view.getPokemonName(), is(storage.getPokemonName()));
        assertThat(view.getNickname(), is(storage.getNickname()));
        assertThat(view.getPersonName(), is(storage.getPersonName()));
        assertThat(view.getGenderName(), is(storage.getGenderName()));
        assertThat(
            view.getAbilityKey(),
            is(KeyFactory.keyToString(storage.getAbilityKey())));
        assertThat(view.getAbilityName(), is(storage.getAbilityName()));
        assertThat(
            view.getIndividualUpperH(),
            is(storage.getIndividualUpperH()));
        assertThat(
            view.getIndividualUpperA(),
            is(storage.getIndividualUpperA()));
        assertThat(
            view.getIndividualUpperB(),
            is(storage.getIndividualUpperB()));
        assertThat(
            view.getIndividualUpperC(),
            is(storage.getIndividualUpperC()));
        assertThat(
            view.getIndividualUpperD(),
            is(storage.getIndividualUpperD()));
        assertThat(
            view.getIndividualUpperS(),
            is(storage.getIndividualUpperS()));
        assertThat(
            view.getIndividualLowerH(),
            is(storage.getIndividualLowerH()));
        assertThat(
            view.getIndividualLowerA(),
            is(storage.getIndividualLowerA()));
        assertThat(
            view.getIndividualLowerB(),
            is(storage.getIndividualLowerB()));
        assertThat(
            view.getIndividualLowerC(),
            is(storage.getIndividualLowerC()));
        assertThat(
            view.getIndividualLowerD(),
            is(storage.getIndividualLowerD()));
        assertThat(
            view.getIndividualLowerS(),
            is(storage.getIndividualLowerS()));
        assertThat(view.getIndividualH(), is(storage.getIndividualH()));
        assertThat(view.getIndividualA(), is(storage.getIndividualA()));
        assertThat(view.getIndividualB(), is(storage.getIndividualB()));
        assertThat(view.getIndividualC(), is(storage.getIndividualC()));
        assertThat(view.getIndividualD(), is(storage.getIndividualD()));
        assertThat(view.getIndividualS(), is(storage.getIndividualS()));
        assertThat(view.getEffortH(), is(storage.getEffortH()));
        assertThat(view.getEffortA(), is(storage.getEffortA()));
        assertThat(view.getEffortB(), is(storage.getEffortB()));
        assertThat(view.getEffortC(), is(storage.getEffortC()));
        assertThat(view.getEffortD(), is(storage.getEffortD()));
        assertThat(view.getEffortS(), is(storage.getEffortS()));
        assertThat(view.getLv50H(), is(storage.getLv50H()));
        assertThat(view.getLv50A(), is(storage.getLv50A()));
        assertThat(view.getLv50B(), is(storage.getLv50B()));
        assertThat(view.getLv50C(), is(storage.getLv50C()));
        assertThat(view.getLv50D(), is(storage.getLv50D()));
        assertThat(
            view.getAwakenPowerElementName(),
            is(storage.getAwakenPowerElementName()));
        assertThat(view.getAwakenPowerEdge(), is(storage.getAwakenPowerEdge()));
        assertThat(view.getRemark(), is(storage.getRemark()));
        assertThat(
            view.getEntryDate(),
            is(DateUtil.toString(storage.getEntryDate())));
    }

    /**
     * 全項目入力JSON変換
     * 
     * 全項目を入力した状態で、JSON変換時に、値が正常であることを確認
     */
    @Test
    public void 全項目入力JSON変換() {
        Storage storage = createTestStorage();

        StorageView view = StorageView.getInstance(storage);
        String json = JsonUtil.createGson().toJson(view);

        Type mapType = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> afterJsonMap =
            JsonUtil.createGson().fromJson(json, mapType);
        Map<String, String> map = convertMapType(afterJsonMap);
        assertThat(KeyFactory.stringToKey(map.get("key")), is(storage.getKey()));
        assertThat(map.get("id"), is(String.valueOf(storage.getKey().getId())));
        assertThat(
            Double.parseDouble(map.get("version")),
            is(Double.parseDouble(storage.getVersion().toString())));
        assertThat(
            KeyFactory.stringToKey(map.get("memberKey")),
            is(storage.getMemberKey()));
        assertThat(
            KeyUtil.toKeyOrNull(afterJsonMap.get("boxKey").toString()),
            is(storage.getBoxKey()));
        assertThat(
            KeyFactory.stringToKey(map.get("pokemonKey")),
            is(storage.getPokemonKey()));
        assertThat(map.get("pokemonName"), is(storage.getPokemonName()));
        assertThat(map.get("nickname"), is(storage.getNickname()));
        assertThat(map.get("personName"), is(storage.getPersonName()));
        assertThat(map.get("genderName"), is(storage.getGenderName()));
        assertThat(
            KeyUtil.toKeyOrNull(map.get("abilityKey")),
            is(storage.getAbilityKey()));
        assertThat(map.get("abilityName"), is(storage.getAbilityName()));
        assertThat(
            map.get("individualUpperH"),
            is(IntegerUtil.toDoubleString(storage.getIndividualUpperH())));
        assertThat(
            map.get("individualUpperA"),
            is(IntegerUtil.toDoubleString(storage.getIndividualUpperA())));
        assertThat(
            map.get("individualUpperB"),
            is(IntegerUtil.toDoubleString(storage.getIndividualUpperB())));
        assertThat(
            map.get("individualUpperC"),
            is(IntegerUtil.toDoubleString(storage.getIndividualUpperC())));
        assertThat(
            map.get("individualUpperD"),
            is(IntegerUtil.toDoubleString(storage.getIndividualUpperD())));
        assertThat(
            map.get("individualUpperS"),
            is(IntegerUtil.toDoubleString(storage.getIndividualUpperS())));
        assertThat(
            map.get("individualLowerH"),
            is(IntegerUtil.toDoubleString(storage.getIndividualLowerH())));
        assertThat(
            map.get("individualLowerA"),
            is(IntegerUtil.toDoubleString(storage.getIndividualLowerA())));
        assertThat(
            map.get("individualLowerB"),
            is(IntegerUtil.toDoubleString(storage.getIndividualLowerB())));
        assertThat(
            map.get("individualLowerC"),
            is(IntegerUtil.toDoubleString(storage.getIndividualLowerC())));
        assertThat(
            map.get("individualLowerD"),
            is(IntegerUtil.toDoubleString(storage.getIndividualLowerD())));
        assertThat(
            map.get("individualLowerS"),
            is(IntegerUtil.toDoubleString(storage.getIndividualLowerS())));
        assertThat(map.get("individualH"), is(storage.getIndividualH()));
        assertThat(map.get("individualA"), is(storage.getIndividualA()));
        assertThat(map.get("individualB"), is(storage.getIndividualB()));
        assertThat(map.get("individualC"), is(storage.getIndividualC()));
        assertThat(map.get("individualD"), is(storage.getIndividualD()));
        assertThat(map.get("individualS"), is(storage.getIndividualS()));
        assertThat(
            map.get("effortH"),
            is(IntegerUtil.toDoubleString(storage.getEffortH())));
        assertThat(
            map.get("effortA"),
            is(IntegerUtil.toDoubleString(storage.getEffortA())));
        assertThat(
            map.get("effortB"),
            is(IntegerUtil.toDoubleString(storage.getEffortB())));
        assertThat(
            map.get("effortC"),
            is(IntegerUtil.toDoubleString(storage.getEffortC())));
        assertThat(
            map.get("effortD"),
            is(IntegerUtil.toDoubleString(storage.getEffortD())));
        assertThat(
            map.get("effortS"),
            is(IntegerUtil.toDoubleString(storage.getEffortS())));
        assertThat(
            map.get("lv50H"),
            is(IntegerUtil.toDoubleString(storage.getLv50H())));
        assertThat(
            map.get("lv50A"),
            is(IntegerUtil.toDoubleString(storage.getLv50A())));
        assertThat(
            map.get("lv50B"),
            is(IntegerUtil.toDoubleString(storage.getLv50B())));
        assertThat(
            map.get("lv50C"),
            is(IntegerUtil.toDoubleString(storage.getLv50C())));
        assertThat(
            map.get("lv50D"),
            is(IntegerUtil.toDoubleString(storage.getLv50D())));
        assertThat(
            map.get("lv50S"),
            is(IntegerUtil.toDoubleString(storage.getLv50S())));
        assertThat(
            map.get("awakenPowerElementName"),
            is(storage.getAwakenPowerElementName()));
        assertThat(
            map.get("awakenPowerEdge"),
            is(IntegerUtil.toDoubleString(storage.getAwakenPowerEdge())));
        assertThat(map.get("remark"), is(storage.getRemark()));
        assertThat(
            map.get("entryDate"),
            is(DateUtil.toString(storage.getEntryDate())));
    }

    /**
     * 入力が無い状態でJSON変換
     * 
     * 入力が無い状態で、JSON変換時に、項目が生成されるを確認
     */
    @Test
    public void 入力が無い状態でJSON変換() {
        Storage storage = new Storage();

        StorageView view = StorageView.getInstance(storage);
        String json = JsonUtil.createGson().toJson(view);

        Type mapType = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> afterJsonMap =
            JsonUtil.createGson().fromJson(json, mapType);
        Map<String, String> map = convertMapType(afterJsonMap);
        assertThat(map.get("key"), is(""));
        assertThat(map.get("id"), is(""));
        assertThat(map.containsKey("version"), is(true));
        assertThat(map.get("version"), is("0.0"));
        assertThat(map.get("memberKey"), is(""));
        assertThat(map.get("boxKey"), is(""));
        assertThat(map.get("pokemonKey"), is(""));
        assertThat(map.get("pokemonName"), is(""));
        assertThat(map.get("nickname"), is(""));
        assertThat(map.get("personName"), is(""));
        assertThat(map.get("genderName"), is(""));
        assertThat(map.get("abilityKey"), is(""));
        assertThat(map.get("abilityName"), is(""));
        // TODO とりあえず、べたがきにしておくが、Modelにでも定数を持たして、参照しようか？
        assertThat(map.get("individualUpperH"), is("-1.0"));
        assertThat(map.get("individualUpperA"), is("-1.0"));
        assertThat(map.get("individualUpperB"), is("-1.0"));
        assertThat(map.get("individualUpperC"), is("-1.0"));
        assertThat(map.get("individualUpperD"), is("-1.0"));
        assertThat(map.get("individualUpperS"), is("-1.0"));
        assertThat(map.get("individualLowerH"), is("99.0"));
        assertThat(map.get("individualLowerA"), is("99.0"));
        assertThat(map.get("individualLowerB"), is("99.0"));
        assertThat(map.get("individualLowerC"), is("99.0"));
        assertThat(map.get("individualLowerD"), is("99.0"));
        assertThat(map.get("individualLowerS"), is("99.0"));
        assertThat(map.get("effortH"), is("-1.0"));
        assertThat(map.get("effortA"), is("-1.0"));
        assertThat(map.get("effortB"), is("-1.0"));
        assertThat(map.get("effortC"), is("-1.0"));
        assertThat(map.get("effortD"), is("-1.0"));
        assertThat(map.get("effortS"), is("-1.0"));
        assertThat(map.get("lv50H"), is("-1.0"));
        assertThat(map.get("lv50A"), is("-1.0"));
        assertThat(map.get("lv50B"), is("-1.0"));
        assertThat(map.get("lv50C"), is("-1.0"));
        assertThat(map.get("lv50D"), is("-1.0"));
        assertThat(map.get("lv50S"), is("-1.0"));
        assertThat(map.get("awakenPowerElementName"), is(""));
        assertThat(map.get("awakenPowerEdge"), is("-1.0"));
        assertThat(map.get("remark"), is(""));
        assertThat(map.get("entryDate"), is(""));
    }

    /**
     * Test用のStorageModelを作成
     * 
     * @return Test用のStorageModel
     */
    private Storage createTestStorage() {
        Storage storage = new Storage();
        storage.setKey(Storage.createKey());
        storage.setVersion(470L);
        storage.setMemberKey(Member.createKey(1L));
        storage.setPokemonKey(Pokemon.createKey(470, "リーフィア"));
        storage.setNickname("フィア");
        storage.setPerson(PersonType.BRAT);
        storage.setAbilityKey(Ability.createKey("リーフガード"));
        storage.setIndividualUpperH(31);
        storage.setIndividualUpperA(31);
        storage.setIndividualUpperB(31);
        storage.setIndividualUpperC(31);
        storage.setIndividualUpperD(31);
        storage.setIndividualUpperS(31);
        storage.setIndividualLowerH(31);
        storage.setIndividualLowerA(31);
        storage.setIndividualLowerB(31);
        storage.setIndividualLowerC(31);
        storage.setIndividualLowerD(31);
        storage.setIndividualLowerS(31);
        storage.setEffortH(0);
        storage.setEffortA(255);
        storage.setEffortB(255);
        storage.setEffortC(0);
        storage.setEffortD(0);
        storage.setEffortS(0);
        storage.setLv50H(100);
        storage.setLv50A(100);
        storage.setLv50B(100);
        storage.setLv50C(100);
        storage.setLv50D(100);
        storage.setLv50S(100);
        storage.setAwakenPowerElement(ElementType.DARK);
        storage.setAwakenPowerEdge(75);
        storage.setRemark("かがくのちからってすげー");
        storage.setEntryDate(new Date());
        return storage;
    }

    /**
     * Mapの型をObjectからStringに変換する <br>
     * valueがnullの場合は、例外を投げる
     * 
     * @param map
     * @return ObjectをStringに変換したMap
     */
    private Map<String, String> convertMapType(Map<String, Object> map) {
        Map<String, String> resultMap = new HashMap<String, String>();
        for (String key : map.keySet()) {
            Object value = map.get(key);
            if (value == null) {
                throw new RuntimeException(String.format("%s is null", key));
            }
            resultMap.put(key, map.get(key).toString());
        }
        return resultMap;
    }
}
