package service.sys.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.sys.sms.service.SmsSendService;
import service.sys.sms.service.remote.HelloServiceClient;

/**
 * Created by Administrator on 2017-09-01.
 */
@Service
public class SmsSendServiceImpl implements SmsSendService {

    @Autowired
    private HelloServiceClient helloServiceClient;

    @Override
    public String send() {
        return "from service-email" + helloServiceClient.hello(3,4);
    }
}
