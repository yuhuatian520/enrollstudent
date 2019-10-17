package com.yunhang.entity;

import javax.persistence.*;
import lombok.Data;

/**
 \* Created with IntelliJ IDEA.
 \* User: 王耀
 \* Date: 2019/10/16
 \* Time: 12:43
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
@Data
@Table(name = "school_img_taginfo")
public class SchoolImgTaginfo {
    /**
     * 标签
     */
    @Id
    @Column(name = "tag_id")
    @GeneratedValue(generator = "JDBC")
    private Integer tagId;

    /**
     * 标签内容
     */
    @Column(name = "tag_content")
    private String tagContent;

    /**
     * 关联校园图片编号
     */
    @Column(name = "sign")
    private Integer sign;
}