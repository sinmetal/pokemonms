package jp.pokemonms.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slim3.tester.AppEngineTestCase;

public class IndividualUtilTest extends AppEngineTestCase {
    @Test
    public void parseStatusUpper1() {
        String value = "10-13";
        int result = IndividualUtil.parseUpper(value);
        assertThat(result,is(13));
    }

    @Test
    public void parseStatusUpper2() {
        String value = "10-";
        int result = IndividualUtil.parseUpper(value);
        assertThat(result, is(IndividualUtil.UNKNOWN_DATA));
    }

    @Test
    public void parseStatusUpper3() {
        String value = "-13";
        int result = IndividualUtil.parseUpper(value);
        assertTrue(result == 13);
    }

    @Test
    public void parseStatusUpper4() {
        String value = "13";
        int result = IndividualUtil.parseUpper(value);
        assertTrue(result == 13);
    }

    @Test
    public void parseStatusUpper5() {
        String value = "???";
        int result = IndividualUtil.parseUpper(value);
        assertThat(result, is(IndividualUtil.UNKNOWN_DATA));
    }

    @Test
    public void parseStatusLower1() {
        String value = "10-13";
        int result = IndividualUtil.parseLower(value);
        assertTrue(result == 10);
    }

    @Test
    public void parseStatusLower2() {
        String value = "10-";
        int result = IndividualUtil.parseLower(value);
        assertThat(result,is(10));
    }

    @Test
    public void parseStatusLower3() {
        String value = "-13";
        int result = IndividualUtil.parseLower(value);
        assertThat(result,is(IndividualUtil.UNKNOWN_DATA));
    }

    @Test
    public void parseStatusLower4() {
        String value = "13";
        int result = IndividualUtil.parseLower(value);
        assertTrue(result == 13);
    }

    @Test
    public void parseStatusLower5() {
        String value = "???";
        int result = IndividualUtil.parseLower(value);
        assertThat(result, is(IndividualUtil.UNKNOWN_DATA));
    }

    @Test
    public void parseStatusUpperUnknown() {
        String value = IndividualUtil.UNKNOWN_VIEW;
        int result = IndividualUtil.parseUpper(value);
        assertThat(result, is(IndividualUtil.UNKNOWN_DATA));
    }

    @Test
    public void parseStatusLowerUnknown() {
        String value = IndividualUtil.UNKNOWN_VIEW;
        int result = IndividualUtil.parseLower(value);
        assertThat(result, is(IndividualUtil.UNKNOWN_DATA));
    }

    @Test
    public void parseStatusUpperSpace() {
        String value = "";
        int result = IndividualUtil.parseUpper(value);
        assertThat(result, is(IndividualUtil.UNKNOWN_DATA));
    }

    @Test
    public void parseStatusLowerSpace() {
        String value = "";
        int result = IndividualUtil.parseLower(value);
        assertThat(result, is(IndividualUtil.UNKNOWN_DATA));
    }

    @Test
    public void parseInt() {
        String value = "10";
        int result = IndividualUtil.parseInt(value);
        assertThat(result, is(10));
    }

    @Test
    public void parseInt2() {
        String value = "";
        int result = IndividualUtil.parseInt(value);
        assertThat(result, is(IndividualUtil.UNKNOWN_DATA));
    }

    @Test
    public void parseInt3() {
        String value = "あ";
        int result = IndividualUtil.parseInt(value);
        assertThat(result, is(IndividualUtil.UNKNOWN_DATA));
    }
}
