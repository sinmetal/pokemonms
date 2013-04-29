package jp.pokemonms.controller.storage;

import jp.pokemonms.controller.AbstractController;
import jp.pokemonms.meta.StorageMeta;
import jp.pokemonms.service.StorageService;

import org.slim3.controller.Navigation;

public class DeleteController extends AbstractController {

    private StorageService service = new StorageService();

    private StorageMeta meta = new StorageMeta();

    @Override
    public Navigation run() throws Exception {
        service.delete(asKey(meta.key), asLong(meta.version));
        return redirect(basePath);
    }
}
