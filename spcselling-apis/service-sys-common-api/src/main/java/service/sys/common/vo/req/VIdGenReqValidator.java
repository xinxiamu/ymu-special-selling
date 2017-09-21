package service.sys.common.vo.req;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VIdGenReqValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return VIdGenReq.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        VIdGenReq vIdGenReq = (VIdGenReq) o;
        if (vIdGenReq.getDataCenterId() < 0) {

        } else if (vIdGenReq.getDataCenterId() > 31) {

        }

        if (vIdGenReq.getWorkerId() < 0) {

        } else if (vIdGenReq.getWorkerId() > 31) {

        }
    }
}
