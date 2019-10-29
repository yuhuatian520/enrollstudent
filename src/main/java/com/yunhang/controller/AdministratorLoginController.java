package com.yunhang.controller;

import com.yunhang.entity.AdministratorInfo;
import com.yunhang.service.AdministratorInfoService;
import com.yunhang.utils.JsonResult;
import com.yunhang.utils.MD5Utils;
import com.yunhang.utils.ReturnCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨春路
 * @data 2019/10/15 9:01
 */
@RestController
/**
 * 超级管理员登陆
 */
@RequestMapping("/administratormanage/")
public class AdministratorLoginController {

    @Autowired
    private AdministratorInfoService administratorInfoService;
    @RequestMapping("superadnimistratorlogin")
    public JsonResult adnimistratorLogin(@RequestBody AdministratorInfo administratorInfo){
        administratorInfo.setAdministratorPassword(MD5Utils.createMd5(administratorInfo.getAdministratorPassword()));
        Boolean b=administratorInfoService.superAdministratorLogin(administratorInfo);
        if(b)
            return JsonResult.build(ReturnCode.okayCode,"超级管理员登陆成功!",b);
        else
            return JsonResult.errorMsg("密码错误");
    }

    @PostMapping("addadministrator")
    public JsonResult administratorAdd(@RequestBody AdministratorInfo administratorInfo){
        administratorInfo.setAdministratorPassword(MD5Utils.createMd5(administratorInfo.getAdministratorPassword()));
        int mark=administratorInfoService.administratorAdd(administratorInfo);
        if(mark>0)
            return JsonResult.ok(administratorInfoService.administratorAdd(administratorInfo));
        else
            return JsonResult.build(ReturnCode.dataError,"插入失败",mark);

    }






}
