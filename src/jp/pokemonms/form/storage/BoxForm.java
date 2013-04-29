package jp.pokemonms.form.storage;

import java.util.Map;

import org.slim3.util.BeanUtil;

/**
 * StorageBoxForm
 * 
 * @author sinmetal
 *
 */
public class BoxForm {

    /** Box名 */
    private String name;
    
    /** 公開範囲 */
    private String publishLvType;

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
    public String getPublishLvType() {
        return publishLvType;
    }

    /**
     * @param publishLvType the publishLvType to set
     */
    public void setPublishLvType(String publishLvType) {
        this.publishLvType = publishLvType;
    }
    
    /**
     * インスタンス生成
     * 
     * @param request 入力値
     * @return 入力値を代入したBoxForm
     */
    public static BoxForm getInstance(Map<String, Object> request) {
        BoxForm instance = new BoxForm();
        BeanUtil.copy(request, instance);
        return instance;
    }
}
