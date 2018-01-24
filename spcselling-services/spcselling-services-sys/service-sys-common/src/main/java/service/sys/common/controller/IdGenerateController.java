package service.sys.common.controller;

import com.spcs.apis.common.ApiRespResultVO;
import com.ymu.spcselling.infrastructure.base.AbstractBaseController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.sys.common.api.IdGenerateServiceApi;
import service.sys.common.service.local.IdService;
import service.sys.common.vo.req.VIdGenReq;
import service.sys.common.vo.req.VIdGenReqValidator;
import service.sys.common.vo.resp.VSnowflakeIdResp;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RefreshScope
@RestController
public class IdGenerateController extends AbstractBaseController implements IdGenerateServiceApi {

    private static final Logger LOGGER = LogManager.getLogger(SendEmailController.class);

    @Override
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new VIdGenReqValidator());
    }


    @Autowired
    private IdService idService;

    @Override
    public long genId(@RequestBody @Validated VIdGenReq vIdGenReq) {
        long id = idService.genId(vIdGenReq.getDataCenterId(), vIdGenReq.getWorkerId());
        LOGGER.debug("genId:" + id);
        return id;
    }

    //    @CrossOrigin(origins = "http://localhost:9000",maxAge = 600)
    @Override
    public ApiRespResultVO expId(@PathVariable(name = "id") long id) {
        VSnowflakeIdResp sid = idService.expId(id);
        sid.removeLinks();
        sid.add(linkTo(IdGenerateController.class).slash(id).withSelfRel());
        LOGGER.debug("sid=", sid.toString());
        return ApiRespResultVO.getInstance(sid, HttpStatus.CREATED).addLink(new Link("http://baidu.com").withRel("baidu"));
    }

    @Override
    public Object test(@PathVariable(name = "name") String name) {
        Map map = new HashMap();
        map.put("name",name);
        return map;
    }
}