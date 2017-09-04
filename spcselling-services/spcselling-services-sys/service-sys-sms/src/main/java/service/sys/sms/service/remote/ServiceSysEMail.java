package service.sys.sms.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.sys.sms.common.Constants;
import service.sys.sms.service.remote.hystrix.ServiceSysEMailHystrix;

@Component
@FeignClient(value = Constants.ServiceAppName.SERVICE_SYS_EMAIL,fallback = ServiceSysEMailHystrix.class)
public interface ServiceSysEMail {

    @GetMapping("/add")
   String hello();
}
