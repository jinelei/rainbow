package cn.jinelei.rainbow.blog.controller;

import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.exception.enumerate.BaseExceptionEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhenlei
 */
@RestController
@ResponseBody
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/exception")
    public String testException() throws CustomizeException {
        throw new CustomizeException(BaseExceptionEnum.INSERT_DATA_ERROR);
    }
}
