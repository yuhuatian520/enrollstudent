package com.yunhang.dto;

import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

/**
 * @author 杨春路
 * @data 2019/10/15 16:04
 */

@Data

public class CustomerServiceDto {
    /**
     * 联系qq
     */
    @Column(name = "cost_qq")
    private String costQq;

    /**
     * 联系电话
     */
    @Column(name = "cost_phone")
    private String costPhone;

    /**
     * 官网公众号
     */
    @Column(name = "official_accounts")
    private String officialAccounts;
}
