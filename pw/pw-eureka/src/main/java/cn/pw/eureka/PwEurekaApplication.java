package cn.pw.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动类
 * @author: libin
 * @date: 19:54 2018/9/20
 */
@SpringBootApplication
@EnableEurekaServer
public class PwEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PwEurekaApplication.class, args);
	}
}
