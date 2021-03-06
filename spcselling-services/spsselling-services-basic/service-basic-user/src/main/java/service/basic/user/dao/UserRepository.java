package service.basic.user.dao;

import com.spcs.entity.user.User;
import com.ymu.spcselling.infrastructure.dao.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends BaseRepository<User,Long>,JpaSpecificationExecutor<User> {

    User findUserByMobile(String mobile);
}
