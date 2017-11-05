package service.basic.user.dao.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.ymu.spcselling.entity.user.QUser;
import com.ymu.spcselling.entity.user.User;
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

    /**
     * 根据电话号码查找用户。
     *
     * @param mobile 用户注册手机号码。
     * @return
     */
    @Override
    public User findUserByMobile(String mobile) {
        QUser  qUser = QUser.user;
        JPAQuery<User> query = new JPAQuery<User>(em);
        User user = query.from(qUser).where(qUser.mobile.eq(mobile)).fetchOne();
        return user;
    }
}
