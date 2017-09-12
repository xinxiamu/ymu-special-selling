package service.sys.sms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017-09-08.
 */
public interface EmailSendServiceApi {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/send")
    String send(@RequestParam(value = "email") String email, @RequestParam(value = "content") String content);

}
