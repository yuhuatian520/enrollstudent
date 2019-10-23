package com.yunhang.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/23
 * \* Time: 10:47
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Table(name = "notice")
@Data
public class Notice {
    /**
     * 公告编号
     */
    @Id
    @Column(name = "notice_id")
    @GeneratedValue(generator = "JDBC")
    private Integer noticeId;

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

    /**
     * 公告添加时间
     */
    @Column(name = "create_time")
    private String createTime;


}