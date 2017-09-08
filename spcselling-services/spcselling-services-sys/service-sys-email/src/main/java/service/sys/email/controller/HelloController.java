package service.sys.email.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.sys.email.service.HelloService;
import service.sys.sms.api.HelloServiceApi;

@RestController
public class HelloController implements HelloServiceApi {

    private static final Logger LOGGER = LogManager.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

    @Value("${user.username}")
    private String username;

    @Override
    public String add() {
        return "from:service-email==" + this.username;
    }

    @Override
    public String hello(@RequestParam int a, @RequestParam int b) {
        LOGGER.debug("==============测试调用远程服务");
        return helloService.helloWorld(a,b);
    }
}