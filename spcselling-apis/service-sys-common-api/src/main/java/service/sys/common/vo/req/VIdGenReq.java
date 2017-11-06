package service.sys.common.vo.req;


import com.spcs.apis.common.VBaseReq;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class VIdGenReq extends VBaseReq {

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
