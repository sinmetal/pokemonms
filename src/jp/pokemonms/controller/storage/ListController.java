package jp.pokemonms.controller.storage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.model.Storage;
import jp.pokemonms.service.StorageFacadeService;
import jp.pokemonms.util.JsonUtil;
import jp.pokemonms.util.StringUtil;
import jp.pokemonms.view.StorageView;

/**
 * AjaxStorageListController
 * 
 * @author Sinmetal
 * 
 */
public class ListController extends JsonController {

    private StorageFacadeService storageFacadeService =
        new StorageFacadeService();

    /**
     * 指定されたメンバーのStorage一覧を返す
     */
    @Override
    protected Map<String, Object> handle() throws Exception {
        Map<String, Object> ret = new HashMap<String, Object>();
        String twitterName = asString("twitterName");
        // TODO static html化の前の名残のままだった。js側でredirectするか？
        // if (isNotLoginAndNotOtherHome(twitterName)) {
        // response.sendRedirect("/");
        // return ret;
        // }

        List<Storage> storages = null;
        if (isMyPage(twitterName)) {
            storages = storageFacadeService.getStorages(getTwitterId());
        } else {
            // TODO 一般公開されているStorageのみ取得
        }
        List<StorageView> storageViews = StorageView.getInstances(storages);
        ret.put("storages", JsonUtil.createGson().toJson(storageViews));
        return ret;
    }

    /**
     * ログインしていない かつ 他の人のページに来たわけでもない
     * 
     * @param twitterName
     * @return
     */
    protected boolean isNotLoginAndNotOtherHome(String twitterName) {
        return (!isLogin() && StringUtil.isEmpty(twitterName));
    }

    /**
     * 自分のページであるか
     * 
     * @param twitterName
     * @return
     */
    protected boolean isMyPage(String twitterName) {
        return (isLogin() && StringUtil.isEmpty(twitterName));
    }
}
