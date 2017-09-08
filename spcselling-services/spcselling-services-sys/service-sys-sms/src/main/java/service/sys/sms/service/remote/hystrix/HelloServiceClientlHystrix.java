package service.sys.sms.service.remote.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import service.sys.sms.service.remote.HelloServiceClient;

/**
 * Created by Administrator on 2017-09-01.
 */
@Component
public class HelloServiceClientlHystrix implements HelloServiceClient {

    @Override
    public String add() {
        return "====出错熔断";
    }

    @Override
    public String hello(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        return "default: 0" ;
    }


}
