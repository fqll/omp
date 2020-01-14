package com.htcl.omp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by sam on 2020-01-14.10:08
 */
@Data
public class UserPermissionsDto {
    /** 请求路径 */
    @NotEmpty(message = "请求路径不能为空")
    private String url;

    /** 功能描述 */
    @NotEmpty(message = "功能描述不能为空")
    private String describes;
}
