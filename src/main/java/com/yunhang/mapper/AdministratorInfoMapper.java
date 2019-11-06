package com.yunhang.mapper;

import com.yunhang.entity.AdministratorInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
*@author 杨春路
*@data 2019/10/15 9:00
*/
@org.apache.ibatis.annotations.Mapper
public interface AdministratorInfoMapper extends Mapper<AdministratorInfo> {

    List<AdministratorInfo> selectByRole(Short role);

    AdministratorInfo selectByName(String administratorName);


}