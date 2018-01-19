package service.basic.user.service.impl;

import com.spcs.entity.user.User;
import com.ymu.spcselling.infrastructure.dao.ds.DSInject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.basic.user.common.Constants;
import service.basic.user.dao.UserDao;
import service.basic.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @DSInject(value = Constants.SPCS_USER_SLAVE)
    @Override
    public User getUserByMobile(String mobile) {
        return userDao.findUserByMobile(mobile);
    }

    @Override
    public String findUserMobileById(long id) {
        return userDao.findUserMobileById(id);
    }
}