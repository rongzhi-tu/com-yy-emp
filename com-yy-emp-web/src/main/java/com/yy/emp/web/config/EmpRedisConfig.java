package com.yy.emp.web.config;

import com.yy.sso.config.RedisConfig;
import com.yy.sso.service.AccessService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tuz
 * on 2020/5/25.
 */
@Configuration
public class EmpRedisConfig extends RedisConfig {
    @Bean
    public AccessService accessService(){
        return new AccessService();
    };
}
