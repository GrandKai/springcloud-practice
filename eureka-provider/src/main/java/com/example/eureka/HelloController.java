package com.example.eureka;

import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.discovery.endpoint.EndpointUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
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
  @Autowired
  private EurekaClient eurekaClient;

  @GetMapping("/hello")
  public String hello(@RequestParam("id") String id) {
//    InstanceInfo instance = discoveryClient.getNextServerFromEureka("STORES", false);
//    return instance.getHomePageUrl();

//    EurekaClientConfig clientConfig = new DefaultEurekaClientConfig();
    List<String> list = EndpointUtils.getServiceUrlsFromConfig(clientConfig,"defaultZone", true);

    list.forEach(System.out::println);

    return list.toString() + " id: " + id;
  }
}
