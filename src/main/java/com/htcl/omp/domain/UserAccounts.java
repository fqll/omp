package com.htcl.omp.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by sam on 2020-01-10.08:59
 */

@Data
public class UserAccounts extends BaseModel implements Serializable {
    /**
     * 用户名称
     */
    private String userName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 电子邮件地址
     */
    private String email;

    /**
     * 盐
     */
    private String salt;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态，0：禁用，1：启用
     */
    private String status;

    /**
     * 账号类型
     */
    private String accountType;

    private static final long serialVersionUID = 1L;
}