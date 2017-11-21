package com.spcs.web.facade.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public class BaseController {

    @Value("${static.server.url}")
    private String staticUrl;

    @ModelAttribute
    public void setReqAndRes(Model model) {
        model.addAttribute("static.url",staticUrl);
    }

}
