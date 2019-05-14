package com.example.eureka.business;

import com.example.service.api.HelloService;
import com.example.service.api.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 20:20
 * @Modified By:
 */
@RestController
public class RefactorHelloController implements HelloService {

  @Override
  public String hello4(@RequestParam("id") String id) {
    return "hello " + id;
  }

  @Override
  public User hello5(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
    return new User(name, age);
  }

  @Override
  public String hello6(@RequestBody User user) {
    return "hello " + user.getName() + ", " + user.getAge();
  }
}
