package service.basic.user.controller;

import com.ymu.spcselling.entity.user.User;
import com.ymu.spcselling.infrastructure.base.AbstractBaseController;
import com.ymu.spcselling.infrastructure.spring.mvc.api.ApiRespResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.basic.user.api.UsersServiceApi;
import service.basic.user.service.UserService;
import service.basic.user.vo.req.VUserReq;
import service.basic.user.vo.req.VUserReqValidator;

import javax.validation.Valid;

@RestController
public class UserController extends AbstractBaseController implements UsersServiceApi {

    @Autowired
    private UserService userService;

    @Override
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new VUserReqValidator());
    }

    @Override
    public ApiRespResultVO saveUser(@RequestBody @Valid VUserReq vUserReq) {
        return null;
    }

    @Override
    public ApiRespResultVO getUserByMobile(@PathVariable(name = "mobile") @Valid String mobile) {
        User user = userService.getUserByMobile(mobile);
        return ApiRespResultVO.getInstance(user, HttpStatus.FOUND);
    }
}
