package com.security.oauth2.server.service.impl;

import com.security.oauth2.server.mapper.TbRoleMapper;
import com.security.oauth2.server.service.TbRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 17:17
 * @Modified By:
 */
@Service
public class TbRoleServiceImpl implements TbRoleService {

  @Autowired
  private TbRoleMapper tbRoleMapper;

}