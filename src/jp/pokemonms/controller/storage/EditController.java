package jp.pokemonms.controller.storage;

import jp.pokemonms.controller.AbstractController;
import jp.pokemonms.form.StorageForm;
import jp.pokemonms.meta.StorageMeta;
import jp.pokemonms.model.Storage;
import jp.pokemonms.model.constant.GenderType;
import jp.pokemonms.model.constant.PublishLvType;
import jp.pokemonms.service.StorageService;

import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;

public class EditController extends AbstractController {

    private StorageService service = new StorageService();

    private StorageMeta meta = StorageMeta.get();

    @Override
    public Navigation run() throws Exception {
        Storage storage = service.get(asKey(meta.key), asLong(meta.version));
        StorageForm form = new StorageForm();
        BeanUtil.copy(storage, form);
        BeanUtil.copy(form, request);

        requestScope("genderType", GenderType.getAll());
        requestScope("publishLvType", PublishLvType.getAll());
        return forward("/storage/edit.jsp");
    }
}
