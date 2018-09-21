package cn.pw.pf.web.controller;

import cn.pw.pf.web.response.RestResponseResult;
import cn.pw.pf.web.response.RestResultGenerator;
import cn.pw.pf.web.vo.CurrentUser;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("/index");
        return modelAndView;
    }

    @PostMapping("/login")
    public RestResponseResult<?> login(@RequestParam("userName") String userName,
                                       @RequestParam("password") String password,
                                       @RequestParam("validateCode") String validateCode){

        return RestResultGenerator.success();
    }
}
