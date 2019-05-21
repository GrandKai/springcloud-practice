package com.security.oauth2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 认证服务器，用于获取 Token
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 11:11
 * @Modified By:
 */
@SpringBootApplication
public class Oauth2ServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(Oauth2ServerApplication.class, args);
  }

}
