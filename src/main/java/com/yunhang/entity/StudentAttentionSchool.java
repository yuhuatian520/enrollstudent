package com.yunhang.entity;

import javax.persistence.*;
import lombok.Data;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/9/27
 \* Time: 10:01
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Data
@Table(name = "student_attention_school")
public class StudentAttentionSchool {
    /**
     * 学生编号
     */
    @Column(name = "student_id")
    private Integer studentId;

    /**
     * 学校编号
     */
    @Column(name = "school_id")
    private Integer schoolId;
}