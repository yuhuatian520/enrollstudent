package com.yunhang.controller;

import com.yunhang.entity.TrainingInfo;
import com.yunhang.service.TrainingInfoService;
import com.yunhang.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/16 17:22
 */

@RestController
@RequestMapping("/traininginfo/")
public class TrainingInfoController {
    @Autowired
    private TrainingInfoService trainingInfoService;
    /**
     * 查询所有培训信息
     */
    @RequestMapping("selectalltraininginfo")
    public JsonResult selectAllTrainingInfo(){
        List<TrainingInfo> trainingInfos=trainingInfoService.queryAllTrainingInfo();
        //if (trainingInfos!=null)
            return JsonResult.ok(trainingInfos);
        //else
           // return JsonResult.ok("无培训信息!");
    }
    /**
     * 查询培训信息ById
     *
     */
    @RequestMapping("selecttraininginfobyid")
    public JsonResult selectTrainingInfoById(Integer traingId){
        TrainingInfo trainingInfo=trainingInfoService.queryTrainingInfoById(traingId);
        if (trainingInfo!=null)
            return JsonResult.ok(trainingInfo);
        else
            return JsonResult.errorMsg("查询错误!");
    }

    /**
     * 添加培训信息
     */
    @RequestMapping("addtraininginfo")
    public JsonResult addTrainingInfo(@RequestBody TrainingInfo trainingInfo){
        int mark=trainingInfoService.addTrainingInfo(trainingInfo);
        if(mark>0)
            return JsonResult.ok(mark);
        else
            return JsonResult.errorMsg("添加失败");
    }
    /**
     * 更新培训信息
     */
    @RequestMapping("updatetraininginfobyid")
    public JsonResult updateTrainingInfoById(@RequestBody TrainingInfo trainingInfo){
        int mark=trainingInfoService.updateTrainingInfo(trainingInfo);
        if(mark>0)
            return JsonResult.ok(mark);
        else if(trainingInfo.getTraingId()==null)
            return JsonResult.errorMsg("请传入ID!");
        else
            return JsonResult.errorMsg("更新失败");
    }

    /**
     * 删除培训信息
     */
    @RequestMapping("deletetraininginfobyid")
    public JsonResult deleteTrainingInfoById(TrainingInfo trainingInfo){
        int mark=trainingInfoService.deleteTrainingInfoById(trainingInfo);
        if(mark>0)
            return JsonResult.ok(mark);
        else if(trainingInfo==null)
            return JsonResult.errorMsg("请传入ID!");
        else
            return JsonResult.errorMsg("删除失败");
    }
}

