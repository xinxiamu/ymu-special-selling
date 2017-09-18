package com.ymu.spcselling.infrastructure.idgenerator.service;


import com.ymu.spcselling.infrastructure.idgenerator.bean.ID;

public interface IdConverter {
    long convert(ID id);

    ID convert(long id);
}
