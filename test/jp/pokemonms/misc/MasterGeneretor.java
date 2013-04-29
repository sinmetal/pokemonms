package jp.pokemonms.misc;

import static org.junit.Assert.assertTrue;

import java.util.List;

import jp.pokemonms.model.Member;
import jp.pokemonms.service.MemberService;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

import com.google.apphosting.api.ApiProxy;

/**
 *
 * http://shin1o.blogspot.com/2010/10/slim3-appengine.html
 * @author sin
 *
 */
public class MasterGeneretor extends AppEngineTestCase {

    private CustomizedAppEngineTester tester = new CustomizedAppEngineTester();

    private MemberService memberService = new MemberService();

    /**
     *
     * @throws Exception
     */
    @Test
    public void createMember() throws Exception {
        tester.setUp();
        ApiProxy.setEnvironmentForCurrentThread(ApiProxy.getCurrentEnvironment());

        Member member = new Member();
        member.setTwitterId(1L);
        memberService.insert(member);

        tester.tearDown();

        List<Member> members = memberService.findAll();
        assertTrue(members.size() > 0);
    }
}
