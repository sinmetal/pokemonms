package jp.pokemonms.service;

import java.util.ArrayList;
import java.util.List;

import jp.pokemonms.model.Trick;
import jp.pokemonms.tester.generater.TrickGenerater;
import jp.pokemonms.tester.generater.constract.TrickName;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;

import com.google.appengine.api.datastore.Key;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * 技サービステスト
 *
 * @author Sinmetal
 *
 */
public class TrickServiceTest extends AppEngineTestCase {

    private TrickService service = new TrickService();

    private TrickGenerater trickGenerater = new TrickGenerater();

    /*
     * (非 Javadoc)
     *
     * @see org.slim3.tester.AppEngineTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        trickGenerater.run();
    }

    /**
     * コンストラクタ
     *
     * @throws Exception
     */
    @Test
    public void コンストラクタ() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    /**
     * 全技数を取得
     *
     * @throws Exception
     */
    @Test
    public void 全技数を取得() throws Exception {
        assertThat(service.count(), is(trickGenerater.count()));
    }

    /**
     * 指定した技名のEntityを取得
     *
     * @throws Exception
     */
    @Test
    public void 指定した技名のEntityを取得() throws Exception {
        Trick tackle = trickGenerater.get(TrickName.TACKLE);

        Trick store = service.findByTrickName(tackle.getTrickName());
        assertThat(store, is(notNullValue()));
        assertThat(store.getKey(), is(tackle.getKey()));
    }

    /**
     * 存在しない技名を指定した場合はnull
     *
     * @throws Exception
     */
    @Test
    public void 存在しない技名を指定した場合はnull() throws Exception {
        Trick store = service.findByTrickName("存在しないよ");
        assertThat(store, is(nullValue()));
    }

    /**
     * 指定した技名に該当するKey一覧を取得
     *
     * @throws Exception
     */
    @Test
    public void 指定した技名に該当するKey一覧を取得() throws Exception {
        Trick tackle = trickGenerater.get(TrickName.TACKLE);
        Trick solarbeam = trickGenerater.get(TrickName.SOLARBEAM);
        Trick glowl = trickGenerater.get(TrickName.GROWL);

        List<String> trickNames = new ArrayList<String>();
        trickNames.add(tackle.getTrickName());
        trickNames.add(solarbeam.getTrickName());
        trickNames.add(glowl.getTrickName());

        List<Key> trickKeys = service.getKeys(trickNames);
        assertThat(trickKeys.size(), is(trickNames.size()));
        assertThat(trickKeys.get(0), is(tackle.getKey()));
        assertThat(trickKeys.get(1), is(solarbeam.getKey()));
        assertThat(trickKeys.get(2), is(glowl.getKey()));
    }

    /**
     * 存在しない技名を取得
     *
     * @throws Exception
     */
    @Test
    public void 存在しない技名を取得() throws Exception {
        Trick tackle = trickGenerater.get(TrickName.TACKLE);
        Trick solarbeam = trickGenerater.get(TrickName.SOLARBEAM);

        List<String> trickNames = new ArrayList<String>();
        trickNames.add(tackle.getTrickName());
        trickNames.add(solarbeam.getTrickName());
        trickNames.add("そんな技はない");

        List<Key> trickKeys = service.getKeys(trickNames);
        assertThat(trickKeys.size(), is(2));
        assertThat(trickKeys.get(0), is(tackle.getKey()));
        assertThat(trickKeys.get(1), is(solarbeam.getKey()));
    }

    /**
     * 存在しない技名のみを渡すテスト
     *
     * @throws Exception
     */
    @Test
    public void 存在しない技名のみを渡すテスト() throws Exception {
        List<String> trickNames = new ArrayList<String>();
        trickNames.add("ほげ");
        trickNames.add("ふがほがががが");

        List<Key> trickKeys = service.getKeys(trickNames);
        assertThat(trickKeys.size(), is(0));
    }

    /**
     * 空のリストからTrickKeyを取得
     *
     * @throws Exception
     */
    @Test
    public void 空のリストからTrickKeyを取得() throws Exception {
        List<String> trickNames = new ArrayList<String>();

        List<Key> trickKeys = service.getKeys(trickNames);
        assertThat(trickKeys.size(), is(0));
    }
}
