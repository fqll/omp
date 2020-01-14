package com.htcl.omp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htcl.omp.domain.UserRoles;
import com.htcl.omp.dto.UserRolesDto;

import java.util.Map;

/**
 * Created by sam on 2020-01-14.09:59
 */
public interface UserRoleService extends IService<UserRoles> {

    /**
     * 创建角色
     * @param userRolesDto
     * @return
     */
    Map<String, Object> createRole(UserRolesDto userRolesDto);

}
