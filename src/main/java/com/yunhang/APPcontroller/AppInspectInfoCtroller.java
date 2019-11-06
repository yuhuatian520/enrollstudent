package com.yunhang.APPcontroller;

import com.alibaba.fastjson.JSON;
import com.yunhang.entity.InspectInfo;
import com.yunhang.service.InspectInfoService;
import com.yunhang.utils.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/11
 * \* Time: 9:58
 * \* To change this template use File | Settings | File Templates.
 * \* Description:问题分析
 * \
 */
@RestController
@RequestMapping("/inspectinfo/")
public class AppInspectInfoCtroller {

    @Resource
    private InspectInfoService inspectInfoService;

    /**
     * 添加问题然后 数据还不完善! 页面数据不完善!暂时不写
     * @param inspectInfo
     * @return
     */
    @PostMapping("addinspectsign")
    public JsonResult appendInspectInfos(@RequestBody InspectInfo inspectInfo){
        if ("{}".trim().equals(JSON.toJSONString(inspectInfo)))return JsonResult.errorMsg("数据为空!");
       //把分析完毕的数据放出来
        return JsonResult.ok(inspectInfoService.updateInspectInfos(inspectInfo));
    }

    /**
     * 问题所有信息查询
     * @return
     */
    @GetMapping("inspectinfoandanswerinfo")
    public JsonResult queryInspectInfoAndAnswerInfo(){
        return JsonResult.ok(inspectInfoService.findInspectAndAnswerInfoAlls());
    }








}
