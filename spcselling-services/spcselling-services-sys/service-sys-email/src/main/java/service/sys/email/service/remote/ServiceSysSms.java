package service.sys.email.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.sys.email.common.Constants;
import service.sys.email.service.remote.hystrix.ServiceSysSmsHystrix;

/**
 * 调用远程服务service-sys-sms
 */
@FeignClient(value = Constants.ServiceAppName.SERVICE_SYS_SMS,fallback = ServiceSysSmsHystrix.class)
public interface ServiceSysSms {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b);
}
