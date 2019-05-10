package com.example.ribbon.config;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-10 11:11
 * @Modified By:
 */

@Data
@ToString
public class Hello {

  private String name;
  private int age;

  public Hello(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Hello() {
  }
}
