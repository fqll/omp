package com.htcl.omp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htcl.omp.dao.UserRolesMapper;
import com.htcl.omp.domain.UserRoles;
import com.htcl.omp.dto.UserRolesDto;
import com.htcl.omp.service.UserRoleService;
import com.htcl.omp.utils.BaseModelUtils;
import com.htcl.omp.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by sam on 2020-01-14.10:00
 */
@Service
@Slf4j
public class UserRoleServiceImpl extends ServiceImpl<UserRolesMapper, UserRoles> implements UserRoleService {
    @Autowired
    private BaseModelUtils<UserRoles> baseModelUtils;

    @Override
    public Map<String, Object> createRole(UserRolesDto userRolesDto) {
        UserRoles userRoles = new UserRoles(userRolesDto);
        baseModelUtils.buildCreateEntity(userRoles, null);
        this.save(userRoles);
        return ResultUtil.resultSuccess();
    }
}
