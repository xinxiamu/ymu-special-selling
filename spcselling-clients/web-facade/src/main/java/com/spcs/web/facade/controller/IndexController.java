package com.spcs.web.facade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String cachePage(Model model) {
        model.addAttribute("name", "111111111");
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
