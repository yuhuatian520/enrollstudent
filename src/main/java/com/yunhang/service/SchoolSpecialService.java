package com.yunhang.service;

import com.yunhang.dto.SchoolSpecialDto;
import com.yunhang.entity.SchoolSpecial;
import com.yunhang.entity.ThreeSpecialKindof;
import com.yunhang.mapper.SchoolSpecialMapper;
import com.yunhang.mapper.SpecialKindMapper;
import com.yunhang.mapper.SpecialKindofMapper;
import com.yunhang.mapper.ThreeSpecialKindofMapper;
import com.yunhang.utils.RandomNumberGenerator;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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
     * 删除学校专业信息!
     * @param object
     * @return
     */
    public Integer deleteSchoolSpecialInfo(Integer object) {
        val schoolSpecial = new SchoolSpecial();
            schoolSpecial.setSpecialId(object);
        int mark = schoolSpecialMapper.deleteByPrimaryKey(schoolSpecial);
        if (mark>0)return 1;
        else return 0;
    }
}
