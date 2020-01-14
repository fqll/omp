package com.htcl.omp.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.htcl.omp.dto.UserAccountsDto;
import com.htcl.omp.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by sam on 2020-01-10.08:59
 */

@Data
@NoArgsConstructor
@TableName("user_accounts")
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

    public UserAccounts(UserAccountsDto userAccountsDto) {
        this.userName = userAccountsDto.getUserName();
        this.phone = userAccountsDto.getPhone();
        this.email = userAccountsDto.getEmail();
        // 默认是有效状态用户
        this.status = StatusEnum.VALID_STATUS.getValue();
    }

    private static final long serialVersionUID = 1L;
}