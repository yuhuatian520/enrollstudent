package com.yunhang.service;

import com.yunhang.entity.AspirationInfo;
import com.yunhang.mapper.AspirationInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/12
 \* Time: 17:58
 \* To change this template use File | Settings | File Templates.
 \* Description:  填写志愿
 \*/
@Service
public class AspirationInfoService{

    @Resource
    private AspirationInfoMapper aspirationInfoMapper;

    public void addAspirationInfos(AspirationInfo aspirationInfo) {

    }
}
