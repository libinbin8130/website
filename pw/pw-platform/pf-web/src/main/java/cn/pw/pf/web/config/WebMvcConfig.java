package cn.pw.pf.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spring mvc 配置
 * @author: libin
 * @date: 10:29 2018/9/22
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    /**
     * 登录请求直接跳页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
