package com.yunhang.service;

import com.yunhang.entity.SchoolImgTaginfo;
import com.yunhang.mapper.SchoolImgTaginfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/16
 \* Time: 12:43
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Service
public class SchoolImgTaginfoService{

    @Resource
    private SchoolImgTaginfoMapper schoolImgTaginfoMapper;

    public List<SchoolImgTaginfo> findAll() {
        return schoolImgTaginfoMapper.selectAll();
    }
}
