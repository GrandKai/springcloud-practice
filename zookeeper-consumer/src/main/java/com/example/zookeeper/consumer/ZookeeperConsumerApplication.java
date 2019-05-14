package com.example.zookeeper.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-14 11:11
 * @Modified By:
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ZookeeperConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZookeeperConsumerApplication.class, args);
  }

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @RestController
  class TestController {

    private final RestTemplate restTemplate;

    public TestController(RestTemplate restTemplate) {
      this.restTemplate = restTemplate;
    }


    @GetMapping("hello")
    public String nacosConsumer() {
      return restTemplate.getForObject("http://zookeeper-provider/hello", String.class);
    }
  }
}
