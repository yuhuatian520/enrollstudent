package com.yunhang.APPcontroller;

import com.yunhang.entity.DetectionMyself;
import com.yunhang.service.DetectionMyselfService;
import com.yunhang.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/10
 * \* Time: 17:39
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@RequestMapping("/inspectinfo/")
public class AppDetectionController {

    @Autowired
    private DetectionMyselfService detectionMyselfService;

    /**
     * 数据信息分析
     * @param detectionMyself
     * @return
     */
    public JsonResult dataInspectInfos(@RequestBody DetectionMyself detectionMyself){
        return null;
    }

    /**
     * 调查信息数据添加
     * @param detectionMyself
     * @return
     */
    @PostMapping("adddetectioninfo")
    public JsonResult appendDetectionInfo(@RequestBody DetectionMyself detectionMyself) throws Exception {

       Integer mark=detectionMyselfService.appendDetectionInfos(detectionMyself);
       switch (mark){
           case 88:
               return JsonResult.errorMsg("数据为空!");
           case 44:
               return JsonResult.errorMsg("已经检测过");
           case 1:
                return JsonResult.ok(detectionMyselfService.findDetectionInfoIng(detectionMyself.getStudentId()));
           default:
               return JsonResult.errorMsg("添加失败!");
       }

    }

    /**
     * 查询检测完毕之后的数据信息
     * @param studentId
     * @return
     */
    @GetMapping("querydetectioninfo/{studentId}")
    public JsonResult findDetectionInfo(@PathVariable("studentId") Integer studentId){

        return JsonResult.ok(detectionMyselfService.findDetectionInfoIng(studentId));
    }













}
