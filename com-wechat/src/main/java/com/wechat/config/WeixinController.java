package com.wechat.config;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zyn
 * @Description:
 * @Date: Created in 2019-05-20 11:11
 * @Modified By:
 */
@Slf4j
@RestController
public class WeixinController {

  /**
   * 微信基本配置信息中的 token
   */
  private static final String TOKEN = "xmyf1225";

  @GetMapping("wx")
  public String hello(HttpServletRequest request) {

    String echostr = request.getParameter("echostr");
    String signature = request.getParameter("signature");
    String timestamp = request.getParameter("timestamp");
    String nonce = request.getParameter("nonce");

    log.info("参数：{}, {}, {}, {}", signature, timestamp, nonce, echostr);
    boolean flag = check(signature, timestamp, nonce);
    if (flag) {
      return echostr;
    }
    return "error";
  }

  @GetMapping("/")
  public String welcome() {
    return "hello world";
  }

  /**
   * 验证服务器地址的有效性
   * @param signature
   * @param timestamp
   * @param nonce
   * @return
   */
  public static boolean check(String signature, String timestamp, String nonce) {
    List<String> param = new ArrayList<String>(4);
    param.add(timestamp);
    param.add(nonce);
    param.add(TOKEN);

    log.info("排序前：" + param.toString());
    param.sort(String::compareTo);
    log.info("排序后：" + param.toString());

    String tmpStr = param.get(0) + param.get(1) + param.get(2);
    return SHA1.encode(tmpStr).equals(signature);
  }

}
