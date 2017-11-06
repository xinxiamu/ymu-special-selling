package service.basic.user.api;

import com.spcs.apis.common.ApiRespResultVO;
import org.springframework.web.bind.annotation.*;
import service.basic.user.vo.req.VUserReq;

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
    @GetMapping("/user/{mobile}")
    ApiRespResultVO getUserByMobile(@PathVariable(name = "mobile") String mobile);

    @GetMapping("/user/mobile/{id}")
    ApiRespResultVO getUserMobileById(@PathVariable(name = "id") long id);

}
