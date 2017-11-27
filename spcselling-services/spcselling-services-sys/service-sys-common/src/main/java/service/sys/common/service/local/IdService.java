package service.sys.common.service.local;


import service.sys.common.vo.resp.VSnowflakeIdResp;

public interface IdService {

    /**
     * 生成ID（线程安全）
     * @param dataCenterId 数据中心id
     * @param workerId 机器id(节点)
     * @return id
     */
    long genId(long dataCenterId, long workerId);

    /**
     * 对id进行解析
     *
     * @param id 生成的ID
     * @return 封装的ID类
     */
    VSnowflakeIdResp expId(long id);


}
