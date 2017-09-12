package service.sys.sms.service.remote.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import service.sys.sms.service.remote.EmailSendServiceClient;

/**
 * Created by Administrator on 2017-09-01.
 */
@Component
public class EmailSendServiceClientHystrix implements EmailSendServiceClient {

    @Override
    public String hello() {
        return null;
    }

    @Override
    public String send(String email, String content) {
        return null;
    }
}
