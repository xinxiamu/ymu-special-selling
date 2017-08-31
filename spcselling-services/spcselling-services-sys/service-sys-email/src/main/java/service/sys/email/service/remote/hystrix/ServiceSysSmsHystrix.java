package service.sys.email.service.remote.hystrix;

import service.sys.email.service.remote.ServiceSysSms;

public class ServiceSysSmsHystrix implements ServiceSysSms {

    @Override
    public String add(Integer a, Integer b) {
        return a + b + "===";
    }
}
