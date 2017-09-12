package service.sys.email.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.sys.email.service.EmailSendService;
import service.sys.email.service.remote.SmsSendServiceClient;

/**
 * Created by Administrator on 2017-09-01.
 */
@Service
public class EmailSendServiceImpl implements EmailSendService {

    private static final Logger LOGGER = LogManager.getLogger(EmailSendServiceImpl.class);

    @Autowired
    private SmsSendServiceClient smsSendServiceClient;

    @Override
    public String sendEmail(String email, String content) {
        return smsSendServiceClient.hello();
    }
}
