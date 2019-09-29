package com.yunhang.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.mapper.StudentManageMapper;
@Service
public class StudentManageService{

    @Resource
    private StudentManageMapper studentManageMapper;

}
