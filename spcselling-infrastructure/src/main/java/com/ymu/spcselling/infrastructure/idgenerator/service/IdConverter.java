package com.ymu.spcselling.infrastructure.idgenerator.service;


public interface IdConverter {
    long convert(ID id);

    ID convert(long id);
}
