package com.yunhang.service;

import com.yunhang.entity.ThreeSpecialKindof;
import com.yunhang.mapper.ThreeSpecialKindofMapper;
import lombok.val;
import org.springframework.stereotype.Service;

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

    /**
     * 删除三级菜单信息!
     * @param object
     * @return
     */
    public Integer deleteThreeSpecialInfo(Integer object) {
        val threeSpecial = new ThreeSpecialKindof();
        threeSpecial.setThreeSpecialId(object);
        int mark = threeSpecialKindofMapper.deleteByPrimaryKey(threeSpecial);
        if (mark>0)return 1;
        else return 0;
    }
}
