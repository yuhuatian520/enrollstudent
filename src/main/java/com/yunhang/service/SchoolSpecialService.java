package com.yunhang.service;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.yunhang.dto.SchoolSpecialDto;
import com.yunhang.dto.vo.SchoolManagerVo;
import com.yunhang.dto.vo.SchoolSpecialVo;
import com.yunhang.dto.vo.SpecialInfoVo2;
import com.yunhang.entity.*;
import com.yunhang.mapper.*;
import com.yunhang.utils.RandomNumberGenerator;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SchoolSpecialService{

    //学校专业信息
    @Resource
    private SchoolSpecialMapper schoolSpecialMapper;
    //二级专业
    @Resource
    private SpecialKindofMapper specialKindofMapper;
    //一级专业
    @Resource
    private SpecialKindMapper specialKindMapper;
    //三级专业
    @Resource
    private ThreeSpecialKindofMapper threeSpecialKindofMapper;
    //对口的职业信息
    @Resource
    private ProfessionalInfoMapper professionalInfoMapper;

    @Resource
    private ProfessionalInfo professionalInfo;
    @Resource
    private SchoolManageMapper schoolManageMapper;

    @Resource
    private SchoolManage schoolManage;
    @Resource
    private SchoolinfoAndSpecialinfoMapper schoolinfoAndSpecialinfoMapper;
    //中间表 对接的专业编号和学校编号
    @Resource
    private SchoolinfoAndSpecialinfo schoolinfoAndSpecialinfo;


    /**
     * 专业编号!
     * @param specialId
     * @return
     */
    public SchoolSpecialDto querySchoolSpecialDtoListInfoAlls(Integer specialId){

        return null;

    }

    /**
     * 学校的专业信息(通过二级菜单编号来进行查询)
     * @param threeSpecialKindof
     * @return 专业信息大全
     */
    public List<ThreeSpecialKindof> querySchoolSpecialInfoBySpecialKindOfId(ThreeSpecialKindof threeSpecialKindof) {
        //三级菜单信息
        List<ThreeSpecialKindof> threeSpecialKindoflist = threeSpecialKindofMapper.select(threeSpecialKindof);
        for (ThreeSpecialKindof specialKindof : threeSpecialKindoflist) {
            SchoolSpecial ss = schoolSpecialMapper.selectByPrimaryKey(specialKindof.getSpecialId());
            specialKindof.setSchoolSpecial(ss);
        }
        return threeSpecialKindoflist;
    }

    /**
     * 添加专业信息!
     * @param schoolSpecial
     * @return 1,0 成功失败!
     */
    public Integer addSchoolSpecialInfo(SchoolSpecial schoolSpecial) {

        schoolSpecial.setSpecialId(Integer.valueOf(RandomNumberGenerator.generateNumber()));
        Integer sign = schoolSpecialMapper.insertSelective(schoolSpecial);
        if (sign>0)return 1;
          else return 0;
    }

    /**
     * 删除学校专业信息!把三级信息删了
     * @param object
     * @return
     */
    public Integer deleteSchoolSpecialInfo(Integer object) {
        val schoolSpecial = new SchoolSpecial();
            schoolSpecial.setSpecialId(object);
        int mark = schoolSpecialMapper.deleteByPrimaryKey(schoolSpecial);
        if (mark>0){
           val three=new ThreeSpecialKindof();
            three.setSpecialId(object);
            List<ThreeSpecialKindof> threeInfos = threeSpecialKindofMapper.select(three);
            if (threeInfos.size()>0||threeInfos!=null) {
                threeInfos.stream().forEach(s -> {
                    three.setThreeSpecialId(s.getThreeSpecialId());
                    three.setSpecialId(0);
                    threeSpecialKindofMapper.updateByPrimaryKeySelective(three);
                });
                return 1;
            }
        }
         return 0;
    }

    public List<SchoolSpecialVo> findSpecialInfoByRecommond() {
        Short recommond=4;
       val schoolSpecial=new SchoolSpecial();
        schoolSpecial.setSpecialRecommend(recommond);
        List<SchoolSpecial> specials = schoolSpecialMapper.select(schoolSpecial);
       return specials.stream().map(schoolSpecial1 -> {
            val school = new SchoolSpecialVo();
            school.setSpecialId(schoolSpecial1.getSpecialId());
            school.setSpecialName(schoolSpecial1.getSpecialName());
            BeanUtils.copyProperties(schoolSpecial1, school);
            return school;
        }).collect(Collectors.toList());

    }

    /**
     * 根据专业的编号查询出专业的详细信息以及学校
     * @param specialId
     * @return
     */
    public SpecialInfoVo2 findSpecialInfoBySpecialId(Integer specialId) {
       val specialInfo=new SchoolSpecial();
        specialInfo.setSpecialId(specialId);
       val specialInfos=schoolSpecialMapper.selectByPrimaryKey(specialInfo);
            professionalInfo.setSpecialId(specialId);
        //schoolManage.setSpecialId(specialId);
        List<ProfessionalInfo> professionalInfos = professionalInfoMapper.select(professionalInfo);
        val specialVo2=new SpecialInfoVo2();
            specialVo2.setProfessionalInfos(professionalInfos);
            specialVo2.setSpecialName(specialInfos.getSpecialName());
            specialVo2.setSpecialPresentation(specialInfos.getSpecialPresentation());
            specialVo2.setSpecialRatioSex(specialInfos.getSpecialRatioSex());
            specialVo2.setSpecialRatioType(specialInfos.getSpecialRatioType());
        //查询相关院校的名称
        schoolinfoAndSpecialinfo.setSpecialId(specialId);
        List<SchoolinfoAndSpecialinfo> schoolinfoAndSpecialinfos = schoolinfoAndSpecialinfoMapper.select(schoolinfoAndSpecialinfo);
        schoolinfoAndSpecialinfos.stream().forEach(schoolinfoAndSpecialinfo1 -> {
            schoolManage.setSchoolId(schoolinfoAndSpecialinfo1.getSchoolId());
            List<SchoolManage> schoolManages = schoolManageMapper.select(schoolManage);
            specialVo2.setSchoolNames(schoolManages.parallelStream().map(schoolManage1 -> {
                val schoolManagers=new SchoolManagerVo();
                LinkedList list = Lists.newLinkedList();
                schoolManagers.setSchoolName(schoolManage1.getSchoolName());
                list.add(schoolManagers);
                return list;
            }).collect(Collectors.toList()));
            BeanUtils.copyProperties(specialInfos,specialVo2);
        });
        return specialVo2;
    }

    /**
     * 修改专业信息数据
     * @param sign  表示几级专业
     * @param data 专业内容
     */
    public Integer updateSpecialInfo(Integer sign, String data) {
       switch (sign){
           case 1:
               SpecialKind special1 = JSON.parseObject(data, com.yunhang.entity.SpecialKind.class);
               int mark = specialKindMapper.updateByPrimaryKeySelective(special1);
               if (mark>0)return 1;
               else return 0;
           case 2:
               specialKindofMapper.updateByPrimaryKeySelective(JSON.parseObject(data, SpecialKindof.class));
               return 1;
           case 3:
               threeSpecialKindofMapper.updateByPrimaryKeySelective(JSON.parseObject(data, ThreeSpecialKindof.class));
               return 1;
           default:
               schoolSpecialMapper.updateByPrimaryKeySelective(JSON.parseObject(data, SchoolSpecial.class));
               return 1;
       }
    }
}
