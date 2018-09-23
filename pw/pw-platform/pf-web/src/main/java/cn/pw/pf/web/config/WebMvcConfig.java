package cn.pw.pf.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * spring mvc 配置
 *
 * @author: libin
 * @date: 10:29 2018/9/22
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 登录请求直接跳页面
     * 可以代替控制器里直接跳转页面的写法
     *
     * @param registry
     * @GetMapping("/login") public ModelAndView login(ModelAndView modelAndView){
     * modelAndView.setViewName("/login");
     * return modelAndView;
     * }
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
