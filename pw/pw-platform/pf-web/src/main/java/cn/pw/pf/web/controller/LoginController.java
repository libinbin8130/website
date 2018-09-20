package cn.pw.pf.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登陆控制器
 * @author: libin
 * @date: 18:19 2018/9/20
 */
@RestController
@RequestMapping
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("/login");
        return modelAndView;
    }
}
