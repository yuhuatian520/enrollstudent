package com.yunhang.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "notice")
public class Notice {
    /**
     * 公告编号
     */
    @Id
    @Column(name = "notice_id")
    private String noticeId;

    /**
     * 公告名称
     */
    @Column(name = "notice_name")
    private String noticeName;

    /**
     * 公告内容
     */
    @Column(name = "notice_content")
    private String noticeContent;

    /**
     * 某某学院发布
     */
    @Column(name = "school_id")
    private Integer schoolId;

    /**
     * 标示
     */
    @Column(name = "sign")
    private Short sign;

    /**
     * 测试
     */
    @Column(name = "mark")
    private Short mark;


}