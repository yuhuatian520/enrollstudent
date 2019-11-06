package com.yunhang.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/15
 * \* Time: 10:58
 * \* To change this template use File | Settings | File Templates.
 * \* Description:学校管理
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
    @Excel(name = "学校简介")
    @Column(name = "school_presentation")
    private String schoolPresentation;

    /**
     * 学校属性
     */
    @Excel(name = "属性")
    @Column(name = "school_attribute")
    private String schoolAttribute;

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

    /**
     * 联系方式
     */
    @Excel(name = "联系电话")
    @Column(name = "scholl_phone")
    private String schollPhone;

    /**
     * 学校网址
     */
    @Excel(name = "网址")
    @Column(name = "school_url")
    private String schoolUrl;

    /**
     * 学校地址(暂时提供的是短地址)
     */
    @Excel(name = "地址")
    @Column(name = "school_address")
    private String schoolAddress;

    /**
     * 校园代码
     */
    @Column(name = "school_code")
    private String schoolCode;

    /**
     * 学校详细地址
     */
    @Excel(name = "所在地")
    @Column(name = "school_detailed")
    private String schoolDetailed;


    /**
     * 学校LOGO
     */
    @Column(name = "school_logo")
    private String schoolLogo;


    /**
     * 录取总人数
     */
    @Column(name = "adopt_total_people")
    private Integer adoptTotalPeople;

    /**
     * 专业编号(方便查询专业的时候查询)
     */
    @Column(name = "special_id")
    private Integer specialId;

    private List<SchoolManagerImg> schoolManagerImgLists;



}