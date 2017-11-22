package service.sys.common.controller;

import com.spcs.apis.common.ApiRespResultVO;
import com.ymu.spcselling.infrastructure.base.AbstractBaseController;
import com.ymu.spcselling.infrastructure.idgenerator.ID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.sys.common.api.IdGenerateServiceApi;
import service.sys.common.service.local.IdService;
import service.sys.common.vo.req.VIdGenReq;
import service.sys.common.vo.req.VIdGenReqValidator;

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
        ID ID = idService.expId(id);
        LOGGER.debug("ID=", ID.toString());
        return ApiRespResultVO.getInstance(ID, HttpStatus.CREATED).addLink(linkTo(methodOn(IdGenerateController.class).expId(id)).withSelfRel()).addLink(new Link("http://baidu.com").withRel("baidu"));
    }


}