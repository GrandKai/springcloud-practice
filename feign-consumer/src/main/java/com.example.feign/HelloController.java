package com.example.feign;

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

  @GetMapping("feign-consumer")
  public String consumer(@RequestParam String id) {
    return helloService.hello(id);
  }

  @GetMapping("feign-consumer/{id}/{name}/{age}")
  public String consumer2(@PathVariable String id, @PathVariable String name, @PathVariable Integer age) {
    StringBuilder sb = new StringBuilder();

    sb.append(helloService.hello(id)).append("\n");
    sb.append(helloService.hello1(name, age)).append("\n");
    sb.append(helloService.hello2(new User(name, age)));

    return sb.toString();
  }
}
