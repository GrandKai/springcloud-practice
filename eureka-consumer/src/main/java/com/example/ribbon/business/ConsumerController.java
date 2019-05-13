package com.example.ribbon.business;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-09 16:16
 * @Modified By:
 */
@Slf4j
@RestController
public class ConsumerController {

  @Autowired
  ConsumerService consumerService;

  @GetMapping("consumer")
  public String consumer(@RequestParam("id") String id) {
    long start = System.currentTimeMillis();

    String result = consumerService.hello(id);

    long end = System.currentTimeMillis();

    /**
     * hystrix 默认超时时间 2s，超过2s，执行 fallbackMethod 方法
     */
    log.error("执行时间：{}s", (end - start)/1000);
    return result;
  }

}
