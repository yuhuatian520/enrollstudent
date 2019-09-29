package com.yunhang.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/9/26
 \* Time: 13:08
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Data
@Table(name = "three_special_kindof")
public class ThreeSpecialKindof {
    /**
     * 三级菜单编号
     */
    @Id
    @Column(name = "three_special_id")
    private Integer threeSpecialId;

    /**
     * 三级菜单名称
     */
    @Column(name = "three_special_name")
    private String threeSpecialName;

    /**
     * 二级菜单编号
     */
    @Column(name = "special_kind_id")
    private Integer specialKindId;

    /**
     * 关联专业信息
     */
    @Column(name = "special_id")
    private Integer specialId;

    private SchoolSpecial schoolSpecial;



}