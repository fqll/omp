package com.htcl.omp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htcl.omp.domain.UserAccounts;
import com.htcl.omp.domain.UserPermissions;
import com.htcl.omp.domain.UserRoles;
import com.htcl.omp.dto.UserAccountsDto;

import java.util.List;
import java.util.Map;

/**
 * Created by sam on 2020-01-10.08:50
 */
public interface SysUserService extends IService<UserAccounts> {

    /**
     * 创建用户
     * @param userAccountsDto
     */
    Map<String, Object> createUser(UserAccountsDto userAccountsDto);

    /**
     * 根据用户名查询实体
     * @param userName
     * @return
     */
    UserAccounts findUserByName(String userName);

    /**
     * 根据用户ID查询角色集合
     * @param userId
     * @return
     */
    List<UserRoles> findRolesByUserId(Integer userId);

    /**
     * 根据用户ID查询权限集合
     * @param userId
     * @return
     */
    List<UserPermissions> findPermissionsListByUserId(Integer userId);
}
