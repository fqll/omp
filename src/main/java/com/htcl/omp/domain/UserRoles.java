package com.htcl.omp.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.htcl.omp.dto.UserRolesDto;
import com.htcl.omp.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by sam on 2020-01-10.08:59
 */

@Data
@NoArgsConstructor
@TableName("user_roles")
public class UserRoles extends BaseModel implements Serializable {

    public UserRoles(UserRolesDto userRolesDto) {
        this.roleName = userRolesDto.getRoleName();
        this.describes = userRolesDto.getDescribes();
        // 默认是有效角色
        this.status = StatusEnum.VALID_STATUS.getValue();
    }

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