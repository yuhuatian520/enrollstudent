package com.yunhang.entity;

import javax.persistence.*;
import lombok.Data;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/9/28
 \* Time: 17:28
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Data
@Table(name = "school_manager_img")
public class SchoolManagerImg {
    /**
     * 学校图片编号
     */
    @Column(name = "student_img_id")
    private Integer studentImgId;

    /**
     * 学校图片名称
     */
    @Column(name = "student_img_name")
    private String studentImgName;

    /**
     * 图片地址
     */
    @Column(name = "student_img_url")
    private String studentImgUrl;

    /**
     * 1,环境图:2,文化图
     */
    @Column(name = "sign")
    private Short sign;

    /**
     * 学校编号
     */
    @Column(name = "school_id")
    private Integer schoolId;
}