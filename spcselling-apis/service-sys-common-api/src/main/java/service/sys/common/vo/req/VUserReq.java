package service.sys.common.vo.req;

import com.spcs.apis.common.VBaseReq;
import com.spcs.entity.constants.UserType;

public class VUserReq extends VBaseReq {

    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
