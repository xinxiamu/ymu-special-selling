package service.basic.user.controller;

import com.ymu.spcselling.infrastructure.base.AbstractBaseController;
import com.ymu.spcselling.infrastructure.spring.mvc.api.ApiRespResultVO;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.basic.user.api.UsersServiceApi;
import service.basic.user.vo.req.VUserReq;
import service.basic.user.vo.req.VUserReqValidator;

import javax.validation.Valid;

@RestController
public class UserController extends AbstractBaseController implements UsersServiceApi {

    @Override
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new VUserReqValidator());
    }

    @Override
    public ApiRespResultVO saveUser(@RequestBody @Valid VUserReq vUserReq) {
        return null;
    }
}
