package com.example.ribbon.business;

import com.example.ribbon.config.Hello;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-10 16:16
 * @Modified By:
 */
@Slf4j
@Service
public class ConsumerService {

  @Autowired
  List<Hello> helloList;

  @Autowired
  RestTemplate restTemplate;

  public static final String SERVICE_NAME = "EUREKA-PROVIDER";

  @Autowired
  private LoadBalancerClient loadBalancerClient;


  public String hello(String id) {

    log.debug(helloList.toString());

    String result = restTemplate.getForObject("http://{1}/hello?id={2}", String.class, SERVICE_NAME, id);

    log.debug("返回结果：{}", result);

//    ServiceInstance instance = loadBalancerClient.choose(SERVICE_NAME);
//    log.debug("当前节点：serviceId: {}, instanceId: {}, schema://host:port {}://{}:{}", instance.getServiceId(), instance.getInstanceId(), instance.getScheme(), instance.getHost(), instance.getPort());
//
//    String s = String.format("当前节点：serviceId: %s, instanceId: %s, schema://host:port %s://%s:%d", instance.getServiceId(), instance.getInstanceId(), instance.getScheme(), instance.getHost(), instance.getPort());

    StringBuilder sb = new StringBuilder("");
    sb.append("\r\n");
    sb.append(result);
    return sb.toString();
  }

}
