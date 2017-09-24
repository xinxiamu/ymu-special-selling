package service.sys.common.vo.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class VIdGenReq {

    @NotNull
    private String name;

    /**
     * 数据中心id
     */
    @Min(0)
    @Max(31)
    private long dataCenterId;

    /**
     * 机器id
     */
    @Min(0)
    @Max(31)
    private long workerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(long dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }
}
