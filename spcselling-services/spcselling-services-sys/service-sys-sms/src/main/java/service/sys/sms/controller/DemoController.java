package service.sys.sms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import service.sys.sms.service.DemoService;

@RestController
public class DemoController {

    private static final Logger LOGGER = LogManager.getLogger(DemoController.class);

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private DemoService demoService;

    @Value("${info.pwd}")
    private String pwd;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        LOGGER.info("/add, host:" + instance.getHost() + ":" + instance.getPort() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return "From service-sys-sms, Result is " + r;
    }

    @GetMapping("/hello")
    public String helloWorld() {
        LOGGER.info("==========hello");
        return demoService.hello();
    }

    @GetMapping("/getPwd")
    public String getPwd() {
        return pwd;
    }
}