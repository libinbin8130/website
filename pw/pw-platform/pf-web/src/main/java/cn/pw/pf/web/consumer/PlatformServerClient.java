package cn.pw.pf.web.consumer;

import cn.pw.pf.web.consumer.impl.PlatformServerClientFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 平台服务
 * @author: libin
 * @date: 18:14 2018/9/20
 */
@FeignClient(name="",fallbackFactory = PlatformServerClientFallbackFactory.class)
public interface PlatformServerClient {
}
