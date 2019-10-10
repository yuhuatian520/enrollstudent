package com.yunhang.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
@ExcelTarget("NoticeDto")
@Data
public class NoticeDto {

    /**
     * 公告编号
     */
    @Id
    @Column(name = "notice_id")
    @Excel(name = "通知编号")
    private String noticeId;

    /**
     * 公告名称
     */
    @Excel(name = "通知名称")
    @Column(name = "notice_name")
    private String noticeName;

    /**
     * 公告内容
     */
    @Excel(name = "通知内容")
    @Column(name = "notice_content")
    private String noticeContent;





}
