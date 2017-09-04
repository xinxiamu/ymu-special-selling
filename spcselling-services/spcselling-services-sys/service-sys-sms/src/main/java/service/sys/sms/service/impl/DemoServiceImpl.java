package service.sys.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.sys.sms.service.DemoService;
import service.sys.sms.service.remote.ServiceSysEMail;

/**
 * Created by Administrator on 2017-09-01.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private ServiceSysEMail serviceSysEMail;

    @Override
    public String hello() {
        return "hello::::" + serviceSysEMail.hello();
    }
}
