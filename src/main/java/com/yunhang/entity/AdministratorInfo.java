package com.yunhang.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

/**
*@author 杨春路
*@data 2019/10/15 9:00
*/
@Data
@Table(name = "administrator_info")
public class AdministratorInfo {
    /**
     * 管理员编号
     */
    @Id
    @Column(name = "administrator_id")
    private String administratorId;

    /**
     * 管理员名称
     */
    @Column(name = "administrator_name")
    private String administratorName;

    /**
     * 管理员密码
     */
    @Column(name = "administrator_password")
    private String administratorPassword;

    /**
     * 状态(4,可以:8,禁用)
     */
    @Column(name = "`status`")
    private Short status;

    /**
     * 注册时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 登陆时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 标识(4,超级管理员:8,普通管理员)
     */
    @Column(name = "role")
    private Short role;
}