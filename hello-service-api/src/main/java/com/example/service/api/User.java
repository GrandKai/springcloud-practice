package com.example.service.api;

import lombok.Data;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 19:19
 * @Modified By:
 */
@Data
public class User {

  private String name;
  private Integer age;

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public User() {
  }
}
