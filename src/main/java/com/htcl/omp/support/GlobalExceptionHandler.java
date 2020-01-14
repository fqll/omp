package com.htcl.omp.support;

import com.htcl.omp.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by sam on 2020-01-02.17:32
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {BindException.class, MethodArgumentNotValidException.class})
    public Object validationExceptionHandler(Exception exception) {
        BindingResult bindResult = null;
        if (exception instanceof BindException) {
            bindResult = ((BindException) exception).getBindingResult();
        } else if (exception instanceof MethodArgumentNotValidException) {
            bindResult = ((MethodArgumentNotValidException) exception).getBindingResult();
        }
        StringBuilder errorMessageBuilder = new StringBuilder("参数校验失败：");

        String msg;
        if (bindResult != null && bindResult.hasErrors()) {
            List<ObjectError> errorList = bindResult.getAllErrors();
            for (ObjectError error : errorList) {
                errorMessageBuilder.append(error.getDefaultMessage() + "；");
            }
            msg = errorMessageBuilder.toString();
            if (msg.contains("NumberFormatException")) {
                msg = "参数类型错误！";
            }
        } else {
            msg = "系统繁忙，请稍后重试...";
        }
        return ResultUtil.resultClientError(msg);
    }

}
