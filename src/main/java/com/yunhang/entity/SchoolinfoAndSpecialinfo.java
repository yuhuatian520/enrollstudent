package com.yunhang.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/15
 \* Time: 15:56
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Data
@Table(name = "schoolinfo_and_specialinfo")
public class SchoolinfoAndSpecialinfo {
    /**
     * 编号
     */
    @Id
    @Column(name = "school_special_id")
    @GeneratedValue(generator = "JDBC")
    private Integer schoolSpecialId;

    /**
     * 学校编号
     */
    @Column(name = "school_id")
    private Integer schoolId;

    /**
     * 专业编号
     */
    @Column(name = "special_id")
    private Integer specialId;
}