package service.sys.common.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017-09-08.
 */
public interface SendSmsServiceApi {

    @RequestMapping(value = "/sendSms", method = RequestMethod.GET)
    String sendSms(@RequestParam(value = "mobile") String mobile, @RequestParam(value = "content") String content);
}
