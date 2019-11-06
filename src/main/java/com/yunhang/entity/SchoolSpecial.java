package com.yunhang.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/15
 * \* Time: 15:04
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

@Data
@Table(name = "school_special")
public class SchoolSpecial {
    /**
     * 专业编号
     */
    @Id
    @Column(name = "special_id")
    @Excel(name = "序号")
    private Integer specialId;

    /**
     * 专业名称
     */
    @Column(name = "special_name")
    @Excel(name = "名称")
    private String specialName;

    /**
     * 专业介绍
     */
    @Column(name = "special_presentation")
    @Excel(name = "专业介绍")
    private String specialPresentation;

    /**
     * 是否热门(4,热门:8,不热门)
     */
    @Column(name = "special_hot")
    private Short specialHot;

    /**
     * 是否推荐(4,推荐:8,不)
     */
    @Column(name = "special_recommend")
    private Short specialRecommend;

    /**
     * 专业评分
     */
    @Column(name = "special_score")
    private Integer specialScore;

    /**
     * 历年专业
     */
    @Column(name = "special_year")
    private Date specialYear;

    /**
     * 报考专业人数
     */
    @Column(name = "special_people_number")
    private Long specialPeopleNumber;

    /**
     * 计划人数(招生数)
     */
    @Column(name = "special_people_plan")
    private Long specialPeoplePlan;

    /**
     * 实际需要的人数(录取人数)
     */
    @Column(name = "special_practical")
    private Long specialPractical;

    /**
     * 专业分数
     */
    @Column(name = "special_grade")
    private Double specialGrade;

    /**
     * 专业编号
     */
    @Column(name = "special_code")
    @Excel(name = "专业代码")
    private String specialCode;

    /**
     * 数据包编号
     */
    @Column(name = "data_package_id")
    private String dataPackageId;

    /**
     * 男女比例
     */
    @Column(name = "special_ratio_sex")
    @Excel(name = "男女比例")
    private String specialRatioSex;

    /**
     * 文理比例
     */
    @Column(name = "special_ratio_type")
    private String specialRatioType;

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

    /**
     * 关联学生
     */
    @Column(name = "student_id")
    private Integer studentId;

    /**
     * 是否删除(4,显示:8,不显示)
     */
    @Column(name = "mark")
    private Short mark;

    /**
     * 是否关注(4,关注:8,不关注)
     */
    @Column(name = "is_attention")
    private Short isAttention;
}