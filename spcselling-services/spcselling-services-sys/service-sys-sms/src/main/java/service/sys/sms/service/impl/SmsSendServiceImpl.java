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
    public String send(int a, int b) {
//        String str = helloServiceClient.hello(a,b); //两个服务之间不可循环调用，否则死循环
        return "请求我发一条短信";
    }
}
