package service.sys.common.service.local;

/**
 * Created by Administrator on 2017-09-01.
 */
public interface SendSmsService {

    /**
     * 发送短信
     * @param mobile
     * @param content
     * @return
     */
    String send(String mobile, String content);
}
