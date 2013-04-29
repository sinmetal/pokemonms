package jp.pokemonms.util;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 * JsonUtil
 * 
 * @author Sinmetal
 * 
 */
public class JsonUtil {

    private static final Type mapType = new TypeToken<Map<String, Object>>() {
    }.getType();

    public static Gson createGson() {
        return new GsonBuilder()
            .setDateFormat(DateUtil.DATE_FORMAT_PATTERN)
            .create();
    }

    public static String toJson(Object obj) {
        final Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public static Map<String, Object> toMap(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, mapType);
    }

    public static <T> T fromJson(String json, Class<T> typeOfT) {
        final Gson gson = new Gson();
        return gson.fromJson(json, typeOfT);
    }
}
