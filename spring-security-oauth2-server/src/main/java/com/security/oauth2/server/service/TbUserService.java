package com.security.oauth2.server.service;

import com.security.oauth2.server.entity.TbUser;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 17:17
 * @Modified By:
 */
public interface TbUserService {
  default TbUser getByUsername(String username) {
    return null;
  }
}
