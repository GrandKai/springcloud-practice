package com.example.zookeeper.consumer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-14 13:13
 * @Modified By:
 */
@RestController
public class HelloController {
  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("service")
  public String serviceUrl() {
    List<ServiceInstance> list = discoveryClient.getInstances("zookeeper-provider");
    if (list != null && list.size() > 0 ) {
      return list.get(0).getUri().toString();
    }
    return null;
  }
}
