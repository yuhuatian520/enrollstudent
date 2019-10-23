package com.yunhang.service;

import com.yunhang.entity.SchoolSpecial;
import com.yunhang.entity.SpecialKind;
import com.yunhang.entity.SpecialKindof;
import com.yunhang.entity.ThreeSpecialKindof;
import com.yunhang.mapper.SchoolSpecialMapper;
import com.yunhang.mapper.SpecialKindMapper;
import com.yunhang.mapper.SpecialKindofMapper;
import com.yunhang.mapper.ThreeSpecialKindofMapper;
import com.yunhang.utils.RandomNumberGenerator;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

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

    @Resource
    private SchoolSpecialMapper schoolSpecialMapper;

    /**
     * 查询一级专业所有的信息
     *
     * @return
     */
    public List<SpecialKind> querySpecialKindListInfo() {
        val example = new Example(SpecialKind.class);
            example.setOrderByClause("kind_id ASC");
            return specialKindMapper.selectByExample(example);
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
     * 删除一级菜单信息 把一级下面的所有信息也删了
     * @return
     * @param object
     */
    @Transactional
    public Integer deletefirstSpecialInfo(Integer object) {
        SpecialKind sp1 = new SpecialKind();
        sp1.setKindId(object);
        int mark = specialKindMapper.delete(sp1);
        if (mark>0){
            val sp2=new SpecialKindof();
            sp2.setKindId(object);
            List<SpecialKindof> specialKindofs = specialKindofMapper.select(sp2);
            if (specialKindofs.size()>0||specialKindofs!=null){
                specialKindofs.stream().forEach(ss -> {
                    int mark2 = specialKindofMapper.deleteByPrimaryKey(ss.getSpecialKindId());
                        if (mark2>0){
                            //三级菜单开始
                            val three=new ThreeSpecialKindof();
                            three.setSpecialKindId(ss.getSpecialKindId());
                            List<ThreeSpecialKindof> threeSpecialKindOfs = threeSpecialKindofMapper.select(three);
                                    if (threeSpecialKindOfs.size()>0||threeSpecialKindOfs!=null){
                                        three.setSpecialKindId(ss.getSpecialKindId());
                                        int mark3 = threeSpecialKindofMapper.delete(three);
                                        if (mark3>0){
                                            threeSpecialKindOfs.stream().forEach(sss->{
                                                val specialInfo=new SchoolSpecial();
                                                    specialInfo.setSpecialId(sss.getSpecialId());
                                                schoolSpecialMapper.delete(specialInfo);

                                            });

                                        }
                                    }

                        }
                });
            }
            return 1;
        }
        else return 0;
    }


}


