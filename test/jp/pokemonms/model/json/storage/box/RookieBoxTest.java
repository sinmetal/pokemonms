package jp.pokemonms.model.json.storage.box;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import jp.pokemonms.meta.json.storage.box.RookieBoxMeta;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.json.storage.Rookie;

import org.junit.Before;
import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Key;

/**
 * 育成前ポケモンBOXテスト
 * 
 * @author sinmetal
 *
 */
public class RookieBoxTest extends AppEngineTestCase {
        
    /**
     * 値が入っているBoxをJSONに変換した場合に、元のインスタンスに戻せる事を確認
     * 
     * @author sinmetal
     * 
     */
    public static class 値が入っているBoxのJSON変換テスト extends AppEngineTestCase {
        /** JSON変換前インスタンス */
        private RookieBox before;
        /** JSON変換後インスタンス */
        private RookieBox after;
        
        /**
         * テスト用の下準備を行う before → JSON → after
         */
        @Before
        public void setUp() throws Exception {
            super.setUp();
            final List<Rookie> testRookies = createTestRookies();
            before = new RookieBox() {
                private static final long serialVersionUID = 1L;
                {
                    setMemberKey(Member.createKey(1L));
                    setRookies(testRookies);
                }
            };
            String json = RookieBox.toJson(before);
            after = RookieBox.fromJson(json);
        }
        
        /**
         * Datastoreに登録できることを確認
         */
        public void Datastoreに登録できることを確認() {
            final Key key = Datastore.put(before);
            final RookieBox store = Datastore.get(RookieBoxMeta.get(), key);
            assertThat(store, is(notNullValue()));
            assertThat(before.getKey(), is(store.getKey()));
            assertTrue(before.getRookies().size() > 0);
            assertThat(before.getRookies().size(), is(store.getRookies().size()));
        }
        
        /**
         * テスト用の育成前ポケモンデータ一覧作成
         * 
         * @return テスト用育成前ポケモンデータ一覧
         */
        private List<Rookie> createTestRookies() {
            final List<Rookie> testRookies = new ArrayList<Rookie>();
            final Rookie rookie1 = new Rookie();
            rookie1.setId(1);
            testRookies.add(rookie1);
            return testRookies;
        }
        
        /**
         * JSON変換後の文字列が１文字以上あることを確認<br>
         * JSON変換時にExceptionが投げられない事を確認している。
         */
        @Test
        public void JSON変換後の文字列が1文字以上あること() {
            assertTrue(RookieBox.toJson(before).length() > 0);
        }
        
        /**
         * MemberKeyをJSON変換してインスタンスに戻せる事を確認
         */
        @Test
        public void MemberKeyをJSON変換してインスタンスに戻せる事を確認() {
            Key key = after.getMemberKey();
            assertThat(key, is(notNullValue()));
            assertThat(key.toString(), is(before.getMemberKey().toString()));
        }
        
        /**
         * RookieListをJSON変換してインスタンスに戻せることを確認()
         */
        @Test
        public void RookieListをJSON変換してインスタンスに戻せることを確認() {
            List<Rookie> rookies = after.getRookies();
            assertThat(rookies, is(notNullValue()));
            assertThat(rookies.size(), is(1));
        }
    }
    
    /**
     * 空のBoxをJSON変換した場合に、元のインスタンスに戻せる事を確認
     * 
     * @author sinmetal
     *
     */
    public static class 空のBoxのJSON変換テスト extends AppEngineTestCase {
        /** JSON変換前インスタンス */
        private RookieBox before;
        /** JSON変換後インスタンス */
        private RookieBox after;
        
        /**
         * テスト用の下準備を行う before → JSON → after
         */
        @Before
        public void setUp() throws Exception {
            super.setUp();
            before = new RookieBox();
            String json = RookieBox.toJson(before);
            after = RookieBox.fromJson(json);
        }
        
        /**
         * JSON変換後の文字列が１文字以上あることを確認<br>
         * JSON変換時にExceptionが投げられない事を確認している。
         */
        @Test
        public void JSON変換後の文字列が1文字以上あること() {
            assertTrue(RookieBox.toJson(before).length() > 0);
        }

        /**
         * MemberKeyがnullの状態でJSON変換してインスタンスに戻せる事を確認
         */
        @Test
        public void MemberKeyがnullの状態でJSON変換してインスタンスに戻せる事を確認() {
            assertThat(after.getMemberKey(), nullValue());
            assertThat(after.getMemberKey(), is(before.getMemberKey()));
        }
    }
}
