package service.sys.common.vo.req;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class VIdGenReqValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return VIdGenReq.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
//        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        VIdGenReq vIdGenReq = (VIdGenReq) o;
        if (vIdGenReq.getDataCenterId() < 0) {
            ValidationUtils.rejectIfEmpty(errors,"dataCenterId","1001","0");
        } else if (vIdGenReq.getDataCenterId() > 31) {

        }

        if (vIdGenReq.getWorkerId() < 0) {

        } else if (vIdGenReq.getWorkerId() > 31) {

        }
    }
}
