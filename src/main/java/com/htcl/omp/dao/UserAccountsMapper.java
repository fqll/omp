package com.htcl.omp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htcl.omp.domain.UserAccounts;
import com.htcl.omp.domain.UserPermissions;
import com.htcl.omp.domain.UserRoles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by sam on 2020-01-10.08:59
 */
@Mapper
public interface UserAccountsMapper extends BaseMapper<UserAccounts> {

    /**
     * 根据用户ID查询权限集合
     * @param userId
     * @return
     */
    List<UserPermissions> selectPermissionsListByUserId(Integer userId);

    /**
     * 根据用户ID查询角色集合
     * @param userId
     * @return
     */
    List<UserRoles> selectRolesByUserId(Integer userId);
}