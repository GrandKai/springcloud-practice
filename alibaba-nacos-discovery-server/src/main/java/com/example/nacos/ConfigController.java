package com.example.nacos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 16:16
 * @Modified By:
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

  @Value("${mysql.url:localhost:3306}")
  private String config;

  @RequestMapping("/get")
  public String getConfig() {
    return config;
  }
}
