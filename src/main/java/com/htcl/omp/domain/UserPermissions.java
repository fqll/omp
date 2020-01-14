package com.htcl.omp.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.htcl.omp.dto.UserPermissionsDto;
import com.htcl.omp.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by sam on 2020-01-10.09:00
 */

@Data
@TableName("user_permissions")
@NoArgsConstructor
public class UserPermissions extends BaseModel implements Serializable {

    public UserPermissions(UserPermissionsDto userPermissionsDto) {
        this.url = userPermissionsDto.getUrl();
        this.describes = userPermissionsDto.getDescribes();
        // 默认是有效状态的权限
        this.status = StatusEnum.VALID_STATUS.getValue();
    }

    /**
     * 请求路径
     */
    private String url;

    /**
     * 请求风格
     */
    private String method;

    /**
     * 功能描述
     */
    private String describes;

    /**
     * 状态，0：禁用，1：启用
     */
    private String status;

    /**
     * 上级ID
     */
    private Integer parentId;

    private static final long serialVersionUID = 1L;
}