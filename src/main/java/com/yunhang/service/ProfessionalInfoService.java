package com.yunhang.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.mapper.ProfessionalInfoMapper;
/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/14
 \* Time: 15:07
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Service
public class ProfessionalInfoService{

    @Resource
    private ProfessionalInfoMapper professionalInfoMapper;

}
