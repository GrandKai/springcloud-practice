package com.security.oauth2.config;

import com.google.common.collect.Lists;
import com.security.oauth2.entity.TbPermission;
import com.security.oauth2.entity.TbUser;
import com.security.oauth2.service.TbPermissionService;
import com.security.oauth2.service.TbUserService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 自定义用户认证与授权
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-22 09:09
 * @Modified By:
 */
@Slf4j
@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  private TbUserService tbUserService;

  @Autowired
  private TbPermissionService tbPermissionService;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    // 查询用户信息
    TbUser tbUser = tbUserService.getByUsername(username);

    List<GrantedAuthority> grantedAuthorityList = Lists.newArrayList();

    if (tbUser != null) {
      // 获取用户授权
      List<TbPermission> tbPermissionList = tbPermissionService.selectByUserId(tbUser.getId());

      // 声明用户授权
      tbPermissionList.forEach(tbPermission -> {
        if (tbPermission != null && tbPermission.getEnname() != null) {
          GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
          grantedAuthorityList.add(grantedAuthority);
        }
      });

      // 由框架完成认证工作
      UserDetails userDetails = new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorityList);

      return userDetails;
    }
    log.error("-----------------------------未获取到用户信息-----------------------------");
    return null;

  }
}
