package cn.pw.pf.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * redis 分布式会话,开启支持spring session
 *
 * @author: libin
 * @date: 11:46 2018/9/21
 */
@Configuration
@EnableRedisHttpSession(redisNamespace = "pw-platform")
public class RedisSessionConfig {

}
