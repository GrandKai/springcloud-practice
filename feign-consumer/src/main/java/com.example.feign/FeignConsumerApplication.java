package com.example.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 15:15
 * @Modified By:
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(FeignConsumerApplication.class, args);
  }
}
