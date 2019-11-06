package com.yunhang.dto.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class SchoolManagerRecommendVo {

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
    private String schoolLogo;
    /**
     * 学校详细地址
     */
    @Excel(name = "所在地")
    @Column(name = "school_detailed")
    private String schoolDetailed;


}
