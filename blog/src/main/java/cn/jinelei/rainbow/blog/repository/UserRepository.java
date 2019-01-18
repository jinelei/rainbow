package cn.jinelei.rainbow.blog.repository;

import cn.jinelei.rainbow.blog.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author zhenlei
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    /**
     * 通过用户名密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    Optional<UserEntity> findUserEntityByUsernameAndPassword(String username, String password);
}
