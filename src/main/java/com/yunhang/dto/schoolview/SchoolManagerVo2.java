package com.yunhang.dto.schoolview;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/15
 * \* Time: 16:28
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 招生简章中的显示数据
 * \
 */
@Data
public class SchoolManagerVo2 {
    /**
     * 学校编号
     */
    @Id
    @Column(name = "school_id")
    private Integer schoolId;
    /**
     * 学校名称
     */
    @Column(name = "school_name")
    private String schoolName;

}
