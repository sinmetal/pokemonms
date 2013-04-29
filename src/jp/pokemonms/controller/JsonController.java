package jp.pokemonms.controller;

import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import jp.pokemonms.util.JsonUtil;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.DatastoreFailureException;
import com.google.appengine.api.datastore.DatastoreTimeoutException;
import com.google.apphosting.api.ApiProxy.CapabilityDisabledException;
import com.google.apphosting.api.DeadlineExceededException;

/**
 * Ajaxで利用するJsonの既定Controller 下記を参考に作成
 * http://tech.topgate.co.jp/gijutsu-shiryou/slim3-json
 * 
 * @author Sinmetal
 * 
 */
public abstract class JsonController extends AbstractController {

    private static final Logger logger = Logger.getLogger(JsonController.class
        .getName());
    public static final String STATUS = "status";
    public static final String ERRCODE = "errorCode";
    public static final String ERRMESSAGE = "errorMessage";
    public static final String CANRETRY = "canRetry";
    public static final String STATUS_OK = "OK";
    public static final String STATUS_NG = "NG";

    abstract protected Map<String, Object> handle() throws Exception;

    @Override
    protected Navigation run() throws Exception {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        Map<String, Object> map = handle();
        if (map == null) {
            throw new AssertionError("handle() must not be null.");
        }
        if (!map.containsKey(STATUS)) {
            map.put(STATUS, STATUS_OK);
        }
        Writer writer = response.getWriter();
        writer.write(JsonUtil.toJson(map));
        response.flushBuffer();
        return null;
    }

    @Override
    protected Navigation handleError(Throwable error) throws Throwable {
        Map<String, Object> map = new HashMap<String, Object>();
        String errorCode;
        String errorMessage;
        boolean canRetry = false;
        if (error instanceof CapabilityDisabledException) {
            errorCode = "READONLY";
            errorMessage = "AppEngineのサービスが読み取り専用です";
        } else if (error instanceof DatastoreTimeoutException) {
            errorCode = "DSTIMEOUT";
            errorMessage = "データストアがタイムアウトしました。";
            canRetry = true;
        } else if (error instanceof DatastoreFailureException) {
            errorCode = "DSFAILURE";
            errorMessage = "データストアのアクセスに失敗しました。";
        } else if (error instanceof DeadlineExceededException) {
            errorCode = "DEE";
            errorMessage = "30秒を超えても処理が終了しませんでした。";
            canRetry = true;
        } else {
            errorCode = "UNKNOWN";
            errorMessage = "予期せぬエラーが発生しました。" + error.toString() + ".";
        }
        map.put(ERRCODE, errorCode);
        map.put(ERRMESSAGE, errorMessage);
        map.put(CANRETRY, canRetry);
        Writer writer = response.getWriter();
        writer.write(JsonUtil.toJson(map));
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        response.flushBuffer();
        logger.log(Level.SEVERE, "error", error);
        return null;
    }
}
