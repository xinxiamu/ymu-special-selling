package service.sys.sms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.sys.sms.api.SmsSendServiceApi;
import service.sys.sms.service.SmsSendService;

@RestController
public class SmsSendController implements SmsSendServiceApi {

    private static final Logger LOGGER = LogManager.getLogger(SmsSendController.class);

    @Autowired
    private EurekaRegistration eurekaRegistration;

    @Autowired
    private SmsSendService smsSendService;

   /* @Value("${info.pwd}")
    private String pwd;*/

    @GetMapping("/getPwd")
    public String getPwd() {
        return "pwd";
    }


    @Override
    public String send(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        LOGGER.info("==========send");
        return "send sms:" + smsSendService.send(a,b);
    }

    @Override
    public String helloWorld() {
        LOGGER.info("==========hello");
        String serviceId = eurekaRegistration.getServiceId();
        LOGGER.info("/add, host:" + eurekaRegistration.getInstanceConfig().getHostName(true) + ":" + eurekaRegistration.getNonSecurePort() + ", service_id:" + serviceId);
        return "hello,From service-sys-sms";
    }
}