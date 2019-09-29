package com.yunhang.service;

import com.yunhang.entity.SpecialKind;
import com.yunhang.entity.SpecialKindof;
import com.yunhang.entity.ThreeSpecialKindof;
import com.yunhang.mapper.SpecialKindMapper;
import com.yunhang.mapper.SpecialKindofMapper;
import com.yunhang.mapper.ThreeSpecialKindofMapper;
import com.yunhang.utils.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecialKindService {

    @Resource
    private SpecialKindMapper specialKindMapper;
    @Autowired
    private SpecialKindofMapper specialKindofMapper;
    @Resource
    private ThreeSpecialKindofMapper threeSpecialKindofMapper;

    /**
     * 查询一级专业所有的信息
     *
     * @return
     */
    public List<SpecialKind> querySpecialKindListInfo() {
        return specialKindMapper.selectAll();
    }

    /**
     * 添加第一级菜单信息
     * @param specialKind
     * @return
     */
    public Integer appendFirstSpecialInfo(SpecialKind specialKind) {
        specialKind.setKindId(Integer.valueOf(RandomNumberGenerator.generateNumber()));
        Integer mark = specialKindMapper.insertSelective(specialKind);
        if (mark>0)return 1;
        else return 0;
    }
    /**
     * 添加第二级菜单信息
     * @param specialKindof
     * @return
     */
    public Integer appendSecondSpecialInfo(SpecialKindof specialKindof) {
        specialKindof.setSpecialKindId(Integer.valueOf(RandomNumberGenerator.generateNumber()));
        int mark = specialKindofMapper.insertSelective(specialKindof);
        if (mark>0)return 1;
        else return 0;
    }
    /**
     * 添加第三级菜单信息
     * @param threeSpecialKindof
     * @return
     */
    public Integer appendThreeSpecialInfo(ThreeSpecialKindof threeSpecialKindof) {
        threeSpecialKindof.setThreeSpecialId(Integer.valueOf(RandomNumberGenerator.generateNumber()));
        int mark = threeSpecialKindofMapper.insertSelective(threeSpecialKindof);
        if (mark>0)return 1;
        else return 0;
    }

    /**
     * 删除一级菜单信息
     * @return
     * @param object
     */
    public Integer deletefirstSpecialInfo(Integer object) {
        SpecialKind sp1 = new SpecialKind();
        sp1.setKindId(object);
        int mark = specialKindMapper.delete(sp1);
        if (mark>0)return 1;
        else return 0;
    }
}


