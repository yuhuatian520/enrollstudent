package com.yunhang.mapper;

import com.yunhang.entity.SpecialKindof;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SpecialKindofMapper extends Mapper<SpecialKindof> {
    List<SpecialKindof> selectById(Integer kindId);
}