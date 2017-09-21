package service.sys.common.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017-09-08.
 */
public interface SendEmailServiceApi {

    @GetMapping("/sendEmail")
    String sendEmail(@RequestParam(value = "email") String email, @RequestParam(value = "content") String content);

}
