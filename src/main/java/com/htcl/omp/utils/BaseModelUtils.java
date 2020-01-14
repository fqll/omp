package com.htcl.omp.utils;

import com.htcl.omp.common.Constants;
import com.htcl.omp.domain.BaseModel;
import com.htcl.omp.security.entity.SelfUserEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by sam on 2019/6/14.9:28 PM
 */
@Component
public class BaseModelUtils<T extends BaseModel> {

    /**
     * 构造基础数据对象
     * @param superEntity
     */
    private void buildBaseEntity(T superEntity) {
        superEntity.setCreatedTime(new Date());
        // 新创建的数据版本号为1
        superEntity.setVersionNum(Constants.DATA_DEFAULT_VERSION);
        // 默认数据未逻辑删除
        superEntity.setDeleted(Constants.DATA_NOT_DELETE);
        // 默认数据有效
        superEntity.setIsValid(Constants.DATA_VALID);
    }

    /**
     * 构造新对象
     * @param superEntity
     * @param userId
     */
    public void buildCreateEntity(T superEntity, Integer userId) {
        // 设置创建者ID
        superEntity.setCreatedId(userId);
        buildBaseEntity(superEntity);
    }

    /**
     * 构造修改对象
     * @param superEntity
     * @param userId
     */
    public void buildModifiyEntity(T superEntity, Integer userId) {
        // 设置创建者ID
        if (userId != null) {
            superEntity.setLastModifyId(userId);
        }
        superEntity.setLastModifyTime(new Date());
        Integer versionNum = superEntity.getVersionNum() == null ? Constants.DATA_DEFAULT_VERSION : superEntity.getVersionNum();
        superEntity.setVersionNum(versionNum + 1);
    }

    /**
     * 获得当前登录用户ID
     * @return
     */
    public Integer getCurrentUserId(){
        SelfUserEntity currentUser = getCurrentUser();
        if (currentUser != null) {
            return currentUser.getUserId();
        }
        return null;
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
