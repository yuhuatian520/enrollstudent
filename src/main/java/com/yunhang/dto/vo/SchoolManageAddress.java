package com.yunhang.dto.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class SchoolManageAddress {

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
     * 学校详细地址
     */
    @Excel(name = "所在地")
    @Column(name = "school_detailed")
    private String schoolDetailed;

    /**
     * 学校地址(暂时提供的是短地址)
     */
    @Excel(name = "地址")
    @Column(name = "school_address")
    private String schoolAddress;

    /**
     * 学校LOGO
     */
    @Column(name = "school_logo")
    private String schoolLogo;

}
