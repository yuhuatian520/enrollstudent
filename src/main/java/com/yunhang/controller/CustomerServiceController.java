package com.yunhang.controller;

import com.yunhang.dto.CustomerServiceDto;
import com.yunhang.service.FeedbackInfoService;
import com.yunhang.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 杨春路
 * @data 2019/10/15 16:06
 */

@RestController
/**
 * 客服信息查询
 */
@RequestMapping("/customerservice/")
public class CustomerServiceController {
    @Autowired
    private FeedbackInfoService feedbackInfoService;
    @RequestMapping("selectcustomerserviceinfo")
    public JsonResult selectCustomerService(){

        return JsonResult.ok(feedbackInfoService.queryCustomerService());
    }
}
