package service.sys.email.service.remote.hystrix;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import service.sys.email.service.remote.ServiceSysSmsClient;

@Component
@Qualifier("serviceSysSmsClientHystrix")
public class ServiceSysSmsClientHystrix implements ServiceSysSmsClient {

    @Override
    public String send(Integer a, Integer b) {
        return "abc";
    }
}
