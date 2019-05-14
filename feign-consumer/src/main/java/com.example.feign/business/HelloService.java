package com.example.feign.business;

import com.example.feign.business.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 15:15
 * @Modified By:
 */
@FeignClient("eureka-provider")
public interface HelloService {

  @GetMapping("hello")
  String hello(@RequestParam(value = "id") String id);

  @GetMapping("hello1")
  String hello1(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

  @PostMapping("hello2")
  String hello2(@RequestBody User user);
}
