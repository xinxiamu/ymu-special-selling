package service.sys.sms.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import service.sys.sms.api.HelloServiceApi;
import service.sys.sms.common.Constants;
import service.sys.sms.service.remote.hystrix.HelloServiceClientlHystrix;

@Component
@FeignClient(value = Constants.ServiceAppName.SERVICE_SYS_EMAIL,fallback = HelloServiceClientlHystrix.class)
public interface HelloServiceClient extends HelloServiceApi {
}
