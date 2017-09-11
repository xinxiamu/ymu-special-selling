package service.sys.email.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import service.sys.email.service.HelloService;
import service.sys.email.service.remote.ServiceSysSmsClient;

/**
 * Created by Administrator on 2017-09-01.
 */
@Service
public class HelloServiceImpl implements HelloService {

    private static final Logger LOGGER = LogManager.getLogger(HelloServiceImpl.class);

    @Qualifier("serviceSysSmsClient")
    @Autowired
    private ServiceSysSmsClient serviceSysSmsClient;

    @Override
    public String helloWorld(int a, int b) {
        LOGGER.debug("===========服务调用：serviceSysSmsClient");
        return  serviceSysSmsClient.send(a,b);
    }
}
