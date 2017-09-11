package service.sys.sms.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017-09-08.
 */
public interface HelloServiceApi {

    @GetMapping("/add")
    default String add() {
        return null;
    }

    ;

    @GetMapping("/hello")
    default String hello(@RequestParam(value = "a") int a, @RequestParam(value = "b") int b) {
        return null;
    }

    ;
}
