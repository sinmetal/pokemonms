package jp.pokemonms.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import jp.pokemonms.model.Member;

import org.junit.Test;
import org.slim3.datastore.Datastore;
import org.slim3.tester.AppEngineTestCase;

/**
 * メンバーサービステスト
 * @author Sinmetal
 *
 */
public class MemberServiceTest extends AppEngineTestCase {

    /** メンバーサービス */
    private MemberService service = new MemberService();

    /**
     * インスタンス生成
     *
     * @throws Exception
     */
    @Test
    public void インスタンス生成() throws Exception {
        assertThat(service, is(notNullValue()));
    }

    /**
     * 更新
     *
     * @throws Exception
     */
    @Test
    public void 更新() throws Exception {
        Member input = new Member();
        input.setTwitterId(1L);
        Member member = service.insert(input);
        assertThat(member, is(notNullValue()));

        Member stored = Datastore.get(Member.class, member.getKey());
        assertThat(stored.getTwitterId(), is(1L));
    }
}
