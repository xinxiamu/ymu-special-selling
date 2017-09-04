package service.sys.sms.service.remote.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import service.sys.sms.service.remote.ServiceSysEMail;

/**
 * Created by Administrator on 2017-09-01.
 */
@Component
public class ServiceSysEMailHystrix implements ServiceSysEMail {

    @Override
    public String hello() {
        return "====出错熔断";
    }
}
