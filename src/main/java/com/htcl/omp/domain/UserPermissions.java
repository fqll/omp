package com.htcl.omp.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by sam on 2020-01-10.09:00
 */

@Data
public class UserPermissions extends BaseModel implements Serializable {

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