package service.basic.user.dao;

import com.ymu.spcselling.infrastructure.dao.BaseDao;

public interface UserDao extends BaseDao<UserRepository> {

    String findUsernameByMobile();
}
