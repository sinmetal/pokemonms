package jp.pokemonms.model.json.storage.box;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import jp.pokemonms.form.storage.BoxForm;
import jp.pokemonms.meta.json.storage.box.RookieBoxMeta;
import jp.pokemonms.model.constant.PublishLvType;
import jp.pokemonms.model.json.storage.Rookie;
import jp.pokemonms.util.JsonUtil;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Datastore;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * 育成前のポケモンBOX
 * 
 * @author sinmetal
 *
 */
@Model(schemaVersion = 1)
public class RookieBox extends AbstractBox implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 育成前ポケモン一覧 */
    @Attribute(lob = true)
    private List<Rookie> rookies;
    
    /**
     * @return the rookies
     */
    public List<Rookie> getRookies() {
        return rookies;
    }

    /**
     * @param rookies the rookies to set
     */
    public void setRookies(List<Rookie> rookies) {
        this.rookies = rookies;
    }
    
    /**
     * Key生成
     * 
     * @param memberKey Boxの持ち主のMemberKey
     * @param boxName Box名
     * @return key
     */
    public static Key createKey(Key memberKey, String boxName) {
        final String memberKeyBase64Text = KeyFactory.keyToString(memberKey);
        final String keyText = 
                String.format("%s,%s", memberKeyBase64Text, boxName);
        return Datastore.createKey(RookieBoxMeta.get(), keyText);
    }
    
    /**
     * Datastore登録用インスタンス生成
     * 
     * @param memberKey Boxの持ち主のMemberKey
     * @param boxForm Box入力Form
     * @return RookieBox
     */
    public static RookieBox getInstance(Key memberKey, BoxForm boxForm) {
        final RookieBox instance = new RookieBox();
        instance.setKey(RookieBox.createKey(memberKey, boxForm.getName()));
        instance.setMemberKey(memberKey);
        instance.setName(boxForm.getName());
        instance.setRookies(new ArrayList<Rookie>());
        instance.setPublishLvType(PublishLvType.ME);
        instance.setSort(0);
        return instance;
    }
    
    /**
     * keyからBox名を取り出す
     * 
     * @param key RookieBoxKey
     * @return Box名
     */
    public static String keyToName(Key key) {
        final String keyName = key.getName();
        final String[] keyNames = keyName.split(",");
        return keyNames[1];
    }
    
    /**
     * Jsonからインスタンスを生成
     * 
     * @param json
     * @return RookieBox
     */
    public static RookieBox fromJson(String json) {
        return JsonUtil.fromJson(json, RookieBox.class);
    }
    
    /**
     * インスタンスをJSONに変換
     * 
     * @param rookieBox
     * @return json
     */
    public static String toJson(RookieBox rookieBox) {
        final Gson gson = JsonUtil.createGson();
        final Type type = new TypeToken<RookieBox>() {
        }.getType();

        return gson.toJson(rookieBox, type);
    }
}
