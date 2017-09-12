package service.sys.email.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import service.sys.email.service.EmailSendService;
import service.sys.sms.api.EmailSendServiceApi;

@RestController
public class EmailSendController implements EmailSendServiceApi {

    private static final Logger LOGGER = LogManager.getLogger(EmailSendController.class);

    @Autowired
    private EmailSendService emailSendService;

    @Value("${user.username}")
    private String username;

    @Override
    public String hello() {
        return "hello,i am email send";
    }

    @Override
    public String send(String email, String content) {
        return emailSendService.sendEmail(email,content);
    }


}