package service.basic.user.service.impl;

import com.ymu.spcselling.entity.user.User;
import com.ymu.spcselling.infrastructure.dao.ds.DataSourceContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.basic.user.config.ds.DSType;
import service.basic.user.dao.UserDao;
import service.basic.user.dao.UserRepository;
import service.basic.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserByMobile(String mobile) {
        DataSourceContextHolder.setDS(DSType.SPCS_USER.name());
        return userDao.findUserByMobile(mobile);

//        return userDao.getMRepository().findUserByMobile(mobile);
    }

    @Override
    public String findUserMobileById(long id) {
        return userDao.findUserMobileById(id);
    }
}