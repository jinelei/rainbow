package cn.jinelei.rainbow.blog.service.impl;

import cn.jinelei.rainbow.blog.authorization.annotation.Authorization;
import cn.jinelei.rainbow.blog.entity.TokenEntity;
import cn.jinelei.rainbow.blog.entity.UserEntity;
import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.exception.enumerate.BaseExceptionEnum;
import cn.jinelei.rainbow.blog.exception.enumerate.UserExceptionEnum;
import cn.jinelei.rainbow.blog.service.TokenService;
import cn.jinelei.rainbow.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhenlei
 */
@Service
public class TokenServiceTestImpl implements TokenService {
    Map<UserEntity, String> tokenStore = new HashMap<>(100);

    @Autowired
    UserService userService;

    @Override
    public TokenEntity createToken(UserEntity userEntity) {
        TokenEntity tokenEntity = new TokenEntity(userEntity, "test");
        tokenStore.put(userEntity, "test");
        return tokenEntity;
    }

    @Override
    public boolean checkToken(TokenEntity model, Authorization authorization) throws CustomizeException {
        UserEntity user = model.getUserEntity();
        boolean result = tokenStore.containsKey(user) && tokenStore.get(user).equals(model.getToken());
        if (!result) {
            return false;
        }
        if (user.getGroupPrivilege().getCode() < authorization.groupType()) {
            throw new CustomizeException(UserExceptionEnum.UNAUTHORIZED_USER);
        }
        if (user.getUserPrivilege().getCode() < authorization.userType()) {
            throw new CustomizeException(UserExceptionEnum.UNAUTHORIZED_GROUP);
        }
        return result;
    }

    @Override
    public TokenEntity getToken(String authentication) throws CustomizeException {
        String[] auths = authentication.split(":");
        Integer userId = Integer.valueOf(auths[0]);
        UserEntity user = userService.findUserById(userId);
        if (tokenStore.containsKey(user) && tokenStore.get(user).equals(auths[1])) {
            return new TokenEntity(user, auths[1]);
        } else {
            return null;
        }
    }

    @Override
    public void deleteToken(UserEntity userEntity) throws CustomizeException {
        if (tokenStore.containsKey(userEntity)) {
            tokenStore.remove(userEntity);
        } else {
            throw new CustomizeException(UserExceptionEnum.USER_NOT_LOGIN);
        }
    }
}
