package service.sys.sms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.sys.sms.api.SmsSendServiceApi;
import service.sys.sms.service.SmsSendService;

@RestController
public class SmsSendController implements SmsSendServiceApi {

    private static final Logger LOGGER = LogManager.getLogger(SmsSendController.class);

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private SmsSendService smsSendService;

   /* @Value("${info.pwd}")
    private String pwd;*/

    @GetMapping("/getPwd")
    public String getPwd() {
        return "pwd";
    }

    @Override
    public String send(@RequestParam Integer a, @RequestParam Integer b) {
        LOGGER.info("==========send");
         return "send sms:" + (a + b);
    }

    @Override
    public String helloWorld() {
        LOGGER.info("==========hello");
        ServiceInstance instance = client.getLocalServiceInstance();
        LOGGER.info("/add, host:" + instance.getHost() + ":" + instance.getPort() + ", service_id:" + instance.getServiceId());
        return "hello,From service-sys-sms";
    }
}