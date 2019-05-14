package com.example.service.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 20:20
 * @Modified By:
 */
@RequestMapping("refactor")
public interface HelloService {

  @GetMapping("hello4")
  String hello4(@RequestParam("id") String id);

  @GetMapping("hello5")
  User hello5(@RequestHeader("name") String name, @RequestHeader("age") Integer age);

  @PostMapping("hello6")
  String hello6(@RequestBody User user);
}
