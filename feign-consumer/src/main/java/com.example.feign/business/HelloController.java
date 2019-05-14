package com.example.feign.business;

import com.example.feign.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 15:15
 * @Modified By:
 */
@RestController
public class HelloController {

  @Autowired
  private HelloService helloService;

  @Autowired
  private RefactorHelloService refactorHelloService;

  @GetMapping("feign-consumer")
  public String consumer1(@RequestParam String id) {
    return helloService.hello(id);
  }

  @GetMapping("feign-consumer/{id}/{name}/{age}")
  public String consumer2(@PathVariable String id, @PathVariable String name, @PathVariable Integer age) {
    StringBuilder sb = new StringBuilder();

    sb.append(helloService.hello(id)).append("\n");
    sb.append(helloService.hello1(name, age)).append("\n");
    sb.append(helloService.hello2(new User(name, age))).append("\n");

    return sb.toString();
  }


  @GetMapping("feign-consumer3")
  public String consumer3() {

    StringBuilder sb = new StringBuilder();
    sb.append(refactorHelloService.hello4("id11111111")).append("\n");
    sb.append(refactorHelloService.hello5("xiaoming", 22)).append("\n");
    sb.append(refactorHelloService.hello6(new com.example.service.api.User("xiaohong", 19))).append("\n");

    return sb.toString();
  }
}
