package service.sys.common.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
import service.sys.common.api.SendEmailServiceApi;

@RefreshScope
@RestController
public class SendEmailController implements SendEmailServiceApi {

    private static final Logger LOGGER = LogManager.getLogger(SendEmailController.class);


//    @Value("${user.username}")
    private String username;


    @Override
    public String sendEmail(String email, String content) {
        return null;
    }
}