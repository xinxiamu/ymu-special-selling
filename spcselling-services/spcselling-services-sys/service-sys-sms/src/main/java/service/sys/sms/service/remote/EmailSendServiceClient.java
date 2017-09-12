package service.sys.sms.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import service.sys.sms.api.EmailSendServiceApi;
import service.sys.sms.common.Constants;
import service.sys.sms.service.remote.hystrix.EmailSendServiceClientHystrix;

@Component
@FeignClient(value = Constants.ServiceAppName.SERVICE_SYS_EMAIL,fallback = EmailSendServiceClientHystrix.class)
public interface EmailSendServiceClient extends EmailSendServiceApi {
}
