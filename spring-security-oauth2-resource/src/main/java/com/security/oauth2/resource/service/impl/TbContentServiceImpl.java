package com.security.oauth2.resource.service.impl;

import com.security.oauth2.resource.entity.TbContent;
import com.security.oauth2.resource.mapper.TbContentMapper;
import com.security.oauth2.resource.service.TbContentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-22 15:15
 * @Modified By:
 */
@Service
public class TbContentServiceImpl implements TbContentService {

  @Autowired
  private TbContentMapper tbContentMapper;

  @Override
  public TbContent getById(Long id) {
    return tbContentMapper.selectByPrimaryKey(id);
  }

  @Override
  public List<TbContent> selectAll() {
    return tbContentMapper.selectAll();
  }

  @Override
  public int insert(TbContent tbContent) {
    return tbContentMapper.insert(tbContent);
  }

  @Override
  public int update(TbContent tbContent) {
    return tbContentMapper.updateByPrimaryKey(tbContent);
  }

  @Override
  public int delete(Long id) {
    return tbContentMapper.deleteByPrimaryKey(id);
  }
}