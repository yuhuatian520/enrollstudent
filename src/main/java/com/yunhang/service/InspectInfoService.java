package com.yunhang.service;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.yunhang.dto.AnalyzeInfoDto;
import com.yunhang.dto.AnswerInfoDto;
import com.yunhang.dto.InspectInfoDto;
import com.yunhang.entity.AnalyzeInfo;
import com.yunhang.entity.AnswerInfo;
import com.yunhang.entity.InspectInfo;
import com.yunhang.mapper.AnalyzeInfoMapper;
import com.yunhang.mapper.AnswerInfoMapper;
import com.yunhang.mapper.InspectInfoMapper;
import com.yunhang.utils.date.DateFormatUtil;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/11
 \* Time: 10:18
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Service
public class InspectInfoService{

    @Resource
    private InspectInfoMapper inspectInfoMapper;
    @Resource
    private AnswerInfoMapper answerInfoMapper;
    @Resource
    private AnalyzeInfoMapper analyzeInfoMapper;

    /**
     * 查询所有的问题和答案信息
     * @return
     */
    public List<InspectInfoDto> findInspectAndAnswerInfoAlls() {
        List<InspectInfoDto> list=new ArrayList<>();
       val inspectInfos=inspectInfoMapper.selectAll();
        for (InspectInfo inspectInfo : inspectInfos) {
            val answer = new AnswerInfo();
            answer.setQuestionId(inspectInfo.getQuestionId());
            val answerInfos=answerInfoMapper.select(answer);
            Multiset<AnswerInfoDto> set = HashMultiset.create();
            for (AnswerInfo info : answerInfos) {
                val answerDto=new AnswerInfoDto();
                answerDto.setAnswerId(info.getAnswerId());
                answerDto.setAnswerContent(info.getAnswerContent());
                BeanUtils.copyProperties(info,answerDto);
                set.add(answerDto);
            }

            val inspectInfoDto=new InspectInfoDto();
                inspectInfoDto.setQuestionId(inspectInfo.getQuestionId());
                inspectInfoDto.setQuestionName(inspectInfo.getQuestionName());
                inspectInfoDto.setAnswerInfoDtos(set);
                BeanUtils.copyProperties(inspectInfo,inspectInfoDto);
                list.add(inspectInfoDto);
        }
        return list;

    }

    /** 传一个问题的编号过来 学生的编号也传过来
     * 测试题添加 然后把对应的数据显示出来
     * @param inspectInfo
     */
    public AnalyzeInfoDto updateInspectInfos(InspectInfo inspectInfo) {

        if (inspectInfo==null)return null;
        inspectInfo.setCreateTime(DateFormatUtil.createDateAndTime());
        //添加了 答案的内容 已经学生的编号
        Integer sign = inspectInfoMapper.updateByPrimaryKeySelective(inspectInfo);
       val analyzeInfo=new AnalyzeInfo();
            analyzeInfo.setStudentId(inspectInfo.getStudentId());
           val analyzeInfoDto=new AnalyzeInfoDto();
        AnalyzeInfo info = analyzeInfoMapper.selectOne(analyzeInfo);
        BeanUtils.copyProperties(analyzeInfo,analyzeInfoDto);
            return analyzeInfoDto;
    }



}
