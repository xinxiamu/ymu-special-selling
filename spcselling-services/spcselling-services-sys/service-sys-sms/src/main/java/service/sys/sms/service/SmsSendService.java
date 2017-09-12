package service.sys.sms.service;

/**
 * Created by Administrator on 2017-09-01.
 */
public interface SmsSendService {

    String send(String mobile, String content);
}
