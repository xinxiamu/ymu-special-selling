package com.spcs.web.facade.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class WebBaseController {

    

    @ModelAttribute
    public void setReqAndRes(Model model) {
        model.addAttribute("static.url","");
    }

}
