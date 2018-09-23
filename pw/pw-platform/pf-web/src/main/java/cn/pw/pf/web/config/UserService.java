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
 * 查询存储的的用户信息
 *
 * @author: libin
 * @date: 12:58 2018/9/22
 */
@Component
public class UserService implements UserDetailsService {

    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CurrentUser user = new CurrentUser();
        user.setUsername(username);
        RestResponseResult<CurrentUser> result = userClient.findUserInfo(user);
        return (null == result || null == result.getData()) ? null : result.getData();
    }
}
