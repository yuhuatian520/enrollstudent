package com.yunhang.service;

import com.yunhang.entity.SchoolManage;
import com.yunhang.entity.StudentAttentionSchool;
import com.yunhang.mapper.SchoolManageMapper;
import com.yunhang.mapper.StudentAttentionSchoolMapper;
import com.yunhang.utils.RandomNumberGenerator;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SchoolManageService{

    @Resource
    private SchoolManageMapper schoolManageMapper;
    //学僧关注的学校
    @Resource
    private StudentAttentionSchoolMapper studentAttentionSchoolMapper;
    /**
     * 添加学校信息
     * @param schoolManage
     * @return
     */
    public Integer apendSchoolManagerInfos(SchoolManage schoolManage) {
        schoolManage.setSchoolId(Integer.valueOf(RandomNumberGenerator.generateNumber()));
        int mark = schoolManageMapper.insertSelective(schoolManage);
            if (mark>0)return 1;
            else return 0;
    }

    /**
     * 修改学校信息!
     * @return
     */
    public Integer updateShoolManagerInfo(SchoolManage schoolManage) {
        int mark = schoolManageMapper.updateByPrimaryKeySelective(schoolManage);
        if (mark>0)return 1;
        else return 0;
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public Integer deleteSchoolInfos(SchoolManage schoolManage) {
        try {
            int sign = schoolManageMapper.deleteByPrimaryKey(schoolManage);
            if (sign > 0){
                val stu = new StudentAttentionSchool();
                stu.setSchoolId(schoolManage.getSchoolId());
                int mark = studentAttentionSchoolMapper.delete(stu);
                if (mark>0)return 1;
                else  return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询学校的管理信息!
     * @param schoolId
     * @return
     */
    public SchoolManage querySchoolManagerInfoBySchoolId(Integer schoolId) {
        if (schoolId > 0) {
            return schoolManageMapper.selectByPrimaryKey(schoolId);
        }
        return null;
    }

    /**
     * 查询全部的数据信息
     * @return List<SchoolManage>
     */
    public List<SchoolManage> querySchoolManagerInfosByAlls() {
        return schoolManageMapper.selectAll();
    }

    /**
     * 通过学校进行模糊查询!
     * @param schoolName
     * @return
     */
    public List<SchoolManage> vagueSearchSchoolManagerInfo(String schoolName) {
        Example example = new Example(SchoolManage.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("schoolId");
        criteria.andLike("schoolName", "%"+schoolName+"%");
        List<SchoolManage> list = schoolManageMapper.selectByExample(example);
        return list;
    }
}
