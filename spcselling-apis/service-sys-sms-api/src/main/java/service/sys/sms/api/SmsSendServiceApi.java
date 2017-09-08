package service.sys.sms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017-09-08.
 */
public interface SmsSendServiceApi {

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    String send(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

    @GetMapping("/hello")
    String helloWorld();
}
