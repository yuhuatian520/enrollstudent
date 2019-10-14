package com.yunhang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yunhang.dto.NoticeDto;
import com.yunhang.entity.Notice;
import com.yunhang.entity.StudentManage;
import com.yunhang.service.NoticeService;
import com.yunhang.utils.JsonResult;
import com.yunhang.utils.ReturnCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangchunlu
 * @date 2019-9-28
 */
@RestController
@RequestMapping("/noticeinfo/")
public class NoticeController {


    @Resource
    private NoticeService noticeService;

    /**
     *
     * 查询所有公告信息
     */

    @RequestMapping("selectallnotice")
    public JsonResult queryAllNotice(@RequestParam(required = false,defaultValue = "1") Integer startPage,
                                     @RequestParam(required = false,defaultValue = "6") Integer pageSize){
        //接收查询到的所有公告,没有公告时,查询成功但返回的是null
        Page<NoticeDto> info = PageHelper.startPage(startPage, pageSize);
        List<NoticeDto> noticeList = noticeService.queryAllNotice();
        if(noticeList.isEmpty())
            return   JsonResult.build(ReturnCode.objectNull,"无公告信息",null);
        else
            return JsonResult.ok(noticeList);

    }

    /**
     *
     * 查询公告信息ByID*/

    @RequestMapping("selectnoticebyid")
    public JsonResult queryNoticeById(Notice notice){
        //判断传入参数是否为空
       if("{}".equals(JSON.toJSONString(notice)))
           return JsonResult.errorMsg("数据传入为空,查询失败!");
       else{
           //执行查询,前端传入的参数为noticeId
           NoticeDto noticeinfo = noticeService.queryNoticeById(notice);
           return   JsonResult.build(ReturnCode.okayCode,"success",noticeinfo);
       }




    }


    /**
     *
     * 添加学校公告信息
     */

    @RequestMapping(value="addschoolnotice", method = RequestMethod.POST)
    public JsonResult addSchoolNotice(@RequestBody Notice notice){
        //判断传入参数是否为空
        if("{}".equals(JSON.toJSONString(notice)))
            return JsonResult.errorMsg("数据传入为空,查询失败!");
        //执行添加
        Integer mark = noticeService.addSchoolNotice(notice);
        if(mark>0)
            return   JsonResult.build(ReturnCode.okayCode,"success",mark);
        else
            return   JsonResult.build(ReturnCode.dataError,"failure",mark);
    }

    /**
     *
     * 添加官方公告信息
     */

    @RequestMapping(value="addofficialnotice", method = RequestMethod.POST)
    public JsonResult addofficialNotice(@RequestBody Notice notice){
        //判断传入参数是否为空
        if("{}".equals(JSON.toJSONString(notice)))
            return JsonResult.errorMsg("数据传入为空,查询失败!");
        //执行添加
        Integer mark = noticeService.addOfficialNotice(notice);
        if(mark>0)
            return   JsonResult.build(ReturnCode.okayCode,"success",mark);
        else
            return   JsonResult.build(ReturnCode.dataError,"failure",mark);
    }


    /**
     *
     * 更新公告信息
     */
    @RequestMapping(value="updatenoticebyid", method = RequestMethod.POST)
    public JsonResult updateNotice(@RequestBody Notice notice){
        //判断传入参数是否为空
        if("{}".equals(JSON.toJSONString(notice)))
            return JsonResult.errorMsg("数据传入为空,更新失败!");
        //执行更新
        Integer mark = noticeService.updateNoticeById(notice);
        if(mark>0)
            return   JsonResult.build(ReturnCode.okayCode,"success",mark);
        else
            return   JsonResult.build(ReturnCode.dataError,"failure",mark);
    }

    /**
     *
     * 删除公告信息
     */

    @RequestMapping(value="deletenoticebyid",method = RequestMethod.POST)
    public JsonResult deleteNotice(Notice notice){
        //判断传入参数是否为空
        if("{}".equals(JSON.toJSONString(notice)))
            return JsonResult.errorMsg("数据传入为空,删除失败!");
        //执行删除
        Integer mark = noticeService.deleteNoticebyid(notice);
        if(mark>0)
            return   JsonResult.build(ReturnCode.okayCode,"success",mark);
        else
            return   JsonResult.build(ReturnCode.dataError,"failure",mark);
    }









}
