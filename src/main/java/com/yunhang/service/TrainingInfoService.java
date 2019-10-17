package com.yunhang.service;

import com.yunhang.dto.TrainingInfoDto;
import com.yunhang.entity.TrainingInfo;
import com.yunhang.mapper.TrainingInfoMapper;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
*@author 杨春路
*@data 2019/10/16 17:21
*/
@Service
public class TrainingInfoService{

    @Resource
    private TrainingInfoMapper trainingInfoMapper;

    @Resource
    private TrainingInfo trainingInfo;

    @Resource
    private TrainingInfoDto trainingInfoDto;

    public TrainingInfoDto findTraingInfoBytrainId(Integer traingId) {
        if (traingId == null || traingId < 0) {
            return null;
        }
        trainingInfo.setTraingId(traingId);
        val traingInfoobj = trainingInfoMapper.selectByPrimaryKey(trainingInfo);
        //val traingInfoDto=new TrainingInfoDto();
        BeanUtils.copyProperties(traingInfoobj, trainingInfoDto);
        return trainingInfoDto;
    }

    /**
     * 查询所有的数据信息
     *
     * @return
     */
    public List<TrainingInfoDto> findTraingInfoByAlls() {
        List<TrainingInfo> trainingInfos = trainingInfoMapper.selectAll();
        return  trainingInfos.parallelStream().map(s->{
            TrainingInfoDto tr = new TrainingInfoDto();
                BeanUtils.copyProperties(s,tr);
                return tr;
        }).collect(Collectors.toList());
    }
}
