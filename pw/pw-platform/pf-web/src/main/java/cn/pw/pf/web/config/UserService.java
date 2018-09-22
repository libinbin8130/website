package cn.pw.pf.web.config;

import cn.pw.pf.web.consumer.UserClient;
import cn.pw.pf.web.response.RestResponseResult;
import cn.pw.pf.web.vo.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: libin
 * @date: 12:58 2018/9/22
 */
@Component
public class UserService {

    @Autowired
    private UserClient userClient;

    public CurrentUser findByUsername(String username) throws UsernameNotFoundException {
        CurrentUser user = new CurrentUser();
        user.setUsername(username);
        user.setPassword(new BCryptPasswordEncoder().encode("123456"));
        RestResponseResult<CurrentUser> result = userClient.findUserInfo(user);
        if (null == result || null == result.getData()) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return result.getData();
    }
}
