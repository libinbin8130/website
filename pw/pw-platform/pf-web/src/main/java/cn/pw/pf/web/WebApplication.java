package cn.pw.pf.web;

import cn.pw.pf.web.consumer.UserClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


/**
 * 启动类
 * @author: libin
 * @date: 19:54 2018/9/20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses=UserClient.class)
@EnableAutoConfiguration
@EnableHystrixDashboard
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
