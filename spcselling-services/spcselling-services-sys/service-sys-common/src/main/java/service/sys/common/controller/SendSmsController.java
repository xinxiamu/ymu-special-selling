package service.sys.common.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.web.bind.annotation.RestController;
import service.sys.common.api.SendSmsServiceApi;

@RestController
public class SendSmsController implements SendSmsServiceApi {

    private static final Logger LOGGER = LogManager.getLogger(SendSmsController.class);

    @Autowired
    private EurekaRegistration eurekaRegistration;

    @Override
    public String sendSms(String mobile, String content) {
        LOGGER.info("==========hello");
        String serviceId = eurekaRegistration.getServiceId();
        LOGGER.info("/add, host:" + eurekaRegistration.getInstanceConfig().getHostName(true) + ":" + eurekaRegistration.getNonSecurePort() + ", service_id:" + serviceId);
        return "hello,From service-sys-common";
    }

}