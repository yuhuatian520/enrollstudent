package com.yunhang.controller;

import com.alibaba.fastjson.JSON;
import com.yunhang.entity.FeedbackInfo;
import com.yunhang.service.FeedbackInfoService;
import com.yunhang.utils.JsonResult;
import com.yunhang.utils.ReturnCode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨春路
 * @data 2019/10/15 14:50
 */


/**
 * 提交意见反馈
 */
@RestController
@RequestMapping("/feedback/")
public class FeedbackInfoController {
    @Autowired
    private FeedbackInfoService feedbackInfoService;
    @RequestMapping("feedbacksubmit")
    public JsonResult feedbackSubmit(@RequestBody FeedbackInfo feedbackInfo){
        if("{}".equals(JSON.toJSONString(feedbackInfo)))
            return JsonResult.errorMsg("反馈内容为空");
        int mark=feedbackInfoService.addFeedback(feedbackInfo);
        if(mark>0)
            return JsonResult.ok(mark);
        else
            return JsonResult.build(ReturnCode.paramError,"数据参数错误",mark);
    }
}
