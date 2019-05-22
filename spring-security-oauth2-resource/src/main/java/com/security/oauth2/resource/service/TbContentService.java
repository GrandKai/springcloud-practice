package com.security.oauth2.resource.service;

import com.security.oauth2.resource.entity.TbContent;
import java.util.List;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-22 15:15
 * @Modified By:
 */
public interface TbContentService {

  /**
   * 根据 ID 获取
   *
   * @param id ID
   * @return {@link TbContent}
   */
  default TbContent getById(Long id) {
    return null;
  }

  /**
   * 获取全部数据
   *
   * @return {@link List<TbContent>}
   */
  default List<TbContent> selectAll() {
    return null;
  }

  /**
   * 新增
   *
   * @param tbContent {@link TbContent}
   * @return int 数据库受影响行数
   */
  default int insert(TbContent tbContent) {
    return 0;
  }

  /**
   * 编辑
   *
   * @param tbContent {@link TbContent}
   * @return int 数据库受影响行数
   */
  default int update(TbContent tbContent) {
    return 0;
  }

  /**
   * 删除
   *
   * @param id ID
   * @return int 数据库受影响行数
   */
  default int delete(Long id) {
    return 0;
  }

}
