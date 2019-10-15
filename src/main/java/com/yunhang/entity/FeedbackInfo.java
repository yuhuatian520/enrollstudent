package com.yunhang.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
 * @author 杨春路
 * @data 2019/10/15 15:27
 */
@Data
@Table(name = "feedback_info")
public class FeedbackInfo {
    /**
     * 我的页面Id
     */
    @Id
    @Column(name = "feedback_id")
    private Integer feedbackId;

    /**
     * 意见内容
     */
    @Column(name = "feedback_content")
    private String feedbackContent;

    /**
     * 联系方式
     */
    @Column(name = "feedback_contactinfo")
    private String feedbackContactinfo;

    /**
     * 联系qq
     */
    @Column(name = "cost_qq")
    private String costQq;

    /**
     * 联系电话
     */
    @Column(name = "cost_phone")
    private String costPhone;

    /**
     * 官网公众号
     */
    @Column(name = "official_accounts")
    private String officialAccounts;

    /**
     * 版本号
     */
    @Column(name = "version_number")
    private String versionNumber;

    /**
     * 软件评分
     */
    @Column(name = "software_evaluation")
    private String softwareEvaluation;

    /**
     * 意见提交时间
     */
    @Column(name = "submission_time")
    private String submissionTime;

    /**
     * 联系邮箱
     */
    @Column(name = "cost_email")
    private String costEmail;
}