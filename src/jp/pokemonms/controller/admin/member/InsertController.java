package jp.pokemonms.controller.admin.member;

import jp.pokemonms.model.Member;
import jp.pokemonms.service.AdminService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.util.BeanUtil;
import org.slim3.util.RequestMap;

public class InsertController extends Controller {

    private AdminService adminService = new AdminService();

    @Override
    public Navigation run() throws Exception {
        RequestMap requestMap = new RequestMap(request);
        Member member = new Member();
        BeanUtil.copy(requestMap, member);
        adminService.insertMember(member);
        return redirect(basePath);
    }
}
