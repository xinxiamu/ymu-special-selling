package service.sys.sms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017-09-08.
 */
public interface HelloServiceApi {

    @GetMapping("/add")
    String add();

    @GetMapping("/hello")
    String hello(@RequestParam int a, @RequestParam int b);
}
