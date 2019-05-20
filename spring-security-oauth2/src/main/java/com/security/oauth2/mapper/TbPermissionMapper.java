package com.security.oauth2.mapper;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 17:17
 * @Modified By:
 */

import com.mybatis.MyMapper;
import com.security.oauth2.entity.TbPermission;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPermissionMapper extends MyMapper<TbPermission> {
  List<TbPermission> selectByUserId(@Param("userId") Long userId);
}