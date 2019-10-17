package com.yunhang.entity;

import javax.persistence.*;
import lombok.Data;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/14
 \* Time: 15:07
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Data
@Table(name = "professional_info")
public class ProfessionalInfo {
    /**
     * 职业规划编号
     */
    @Id
    @Column(name = "professional_id")
    @GeneratedValue(generator = "JDBC")
    private Integer professionalId;

    /**
     * 职业规划名称
     */
    @Column(name = "professional_name")
    private String professionalName;

    /**
     * 职业规划名称的描述
     */
    @Column(name = "professional_content")
    private String professionalContent;

    /**
     * 专业编号(跟专业挂钩)
     */
    @Column(name = "special_id")
    private Integer specialId;
}