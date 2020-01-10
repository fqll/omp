package com.htcl.omp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htcl.omp.dao.UserAccountsMapper;
import com.htcl.omp.domain.UserAccounts;
import com.htcl.omp.domain.UserPermissions;
import com.htcl.omp.domain.UserRoles;
import com.htcl.omp.dto.UserAccountsDto;
import com.htcl.omp.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sam on 2020-01-10.08:50
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<UserAccountsMapper, UserAccounts> implements SysUserService {
    @Override
    public void createUser(UserAccountsDto userAccountsDto) {

    }

    @Override
    public UserAccounts findUserByName(String userName) {
        QueryWrapper<UserAccounts> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserAccounts::getUserName, userName);
        return this.baseMapper.selectOne(queryWrapper);
    }

    @Override
    public List<UserRoles> findRolesByUserId(Integer userId) {
        return this.baseMapper.selectRolesByUserId(userId);
    }

    @Override
    public List<UserPermissions> findPermissionsListByUserId(Integer userId) {
        return this.baseMapper.selectPermissionsListByUserId(userId);
    }
}
