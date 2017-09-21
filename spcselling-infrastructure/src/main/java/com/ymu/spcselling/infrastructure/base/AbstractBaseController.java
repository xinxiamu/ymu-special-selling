package com.ymu.spcselling.infrastructure.base;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class AbstractBaseController {

    @InitBinder
    protected abstract void initBinder(WebDataBinder binder);
}
