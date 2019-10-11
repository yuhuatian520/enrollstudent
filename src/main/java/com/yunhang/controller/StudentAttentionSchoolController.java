package com.yunhang.controller;

import com.alibaba.fastjson.JSON;
import com.yunhang.dto.StudentAttentionSchoolDto;
import com.yunhang.entity.StudentAttentionSchool;
import com.yunhang.service.StudentAttentionSchoolService;
import com.yunhang.utils.JsonResult;
import com.yunhang.utils.ReturnCode;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangchunlu
 * @date 2019-9-28
 */
@RestController
@RequestMapping("/AttentionInfo/")
public class StudentAttentionSchoolController {

    @Resource
    private StudentAttentionSchoolService studentAttentionSchoolService;

    /**
     *
     * 根据学生id查询收藏的学校(学校意向)
     */
    @RequestMapping("selectAttentionSchoolByStuId")
    public JsonResult queryAttentionSchoolByStuId(Integer studentId){
        //判断传入参数是否为空
        if(studentId==null)
            return JsonResult.errorMsg("数据传入为空,查询失败!");
        //生成一个存储收藏信息的数组result,存储传入的学生ID参数而查询到的所有收藏信息
        List<StudentAttentionSchoolDto> result=studentAttentionSchoolService.seletcSchoolAttentionByStuId(studentId);
        if(result!=null)
            //查询成功,返回收藏信息
            return JsonResult.build(ReturnCode.okayCode,"success",result);
        else
            //如果查询到的为空,则返回空串
            return JsonResult.errorException("无收藏信息,查询失败!");

    }
    /**
     *
     * 学校意向添加(添加收藏)
     */
    @RequestMapping("addAttentionSchoolByStuId")
    public JsonResult addAttentionSchool(@RequestBody StudentAttentionSchool studentAttentionSchool){
        //判断传入参数是否为空
        if("{}".equals(JSON.toJSONString(studentAttentionSchool)))
            return JsonResult.errorMsg("数据传入为空,添加失败!");
        //执行添加,定义一个mark接收返回的受影响行数
        Integer mark=studentAttentionSchoolService.addSchoolAttention(studentAttentionSchool);
        if(mark>0)
            //添加成功,返回成功信息
            return JsonResult.build(ReturnCode.okayCode,"success",mark);
        else
            //添加失败,返回失败信息
            return JsonResult.errorException("添加失败,您已经收藏过了,或者您所收藏的学校不存在");
    }
    /**
     *
     * 学校意向删除(取消收藏)
     */
    @RequestMapping("deleteAttentionSchoolByStuIdAndSchId")
    public JsonResult deleteAttentionSchool(StudentAttentionSchool studentAttentionSchool){
        //判断传入参数是否为空
        if("{}".equals(JSON.toJSONString(studentAttentionSchool)))
            return JsonResult.errorMsg("数据传入为空,删除失败!");
        //执行添加,定义一个mark接收返回的受影响行数
        Integer mark=studentAttentionSchoolService.deleteSchoolAttentionBySchoolId(studentAttentionSchool);
        if(mark>0)
            //删除成功,返回成功信息
            return JsonResult.build(ReturnCode.okayCode,"success",mark);
        else
            //添加失败,返回失败信息
            return JsonResult.errorException("没有传入学校ID或收藏信息不存在,删除失败!");

    }
}
