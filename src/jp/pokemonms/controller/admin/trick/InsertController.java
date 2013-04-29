package jp.pokemonms.controller.admin.trick;

import jp.pokemonms.service.AdminService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.RequestMap;

public class InsertController extends Controller {

    private AdminService adminService = new AdminService();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        adminService.insertBatch4Trick(requestMap);
        return redirect(basePath);
    }
}
