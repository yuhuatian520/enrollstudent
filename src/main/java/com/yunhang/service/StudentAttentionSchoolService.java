package com.yunhang.service;

import com.alibaba.fastjson.JSON;
import com.yunhang.dto.StudentAttentionSchoolDto;
import com.yunhang.entity.SchoolManage;
import com.yunhang.entity.StudentAttentionSchool;
import com.yunhang.mapper.SchoolManageMapper;
import com.yunhang.mapper.StudentAttentionSchoolMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchunlu
 * @date 2019-9-28
 */
@Service
public class StudentAttentionSchoolService {


    @Resource
    private StudentAttentionSchoolMapper studentAttentionSchoolMapper;


    @Autowired
    private SchoolManageMapper schoolManageMapper;

    /**
     * 查询学生的意向学校
     */
    public List<StudentAttentionSchoolDto> seletcSchoolAttentionByStuId(Integer studentId) {
        // List<SchoolManage> schoolManageList=new ArrayList<>();
        //生成一个存储收藏信息的数组studentAttentionSchoolDto  里面包含了studentId、schoolId、schoolName
        List<StudentAttentionSchoolDto> studentAttentionSchoolDtoList = new ArrayList<>();
        //通过学生Id查询收藏表的所有信息,存为数组studentAttentionSchoolResult
        List<StudentAttentionSchool> studentAttentionSchoolResult = studentAttentionSchoolMapper.selectStuAttentionSchListByStuId(studentId);
        //查询所有学校信息
        List<SchoolManage> schoolManageList=schoolManageMapper.selectAll();
        //遍历查询到的收藏表数组studentAttentionSchoolResult
        for (StudentAttentionSchool result : studentAttentionSchoolResult) {
            //通过学校ID查询学校信息
            SchoolManage schoolManage = schoolManageMapper.selectByPrimaryKey(result.getSchoolId());
           // for (SchoolManage s:schoolManageList) {
                    //生成一个存储收藏信息的对象studentAttentionSchoolDto
                    StudentAttentionSchoolDto studentAttentionSchoolDto = new StudentAttentionSchoolDto();
                    //将查询出来的学校信息存到studentAttentionSchoolDto中
                    BeanUtils.copyProperties(schoolManage, studentAttentionSchoolDto);
                    //将收藏表中查到的StudentId中添加到studentAttentionSchoolDto
                    studentAttentionSchoolDto.setStudentId(result.getStudentId());
                    //将此studentAttentionSchoolDto对象存入到存储收藏信息的数组studentAttentionSchoolDto
                    studentAttentionSchoolDtoList.add(studentAttentionSchoolDto);

           // }

        }


        //返回该学生所有收藏信息
        return studentAttentionSchoolDtoList;
    }


    /**
     * 添加学生的意向学校
     */
    public Integer addSchoolAttention(StudentAttentionSchool studentAttentionSchool) {
        //查询收藏表中的信息
        List<StudentAttentionSchool> studentAttentionSchoolsList = studentAttentionSchoolMapper.selectAll();
        //查询所有学校信息
        List<SchoolManage> schoolManageList=schoolManageMapper.selectAll();
        //判断传入的学生ID参数和学校ID参数是否为空
        if (StringUtils.isEmpty(studentAttentionSchool.getStudentId()) || StringUtils.isEmpty(studentAttentionSchool.getSchoolId())) {
            return 0;
        }
        else {
            //遍历收藏表
            for (StudentAttentionSchool s : studentAttentionSchoolsList) {
                //判断传入的学生Id和学校Id是否存在于收藏表中,已存在则返回0,代表插入失败
                if (JSON.toJSONString(s).equals(JSON.toJSONString(studentAttentionSchool)))
                    return 0;
            }
/*            //遍历学校表
            for (SchoolManage sm:schoolManageList) {
                //判断传入的学校Id是否存在于学校表中,存在则执行添加
                if (studentAttentionSchool.getSchoolId()==sm.getSchoolId())
                {


                }

            }*/
            Integer mark = studentAttentionSchoolMapper.insert(studentAttentionSchool);
            return mark;
            //以上判断条件不满足则返回0


        }


    }

    /**
     * 删除学生的意向学校
     */
    public Integer deleteSchoolAttentionBySchoolId(StudentAttentionSchool studentAttentionSchool) {

            //查询收藏表
            List<StudentAttentionSchool> studentAttentionSchool1List = studentAttentionSchoolMapper.selectAll();
            //遍历收藏表中的信息
            for (StudentAttentionSchool s : studentAttentionSchool1List) {
                //判断传入的学生ID参数和学校ID参数是否存在于收藏表中,存在则执行删除
                if (JSON.toJSONString(s).equals(JSON.toJSONString(studentAttentionSchool))) {
                       Integer mark= studentAttentionSchoolMapper.delete(studentAttentionSchool);
                        return mark;
                }


        }
        //以上判断条件不满足则返回0,删除失败
        return 0;


    }
}
