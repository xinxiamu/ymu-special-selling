package service.sys.common.api;

import com.ymu.spcselling.infrastructure.constants.SpcsConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 分布式id生成服务。
 */
@RequestMapping(SpcsConstants.API_VERSION + "/id")
public interface IdGenerateApi {

    @GetMapping("/gen")
    long genId(@RequestParam(value = "workerId") long workerId);
}
