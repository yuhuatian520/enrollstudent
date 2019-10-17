package com.yunhang.service;

import com.yunhang.dto.schoolview.SchoolAndSpecialPlan;
import com.yunhang.dto.schoolview.SchoolInfoImgVo;
import com.yunhang.dto.schoolview.SchoolInfoVo;
import com.yunhang.dto.schoolview.SchoolManagerVo2;
import com.yunhang.dto.specialvo.SpecialInfoVo;
import com.yunhang.dto.vo.SpecialInfoPlanVo;
import com.yunhang.entity.SchoolManage;
import com.yunhang.entity.SchoolManagerImg;
import com.yunhang.entity.SchoolinfoAndSpecialinfo;
import com.yunhang.mapper.SchoolManageMapper;
import com.yunhang.mapper.SchoolManagerImgMapper;
import com.yunhang.mapper.SchoolSpecialMapper;
import com.yunhang.mapper.SchoolinfoAndSpecialinfoMapper;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/9/28
 \* Time: 17:28
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Service
public class SchoolManagerImgService{

    @Resource
    private SchoolManagerImgMapper schoolManagerImgMapper;

    @Resource
    private SchoolManageMapper schoolManageMapper;
    @Resource
    private SchoolManage schoolManage;
    @Resource
    private SchoolManagerImg schoolManagerImg;
    @Resource
    private SchoolInfoVo schoolInfoVo;

    @Resource
    private SchoolSpecialMapper schoolSpecialMapper;
    @Resource
    private SpecialInfoPlanVo specialInfoPlanVo;
    @Resource
    private SchoolAndSpecialPlan schoolAndSpecialPlan;

    @Resource
    private SchoolinfoAndSpecialinfo schoolinfoAndSpecialinfo;
    @Resource
    private SchoolinfoAndSpecialinfoMapper schoolinfoAndSpecialinfoMapper;

    public List<SchoolManagerImg> findSchoolInfoImgBySchoolIdAndSign(Integer schoolId) {
        return schoolManagerImgMapper.selectAll();
    }



    /**
     * 查询学校的详情信息 把图片查询出
     * @param schoolId
     */
    public SchoolInfoVo findSchoolInfoBySchoolId(Integer schoolId) {
        SchoolManage schoolInfo = schoolManageMapper.selectByPrimaryKey(schoolId);
        List<SchoolManagerImg> schoolInfoImgs = schoolManagerImgMapper.select(schoolManagerImg);
        schoolManagerImg.setSchoolId(schoolId);
        schoolInfoVo.setSchoolImgs(schoolInfoImgs.stream().map(s->{
            val schoolImg=new SchoolInfoImgVo();
            schoolImg.setStudentImgUrl(s.getStudentImgUrl());
            schoolImg.setSign(s.getSign());
            BeanUtils.copyProperties(s,schoolImg);
            return schoolImg;
        }).collect(Collectors.toList()));
        BeanUtils.copyProperties(schoolInfo,schoolInfoVo);
        return schoolInfoVo;
    }

    /**
     * 模糊查询得到学校信息
     * @param schoolName
     * @return
     */
    public List<SchoolManagerVo2> findSchoolInfoPlanBySchoolName(String schoolName) {
        val example = new Example(SchoolManage.class);
        Example.Criteria creatia = example.createCriteria();
            creatia.andLike("schoolName","%"+schoolName+"%");
        List<SchoolManage> schoolList = schoolManageMapper.selectByExample(example);
        return schoolList.stream().map(s->{
            val sc = new SchoolManagerVo2();
            sc.setSchoolId(s.getSchoolId());
            sc.setSchoolName(s.getSchoolName());
            BeanUtils.copyProperties(s,sc);
            return sc;
        }).collect(Collectors.toList());

    }

    /**
     * 查询学校专业信息招生计划
     * @param schoolId
     * @return
     */
    public List<SpecialInfoVo> findSchoolSpecialInfos(Integer schoolId){
       val schoolInfoaNDsPecialInfo=new SchoolinfoAndSpecialinfo();
            schoolInfoaNDsPecialInfo.setSchoolId(schoolId);
        List<SchoolinfoAndSpecialinfo> schoolinfoAndSpecialinfoList = schoolinfoAndSpecialinfoMapper.select(schoolInfoaNDsPecialInfo);
       return schoolinfoAndSpecialinfoList.parallelStream().map(s->{
           val specialInfoVo=new SpecialInfoVo();
            val schoolSpecialInfo = schoolSpecialMapper.selectByPrimaryKey(s.getSpecialId());

                BeanUtils.copyProperties(schoolSpecialInfo,specialInfoVo);
                   return  specialInfoVo;
        }).collect(Collectors.toList());
    }

    /**
     * 添加校园图片数据
     * @param schoolManagerImg
     */
    public Integer appendSchoolImg(SchoolManagerImg schoolManagerImg) {
       int mark=schoolManagerImgMapper.insertSelective(schoolManagerImg);
       if (mark>0)return 1;
       else return 0;
    }



}
