package com.htcl.omp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htcl.omp.dao.UserPermissionsMapper;
import com.htcl.omp.domain.UserPermissions;
import com.htcl.omp.dto.UserPermissionsDto;
import com.htcl.omp.service.UserPermissionService;
import com.htcl.omp.utils.BaseModelUtils;
import com.htcl.omp.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by sam on 2020-01-14.10:06
 */
@Slf4j
@Service
public class UserPermissionServiceImpl extends ServiceImpl<UserPermissionsMapper, UserPermissions> implements UserPermissionService {
    @Autowired
    private BaseModelUtils<UserPermissions> baseModelUtils;

    @Override
    public Map<String, Object> createPermission(UserPermissionsDto userPermissionsDto) {
        UserPermissions userPermissions = new UserPermissions(userPermissionsDto);
        baseModelUtils.buildCreateEntity(userPermissions, null);
        this.save(userPermissions);
        return ResultUtil.resultSuccess();
    }
}
