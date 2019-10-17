package com.yunhang.service;

import com.yunhang.dto.DetectionMyselfDto;
import com.yunhang.entity.DetectionMyself;
import com.yunhang.mapper.DetectionMyselfMapper;
import com.yunhang.utils.RandomNumberGenerator;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/10
 \* Time: 17:38
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Service
public class DetectionMyselfService{

    @Resource
    private DetectionMyselfMapper detectionMyselfMapper;

    @Autowired
    private DetectionMyself detectionMyself;
    /**
     * 自我检测的数据添加
     * @param detectionMyself
     * @return 88数据为空 1成功 0 失败
     */
    public Integer appendDetectionInfos(DetectionMyself detectionMyself) throws Exception {

        if (detectionMyself.getStudentId()!=null){

            detectionMyself.setStudentId(detectionMyself.getStudentId());
           val info=detectionMyselfMapper.selectOne(detectionMyself);
           if (info!=null)return 44;
        } else
        if (detectionMyself==null)
            return 88;

        //编号
        detectionMyself.setDetectionId(Integer.valueOf(RandomNumberGenerator.generateNumber()));
        //检测的时间
        detectionMyself.setDsocreTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        //分别获取各科的分数进行求数据
        Integer detectionScore = (detectionMyself.getDscoreChinese()
                + detectionMyself.getDscoreMath()
                + detectionMyself.getDscoreEnglish()
                + detectionMyself.getDscorePolitecs()
                + detectionMyself.getDscoreHistory()
                + detectionMyself.getDscoreGeography()
                + detectionMyself.getDscorePhysics()
                + detectionMyself.getDscoreChemistry()
                + detectionMyself.getDscoreBiology()) / 9;
          if (detectionScore>=1&&detectionScore<2){
              detectionMyself.setDscoreAvg(detectionScore);
              detectionMyselfMapper.updateByPrimaryKeySelective(detectionMyself);
          }else if (detectionScore>=2&&detectionScore<3){
              detectionMyself.setDscoreAvg(detectionScore);
              detectionMyselfMapper.updateByPrimaryKeySelective(detectionMyself);
          }else if (detectionScore>=3&&detectionScore<4){
              detectionMyself.setDscoreAvg(detectionScore);
              detectionMyselfMapper.updateByPrimaryKeySelective(detectionMyself);
          }else if (detectionScore>=4){
              detectionMyself.setDscoreAvg(detectionScore);
              detectionMyselfMapper.updateByPrimaryKeySelective(detectionMyself);
          }
        int sign = detectionMyselfMapper.insertSelective(detectionMyself);
        if (sign>0)return 1;
        else return 0;
        }



    /**
     * 查询检测完毕之后的数据信息
     * @param studentId
     * @return
     */
    public DetectionMyselfDto findDetectionInfoIng(Integer studentId) {

        detectionMyself.setStudentId(studentId);
        DetectionMyself detectionMyselfInfo = detectionMyselfMapper.selectOne(detectionMyself);
        if (detectionMyselfInfo==null)return null;
        val detectionMyself=new DetectionMyself();
        detectionMyself.setStudentId(studentId);
        DetectionMyself info = detectionMyselfMapper.selectOne(detectionMyself);
        val detectionMyselfDto=new DetectionMyselfDto();
        BeanUtils.copyProperties(info,detectionMyselfDto);
        return detectionMyselfDto;
    }



}
