package cn.jinelei.rainbow.blog.authorization.annotation;


import cn.jinelei.rainbow.blog.entity.enumerate.GroupPrivilege;
import cn.jinelei.rainbow.blog.entity.enumerate.UserPrivilege;
import org.hibernate.usertype.UserType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在Controller的方法上使用此注解，该方法在映射时会检查用户是否登录，未登录返回401错误
 *
 * @author zhenlei
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authorization {
    int userType() default UserPrivilege.Constants.TOURIST_USER;

    int groupType() default GroupPrivilege.Constants.TOURIST_GROUP;
}

