package jp.pokemonms.util;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

public class DateUtilTest extends AppEngineTestCase {

    @Test
    public void getNow() {

    }

    // 以下のテストが通らないのはなぜだろう？
//    @Test
//    public void ToDateした時のフォーマットを確認() throws Exception {
//        Date testDate = new Date();
//        String dateText = testDate.toString();
//        SimpleDateFormat format = new SimpleDateFormat("dow mon dd hh:mm:ss zzz yyyy");
//        Date ansDate = format.parse(dateText);
//        assertThat(ansDate, is(testDate));
//    }
}
