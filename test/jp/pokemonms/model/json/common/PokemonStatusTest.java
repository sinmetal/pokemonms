package jp.pokemonms.model.json.common;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jp.pokemonms.model.json.common.PokemonStatus;

import org.junit.Test;

/**
 * ポケモンステータスビーンテスト
 * 
 * @author sinmetal
 *
 */
public class PokemonStatusTest {

    /** テスト値 H */
    private final Integer H = 1;
    /** テスト値 A */
    private final Integer A = 2;
    /** テスト値 B */
    private final Integer B = 3;
    /** テスト値 C */
    private final Integer C = 4;
    /** テスト値 D */
    private final Integer D = 5;
    /** テスト値 S */
    private final Integer S = 6;
    
    /**
     * 初期値設定用のコンストラクタを利用して、初期値が設定できることを確認
     */
    @Test
    public void 初期値設定コンストラクタを利用して初期値が設定できる() {
        PokemonStatus status = new PokemonStatus(H, A, B, C, D, S);
        assertThat(status, is(notNullValue()));
        assertThat(status.getH(), is(H));
        assertThat(status.getA(), is(A));
        assertThat(status.getB(), is(B));
        assertThat(status.getC(), is(C));
        assertThat(status.getD(), is(D));
        assertThat(status.getS(), is(S));
    }

    /**
     * 全ステータスが同値である場合、equals()がtrueを返す事を確認
     */
    @Test
    public void 全ステータスが同じ値の場合equalsがtrue() {
        PokemonStatus status1 = new PokemonStatus(H, A, B, C, D, S);
        PokemonStatus status2 = new PokemonStatus(H, A, B, C, D, S);
        assertThat(status1.equals(status2), is(true));
    }
}
