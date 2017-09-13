package service.sys.email.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import service.sys.email.common.Constants;
import service.sys.email.service.remote.hystrix.SmsSendServiceClientHystrix;
import service.sys.sms.api.SmsSendServiceApi;

import java.io.Serializable;

/**
 * 调用远程服务service-sys-sms
 */
@FeignClient(value = Constants.ServiceAppName.SERVICE_SYS_SMS,fallback = SmsSendServiceClientHystrix.class)
public interface SmsSendServiceClient extends SmsSendServiceApi {

}
