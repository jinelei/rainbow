package cn.jinelei.rainbow.blog.repository;

import cn.jinelei.rainbow.blog.model.UserModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhenlei
 */
@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {
}
