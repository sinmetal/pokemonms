package jp.pokemonms.model.json.storage;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jp.pokemonms.model.Ability;
import jp.pokemonms.model.Member;
import jp.pokemonms.model.Pokemon;
import jp.pokemonms.model.Trick;
import jp.pokemonms.model.constant.ElementType;
import jp.pokemonms.model.constant.GenderType;
import jp.pokemonms.model.constant.PersonType;
import jp.pokemonms.model.json.common.AwakenPower;
import jp.pokemonms.model.json.common.IndividualStatus;
import jp.pokemonms.model.json.common.PokemonStatus;
import jp.pokemonms.util.DateUtil;

import org.junit.Before;
import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.google.appengine.api.datastore.Key;

/**
 * 育成前ポケモンストレージテスト
 * 
 * @author sinmetal
 * 
 */
public class RookieTest extends AppEngineTestCase {

    /**
     * 値が入っているRokieをJSONに変換した場合に、元のインスタンスに戻せる事を確認
     * 
     * @author sinmetal
     * 
     */
    public static class 値が入っているRookieのJSON変換テスト extends AppEngineTestCase {
        /** JSON変換前インスタンス */
        private Rookie before;
        /** JSON変換後インスタンス */
        private Rookie after;

        /**
         * テスト用の下準備を行う before → JSON → after
         */
        @Before
        public void setUp() throws Exception {
            super.setUp();
            before = new Rookie() {
                private static final long serialVersionUID = 1L;
                {
                    setId(1);
                    setMemberKey(Member.createKey(1L));
                    setPokemonKey(Pokemon.createKey(1, "フシギダネ"));
                    setNickname("フッシー");
                    setPerson(PersonType.BRAT);
                    setGender(GenderType.MALE);
                    setAbilityKey(Ability.createKey("ようりょくそ"));
                    setIndividual(new IndividualStatus(
                        new PokemonStatus(11, 12, 13, 14, 15, 16),
                        new PokemonStatus(1, 2, 3, 4, 5, 6)));
                    setEffort(new PokemonStatus(1, 2, 3, 4, 5, 6));
                    setPower(new PokemonStatus(10, 20, 30, 40, 50, 60));
                    List<Key> trickKeys = new ArrayList<Key>();
                    trickKeys.add(Trick.createKey("たいあたり"));
                    trickKeys.add(Trick.createKey("つるのムチ"));
                    trickKeys.add(Trick.createKey("ソーラービーム"));
                    trickKeys.add(Trick.createKey("なきごえ"));
                    setTrickKeys(trickKeys);
                    setAwakenPower(new AwakenPower(ElementType.FIRE, 10));
                    setRemark("びこうてすと");
                    setEntryDate(new Date());
                }
            };
            String json = Rookie.toJson(before);
            after = Rookie.fromJson(json);
        }

        /**
         * JSON変換後の文字列が１文字以上あることを確認<br>
         * JSON変換時にExceptionが投げられない事を確認している。
         */
        @Test
        public void JSON変換後の文字列が1文字以上あること() {
            assertTrue(Rookie.toJson(before).length() > 0);
        }

        /**
         * IDをJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void IDを変換() {
            assertThat(after.getId(), is(notNullValue()));
            assertThat(after.getId(), is(before.getId()));
        }

        /**
         * MemberKeyをJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void MemberKeyを変換() {
            Key key = after.getMemberKey();
            assertThat(key, is(notNullValue()));
            assertThat(key.toString(), is(before.getMemberKey().toString()));
        }

        /**
         * PokemonKeyをJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void PokemonKeyを変換() {
            Key key = after.getPokemonKey();
            assertThat(key, is(notNullValue()));
            assertThat(key.toString(), is(before.getPokemonKey().toString()));
        }
        
        /**
         * ニックネームをJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void ニックネームを変換() {
            assertThat(after.getNickname(), is(notNullValue()));
            assertThat(after.getNickname(), is(before.getNickname()));
        }
        
        /**
         * 性格をJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void 性格を変換() {
            assertThat(after.getPerson(), is(notNullValue()));
            assertThat(after.getPerson(), is(before.getPerson()));
        }
        
        /**
         * 性別をJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void 性別を変換() {
            assertThat(after.getGender(), is(notNullValue()));
            assertThat(after.getGender(), is(before.getGender()));
        }
        
        /**
         * 特性KeyをJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void 特性Keyを変換() {
            Key key = after.getAbilityKey();
            assertThat(key, is(notNullValue()));
            assertThat(key.toString(), is(before.getAbilityKey().toString()));
        }
        
        /**
         * 個体値をJSONに変換してインスタンスに戻せる事を確認
         */
        @Test
        public void 個体値をJSONに変換してインスタンスに戻せる事を確認() {
            assertThat(after.getIndividual(), is(notNullValue()));
            assertThat(after.getIndividual().getUpper(),
                is(before.getIndividual().getUpper()));
        }
        
        /**
         * 努力値をJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void 努力値を変換() {
            PokemonStatus effort = after.getEffort();
            assertThat(effort, is(notNullValue()));
            assertThat(effort, is(before.getEffort()));
        }
        
        /**
         * 能力値をJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void 能力値を変換() {
            PokemonStatus power = after.getPower();
            assertThat(power, is(notNullValue()));
            assertThat(power, is(before.getPower()));
        }
        
        /**
         * 技Key一覧をJSON変換してインスタンスに戻せる事を確認
         */
        @Test
        public void 技Key一覧をJSON変換してインスタンスに戻せる事を確認() {
            List<Key> keys = after.getTrickKeys();
            assertThat(keys, is(notNullValue()));
            assertThat(keys.size(), is(before.getTrickKeys().size()));
        }
        
