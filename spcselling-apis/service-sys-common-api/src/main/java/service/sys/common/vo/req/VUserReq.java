package service.sys.common.vo.req;

import com.ymu.spcselling.entity.constants.UserType;
import com.ymu.spcselling.infrastructure.base.VBaseReq;

public class VUserReq extends VBaseReq {

    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}
