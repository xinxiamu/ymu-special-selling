package service.sys.common.vo.resp;

import com.spcs.apis.common.VBaseResp;

public class VSnowflakeIdResp extends VBaseResp {

    /**
     * 时间戳。41位的时间序列
     */
    private long timeStamp;

    /**
     * 数据中心id。5位
     */
    private long dataCenterId;

    /**
     * 节点机器id。5位
     */
    private long workerId;

    /**
     * 12位序列号
     */
    private long sequence;

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
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

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }
}
