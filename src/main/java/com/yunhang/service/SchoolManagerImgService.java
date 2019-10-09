package com.yunhang.service;

import com.yunhang.entity.SchoolManagerImg;
import com.yunhang.mapper.SchoolManagerImgMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/9/28
 \* Time: 17:28
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Service
public class SchoolManagerImgService{

    @Resource
    private SchoolManagerImgMapper schoolManagerImgMapper;


    public List<SchoolManagerImg> findSchoolInfoImgBySchoolIdAndSign(Integer schoolId, Short sign) {
        return schoolManagerImgMapper.selectAll();
    }
}
