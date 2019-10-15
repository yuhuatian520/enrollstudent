package com.yunhang.service;

import com.yunhang.entity.AdministratorInfo;
import com.yunhang.utils.RandomNumberGenerator;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.mapper.AdministratorInfoMapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
*@author 杨春路
*@data 2019/10/15 9:00
*/
@Service
public class AdministratorInfoService{

    @Resource
    private AdministratorInfoMapper administratorInfoMapper;
    /**
     * 超级管理员登陆
     */
    public Boolean superAdministratorLogin(AdministratorInfo administratorInfo) {

        if(administratorInfo.getRole()==4){

            List<AdministratorInfo> administratorInfoList=administratorInfoMapper.selectByRole(administratorInfo.getRole());
            for (AdministratorInfo info : administratorInfoList) {
                if (info.getAdministratorName().equals(administratorInfo.getAdministratorName())&&info.getAdministratorPassword().equals(administratorInfo.getAdministratorPassword())){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 普通管理员添加
     * @param administratorInfo
     * @return
     */
    public int administratorAdd(AdministratorInfo administratorInfo) {
        administratorInfo.setAdministratorId(Integer.valueOf(RandomNumberGenerator.generateNumber()).toString());
        administratorInfo.setRole((short) 4);
        return administratorInfoMapper.insertSelective(administratorInfo);
    }
}
