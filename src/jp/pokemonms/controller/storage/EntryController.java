package jp.pokemonms.controller.storage;

import java.util.HashMap;
import java.util.Map;

import jp.pokemonms.controller.JsonController;
import jp.pokemonms.form.StorageForm;
import jp.pokemonms.model.Storage;
import jp.pokemonms.service.StorageFacadeService;
import jp.pokemonms.util.JsonUtil;
import jp.pokemonms.validator.ExtValidators;
import jp.pokemonms.view.StorageView;

import org.slim3.util.RequestMap;

/**
 * StorageEntryController
 * 
 * @author Sinmetal
 * 
 */
public class EntryController extends JsonController {

    /** StorageFacadeService */
    private StorageFacadeService storageFacadeService =
        new StorageFacadeService();

    @Override
    protected Map<String, Object> handle() throws Exception {
        // TODO ログインを促すページが必要か？

        RequestMap requestMap = new RequestMap(request);
        ExtValidators v = createValidator(requestMap);
        Map<String, Object> ret = new HashMap<String, Object>();
        if (!v.validate()) {
            ret.put(STATUS, STATUS_NG);
            ret.put("errors", v.getErrors());
            return ret;
        }

        StorageForm form = StorageForm.getInstance(requestMap);
        Storage storage =
            storageFacadeService.insertStorage(form, getTwitterId());
        StorageView view = StorageView.getInstance(storage);
        ret.put("storage", JsonUtil.createGson().toJson(view));
        return ret;
    }

    /**
     * Validate
     * 
     * @param request
     * @return
     */
    protected ExtValidators createValidator(RequestMap requestMap) {
        ExtValidators v = new ExtValidators(requestMap);
        v.add("pokemonName", v.required(), v.existsPokemon());
        v.add("", v.regexp("^([0-9]{0,3})-?([0-9]{0,3})$"));
        return v;
    }
}
