package com.example.nacos.consumer;

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
 * @Date: Created in 2019-05-14 10:10
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(NacosConsumerApplication.class, args);
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


    @GetMapping("nacos")
    public String nacosConsumer() {
      return restTemplate.getForObject("http://alibaba-nacos-discovery-server/config/get", String.class);
    }
  }
}
