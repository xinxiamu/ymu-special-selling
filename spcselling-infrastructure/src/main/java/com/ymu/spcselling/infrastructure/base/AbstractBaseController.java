package com.ymu.spcselling.infrastructure.base;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractBaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
    }

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request,
                             HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

}
