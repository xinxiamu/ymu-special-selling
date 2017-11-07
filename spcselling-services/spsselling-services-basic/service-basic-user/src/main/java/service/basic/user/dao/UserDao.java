package service.basic.user.dao;

import com.ymu.spcselling.entity.user.User;
import com.ymu.spcselling.infrastructure.dao.BaseDao;
import com.ymu.spcselling.infrastructure.dao.ds.DSInject;
import service.basic.user.common.Constants;
import service.basic.user.config.ds.DSType;

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
