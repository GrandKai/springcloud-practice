package com.example.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 13:13
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosApplication {

  public static void main(String[] args) {
    SpringApplication.run(NacosApplication.class, args);
  }
}
