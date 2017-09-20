package service.sys.common.service.local.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import service.sys.common.service.local.SendEmailService;

/**
 * Created by Administrator on 2017-09-01.
 */
@Service
public class SendEmailServiceImpl implements SendEmailService {

    private static final Logger LOGGER = LogManager.getLogger(SendEmailServiceImpl.class);


    @Override
    public String sendEmail(String email, String content) {
        return null;
    }
}
