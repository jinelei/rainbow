package cn.jinelei.rainbow.blog.controller;

import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.exception.enumerate.UserExceptionEnum;
import cn.jinelei.rainbow.blog.model.UserModel;
import cn.jinelei.rainbow.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author zhenlei
 */
@RestController
@ResponseBody
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public UserModel addUser(UserModel userModel) throws CustomizeException {
        UserModel opeartionResult = userService.addUser(userModel);
        return opeartionResult;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser(UserModel userModel) throws CustomizeException {
        userService.removeUser(userModel);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserModel updateUser(UserModel userModel) throws CustomizeException {
        UserModel opeartionResult = userService.updateUser(userModel);
        return opeartionResult;
    }

    @RequestMapping(name = "/:id", method = RequestMethod.GET)
    public UserModel getUserById(@PathVariable("id") Integer id) throws CustomizeException {
        Optional<UserModel> opeartionResult = userService.findUserById(id);
        if (opeartionResult.isPresent()) {
            return opeartionResult.get();
        } else {
            throw new CustomizeException(UserExceptionEnum.USER_NOT_FOUND);
        }
    }

}
