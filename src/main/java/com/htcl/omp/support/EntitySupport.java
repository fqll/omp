package com.htcl.omp.support;

import com.htcl.omp.common.Constants;
import com.htcl.omp.domain.BaseModel;
import com.htcl.omp.security.entity.SelfUserEntity;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by sam on 2020-01-10.18:02
 */
@Aspect
@Order(4)
@Component
public class EntitySupport {
    /**
     * 创建实体
     *
     * @param baseModel
     */
    @Before("execution(public * com.htcl.omp.service.*Service.create*(..)) && args(baseModel,..)")
    public void createBo(BaseModel baseModel) {
        buildCreateEntity(baseModel);
    }

    public void buildCreateEntity(BaseModel baseModel) {
        SelfUserEntity currentUser = getCurrentUser();
        if (currentUser == null) {
            throw new RuntimeException("获取登录用户信息失败");
        }
        // 设置创建者ID
        baseModel.setCreatedId(currentUser.getUserId());
        buildBaseEntity(baseModel);
    }

    public void buildBaseEntity(BaseModel baseModel) {
        baseModel.setCreatedTime(new Date());
        // 新创建的数据版本号为1
        baseModel.setVersionNum(Constants.DATA_DEFAULT_VERSION);
        // 默认数据未逻辑删除
        baseModel.setDeleted(Constants.DATA_NOT_DELETE);
        // 默认数据有效
        baseModel.setIsValid(Constants.DATA_VALID);
    }

    /**
     * 获取当前登录用户
     * @return
     */
    public SelfUserEntity getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            // 获取用户信息
            return (SelfUserEntity) authentication.getPrincipal();
        }
        return null;
    }

}
