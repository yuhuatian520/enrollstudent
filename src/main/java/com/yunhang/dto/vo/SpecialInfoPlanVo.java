package com.yunhang.dto.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/15
 * \* Time: 14:56
 * \* To change this template use File | Settings | File Templates.
 * \* Description:学校专业计划招生人数
 * \
 */
@Data
public class SpecialInfoPlanVo {

    /**
     * 专业编号
     */
    @Id
    @Column(name = "special_id")
    private Integer specialId;
    /**
     * 专业名称
     */
    @Column(name = "special_name")
    private String specialName;

    /**
     * 计划人数(招生数)
     */
    @Column(name = "special_people_plan")
    private Long specialPeoplePlan;


    /**
     * 专业学年度
     */
    @Column(name = "special_study_year")
    private Short specialStudyYear;

    /**
     * 专业学习费用
     */
    @Column(name = "special_study_money")
    private Integer specialStudyMoney;


}
