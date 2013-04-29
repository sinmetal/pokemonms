package jp.pokemonms.controller.storage;

import jp.pokemonms.controller.AbstractController;
import jp.pokemonms.form.StorageForm;
import jp.pokemonms.meta.StorageMeta;
import jp.pokemonms.service.StorageFacadeService;
import jp.pokemonms.validator.ExtValidators;

import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

/**
 * StorageUpdateController
 * @author Sinmetal
 *
 */
public class UpdateController extends AbstractController {

    /** StorageFacadeService */
    private StorageFacadeService service = new StorageFacadeService();

    private StorageMeta meta = new StorageMeta();

    /**
     * Storageの更新を行う
     */
    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        if (!validate(requestMap)) {
            return forward("/storage/entry");
        }

        StorageForm form = StorageForm.getInstance(requestMap);
        service.updateStorage(asKey(meta.key), asLong(meta.version), form);
        return redirect("/storage/");
    }

    /**
     * Validate
     *
     * @param requestMap
     * @return
     */
    protected Boolean validate(RequestMap requestMap) {
        ExtValidators v = new ExtValidators(requestMap);
        v.add("pokemonName", v.required(), v.existsPokemon());
        v.add("", v.regexp("^([0-9]{0,3})-?([0-9]{0,3})$"));
        return v.validate();
    }
}
