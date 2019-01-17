package cn.jinelei.rainbow.blog.service;

import cn.jinelei.rainbow.blog.model.UserModel;

/**
 * @author zhenlei
 */
public interface UserService {
    void addUser(UserModel userModel) throws UserException;
}
