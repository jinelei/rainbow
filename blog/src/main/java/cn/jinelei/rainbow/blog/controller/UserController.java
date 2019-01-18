package cn.jinelei.rainbow.blog.controller;

import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.exception.enumerate.BaseExceptionEnum;
import cn.jinelei.rainbow.blog.exception.enumerate.UserExceptionEnum;
import cn.jinelei.rainbow.blog.entity.UserEntity;
import cn.jinelei.rainbow.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    HttpServletRequest request;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/test",
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public String test() throws CustomizeException {
        LOGGER.debug(request.getServletContext().getRealPath("/"));
        LOGGER.debug(request.getServletContext().getContextPath());
        throw new CustomizeException(BaseExceptionEnum.INSERT_DATA_ERROR);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserEntity> addUser(
            @RequestBody UserEntity userEntity) throws CustomizeException {
        LOGGER.debug("addUser: " + userEntity);
        UserEntity opeartionResult = userService.addUser(userEntity);
        HttpHeaders httpHeaders = new HttpHeaders();
        URI locationUrl = URI.create(String.format("http://%s:%d/user/id/%d",
                request.getLocalName(), request.getLocalPort(), opeartionResult.getUserId()));
        httpHeaders.setLocation(locationUrl);
        return new ResponseEntity<UserEntity>(opeartionResult, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE,
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public void deleteUser(UserEntity userEntity) throws CustomizeException {
        userService.removeUser(userEntity);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public UserEntity updateUser(UserEntity userEntity) throws CustomizeException {
        UserEntity opeartionResult = userService.updateUser(userEntity);
        return opeartionResult;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET,
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserEntity> getUserById(
            @PathVariable(name = "id", required = true) Integer id) throws CustomizeException {
        UserEntity opeartionResult = userService.findUserById(id);
        LOGGER.debug("getUserById: " + id);
        return new ResponseEntity<UserEntity>(opeartionResult, HttpStatus.OK);
    }

}
