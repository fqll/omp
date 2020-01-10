package com.htcl.omp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created by sam on 2020-01-10.17:46
 */
@Data
public class UserAccountsDto {
    /** 用户名称 */
    @NotEmpty(message = "用户名不能为空")
    private String userName;

    /** 手机号码 */
    @NotEmpty(message = "手机号码不能为空")
    private String phone;

    /** 电子邮件地址 */
    @NotEmpty(message = "电子邮件不能为空")
    private String email;
}
