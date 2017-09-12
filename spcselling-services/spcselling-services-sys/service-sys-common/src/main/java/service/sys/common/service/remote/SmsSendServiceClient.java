//package service.sys.common.service.remote;
//
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.cloud.netflix.feign.FeignClient;
//import service.sys.email.common.Constants;
//import service.sys.email.service.remote.hystrix.SmsSendServiceClientHystrix;
//import service.sys.common.api.SmsSendServiceApi;
//
///**
// * 调用远程服务service-sys-common
// */
//@FeignClient(value = Constants.ServiceAppName.SERVICE_SYS_SMS,fallback = SmsSendServiceClientHystrix.class)
//@Qualifier("smsSendServiceClient")
//public interface SmsSendServiceClient extends SmsSendServiceApi {
//
//}
