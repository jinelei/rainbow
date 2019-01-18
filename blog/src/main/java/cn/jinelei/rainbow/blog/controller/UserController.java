package cn.jinelei.rainbow.blog.controller;

import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.exception.enumerate.BaseExceptionEnum;
import cn.jinelei.rainbow.blog.exception.enumerate.UserExceptionEnum;
import cn.jinelei.rainbow.blog.model.UserModel;
import cn.jinelei.rainbow.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @RequestMapping("/exception")
    public String testException() throws CustomizeException {
        throw new CustomizeException(BaseExceptionEnum.INSERT_DATA_ERROR);
    }

    @RequestMapping("/test")
    public String test() throws CustomizeException {
        return "test";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel userModel) throws CustomizeException {
        LOGGER.debug("addUser: " + userModel);
        UserModel opeartionResult = userService.addUser(userModel);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI locationUrl = URI.create("localhost:8080/user/" + opeartionResult.getUserId());
        httpHeaders.setLocation(locationUrl);
        return new ResponseEntity<UserModel>(opeartionResult, httpHeaders, HttpStatus.CREATED);
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

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserModel> getUserById(@PathVariable(name = "id", required = true) Integer id) throws CustomizeException {
        Optional<UserModel> opeartionResult = userService.findUserById(id);
        LOGGER.debug("getUserById: " + id);
        if (opeartionResult.isPresent()) {
            return new ResponseEntity<UserModel>(opeartionResult.get(), HttpStatus.OK);
        } else {
            throw new CustomizeException(UserExceptionEnum.USER_NOT_FOUND);
        }
    }

}
