package cn.pw.pf.web.consumer;

import cn.pw.pf.web.consumer.impl.UserClientFallbackFactory;
import cn.pw.pf.web.response.RestResponseResult;
import cn.pw.pf.web.vo.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * 平台服务
 * @author: libin
 * @date: 18:14 2018/9/20
 */
@FeignClient(value="metis-user-server",url="127.0.0.1:8080",fallbackFactory = UserClientFallbackFactory.class)
public interface UserClient {

    @RequestMapping(value="/user/findUserInfo", method = RequestMethod.POST)
    RestResponseResult<CurrentUser> findUserInfo(@RequestBody CurrentUser user);
}