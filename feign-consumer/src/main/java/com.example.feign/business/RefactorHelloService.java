package com.example.feign.business;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 20:20
 * @Modified By:
 */
@Primary
@FeignClient("eureka-provider")
public interface RefactorHelloService extends com.example.service.api.HelloService {

}
