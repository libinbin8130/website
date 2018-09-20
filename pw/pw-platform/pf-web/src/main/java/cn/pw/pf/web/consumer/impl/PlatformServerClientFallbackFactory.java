package cn.pw.pf.web.consumer.impl;

import cn.pw.pf.web.consumer.PlatformServerClient;
import feign.hystrix.FallbackFactory;

/**
 * @author: libin
 * @date: 18:16 2018/9/20
 */
public class PlatformServerClientFallbackFactory implements FallbackFactory<PlatformServerClient> {
    @Override
    public PlatformServerClient create(Throwable cause) {
        return null;
    }
}
