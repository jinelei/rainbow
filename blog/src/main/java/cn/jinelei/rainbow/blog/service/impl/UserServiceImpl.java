package cn.jinelei.rainbow.blog.service.impl;

import cn.jinelei.rainbow.blog.entity.UserEntity;
import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.exception.enumerate.UserExceptionEnum;
import cn.jinelei.rainbow.blog.repository.UserRepository;
import cn.jinelei.rainbow.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author zhenlei
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = {CustomizeException.class, Exception.class})
    public UserEntity addUser(UserEntity userEntity) throws CustomizeException {
        UserEntity saveResult = userRepository.save(userEntity);
        if (!saveResult.equalsWithId(userEntity)) {
            throw new CustomizeException(UserExceptionEnum.INSERT_DATA_ERROR);
        }
        return saveResult;
    }

    @Override
    @Transactional(rollbackFor = {CustomizeException.class, Exception.class})
    public void removeUser(UserEntity userEntity) throws CustomizeException {
        userRepository.delete(userEntity);
    }

    @Override
    @Transactional(rollbackFor = {CustomizeException.class, Exception.class})
    public UserEntity updateUser(UserEntity userEntity) throws CustomizeException {
        UserEntity saveResult = userRepository.save(userEntity);
        if (!saveResult.equalsWithId(userEntity)) {
            throw new CustomizeException(UserExceptionEnum.UPDATE_DATA_ERROR);
        }
        return saveResult;
    }

    @Override
    @Transactional(rollbackFor = {CustomizeException.class, Exception.class})
    public UserEntity findUserById(Integer id) throws CustomizeException {
        Optional<UserEntity> findResult = userRepository.findById(id);
        if (findResult.isPresent()) {
            return findResult.get();
        } else {
            throw new CustomizeException(UserExceptionEnum.USER_NOT_FOUND);
        }
    }

    @Override
    public UserEntity validUserByUsernameAndPassword(String username, String password) throws CustomizeException {
        Optional<UserEntity> userEntityOption = userRepository.findUserEntityByUsernameAndPassword(username, password);
        if (userEntityOption.isPresent()) {
            return userEntityOption.get();
        } else {
            throw new CustomizeException(UserExceptionEnum.USERNAME_OR_PASSWORD_INVAILD);
        }
    }

}
