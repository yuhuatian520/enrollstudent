package com.yunhang.service;

import com.yunhang.entity.SchoolSpecial;
import com.yunhang.entity.SpecialKindof;
import com.yunhang.entity.ThreeSpecialKindof;
import com.yunhang.mapper.SchoolSpecialMapper;
import com.yunhang.mapper.SpecialKindMapper;
import com.yunhang.mapper.SpecialKindofMapper;
import com.yunhang.mapper.ThreeSpecialKindofMapper;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecialKindofService{
    /**
     * 二级菜单
     */
    @Resource
    private SpecialKindofMapper specialKindofMapper;
    /**
     * 二级菜单
     */
    @Resource
    private SpecialKindMapper specialKindMapper;

    @Resource
    private ThreeSpecialKindofMapper threeSpecialKindofMapper;

    @Resource
    private SchoolSpecialMapper schoolSpecialMapper;

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
     * 删除二级菜单信息把关联的一级菜单信息编号设置为空!
     * @param object
     * @return
     */
    @Transactional
    public Integer deleteSecondSpecialInfo(Integer object) {
        val special2 = new SpecialKindof();
            special2.setSpecialKindId(object);
        int mark = specialKindofMapper.deleteByPrimaryKey(special2);
        if (mark>0){
           //把子类删了
            val threeInfo=new ThreeSpecialKindof();
                threeInfo.setSpecialKindId(object);
            List<ThreeSpecialKindof> threeInfos = threeSpecialKindofMapper.select(threeInfo);
            if (threeInfos!=null||threeInfos.size()>0){
                threeInfos.forEach(s->{
                    //删除三级
                    int mark2 = threeSpecialKindofMapper.deleteByPrimaryKey(s);
                   if (mark2>0){
                       //删除四级
                     val schoolSpecialInfo=new SchoolSpecial();
                     //三级主键是四级的主键
                       schoolSpecialInfo.setSpecialId(s.getThreeSpecialId());
                      val schoolSpecial=schoolSpecialMapper.selectByPrimaryKey(schoolSpecialInfo);
                           schoolSpecialMapper.deleteByPrimaryKey(schoolSpecial);
                   }
                });
            }
            return 1;
        }
       return 0;
    }
}
