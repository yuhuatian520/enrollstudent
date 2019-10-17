package com.yunhang.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/12
 \* Time: 17:58
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Data
@Table(name = "aspiration_info")
public class AspirationInfo {
    /**
     * 志愿编号
     */
    @Id
    @Column(name = "aspiration_id")
    @GeneratedValue(generator = "JDBC")
    private Integer aspirationId;

    /**
     * 校园编号
     */
    @Column(name = "school_id")
    private Integer schoolId;

    /**
     * 专业编号
     */
    @Column(name = "school_special_id")
    private Integer schoolSpecialId;
}