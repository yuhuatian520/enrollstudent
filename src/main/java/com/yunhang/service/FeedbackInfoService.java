package com.yunhang.service;

import com.yunhang.dto.CustomerServiceDto;
import com.yunhang.entity.FeedbackInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.mapper.FeedbackInfoMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

/**
 * @author 杨春路
 * @data 2019/10/15 14:50
 */
@Service
public class FeedbackInfoService {

    @Resource
    private FeedbackInfoMapper feedbackInfoMapper;

    /**
     * 提交意见反馈
     *
     * @param feedbackInfo
     * @return
     */
    public int addFeedback(FeedbackInfo feedbackInfo) {
/*        //获取传进来的联系方式
        String contactInfo = feedbackInfo.getFeedbackContactinfo();
        //如果是手机号码,则将手机号码存入
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        if (Pattern.matches(regex, contactInfo)) {
            feedbackInfo.setCostPhone(contactInfo);
        }

            //如果是QQ号码,将QQ号码存入
        else
            feedbackInfo.setCostQq(contactInfo);*/

        feedbackInfo.setSubmissionTime(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        //如果是邮箱,则将邮箱存入
        if (feedbackInfo.getFeedbackContactinfo().indexOf("@") != (-1))
            feedbackInfo.setCostEmail(feedbackInfo.getFeedbackContactinfo());
        return feedbackInfoMapper.insertSelective(feedbackInfo);
    }

    /**
     * 获得客服数据
     * @return
     */

    public CustomerServiceDto queryCustomerService() {
        FeedbackInfo feedbackInfo=feedbackInfoMapper.selectByPrimaryKey(1);
        CustomerServiceDto customerServiceDto=new CustomerServiceDto();
        BeanUtils.copyProperties(feedbackInfo,customerServiceDto);
        return customerServiceDto;
    }
}


