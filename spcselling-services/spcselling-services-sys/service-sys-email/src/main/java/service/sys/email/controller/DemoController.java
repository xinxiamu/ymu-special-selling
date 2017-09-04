package service.sys.email.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import service.sys.email.service.DemoService;
import service.sys.email.service.remote.ServiceSysSms;

@RestController
public class DemoController {

    private static final Logger LOGGER = LogManager.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @Value("${user.username}")
    private String username;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "from:service-email==" + this.username;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam int a, @RequestParam int b) {
        LOGGER.debug("==============测试调用远程服务");
        return demoService.helloWorld(a,b);
    }
}