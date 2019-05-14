package com.example.eureka.business;

import com.netflix.discovery.EurekaClientConfig;
import com.netflix.discovery.endpoint.EndpointUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-08 16:16
 * @Modified By:
 */
@RestController
public class HelloController {
  @Autowired
  private DiscoveryClient discoveryClient;
  @Autowired
  private EurekaClientConfig clientConfig;

  @GetMapping("/hello")
  public String hello(@RequestParam("id") String id) {
    List<String> list = EndpointUtils.getServiceUrlsFromConfig(clientConfig,"defaultZone", true);

    list.forEach(System.out::println);

    return list.toString() + " id: " + id;
  }

  @GetMapping("/hello1")
  public String hello1(@RequestHeader String name) {
    return "hello " + name;
  }


  @PostMapping("/hello2")
  public String hello2(@RequestBody User user) {
    return "hello " + user.getName() + ", " + user.getAge();
  }
}
