package com.yunhang.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
*@author 杨春路
*@data 2019/10/16 17:21
*/
@Data
@Table(name = "training_info")
public class TrainingInfo {
    /**
     * 培训编号
     */
    @Id
    @Column(name = "traing_id")
    @GeneratedValue(generator = "JDBC")
    private Integer traingId;

    /**
     * 培训名称
     */
    @Column(name = "traing_name")
    private String traingName;

    /**
     * 培训内容
     */
    @Column(name = "traing_content")
    private String traingContent;

    /**
     * 培训日期
     */
    @Column(name = "traing_start_date")
    private Date traingStartDate;

    /**
     * 结束日期
     */
    @Column(name = "traing_end_date")
    private Date traingEndDate;

    /**
     * 培训时间
     */
    @Column(name = "traing_start_time")
    private Date traingStartTime;

    /**
     * 培训结束时间
     */
    @Column(name = "traing_end_time")
    private Date traingEndTime;

    /**
     * 培训地址
     */
    @Column(name = "traing_address")
    private String traingAddress;

    /**
     * 报名参加支付金额
     */
    @Column(name = "traing_money")
    private BigDecimal traingMoney;

    /**
     * 发布活动时间
     */
    @Column(name = "send_time")
    private Date sendTime;

    /**
     * 培训描述
     */
    @Column(name = "train_description")
    private String trainDescription;

    /**
     * 报名的状态(4,ing:8,结束)
     */
    @Column(name = "train_sign")
    private Short trainSign;

    /**
     * 状态(4存在,8不存在)
     */
    @Column(name = "`status`")
    private Short status;
}