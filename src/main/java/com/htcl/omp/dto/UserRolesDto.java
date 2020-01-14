package com.htcl.omp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by sam on 2020-01-14.10:03
 */
@Data
public class UserRolesDto {
    /** 角色名称 */
    @NotEmpty(message = "角色名称不能为空")
    private String roleName;

    /** 角色描述 */
    @NotEmpty(message = "角色描述不能为空")
    private String describes;
}