        /**
         * めざめるパワーをJSON変換してインスタンスに戻せる事を確認
         */
        @Test
        public void めざめるパワーをJSON変換してインスタンスに戻せる事を確認() {
            AwakenPower afterAwakenPower = after.getAwakenPower();
            AwakenPower beforeAwakenPower = before.getAwakenPower();
            assertThat(afterAwakenPower, is(notNullValue()));
            assertThat(afterAwakenPower, is(beforeAwakenPower));
            assertThat(afterAwakenPower.getElement(), 
                is(beforeAwakenPower.getElement()));
            assertThat(afterAwakenPower.getEdge(), is(beforeAwakenPower.getEdge()));
        }
        
        /**
         * 備考をJSON変換してインスタンスに戻せる事を確認
         */
        @Test
        public void 備考をJSON変換してインスタンスに戻せる事を確認() {
            assertThat(after.getRemark(), is(before.getRemark()));
        }
        
        /**
         * 登録日時をJSON変換してインスタンスに戻せる事を確認
         */
        @Test
        public void 登録日時をJSON変換してインスタンスに戻せる事を確認() {
            SimpleDateFormat format = 
                    new SimpleDateFormat(DateUtil.DATE_FORMAT_PATTERN);
            String afterEntryDateText = format.format(after.getEntryDate());
            String beforeEntryDateText = format.format(before.getEntryDate());
            assertThat(afterEntryDateText, is(beforeEntryDateText));
        }
    }
    
    /**
     * 空のRookieをJSON変換した場合に、元のインスタンスに戻せる事を確認
     * 
     * @author sinmetal
     *
     */
    public static class 空のRookieのJSON変換テスト extends AppEngineTestCase {
        /** JSON変換前インスタンス */
        private Rookie before;
        /** JSON変換後インスタンス */
        private Rookie after;

        /**
         * テスト用の下準備を行う before → JSON → after
         */
        @Before
        public void setUp() throws Exception {
            super.setUp();
            before = new Rookie();
            String json = Rookie.toJson(before);
            after = Rookie.fromJson(json);
        }

        /**
         * JSON変換後の文字列が１文字以上あることを確認<br>
         * JSON変換時にExceptionが投げられない事を確認している。
         */
        @Test
        public void JSON変換後の文字列が1文字以上あること() {
            assertTrue(Rookie.toJson(before).length() > 0);
        }
        
        /**
         * IDをJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void IDを変換() {
            assertThat(after.getId(), is(nullValue()));
            assertThat(after.getId(), is(before.getId()));
        }
        
        /**
         * MemberKeyをJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void MemberKeyを変換() {
            Key key = after.getMemberKey();
            assertThat(key, is(nullValue()));
            assertThat(key, is(before.getMemberKey()));
        }

        /**
         * PokemonKeyをJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void PokemonKeyを変換() {
            Key key = after.getPokemonKey();
            assertThat(key, is(nullValue()));
            assertThat(key, is(before.getPokemonKey()));
        }
        
        /**
         * ニックネームをJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void ニックネームを変換() {
            assertThat(after.getNickname(), is(nullValue()));
            assertThat(after.getNickname(), is(before.getNickname()));
        }
        
        /**
         * 性格をJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void 性格を変換() {
            assertThat(after.getPerson(), is(nullValue()));
            assertThat(after.getPerson(), is(before.getPerson()));
        }
        
        /**
         * 性別をJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void 性別を変換() {
            assertThat(after.getGender(), is(nullValue()));
            assertThat(after.getGender(), is(before.getGender()));
        }
        
        /**
         * 特性Keyがnullの状態で、JSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void 特性Keyを変換() {
            assertThat(after.getAbilityKey(), is(nullValue()));
            assertThat(after.getAbilityKey(), is(before.getAbilityKey()));
        }
        
        /**
         * 努力値がnullの状態でJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void 努力値がnullの状態でJSON変換してインスタンスに戻せる事を確認() {
            assertThat(after.getEffort(), is(nullValue()));
            assertThat(after.getEffort(), is(before.getEffort()));
        }
        
        /**
         * 能力値がnullの状態でJSON変換して、インスタンスに戻せる事を確認
         */
        @Test
        public void 能力値がnullの状態でJSON変換してインスタンスに戻せる事を確認() {
            assertThat(after.getPower(), is(nullValue()));
            assertThat(after.getPower(), is(before.getPower()));
        }
        
        /**
         * 技Key一覧がnullの状態でJSON変換してインスタンスに戻せる事を確認
         */
        @Test
        public void 技Key一覧がnullの状態でJSON変換してインスタンスに戻せる事を確認() {
            assertThat(after.getTrickKeys(), is(nullValue()));
            assertThat(after.getTrickKeys(), is(before.getTrickKeys()));
        }
        
        /**
         * めざめるパワーがnullの状態でJSON変換してインスタンスに戻せる事を確認
         */
        @Test
        public void めざめるパワーがnullの状態でJSON変換してインスタンスに戻せる事を確認() {
            assertThat(after.getAwakenPower(), is(nullValue()));
            assertThat(after.getAwakenPower(), is(before.getAwakenPower()));
        }
        
        /**
         * 備考がnullの状態でJSON変換してインスタンスに戻せる事を確認
         */
        @Test
        public void 備考がnullの状態でJSON変換してインスタンスに戻せる事を確認() {
            assertThat(after.getRemark(), is(nullValue()));
            assertThat(after.getRemark(), is(before.getRemark()));
        }
        
        /**
         * 登録日時がnullの状態でJSON変換してインスタンスに戻せる事を確認
         */
        @Test
        public void 登録日時がnullの状態でJSON変換してインスタンスに戻せる事を確認() {
            assertThat(after.getEntryDate(), nullValue());
            assertThat(after.getEntryDate(), is(before.getEntryDate()));
        }
    }
}
