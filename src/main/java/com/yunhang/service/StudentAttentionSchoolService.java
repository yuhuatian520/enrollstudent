package com.yunhang.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.mapper.StudentAttentionSchoolMapper;
/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/9/27
 \* Time: 10:01
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Service
public class StudentAttentionSchoolService{

    @Resource
    private StudentAttentionSchoolMapper studentAttentionSchoolMapper;

}
