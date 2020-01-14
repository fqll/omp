package com.htcl.omp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htcl.omp.domain.UserPermissions;
import com.htcl.omp.dto.UserPermissionsDto;

import java.util.Map;

/**
 * Created by sam on 2020-01-14.10:05
 */
public interface UserPermissionService extends IService<UserPermissions> {
    /**
     * 创建权限
     * @param userPermissionsDto
     * @return
     */
    Map<String, Object> createPermission(UserPermissionsDto userPermissionsDto);
}
