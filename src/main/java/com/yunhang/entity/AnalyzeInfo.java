package com.yunhang.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/12
 \* Time: 17:58
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Data
@Table(name = "analyze_info")
public class AnalyzeInfo {
    /**
     * 分析编号
     */
    @Column(name = "analyze_id")
    private String analyzeId;

    /**
     * 类型名称
     */
    @Column(name = "analyze_name")
    private String analyzeName;

    /**
     * 类型值
     */
    @Column(name = "analyze_value")
    private String analyzeValue;

    /**
     * 学生编号
     */
    @Column(name = "student_id")
    private Integer studentId;
}