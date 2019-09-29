package com.yunhang.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class SchoolSpecialDto {

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
     * 专业介绍
     */
    @Column(name = "special_presentation")
    private String specialPresentation;

    /**
     * 是否热门(4,热门:8,不热门)
     */
    @Column(name = "special_hot")
    private Short specialHot;

    /**
     * 是否推荐(4,热门:8,不热门)
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
    private Integer specialCode;

    /**
     * 数据包编号
     */
    @Column(name = "data_package_id")
    private String dataPackageId;

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
