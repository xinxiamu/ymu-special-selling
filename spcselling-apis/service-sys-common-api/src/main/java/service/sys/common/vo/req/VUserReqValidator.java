package service.sys.common.vo.req;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VUserReqValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
