package com.yunhang.dto.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class SchoolSpecialInfoRecommendVo {

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
     * 专业学习费用
     */
    @Column(name = "special_study_money")
    private Integer specialStudyMoney;
    /**
     * 种类下的专业种类名称
     */
    @Column(name = "special_kind_name")
    private String specialKindName;

}
