package service.sys.common.controller;

import com.ymu.spcselling.infrastructure.base.AbstractBaseController;
import com.ymu.spcselling.infrastructure.idgenerator.ID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RestController;
import service.sys.common.api.IdGenerateApi;
import service.sys.common.service.local.IdService;
import service.sys.common.vo.req.VIdGenReq;
import service.sys.common.vo.req.VIdGenReqValidator;

@RefreshScope
@RestController
public class IdGenerateController extends AbstractBaseController implements IdGenerateApi {

    private static final Logger LOGGER = LogManager.getLogger(SendEmailController.class);

    @Override
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(new VIdGenReqValidator());
    }

    @Autowired
    private IdService idService;

    @Override
    public long genId(VIdGenReq vIdGenReq) {
        long id = idService.genId(vIdGenReq.getDataCenterId(), vIdGenReq.getWorkerId());
        LOGGER.debug("genId:" + id);
        return id;
    }

    @Override
    public ID expId(long id) {
        ID ID = idService.expId(id);
        LOGGER.debug("ID=", ID.toString());
        return ID;
    }

}