package com.yunhang.dto.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/14
 * \* Time: 14:21
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
public class SchoolSpecialVo {

    /**
     * 专业编号
     */
    @Id
    @Column(name = "special_id")
    private Integer specialId;

    /**
     * 专业名称
     */
    @Column(name = "special_name")
    private String specialName;

}
