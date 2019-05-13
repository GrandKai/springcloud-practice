package com.example.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-13 15:15
 * @Modified By:
 */
@FeignClient()
public interface HelloService {


  String hello();
}
