package com.htcl.omp.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by sam on 2020-01-10.08:59
 */

@Data
public class UserRoles extends BaseModel implements Serializable {
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String describes;

    /**
     * 状态，0：禁用，1：启用
     */
    private String status;

    /**
     * 角色类型
     */
    private String rolesType;

    private static final long serialVersionUID = 1L;
}