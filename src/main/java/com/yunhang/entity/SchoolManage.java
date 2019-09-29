package com.yunhang.entity;

import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "school_manage")
public class SchoolManage {
    /**
     * 学校编号
     */
    @Id
    @Column(name = "school_id")
    private Integer schoolId;

    /**
     * 学校名称
     */
    @Column(name = "school_name")
    private String schoolName;

    /**
     * 学校介绍
     */
    @Column(name = "school_presentation")
    private String schoolPresentation;

    /**
     * 学校环境图
     */
    @Column(name = "school_img")
    private byte[] schoolImg;

    /**
     * 是否推荐(4,推荐:8,不推荐)
     */
    @Column(name = "school_recommend")
    private Short schoolRecommend;

    /**
     * 是否热门(4,推荐:8,不推荐)
     */
    @Column(name = "school_hot")
    private Short schoolHot;

    /**
     * 专业编号
     */
    @Column(name = "school_special_id")
    private Integer schoolSpecialId;

    /**
     * 是否关注(4,关注:8,不关注)
     */
    @Column(name = "is_attention")
    private Short isAttention;
}