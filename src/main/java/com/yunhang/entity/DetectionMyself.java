package com.yunhang.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/10
 \* Time: 17:38
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Data
@Table(name = "detection_myself")
public class DetectionMyself {
    /**
     * 检测编号
     */
    @Id
    @Column(name = "detection_id")
    @GeneratedValue(generator = "JDBC")
    private Integer detectionId;

    /**
     * 中文
     */
    @Column(name = "dscore_chinese")
    private Short dscoreChinese;

    /**
     * 数学
     */
    @Column(name = "dscore_math")
    private Short dscoreMath;

    /**
     * 英语
     */
    @Column(name = "dscore_english")
    private Short dscoreEnglish;

    /**
     * 政治
     */
    @Column(name = "dscore_politecs")
    private Short dscorePolitecs;

    /**
     * 历史
     */
    @Column(name = "dscore_history")
    private Short dscoreHistory;

    /**
     * 地理
     */
    @Column(name = "dscore_geography")
    private Short dscoreGeography;

    /**
     * 物理
     */
    @Column(name = "dscore_physics")
    private Short dscorePhysics;

    /**
     * 化学
     */
    @Column(name = "dscore_chemistry")
    private Short dscoreChemistry;

    /**
     * 生物
     */
    @Column(name = "dscore_biology")
    private Short dscoreBiology;

    /**
     * 平均综合成绩
     */
    @Column(name = "dscore_avg")
    private Integer dscoreAvg;

    /**
     * 关联学生
     */
    @Column(name = "student_id")
    private Integer studentId;

    /**
     * 存在与否(4,存在:8,不存在)
     */
    @Column(name = "`status`")
    private Short status;

    /**
     * 检测时间
     */
    @Column(name = "dsocre_time")
    private String dsocreTime;
}