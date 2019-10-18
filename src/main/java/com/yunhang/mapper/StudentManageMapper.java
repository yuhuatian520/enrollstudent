package com.yunhang.mapper;

import com.yunhang.entity.StudentManage;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yangchunlu
 * @date 2019-9-27
 */
@org.apache.ibatis.annotations.Mapper
public interface StudentManageMapper extends Mapper<StudentManage> {

    List<StudentManage> selectStudentInfoByName(String studentName);
    StudentManage selectStudentInfoById(Integer studentId);
    List<StudentManage> selectallStudentInfo();


    StudentManage selectStudentInfoByPhone(String studentPhone);
}