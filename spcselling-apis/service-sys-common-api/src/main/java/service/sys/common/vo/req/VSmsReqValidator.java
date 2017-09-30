package service.sys.common.vo.req;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VSmsReqValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return VSmsReq.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//        ValidationUtils.rejectIfEmpty(errors,"mobile","1002");
        VSmsReq vSmsReq = (VSmsReq) target;
        if (vSmsReq.getMobile() == null || "".equals(vSmsReq.getMobile())) {
            throw new NullPointerException("手机号码不能空");
        }
    }
}
