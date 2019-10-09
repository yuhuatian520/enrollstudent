package com.yunhang.mapper;

import com.yunhang.entity.StudentAttentionSchool;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author yangchunlu
 * @date 2019-9-28
 */
@org.apache.ibatis.annotations.Mapper
public interface StudentAttentionSchoolMapper extends Mapper<StudentAttentionSchool> {
    //配置通过学生ID查询收藏表中的所有信息
    List<StudentAttentionSchool> selectStuAttentionSchListByStuId(Integer studentId);
}