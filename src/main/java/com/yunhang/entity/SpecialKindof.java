package com.yunhang.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "special_kindof")
public class SpecialKindof {
    /**
     * 种类下的专业种类编号
     */
    @Id
    @Column(name = "special_kind_id")
    @Excel(name = "序号")
    private Integer specialKindId;

    /**
     * 种类下的专业种类名称
     */
    @Column(name = "special_kind_name")
    @Excel(name = "专业二级类别")
    private String specialKindName;

    /**
     * 关联的专业编号
     */
    @Column(name = "special_id")
    private Integer specialId;

    /**
     * 关联第一级专业
     */
    @Excel(name = "一级序号")
    @Column(name = "kind_id")
    private Integer kindId;


}