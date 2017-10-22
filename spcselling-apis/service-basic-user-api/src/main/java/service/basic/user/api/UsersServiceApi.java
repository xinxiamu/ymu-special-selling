package service.basic.user.api;

import com.ymu.spcselling.infrastructure.spring.mvc.api.ApiRespResultVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
