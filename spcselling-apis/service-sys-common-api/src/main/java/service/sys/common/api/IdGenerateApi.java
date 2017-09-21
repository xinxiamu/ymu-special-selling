package service.sys.common.api;

import com.ymu.spcselling.infrastructure.constants.SpcsConstants;
import com.ymu.spcselling.infrastructure.idgenerator.ID;
import org.springframework.web.bind.annotation.*;
import service.sys.common.vo.req.VIdGenReq;

import javax.validation.Valid;

/**
 * 分布式id生成服务。
 */
@RequestMapping(SpcsConstants.API_VERSION + "/id")
public interface IdGenerateApi {

    /**
     * 生成分布式id。
     * @param vIdGenReq
     * @return
     */
    @PostMapping("/gen")
    long genId(@RequestBody @Valid VIdGenReq vIdGenReq);

    /**
     * 解析分布式id。
     * @param id
     * @return
     */
    @GetMapping("/expId")
    public ID expId(@RequestParam(value = "id") long id);
}
