package service.sys.common.vo.req;

import com.ymu.spcselling.infrastructure.base.VBaseReq;

public class VIdGenReq extends VBaseReq {

    /**
     * 数据中心id
     */
    private long dataCenterId;

    /**
     * 机器id
     */
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
