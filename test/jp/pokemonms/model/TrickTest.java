package jp.pokemonms.model;

import java.util.HashMap;

import jp.pokemonms.meta.TrickMeta;

import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;
import org.slim3.util.BeanUtil;
import org.junit.Test;

import com.google.appengine.api.datastore.Key;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * 技モデルテスト
 * @author Sinmetal
 *
 */
public class TrickTest extends AppEngineTestCase {

    private Trick model = new Trick();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }

    @Test
    public void Keyを技名にする() throws Exception {
        final String TRICK_NAME = "アイアンテール";
        Key key = Datastore.createKey(TrickMeta.get(), TRICK_NAME);
        model.setKey(key);
        model.setTrickName(TRICK_NAME);
        Datastore.put(model);

        Trick store = Datastore.get(TrickMeta.get(), key);
        assertThat(store, is(notNullValue()));
        assertThat(store.getKey().getName(), is(TRICK_NAME));
        assertThat(store.getTrickName(), is(TRICK_NAME));
    }

    @Test
    public void インスタンス生成() throws Exception {
        final String TRICK_NAME = "アイアンテール";
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("trickName", TRICK_NAME);

        Trick trick = new Trick();
//        Trick trick = Trick.getInstance(map);
//        assertThat(trick.getTrickName(), is(TRICK_NAME));

        BeanUtil.copy(map, trick);
        assertThat(trick.getTrickName(), is(TRICK_NAME));
    }
}
