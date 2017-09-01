package service.sys.sms.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.sys.sms.common.Constants;
import service.sys.sms.service.remote.hystrix.ServiceSysEMailHystrix;

@FeignClient(value = Constants.ServiceAppName.SERVICE_SYS_EMAIL,fallback = ServiceSysEMailHystrix.class)
public interface ServiceSysEMail {

    @GetMapping("/hello")
   String hello(@RequestParam int a, @RequestParam int b);
}
