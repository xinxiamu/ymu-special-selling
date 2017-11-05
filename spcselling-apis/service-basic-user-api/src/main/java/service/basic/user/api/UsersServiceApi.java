package service.basic.user.api;

import com.ymu.spcselling.infrastructure.spring.mvc.api.ApiRespResultVO;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.*;
import service.basic.user.vo.req.VUserReq;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 会员管理。
 */
@RequestMapping("/users")
public interface UsersServiceApi {

    /**
     * 添加会员。
     * @param vUserReq
     * @return
     */
    @PostMapping
    ApiRespResultVO saveUser(@RequestBody VUserReq vUserReq);

    /**
     * 根据手机号码查找用户。
     * @param mobile
     * @return
     */
    @GetMapping(name = "/{mobile}")
    ApiRespResultVO getUserByMobile(@PathVariable(name = "mobile") @Valid @NotNull @NotEmpty  String mobile);

}
