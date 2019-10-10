package com.yunhang.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author yangchunlu
 * @date 2019-9-28
 */
@Data
public class SelectStudentInfoDto {
    /**
     * 学生姓名
     */
    @Column(name = "student_name")
    private String studentName;

    /**
     * 学生学校名称
     */
    @Column(name = "student_schoolname")
    private String studentSchoolname;

    /**
     * 学生年龄
     */
    @Column(name = "student_age")
    private Integer studentAge;

    /**
     * 学生性别(1,男:2,女:3,未知)
     */
    @Column(name = "student_sex")
    private Short studentSex;

    /**
     * 学生手机号码
     */
    @Column(name = "student_phone")
    private String studentPhone;

    /**
     * 学生心愿
     */
    @Column(name = "student_wish")
    private String studentWish;



    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;



}
