package com.security.oauth2.service.impl;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 17:17
 * @Modified By:
 */

import com.security.oauth2.entity.TbPermission;
import com.security.oauth2.mapper.TbPermissionMapper;
import com.security.oauth2.service.TbPermissionService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TbPermissionServiceImpl implements TbPermissionService {

  @Resource
  private TbPermissionMapper tbPermissionMapper;

  @Override
  public List<TbPermission> selectByUserId(Long userId) {
    return tbPermissionMapper.selectByUserId(userId);
  }
}
