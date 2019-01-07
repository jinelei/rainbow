package cn.jinelei.rainbow.authorizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhenlei
 */
@SpringBootApplication
@EnableOAuth2Sso
public class AuthorizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizerApplication.class, args);
    }

}

