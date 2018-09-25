package cn.pw.pf.web.controller;

import cn.pw.pf.web.response.ResponseCode;
import cn.pw.pf.web.response.RestResponseResult;
import cn.pw.pf.web.response.RestResultGenerator;
import cn.pw.pf.web.vo.CurrentUser;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆控制器
 *
 * @author: libin
 * @date: 18:19 2018/9/20
 */
@RestController
@RequestMapping
public class LoginController {

    @GetMapping("/index")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("/index");
        return modelAndView;
    }
}
