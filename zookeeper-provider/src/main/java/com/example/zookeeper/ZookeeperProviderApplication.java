package com.example.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-14 11:11
 * @Modified By:
 */

@SpringBootApplication
@RestController
public class ZookeeperProviderApplication {


  @RequestMapping("/hello")
  public String home() {
    return "Hello world";
  }

  public static void main(String[] args) {
    SpringApplication.run(ZookeeperProviderApplication.class, args);
  }

}
