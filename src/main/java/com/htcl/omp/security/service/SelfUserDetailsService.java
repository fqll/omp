package com.htcl.omp.security.service;

import com.htcl.omp.domain.UserAccounts;
import com.htcl.omp.security.entity.SelfUserEntity;
import com.htcl.omp.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by sam on 2020-01-10.09:20
 */
@Component
public class SelfUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public SelfUserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户信息
        UserAccounts userAccounts = sysUserService.findUserByName(username);
        if (userAccounts != null) {
            // 组装参数
            SelfUserEntity selfUserEntity = new SelfUserEntity();
            BeanUtils.copyProperties(userAccounts, selfUserEntity);
            return selfUserEntity;
        }
        return null;
    }
}
