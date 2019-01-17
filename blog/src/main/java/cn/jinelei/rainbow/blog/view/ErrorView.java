package cn.jinelei.rainbow.blog.view;

import cn.jinelei.rainbow.blog.exception.CustomizeException;
import cn.jinelei.rainbow.blog.exception.enumerate.ArticleExceptionEnum;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * @author zhenlei
 */
public class ErrorView implements Serializable {
    @JSONField(name = "code")
    private Integer code;
    @JSONField(name = "message")
    private String message;

    public ErrorView(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorView(CustomizeException e) {
        this.code = e.getCode();
        this.message = e.getMessage();
    }

    @Override
    public String toString() {
        return "ErrorView{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
