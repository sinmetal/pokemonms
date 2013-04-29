package jp.pokemonms.util;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * DatastoreのKeyに関するUtil
 * 
 * @author sinmetal
 * 
 */
public class KeyUtil {

    /**
     * BASE64FormatのKeyをKeyObjectに変換する
     * 
     * @param base64Key
     *            BASE64FormatのKey文字列
     * @return 変換されたKeyObject 渡されたbase64Keyがnullか空文字の場合はnullFsFs
     */
    public static Key toKeyOrNull(String base64Key) {
        if (StringUtil.isEmpty(base64Key)) {
            return null;
        }
        return KeyFactory.stringToKey(base64Key);
    }
}
