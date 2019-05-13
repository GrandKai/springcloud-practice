package com.example.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 13:13
 * @Modified By:
 */
@RestController
@Slf4j
public class HelloController {

  @GetMapping("hello")
  public String hello(@RequestParam String id) {
    log.info("invoked id: {}", id);

    return "hello nacos" + id;
  }
}
