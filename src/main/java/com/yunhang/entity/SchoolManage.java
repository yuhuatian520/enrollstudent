package com.yunhang.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/8
 * \* Time: 11:41
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
@Table(name = "school_manage")
public class SchoolManage {
    /**
     * 学校编号
     */
    @Id
    @Column(name = "school_id")
    @Excel(name = "序号")
    private Integer schoolId;

    /**
     * 学校名称
     */
    @Column(name = "school_name")
    @Excel(name = "名称")
    private String schoolName;

    /**
     * 学校介绍
     */
    @Column(name = "school_presentation")
    @Excel(name = "学校简介")
    private String schoolPresentation;

    /**
     * 学校环境图
     */
    @Column(name = "school_img")
    @Excel(name = "学校图片")
    private String schoolImg;

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

    /**
     * 联系方式
     */
    @Column(name = "scholl_phone")
    @Excel(name = "联系电话")
    private String schollPhone;

    /**
     * 学校网址
     */
    @Column(name = "school_url")
    private String schoolUrl;

    /**
     * 学校地址
     */
    @Column(name = "school_address")
    @Excel(name = "地址")
    private String schoolAddress;


    public SchoolManage() {
    }



}