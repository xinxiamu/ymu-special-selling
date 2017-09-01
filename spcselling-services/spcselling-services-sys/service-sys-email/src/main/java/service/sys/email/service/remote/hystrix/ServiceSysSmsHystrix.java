package service.sys.email.service.remote.hystrix;

import org.springframework.stereotype.Component;
import service.sys.email.service.remote.ServiceSysSms;

@Component
public class ServiceSysSmsHystrix implements ServiceSysSms {

    @Override
    public String add(Integer a, Integer b) {
        return a + b + "===错鸟";
    }
}
