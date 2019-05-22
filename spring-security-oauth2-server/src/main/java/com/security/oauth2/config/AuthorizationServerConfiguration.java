package com.security.oauth2.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * 配置认证服务器
 *
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 14:14
 * @Modified By:
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

  // 注入 WebSecurityConfiguration 中配置的 BCryptPasswordEncoder
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    // 读取客户端配置 - 数据库设置
    clients.withClientDetails(jdbcClientDetailsService());

    // 配置客户端 - 内存设置
    /*
    clients
        // 使用内存设置
        .inMemory()
        // client_id
        .withClient("client")
        // client_secret
        .secret(passwordEncoder.encode("secret"))
        // 授权类型
        .authorizedGrantTypes("authorization_code")
        // 授权范围
        .scopes("app")
        // 注册回调地址
        .redirectUris("http://localhost:8080");
    */
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    // 设置令牌
    endpoints.tokenStore(tokenStore());
  }

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    // 配置数据源（注意，我使用的是 HikariCP 连接池），以上注解是指定数据源，否则会有冲突
    return DataSourceBuilder.create().build();
  }

  @Bean
  public TokenStore tokenStore() {
    // 基于 JDBC 实现，令牌保存到数据
    return new JdbcTokenStore(dataSource());
  }

/*  @Bean
  public ApprovalStore approvalStore() {
    return new JdbcApprovalStore(dataSource());
  }*/

  @Bean
  public ClientDetailsService jdbcClientDetailsService() {
    // 基于 JDBC 实现，需要事先在数据库配置客户端信息
    return new JdbcClientDetailsService(dataSource());
  }
}
