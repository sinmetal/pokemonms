package jp.pokemonms.tester;

import org.slim3.tester.ControllerTestCase;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * HRDで実行するためのControllerTestCase
 * @author sinmetal
 *
 */
public class ControllerTestCase4HRD extends ControllerTestCase {
    private LocalServiceTestHelper helper;

    @Override
    public void setUp() throws Exception {
        helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig()
                .setDefaultHighRepJobPolicyUnappliedJobPercentage(100));

        helper.setUp();
        super.setUp();
        System.setProperty("slim3.useXGTX", "true");
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        helper.tearDown();
    }
}
