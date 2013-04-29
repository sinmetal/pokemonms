package jp.pokemonms.model.json.storage.box;

import java.io.Serializable;

import jp.pokemonms.model.constant.PublishLvType;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

/**
 * Boxに登録するJSONの基底クラス
 * 
 * @author sinmetal
 *
 */
@Model(schemaVersion = 1)
public abstract class AbstractBox implements Serializable {
    
    protected static final long serialVersionUID = 1L;

    /** BoxKey */
    @Attribute(primaryKey = true)
    private Key key;
    
    /** メンバーKey */
    private Key memberKey;
    
    /** Box名 */
    private String name;
    
    /** 公開範囲 */
    private PublishLvType publishLvType;
    
    /** 並び順 */
    private Integer sort;

    /**
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * @return the memberKey
     */
    public Key getMemberKey() {
        return memberKey;
    }

    /**
     * @param memberKey the memberKey to set
     */
    public void setMemberKey(Key memberKey) {
        this.memberKey = memberKey;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the publishLvType
     */
    public PublishLvType getPublishLvType() {
        return publishLvType;
    }

    /**
     * @param publishLvType the publishLvType to set
     */
    public void setPublishLvType(PublishLvType publishLvType) {
        this.publishLvType = publishLvType;
    }

    /**
     * @return the sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort the sort to set
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
