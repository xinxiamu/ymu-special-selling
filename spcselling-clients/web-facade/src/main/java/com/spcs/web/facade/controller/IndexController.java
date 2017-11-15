package com.spcs.web.facade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/index")
public class IndexController {

    @RequestMapping
    public String cachePage(Model model) {
        model.addAttribute("name", "abc");
        return "index";
    }
}
