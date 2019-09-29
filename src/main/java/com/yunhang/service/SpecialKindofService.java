package com.yunhang.service;

import com.yunhang.entity.SpecialKindof;
import com.yunhang.mapper.SpecialKindofMapper;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecialKindofService{

    @Resource
    private SpecialKindofMapper specialKindofMapper;


    /**
     * 根据专业种类下的编号查询的二级专业数据
     * @param kindId  专业种类下的编号
     * @return
     */
    public List<SpecialKindof> querySpecialKindoflist(Integer kindId){
        if (kindId<0)return null;
        else return specialKindofMapper.selectById(kindId);
    }

    /**
     * 删除二级菜单信息
     * @param object
     * @return
     */
    public Integer deleteSecondSpecialInfo(Integer object) {
        val special2 = new SpecialKindof();
            special2.setSpecialKindId(object);
        int mark = specialKindofMapper.deleteByPrimaryKey(special2);
        if (mark>0)return 1;
        else return 0;
    }
}
