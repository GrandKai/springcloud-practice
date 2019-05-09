package com.example.ribbon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-09 16:16
 * @Modified By:
 */
@Slf4j
@RestController
public class ConsumerController {


  public static final String SERVICE_NAME = "eureka-provider";
  @Autowired
  RestTemplate restTemplate;
  @Autowired
  LoadBalancerClient loadBalancerClient;

  @GetMapping("consumer")
  public String consumer(@RequestParam("id") String id) {

    String result = restTemplate.getForObject("http://{1}/hello?id={2}", String.class, SERVICE_NAME, id);

    log.info("返回结果：{}", result);
    return result;
  }

  @GetMapping("node")
  public String currentNode() {
    ServiceInstance instance = loadBalancerClient.choose(SERVICE_NAME);
    log.info("当前节点：serviceId: {}, instanceId: {}, schema://host:port {}://{}:{}", instance.getServiceId(), instance.getInstanceId(), instance.getScheme(), instance.getHost(), instance.getPort());

    return
        String.format("当前节点：serviceId: %s, instanceId: %s, schema://host:port %s://%s:%d", instance.getServiceId(), instance.getInstanceId(), instance.getScheme(), instance.getHost(), instance.getPort());
  }
}
