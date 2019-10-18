package com.yunhang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yunhang.entity.SchoolManage;
import com.yunhang.entity.StudentManage;
import com.yunhang.service.StudentManageService;
import com.yunhang.utils.JsonResult;
import com.yunhang.utils.ReturnCode;
import com.yunhang.utils.alibabautils.AliBaBaUploadUtil;
import com.yunhang.utils.alibabautils.LocalUploadUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangchunlu
 * @date 2019-9-27
 */
@RestController
@RequestMapping("/studentinfo/")
public class StudentManageController {

    @Resource
    private StudentManageService studentManageService;

    private final AliBaBaUploadUtil aliBaBaUploadUtil=new AliBaBaUploadUtil();



    /**
     * 分页查询学生
     * @param startPage
     * @param pageSize
     * @return
     */
    @RequestMapping("selectallstudentinfo")
    public JsonResult queryAllStudentInfo(@RequestParam(required = false,defaultValue = "1") Integer startPage,
                                          @RequestParam(required = false,defaultValue = "6") Integer pageSize){

        Page<StudentManage> info = PageHelper.startPage(startPage, pageSize);
        List<StudentManage> studentManagerList = studentManageService.queryAllStudentInfo();
        return JsonResult.ok(studentManagerList);
    }

    /**
     *
     * 通过名字查询学生
     */
    @RequestMapping("selectstudentinfobyname")
    public JsonResult queryStudentInfoByName(String studentName){

        List<StudentManage> selectStudentInfo=studentManageService.queryStudentInfoByName(studentName);
        if(StringUtils.isEmpty(studentName))
            return JsonResult.errorMsg("数据传入为空,查询失败!");
        else
            return   JsonResult.build(ReturnCode.okayCode,"success",selectStudentInfo);
    }
    /**
     *
     * 通过ID查询学生
     */
    @RequestMapping("selectstudentinfobyid")
    public JsonResult queryStudentInfoByName(Integer studentId){

        StudentManage selectStudentInfo=studentManageService.queryStudentInfoById(studentId);
        if(studentId==null)
            return JsonResult.errorMsg("数据传入为空,查询失败!");

        else
            return   JsonResult.build(ReturnCode.okayCode,"success",selectStudentInfo);
    }

    /**
     *
     * 通过手机号查询学生
     */
    @RequestMapping("selectstudentinfobyphone")
    public JsonResult queryStudentInfoByPhone(String studentPhone){

        StudentManage StudentInfo=studentManageService.queryStudentInfoByPhone(studentPhone);
        if(studentPhone==null)
            return JsonResult.errorMsg("数据传入为空,查询失败!");

        else
            return   JsonResult.build(ReturnCode.okayCode,"success",StudentInfo);
    }
    /**
     *
     * 添加学生
     */
    @RequestMapping(value = "addstudent",method = RequestMethod.POST)
    public JsonResult addstudent(@RequestBody StudentManage studentManage){
        //判断传入的参数是否为空
        if("{}".equals(JSON.toJSONString(studentManage)))
            return   JsonResult.errorMsg("数据传入为空,添加失败!");
        //执行插入
        Integer mark=studentManageService.addstudent(studentManage);
        //判断插入是否成功
        if(mark>0)
           // return JsonResult.ok();
            return   JsonResult.build(ReturnCode.okayCode,"success",mark);
        else
            return   JsonResult.build(ReturnCode.dataError,"failure",mark);

    }
    /**
     *
     * 更新学生信息
     */
    @RequestMapping(value = "updatestudentbyid",method = RequestMethod.POST)
    public JsonResult updatestudent(@RequestBody StudentManage studentManage){
        //判断传入的参数是否为空
        if("{}".equals(JSON.toJSONString(studentManage)))
            return   JsonResult.errorMsg("数据传入为空,添加失败!");

            Integer mark=0;

        if(studentManage.getStudentId()!=null)
            //执行更新
            mark=studentManageService.updatestudent(studentManage);
        if(mark>0)
            return   JsonResult.build(ReturnCode.okayCode,"success",mark);

        return   JsonResult.build(ReturnCode.dataError,"failure,学生ID不存在或手机号已存在",mark);

    }
    /**
     *
     * 删除学生信息
     */
    @RequestMapping(value = "deletestudentbyid",method = RequestMethod.POST)
    public JsonResult deletestudent(StudentManage studentManage){
        //判断传入的参数是否为空
        if("{}".equals(JSON.toJSONString(studentManage)))
            return   JsonResult.errorMsg("数据传入为空,添加失败!");
        Integer mark=0;

        //判断是否传入了学生ID且学生存在于学生表中
        if(studentManage.getStudentId()!=null){
            //执行删除
            mark=studentManageService.deletestudent(studentManage);
        }
        if(mark>0)
        return   JsonResult.build(ReturnCode.okayCode,"success",mark);
        else
        return   JsonResult.build(ReturnCode.dataError,"failure",mark);

    }



}
