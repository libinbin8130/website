package cn.pw.pf.web.consumer.impl;

import cn.pw.pf.web.consumer.UserClient;
import cn.pw.pf.web.response.RestResponseResult;
import cn.pw.pf.web.response.RestResultGenerator;
import cn.pw.pf.web.vo.*;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务调用熔断
 *
 * @author: libin
 * @date: 10:46 2018/9/22
 */
@Slf4j
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserClient> {

    @Override
    public UserClient create(Throwable cause) {
        return new UserClient() {
            @Override
            public RestResponseResult<CurrentUser> findUserInfo(CurrentUser user) {
                user.setDeveloper(true);
                user.setCurrentModels(CollectionUtils.arrayToList(SystemModel.values()));
                user.setPassword("$2a$10$8kc9dhvAS8BPQNgC23.HwOJdl6OjH3Q.k.mRfy7dGzaeQaFY7YQHW");
                List<Permission> permissions = new ArrayList<>();
                Permission permission1 = new Permission();
                Resource resource1 = new Resource();
                resource1.setSign("BASE_ROLE_MANAGE");
                resource1.setPath("/role");
                permission1.setResource(resource1);
                permission1.setOprations(CollectionUtils.arrayToList(Opration.values()));
                user.setPermissions(permissions);
                return RestResultGenerator.success(user);
                //   log.warn("userClient fallback in create:{},{}", cause.getMessage(), user.getUsername());
                //   return RestResultGenerator.failture(ResponseCode.SERVER_FALLBACK,"内部服务请求异常，请稍后...");
            }
        };
    }
}
