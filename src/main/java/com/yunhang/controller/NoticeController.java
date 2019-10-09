package com.yunhang.controller;

import com.yunhang.dto.NoticeDto;
import com.yunhang.entity.Notice;
import com.yunhang.service.NoticeService;
import com.yunhang.utils.JsonResult;
import com.yunhang.utils.ReturnCode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/noticeinfo/")
public class NoticeController {


    @Resource
    private NoticeService noticeService;

    @RequestMapping("selectnoticebyid")
    public JsonResult queryNoticeByNoticeId(Notice notice){
        NoticeDto noticeinfo = noticeService.queryNoticeByNoticeId(notice);
        return   JsonResult.build(ReturnCode.okayCode,"success",noticeinfo);
    }






}
