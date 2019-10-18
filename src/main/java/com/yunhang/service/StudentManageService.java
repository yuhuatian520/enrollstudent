package com.yunhang.service;

import com.yunhang.entity.StudentManage;
import com.yunhang.mapper.StudentManageMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangchunlu
 * @date 2019-9-27
 */
@Service
public class StudentManageService{

    @Resource
    private StudentManageMapper studentManageMapper;

    /**
     * 查询所有学生信息
     * @return
     */
    public List<StudentManage> queryAllStudentInfo(){

        return studentManageMapper.selectallStudentInfo();

    }
    /**
     *
     * 通过Name查询学生信息
     */

    public List<StudentManage> queryStudentInfoByName(String studentName){

        //判断是否传入了学生姓名
        if(StringUtils.isEmpty(studentName)) return null;
        else {
            //模糊查询所有学生信息
            List<StudentManage> result= studentManageMapper.selectStudentInfoByName(studentName);

            /*for (StudentManage s:result ) {
                if(s.getMark()==8)
                result.remove(s);
            }*/
            //返回mark为4的所有学生
            //return  result.parallelStream().filter(s -> s.getMark() == 4).collect(Collectors.toList());
            return  result;



        }
    }

    /**
     *
     * 通过Id查询学生信息
     */

    public StudentManage queryStudentInfoById(Integer studentId){

        //判断是否传入了学生Id
        if(StringUtils.isEmpty(studentId)) return null;
        else {
            //查询所有学生信息
           StudentManage result=studentManageMapper.selectStudentInfoById(studentId);
            //List<StudentManage> result= studentManageMapper.selectStudentInfoById(studentId);
            return  result;
        }
    }
    /**
     *
     * 通过手机号查询学生信息
     */
    public StudentManage queryStudentInfoByPhone(String studentPhone) {
        StudentManage result=studentManageMapper.selectStudentInfoByPhone(studentPhone);
        return result;
    }

    /**
     *
     * 添加学生
     */

    public Integer addstudent(StudentManage studentManage){
            //添加获取到的时间字符串添加
            studentManage.setCreateTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
            //执行插入

            return studentManageMapper.insertSelective(studentManage);
    }

    /**
     *
     * 更新学生信息
     */

    public Integer updatestudent(StudentManage studentManage){

            return studentManageMapper.updateByPrimaryKeySelective(studentManage);

    }

    /**
     *
     * 删除学生信息
     */

    public Integer deletestudent(StudentManage studentManage){
            studentManage.setMark((short) 8);
            return studentManageMapper.updateByPrimaryKeySelective(studentManage);

    }



}


