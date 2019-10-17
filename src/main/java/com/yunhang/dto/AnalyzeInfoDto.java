package com.yunhang.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/14
 * \* Time: 10:45
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 问题分析下面的显示
 * \
 */
@Data
public class AnalyzeInfoDto {


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
