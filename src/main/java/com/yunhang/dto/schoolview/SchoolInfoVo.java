package com.yunhang.dto.schoolview;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/15
 * \* Time: 10:30
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 展示学校的信息数据!  原型图中的爱校园模块
 * \
 */
@Data
public class SchoolInfoVo {

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
     * 学校LOGO
     */
    @Column(name = "school_logo")
    @Excel(name = "学校logo")
    private String schoolLogo;

    /**
     * 录取总人数
     */
    @Column(name = "adopt_total_people")
    private Integer adoptTotalPeople;

    /**
     * 学校介绍
     */
    @Column(name = "school_presentation")
    @Excel(name = "学校简介")
    private String schoolPresentation;


    /**
     * 学校环境图
     */
    private List schoolImgs;


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


}
