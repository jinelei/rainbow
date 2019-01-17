package cn.jinelei.rainbow.blog.service.impl;

import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.exception.enumerate.UserExceptionEnum;
import cn.jinelei.rainbow.blog.model.UserModel;
import cn.jinelei.rainbow.blog.repository.UserRepository;
import cn.jinelei.rainbow.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhenlei
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = {CustomizeException.class, Exception.class})
    public UserModel addUser(UserModel userModel) throws CustomizeException {
        UserModel saveResult = userRepository.save(userModel);
        if (!saveResult.equalsWithId(userModel)) {
            throw new CustomizeException(UserExceptionEnum.INSERT_DATA_ERROR);
        }
        return saveResult;
    }

    @Override
    @Transactional(rollbackFor = {CustomizeException.class, Exception.class})
    public void removeUser(UserModel userModel) throws CustomizeException {
        userRepository.delete(userModel);
    }

    @Override
    @Transactional(rollbackFor = {CustomizeException.class, Exception.class})
    public UserModel updateUser(UserModel userModel) throws CustomizeException {
        UserModel saveResult = userRepository.save(userModel);
        if (!saveResult.equalsWithId(userModel)) {
            throw new CustomizeException(UserExceptionEnum.UPDATE_DATA_ERROR);
        }
        return saveResult;
    }
}
