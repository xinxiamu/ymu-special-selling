package service.sys.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.sys.sms.service.SmsSendService;
import service.sys.sms.service.remote.EmailSendServiceClient;

/**
 * Created by Administrator on 2017-09-01.
 */
@Service
public class SmsSendServiceImpl implements SmsSendService {

    @Autowired
    private EmailSendServiceClient emailSendServiceClient;

    @Override
    public String send(String mobile, String content) {
        return null;
    }
}
