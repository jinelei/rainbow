package cn.jinelei.rainbow.blog.exception.handler;


import cn.jinelei.rainbow.blog.exception.CustomizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhenlei
 */
@ControllerAdvice
public class GlobalExceptionhandler {

    @ExceptionHandler(value = {CustomizeException.class})
    @ResponseBody
    public CustomizeException handleException(CustomizeException e) {
        return e;
    }
}
