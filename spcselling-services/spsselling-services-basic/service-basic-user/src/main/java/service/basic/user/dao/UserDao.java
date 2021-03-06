package service.basic.user.dao;

import com.spcs.entity.user.User;
import com.ymu.spcselling.infrastructure.dao.BaseDao;

public interface UserDao extends BaseDao<UserRepository> {

    /**
     * 根据用户id获取用户手机号码。
     * @param id
     * @return
     */
    String findUserMobileById(long id);

    /**
     * 根据电话号码查找用户。
     * @param mobile 用户注册手机号码。
     * @return
     */
    User findUserByMobile(String mobile);
}
