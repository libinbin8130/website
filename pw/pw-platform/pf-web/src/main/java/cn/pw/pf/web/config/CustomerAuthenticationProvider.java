package cn.pw.pf.web.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 自定义验证
 *
 * @author: libin
 * @date: 15:21 2018/9/22
 */
@Component
public class CustomerAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = token.getName();
        UserDetails user = null;
        if (StringUtils.isNotBlank(username)) {
            user = userService.loadUserByUsername(username);
        }
        if (null == user) {
            throw new UsernameNotFoundException("用户名错误");
        } else if (!user.isCredentialsNonExpired()) {
            throw new LockedException("凭证已过期");
        }
        String password = user.getPassword();
        if (!password.equals(token.getCredentials())) {
            throw new BadCredentialsException("密码错误");
        }
        return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //返回true后才会执行上面的authenticate方法
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
