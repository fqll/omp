package com.htcl.omp.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * JWT配置类
 * @Author sam
 * @CreateTime 2020-01-10.08:59
 */
@Getter
@Component
public class JWTConfig {
    /**
     * 密钥KEY
     */
    public static String secret;
    /**
     * TokenKey
     */
    public static String tokenHeader;
    /**
     * Token前缀字符
     */
    public static String tokenPrefix;
    /**
     * 过期时间
     */
    public static Integer expiration;
    /**
     * 不需要认证的接口
     */
    public static String antMatchers;

    @Value("${jwt.secret}")
    public void setSecret(String secret) {
        JWTConfig.secret = secret;
    }

    @Value("${jwt.tokenHeader}")
    public void setTokenHeader(String tokenHeader) {
        JWTConfig.tokenHeader = tokenHeader;
    }

    @Value("${jwt.tokenPrefix}")
    public void setTokenPrefix(String tokenPrefix) {
        JWTConfig.tokenPrefix = tokenPrefix;
    }

    @Value("${jwt.expiration}")
    public void setExpiration(Integer expiration) {
        JWTConfig.expiration = expiration;
    }

    @Value("${jwt.antMatchers}")
    public void setAntMatchers(String antMatchers) {
        JWTConfig.antMatchers = antMatchers;
    }
}