package service.sys.common.api;

import com.spcs.apis.common.ApiRespResultVO;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import service.sys.common.vo.req.VSmsReq;

import javax.validation.Valid;

/**
 * 短信服务。
 * Created by Administrator on 2017-09-08.
 */
@RequestMapping("/sms")
public interface SendSmsServiceApi {

    /**
     * 发送短信。
     * @param vSmsReq
     * @return
     */
    @PostMapping
    ApiRespResultVO sendSms(@RequestBody @Valid VSmsReq vSmsReq, BindingResult result);
}
