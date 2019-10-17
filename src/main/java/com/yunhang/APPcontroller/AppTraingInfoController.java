package com.yunhang.APPcontroller;

import com.yunhang.service.TrainingInfoService;
import com.yunhang.utils.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/12
 * \* Time: 12:07
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 培训相关信息
 * \
 */
@RestController
@RequestMapping("/trainginfo/")
public class AppTraingInfoController {

    @Resource
    private TrainingInfoService trainingInfoService;


    /**
     * 查询培训广告信息
     * @return
     */
    @GetMapping("querytrainginfobytraingid/{traingId}")
    public JsonResult findTraingInfoBytraingId(@PathVariable("traingId") Integer traingId){
        return JsonResult.ok(trainingInfoService.findTraingInfoBytrainId(traingId));
    }


    @GetMapping("querytrainginfoalls")
    public JsonResult findTraingInfoByAlls(){
        return JsonResult.ok(trainingInfoService.findTraingInfoByAlls());
    }





}
