package service.basic.user.dao.impl;

import com.ymu.spcselling.infrastructure.dao.BaseDaoImpl;
import org.springframework.stereotype.Repository;
import service.basic.user.dao.UserDao;
import service.basic.user.dao.UserRepository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserRepository> implements UserDao {

    @Override
    public String findUsernameByMobile() {
        return null;
    }
}
