package io.tonny.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * config-server
 * curl -i http://config-server-host:port/{application}/{proflie}/{label}
 * 配置中心管理组度: <br>
 *     应用，环境(sit/uat/prod)，版本；对特殊场景如：灰度发布，A/B测试等提供了很好的支持。
 *  优点：<br>
 *      配置存储支持Git，天生就能非常好的支持版本（还支持其它的存储如本地文件、SVN等）
 *      和Spring无缝集成（无缝支持Spring里面Environment和PropertySource的接口）
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
