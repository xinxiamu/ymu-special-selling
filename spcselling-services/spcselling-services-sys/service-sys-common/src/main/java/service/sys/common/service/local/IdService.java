package service.sys.common.service.local;


import java.util.Date;

public interface IdService {

    long genId();

    ID expId(long id);

    Date transTime(long time);

    long makeId(long time, long seq);

    long makeId(long time, long seq, long machine);
}
