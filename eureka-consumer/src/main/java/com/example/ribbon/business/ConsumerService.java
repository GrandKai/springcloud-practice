package com.example.ribbon.business;

import com.example.ribbon.config.Hello;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-10 16:16
 * @Modified By:
 */
@Slf4j
@Service
public class ConsumerService {

  /**
   * 注入多个bean到List中
   */
  @Autowired
  List<Hello> helloList;

  @Autowired
  RestTemplate restTemplate;

  public static final String SERVICE_NAME = "EUREKA-PROVIDER";

  @Autowired
  private LoadBalancerClient loadBalancerClient;


  @HystrixCommand(fallbackMethod = "fallbackMethod")
  public String hello(String id) {

    int time = ThreadLocalRandom.current().nextInt(5000);
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      log.error("线程睡眠异常：", e);
    }
    String result = restTemplate.getForObject("http://{1}/hello?id={2}", String.class, SERVICE_NAME, id);
    log.info("返回结果：{}，线程睡眠时间：{}", result, time);
    return result;
  }

  public String fallbackMethod(String id) {
    log.error("熔断器执行方法：circuit breaker method fallbackMethod，参数：{}", id);
    return "error";
  }
}
