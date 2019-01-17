package cn.jinelei.rainbow.blog.exception.handler;


import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.view.ErrorView;
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
    public ErrorView handleCustomizeException(CustomizeException e) {
        return new ErrorView(e);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public Exception handleException(Exception e) {
        return e;
    }


}
