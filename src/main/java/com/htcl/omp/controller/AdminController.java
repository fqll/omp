package com.htcl.omp.controller;

import com.htcl.omp.dto.UserAccountsDto;
import com.htcl.omp.dto.UserPermissionsDto;
import com.htcl.omp.dto.UserRolesDto;
import com.htcl.omp.service.SysUserService;
import com.htcl.omp.service.UserPermissionService;
import com.htcl.omp.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by sam on 2020-01-10.15:15
 */
@RestController
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserPermissionService userPermissionService;

    /**
     * 创建用户
     * @param userAccountsDto
     * @return
     */
    @PostMapping("addUser")
    public Map<String, Object> createUser(@RequestBody UserAccountsDto userAccountsDto) {
        return sysUserService.createUser(userAccountsDto);
    }

    /**
     * 创建角色
     * @param userRolesDto
     * @return
     */
    @PostMapping("addRole")
    public Map<String, Object> addRole(@RequestBody UserRolesDto userRolesDto) {
        return userRoleService.createRole(userRolesDto);
    }

    /**
     * 创建权限
     * @param userPermissionsDto
     * @return
     */
    @PostMapping("addPermission")
    public Map<String, Object> addPermission(@RequestBody UserPermissionsDto userPermissionsDto) {
        return userPermissionService.createPermission(userPermissionsDto);
    }
}
