package service.sys.common.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import service.sys.common.api.IdGenerateApi;

@RefreshScope
@RestController
public class IdGenerateController implements IdGenerateApi {

//    @Autowired
//    private IdService idService;

    @Override
    public long genId(long workerId) {
//        return idService.genId();
        return 0;
    }
}
