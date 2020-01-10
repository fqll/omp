package com.htcl.omp.utils;

import com.htcl.omp.config.JWTConfig;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sam on 2020-01-10.15:01
 */
public class DateUtils {

    /**
     * 获取token过期时间
     * @return
     */
    public static Date getExpirationDate() {
        long currentTimeMillis = System.currentTimeMillis() + JWTConfig.expiration;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimeMillis);
        return calendar.getTime();
    }
}
