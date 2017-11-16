package com.spcs.web.facade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String cachePage(Model model) {
        model.addAttribute("name", "111111111");
        return "index";
    }
}
