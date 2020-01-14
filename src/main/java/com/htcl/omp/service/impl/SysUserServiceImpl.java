package com.htcl.omp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htcl.omp.common.Constants;
import com.htcl.omp.dao.UserAccountsMapper;
import com.htcl.omp.domain.UserAccounts;
import com.htcl.omp.domain.UserPermissions;
import com.htcl.omp.domain.UserRoles;
import com.htcl.omp.dto.UserAccountsDto;
import com.htcl.omp.service.SysUserService;
import com.htcl.omp.utils.BaseModelUtils;
import com.htcl.omp.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sam on 2020-01-10.08:50
 */
@Service
@Slf4j
public class SysUserServiceImpl extends ServiceImpl<UserAccountsMapper, UserAccounts> implements SysUserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private BaseModelUtils<UserAccounts> baseModelUtils;

    @Override
    public Map<String, Object> createUser(UserAccountsDto userAccountsDto) {
        UserAccounts userAccounts = new UserAccounts(userAccountsDto);
        userAccounts.setPassword(bCryptPasswordEncoder.encode(Constants.INIT_PASSWORD));
        baseModelUtils.buildCreateEntity(userAccounts, null);
        this.save(userAccounts);
        return ResultUtil.resultSuccess();
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
