package com.yunhang.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;


/**
 * @author yangchunlu
 * @date 2019-9-28
 */

@ExcelTarget("NoticeDto")

@Data
public class NoticeDto {


    /**
     * 公告编号
     */
    @Id
    @Column(name = "notice_id")
    @Excel(name = "通知编号")
    private Integer noticeId;

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

    //学校名称
    private String schoolName;
    //公告创建时间
    private String createTime;
    //学校图片
    private String schoolLogo;


}
