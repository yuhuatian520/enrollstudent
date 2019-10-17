package com.yunhang.service;

import com.yunhang.entity.TrainingInfo;
import org.apache.poi.hpsf.Decimal;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.mapper.TrainingInfoMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 杨春路
 * @data 2019/10/17 11:35
 */
@Service
public class BackstageTrainingInfoService {
    @Resource
    private TrainingInfoMapper trainingInfoMapper;
    /**
     * 查询所有培训信息
     */
    public List<TrainingInfo> queryAllTrainingInfo() {
        return trainingInfoMapper.selectAllByMark();
    }
    /**
     * 查询培训信息ById
     *
     */
    public TrainingInfo queryTrainingInfoById(Integer traingId) {
        return trainingInfoMapper.selectByPrimaryKey(traingId);
    }
    /**
     * 添加培训信息
     */
    public int addTrainingInfo(TrainingInfo trainingInfo) {
        trainingInfo.setSendTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        return trainingInfoMapper.insertSelective(trainingInfo);
    }
    /**
     * 更新培训信息
     */
    public int updateTrainingInfo(TrainingInfo trainingInfo) {
        return trainingInfoMapper.updateByPrimaryKeySelective(trainingInfo);
    }
    /**
     * 删除培训信息
     */
    public int deleteTrainingInfoById(TrainingInfo trainingInfo) {
        trainingInfo.setStatus((short)8);
        return trainingInfoMapper.updateByPrimaryKeySelective(trainingInfo);
    }
}
