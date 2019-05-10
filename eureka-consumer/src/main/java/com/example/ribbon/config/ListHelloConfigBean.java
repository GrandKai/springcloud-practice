package com.example.ribbon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-10 11:11
 * @Modified By:
 */

@Configuration
public class ListHelloConfigBean {


  @Bean
  public Hello hello1() {
    return new Hello("a", 1);
  }


  @Bean
  public Hello hello2() {
    return new Hello("b", 2);
  }
}
