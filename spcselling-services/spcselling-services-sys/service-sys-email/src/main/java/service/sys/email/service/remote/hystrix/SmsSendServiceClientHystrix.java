package service.sys.email.service.remote.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import service.sys.email.service.remote.SmsSendServiceClient;

@Component
public class SmsSendServiceClientHystrix implements SmsSendServiceClient {

    @Override
    public String send(@RequestParam Integer a, @RequestParam Integer b) {
        return null;
    }

    @Override
    public String helloWorld() {
        return null;
    }
}
