package com.example.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-09 15:15
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class RibbonApplication {

  public static void main(String[] args) {
    SpringApplication.run(RibbonApplication.class, args);
  }

  @Bean(name = "restTemplate1")
  @LoadBalanced
  public RestTemplate restTemplate1() {
    return new RestTemplate();
  }

}
