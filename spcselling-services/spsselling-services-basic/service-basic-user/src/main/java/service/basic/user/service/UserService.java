package service.basic.user.service;

import com.ymu.spcselling.entity.user.User;

public interface UserService {

    User getUserByMobile(String mobile);

    String findUserMobileById(long id);
}
