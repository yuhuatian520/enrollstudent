package com.yunhang.controller;

import com.alibaba.fastjson.JSONObject;
import com.yunhang.annotation.UserLoginToken;
import com.yunhang.entity.AdministratorInfo;
import com.yunhang.service.AdministratorInfoService;
import com.yunhang.tokenutils.TokenUtil;
import com.yunhang.utils.JsonResult;
import com.yunhang.utils.MD5Utils;
import com.yunhang.utils.ReturnCode;
import lombok.val;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @Resource
    private RedisTemplate redisTemplate;

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

    @PostMapping("login")
    public JsonResult loginTest(@RequestBody AdministratorInfo administratorInfo){
       val admin=administratorInfoService.findAdministratorInfoByAdminame(administratorInfo.getAdministratorName());
        if (admin==null){
            return JsonResult.errorMsg("用户不存在!");
        }else{

            if (!administratorInfo.getAdministratorPassword().equals(admin.getAdministratorPassword())){
            return JsonResult.errorMsg("密码错误!");
        }else {
                var token = TokenUtil.getToken(admin);
                   val json=new JSONObject();
                   json.put("token",token);
                   json.put("admin",admin);
                redisTemplate.opsForValue().set("token",token);
                System.out.println(redisTemplate.opsForValue().get("token"));
                return JsonResult.ok(json);
            }
        }
    }



    @UserLoginToken
    @GetMapping("getMessage")
    public String getMessage(){
        Object token = redisTemplate.opsForValue().get("token");
        if ("".equals(token.toString())){
            System.out.println(token.toString());
            return "登录过期!";
        }
        return "你已通过验证";
    }



}
