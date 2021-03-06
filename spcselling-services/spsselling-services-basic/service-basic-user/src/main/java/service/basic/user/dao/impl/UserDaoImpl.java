package service.basic.user.dao.impl;

import com.spcs.entity.user.User;
import com.ymu.spcselling.infrastructure.dao.BaseDaoImpl;
import com.ymu.spcselling.infrastructure.dao.ds.DSInject;
import com.ymu.spcselling.infrastructure.utils.sql.SqlBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import service.basic.user.common.Constants;
import service.basic.user.dao.UserDao;
import service.basic.user.dao.UserRepository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<UserRepository> implements UserDao {

    private static final Logger LOGGER = LogManager.getLogger(UserDaoImpl.class);

    @DSInject(value = Constants.SPCS_USER_SLAVE)
    @Override
    public String findUserMobileById(long id) {
        String sql = new SqlBuilder(){
            {
                SELECT("u.password");
                FROM("user as u");
                WHERE("u.id=?");
            }
        }.toString();
        LOGGER.debug("sql:" + sql);
        String mobile = jdbcTemplate.queryForObject(sql,new Object[]{id},String.class);
        return mobile;
    }

    /**
     * 根据电话号码查找用户。
     *
     * @param mobile 用户注册手机号码。
     * @return
     */
    @Override
    public User findUserByMobile(String mobile) {
        /*QUser qUser = QUser.user;
        JPAQuery<User> query = new JPAQuery<>(em);
        User user = query.from(qUser).where(qUser.mobile.eq(mobile)).fetchOne();
        return user;*/
        return null;
    }
}
