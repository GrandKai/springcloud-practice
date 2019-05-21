package com.security.oauth2.service.impl;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 17:17
 * @Modified By:
 */

import com.security.oauth2.entity.TbUser;
import com.security.oauth2.mapper.TbUserMapper;
import com.security.oauth2.service.TbUserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class TbUserServiceImpl implements TbUserService {

  @Resource
  private TbUserMapper tbUserMapper;

  @Override
  public TbUser getByUsername(String username) {
    Example example = new Example(TbUser.class);
    example.createCriteria().andEqualTo("username", username);
    return tbUserMapper.selectOneByExample(example);
  }
}