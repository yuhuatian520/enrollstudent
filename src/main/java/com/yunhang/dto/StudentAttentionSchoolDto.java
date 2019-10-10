package com.yunhang.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author yangchunlu
 * @date 2019-9-28
 */
@Data
public class StudentAttentionSchoolDto {
    /**
     * 学生编号
     */
    private Integer studentId;

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


}
