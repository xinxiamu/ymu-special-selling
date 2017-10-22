package service.basic.user.vo.req;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VUserReqValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return VUserReq.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        VUserReq vUserReq = (VUserReq) o;
    }
}
