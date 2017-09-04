package service.sys.email.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.sys.email.service.DemoService;
import service.sys.email.service.remote.ServiceSysSms;

/**
 * Created by Administrator on 2017-09-01.
 */
@Service
public class DemoServiceImpl implements DemoService {

    private static final Logger LOGGER = LogManager.getLogger(DemoServiceImpl.class);

    @Autowired
    ServiceSysSms serviceSysSms;

    @Override
    public String helloWorld(int a, int b) {
        return  serviceSysSms.add(a, b);
    }
}
