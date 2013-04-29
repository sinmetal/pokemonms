package jp.pokemonms.controller.storage;

import jp.pokemonms.tester.LoginHelper;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * ストレージ更新コントローラテスト
 * @author Sinmetal
 *
 */
public class UpdateControllerTest extends ControllerTestCase {

    /** loginHelper */
    private LoginHelper loginHelper;

    /* (非 Javadoc)
     * @see org.slim3.tester.ControllerTestCase#setUp()
     */
    @Override
    public void setUp() throws Exception {
        super.setUp();
        loginHelper = new LoginHelper();

    }

    /**
     * validateにかかった場合は、登録画面に戻る
     *
     * @throws Exception
     */
    @Test
    public void validateエラー時は登録画面へ() throws Exception {
        tester.sessionScope(loginHelper.LOGIN_INFO, loginHelper.getLoginInfo());
        tester.start("/storage/update");
        UpdateController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/storage/entry"));
    }

    /**
     * 未ログイン時は、登録画面へ
     *
     * @throws Exception
     */
    @Test
    public void 未ログイン時は登録画面へ() throws Exception {
        tester.start("/storage/update");
        UpdateController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/storage/entry"));
    }
}
