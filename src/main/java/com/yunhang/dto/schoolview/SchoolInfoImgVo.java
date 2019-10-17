package com.yunhang.dto.schoolview;

import lombok.Data;

import javax.persistence.Column;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/15
 * \* Time: 11:26
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 显示原型的页面图片信息
 * \
 */
@Data
public class SchoolInfoImgVo {

    /**
     * 图片地址
     */
    @Column(name = "student_img_url")
    private String studentImgUrl;

    /**
     * 1,环境图:2,文化图
     */
    @Column(name = "sign")
    private Short sign;



}
