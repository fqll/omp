package com.htcl.omp.utils;

import com.alibaba.fastjson.JSON;
import com.htcl.omp.common.Constants;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果工具类
 *
 * @Author sam
 * @CreateTime 2020-01-09.15:39
 */
@Slf4j
public class ResultUtil {

    /**
     * 私有化构造器
     */
    private ResultUtil() {
    }

    /**
     * 使用response输出JSON
     *
     * @Author Sans
     * @CreateTime 2019/9/28 11:23
     * @Param resultMap 数据
     * @Return void
     */
    public static void responseJson(ServletResponse response, Map<String, Object> resultMap) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(resultMap));
        } catch (Exception e) {
            log.error("【JSON输出异常】" + e);
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

    /**
     * 返回成功
     *
     * @return
     */
    public static Map<String, Object> resultSuccess() {
        return resultCode(Constants.HTTP_OK, Constants.SUCCESS);
    }

    /**
     * 返回成功示例
     *
     * @Author Sans
     * @CreateTime 2019/9/28 11:29
     * @Param resultMap  返回数据MAP
     * @Return Map<String, Object> 返回数据MAP
     */
    public static Map<String, Object> resultSuccess(Map<String, Object> resultMap) {
        resultMap.put(Constants.CODE, Constants.HTTP_OK);
        resultMap.put(Constants.MESSAGE, "操作成功");
        return resultMap;
    }

    /**
     * 返回失败示例
     *
     * @Author Sans
     * @CreateTime 2019/9/28 11:31
     * @Param resultMap  返回数据MAP
     * @Return Map<String, Object> 返回数据MAP
     */
    public static Map<String, Object> resultError(Map<String, Object> resultMap) {
        resultMap.put(Constants.CODE, Constants.HTTP_500);
        resultMap.put(Constants.MESSAGE, "操作失败");
        return resultMap;
    }

    /**
     * 返回失败
     * @param errorMessage
     * @return
     */
    public static Map<String, Object> resultClientError(String errorMessage) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(Constants.CODE, Constants.HTTP_400);
        resultMap.put(Constants.MESSAGE, errorMessage);
        return resultMap;
    }

    public static Map<String, Object> resultServerError(String errorMessage) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(Constants.CODE, Constants.HTTP_500);
        resultMap.put(Constants.MESSAGE, errorMessage);
        return resultMap;
    }

    /**
     * 通用示例
     *
     * @Author Sans
     * @CreateTime 2019/9/28 11:35
     * @Param code 信息码
     * @Param msg  信息
     * @Return Map<String, Object> 返回数据MAP
     */
    public static Map<String, Object> resultCode(Integer code, String msg) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(Constants.MESSAGE, msg);
        resultMap.put(Constants.CODE, code);
        return resultMap;
    }

}