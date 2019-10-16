package com.yunhang.service;

import com.yunhang.entity.TrainingInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.mapper.TrainingInfoMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
*@author 杨春路
*@data 2019/10/16 17:21
*/
@Service
public class TrainingInfoService{

    @Resource
    private TrainingInfoMapper trainingInfoMapper;

    public List<TrainingInfo> queryAllTrainingInfo() {
        return trainingInfoMapper.selectAll();
    }

    public TrainingInfo queryTrainingInfoById(Integer traingId) {
        return trainingInfoMapper.selectByPrimaryKey(traingId);
    }

    public int addTrainingInfo(TrainingInfo trainingInfo) {
        trainingInfo.setSendTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        return trainingInfoMapper.insertSelective(trainingInfo);
    }

    public int updateTrainingInfo(TrainingInfo trainingInfo) {
        return trainingInfoMapper.updateByPrimaryKeySelective(trainingInfo);
    }

    public int deleteTrainingInfoById(TrainingInfo trainingInfo) {
        trainingInfo.setStatus((short)8);
        return trainingInfoMapper.updateByPrimaryKeySelective(trainingInfo);
    }
}
