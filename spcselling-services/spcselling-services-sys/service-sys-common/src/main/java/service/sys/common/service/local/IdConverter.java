package service.sys.common.service.local;


public interface IdConverter {

    long convert(ID id);

    ID convert(long id);
}
