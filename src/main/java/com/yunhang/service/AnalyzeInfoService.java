package com.yunhang.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.mapper.AnalyzeInfoMapper;
/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/12
 \* Time: 17:58
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Service
public class AnalyzeInfoService{

    @Resource
    private AnalyzeInfoMapper analyzeInfoMapper;

}
