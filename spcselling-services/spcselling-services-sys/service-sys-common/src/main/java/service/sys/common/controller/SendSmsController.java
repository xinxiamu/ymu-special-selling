package service.sys.common.controller;

import com.ymu.spcselling.infrastructure.base.AbstractBaseController;
import com.ymu.spcselling.infrastructure.spring.AppContext;
import com.ymu.spcselling.infrastructure.spring.mvc.api.ApiRespResultVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.serviceregistry.EurekaRegistration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContextUtils;
import service.sys.common.api.SendSmsServiceApi;
import service.sys.common.vo.req.VSmsReq;
import service.sys.common.vo.req.VSmsReqValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

@RefreshScope
@RestController
public class SendSmsController extends AbstractBaseController implements SendSmsServiceApi {

    private static final Logger LOGGER = LogManager.getLogger(SendSmsController.class);

    @Override
    protected void initBinder(WebDataBinder binder) {
        super.initBinder(binder);
        binder.addValidators(new VSmsReqValidator());
    }

    @Autowired
    private EurekaRegistration eurekaRegistration;

    @Override
    public ApiRespResultVO sendSms(@RequestBody @Valid VSmsReq vSmsReq, BindingResult result) {
        Locale locale = RequestContextUtils.getLocaleResolver(request).resolveLocale(request);
        String menuName = AppContext.getApplicationContext().getMessage("hello",null, "菜单A", locale);

        LOGGER.info("==========hello::" + menuName);
        String serviceId = eurekaRegistration.getServiceId();
        LOGGER.info("/add, host:" + eurekaRegistration.getInstanceConfig().getHostName(true) + ":" + eurekaRegistration.getNonSecurePort() + ", service_id:" + serviceId);
        return ApiRespResultVO.getInstance("发送短信成功!", HttpStatus.CREATED);
    }

}