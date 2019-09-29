package com.yunhang.entity;

import javax.persistence.*;
import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/9/26
 * \* Time: 16:36
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
@Table(name = "notice")
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
}