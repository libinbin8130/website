package cn.pw.pf.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * 启动类
 * @author: libin
 * @date: 19:54 2018/9/20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
