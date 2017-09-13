package service.sys.email.service.remote.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import service.sys.email.service.remote.SmsSendServiceClient;

@Component
public class SmsSendServiceClientHystrix implements SmsSendServiceClient {

    @Override
    public String send(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return "";
    }
}
