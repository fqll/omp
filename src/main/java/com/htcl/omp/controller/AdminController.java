package com.htcl.omp.controller;

import com.htcl.omp.dto.UserAccountsDto;
import com.htcl.omp.service.SysUserService;
import com.htcl.omp.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by sam on 2020-01-10.15:15
 */
@RestController
@RequestMapping("/admin/")
public class AdminController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("add")
    public Map<String, Object> createUser(@RequestBody UserAccountsDto userAccountsDto) {
        return ResultUtil.resultSuccess();
    }
}
