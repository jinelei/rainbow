package cn.jinelei.rainbow.blog.service;

import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author zhenlei
 */
public interface UserService {
    /**
     * 添加用户
     *
     * @param userEntity
     * @return
     * @throws CustomizeException
     */
    UserEntity addUser(UserEntity userEntity) throws CustomizeException;

    /**
     * 删除用户
     *
     * @param userEntity
     * @return
     * @throws CustomizeException
     */
    void removeUser(UserEntity userEntity) throws CustomizeException;

    /**
     * 更新用户
     *
     * @param userEntity
     * @return
     * @throws CustomizeException
     */
    UserEntity updateUser(UserEntity userEntity) throws CustomizeException;

    /**
     * 查找用户
     *
     * @param id 用户id
     * @return
     * @throws CustomizeException
     */
    UserEntity findUserById(Integer id) throws CustomizeException;

    /**
     * 验证用户名密码
     *
     * @param username
     * @param password
     * @return
     * @throws CustomizeException
     */
    UserEntity validUserByUsernameAndPassword(String username, String password)
            throws CustomizeException;
}
