package jp.pokemonms.misc;

import java.lang.reflect.Method;

import org.slim3.tester.AppEngineTester;
import org.slim3.util.AppEngineUtil;

import com.google.apphosting.api.ApiProxy;

public class CustomizedAppEngineTester extends AppEngineTester {

    @Override
    public void tearDown() throws Exception {
      ClassLoader loader = loadLibraries();
      Class<?> apiProxyLocalImplClass = loader.loadClass(API_PROXY_LOCAL_IMPL_CLASS_NAME);
      Method stopMethod = apiProxyLocalImplClass.getMethod("stop");
      stopMethod.setAccessible(true);
      stopMethod.invoke(apiProxyLocalImpl);
      ApiProxy.setDelegate(originalDelegate);
      if (!AppEngineUtil.isProduction()) {
        ApiProxy.setEnvironmentForCurrentThread(originalEnvironment);
      }
    }
}
