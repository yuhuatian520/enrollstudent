package com.yunhang.mapper;

import com.yunhang.entity.TrainingInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
*@author 杨春路
*@data 2019/10/16 17:21
*/
@org.apache.ibatis.annotations.Mapper
public interface TrainingInfoMapper extends Mapper<TrainingInfo> {
    List<TrainingInfo> selectAllByMark();
}