package com.security.oauth2.server.service;

import com.security.oauth2.server.entity.TbPermission;
import java.util.List;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 17:17
 * @Modified By:
 */
public interface TbPermissionService {
  default List<TbPermission> selectByUserId(Long userId) {
    return null;
  }
}
