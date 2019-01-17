package cn.jinelei.rainbow.blog.service;

import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.model.UserModel;

/**
 * @author zhenlei
 */
public interface UserService {
    /**
     * 添加用户
     *
     * @param userModel
     * @throws CustomizeException
     */
    UserModel addUser(UserModel userModel) throws CustomizeException;

    /**
     * 删除用户
     *
     * @param userModel
     * @throws CustomizeException
     */
    void removeUser(UserModel userModel) throws CustomizeException;

    /**
     * 更新用户
     *
     * @param userModel
     * @throws CustomizeException
     */
    UserModel updateUser(UserModel userModel) throws CustomizeException;
}
