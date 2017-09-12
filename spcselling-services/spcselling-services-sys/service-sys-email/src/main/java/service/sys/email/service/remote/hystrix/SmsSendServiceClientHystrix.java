package service.sys.email.service.remote.hystrix;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import service.sys.email.service.remote.SmsSendServiceClient;

@Component
@Qualifier("smsSendServiceClientHystrix")
public class SmsSendServiceClientHystrix implements SmsSendServiceClient {

    @Override
    public String send(String mobile, String content) {
        return null;
    }

    @Override
    public String hello() {
        return null;
    }
}
