package com.yunhang.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.mapper.AnswerInfoMapper;
/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/10
 \* Time: 17:38
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Service
public class AnswerInfoService{

    @Resource
    private AnswerInfoMapper answerInfoMapper;

}
