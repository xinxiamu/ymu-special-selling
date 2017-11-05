package service.basic.user.dao;

import com.ymu.spcselling.entity.user.User;
import com.ymu.spcselling.infrastructure.dao.BaseDao;

public interface UserDao extends BaseDao<UserRepository> {

    String findUsernameByMobile();

    /**
     * 根据电话号码查找用户。
     * @param mobile 用户注册手机号码。
     * @return
     */
    User findUserByMobile(String mobile);
}
