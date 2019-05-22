package com.security.oauth2.server.service.impl;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 17:17
 * @Modified By:
 */

import com.security.oauth2.server.entity.TbPermission;
import com.security.oauth2.server.mapper.TbPermissionMapper;
import com.security.oauth2.server.service.TbPermissionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

  @Autowired
  private TbPermissionMapper tbPermissionMapper;

  @Override
  public List<TbPermission> selectByUserId(Long userId) {
    return tbPermissionMapper.selectByUserId(userId);
  }
}
