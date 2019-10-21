package com.yunhang.service;

import com.yunhang.entity.ThreeSpecialKindof;
import com.yunhang.mapper.SchoolSpecialMapper;
import com.yunhang.mapper.SpecialKindofMapper;
import com.yunhang.mapper.ThreeSpecialKindofMapper;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/9/26
 \* Time: 13:08
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Service
public class ThreeSpecialKindofService{

    @Resource
    private ThreeSpecialKindofMapper threeSpecialKindofMapper;

    @Resource
    private SpecialKindofMapper specialKindofMapper;

    @Resource
    private SchoolSpecialMapper schoolSpecialMapper;

    /**
     * 删除三级菜单信息!
     * @param object
     * @return
     */
    @Transactional
    public Integer deleteThreeSpecialInfo(Integer object) {
        val threeSpecial = new ThreeSpecialKindof();
        threeSpecial.setThreeSpecialId(object);
        int mark = threeSpecialKindofMapper.deleteByPrimaryKey(threeSpecial);
        if (mark>0){
           val school=schoolSpecialMapper.selectByPrimaryKey(object);
           schoolSpecialMapper.deleteByPrimaryKey(school);
           return 1;
        }
         return 0;
    }
}
