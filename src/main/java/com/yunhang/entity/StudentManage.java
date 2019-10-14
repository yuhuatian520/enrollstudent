package com.yunhang.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "student_manage")
public class StudentManage {
    /**
     * 学生编号
     */
    @Id
    @Column(name = "student_id")
    private Integer studentId;

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
     * 性格编号
     */
    @Column(name = "personality_id")
    private String personalityId;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 删除学生(4,显示:8,不显示)
     */
    @Column(name = "mark")
    private Short mark;

    /**
     * 学生头像
     */
    @Column(name = "student_avatar")
    private String studentAvatarUrl;


}