package com.yunhang.dto.vo;

import com.yunhang.entity.ProfessionalInfo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/14
 * \* Time: 15:11
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
public class SpecialInfoVo2 {
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

    /**
     * 专业介绍
     */
    @Column(name = "special_presentation")
    private String specialPresentation;

    /**
     * 男女比例
     */
    @Column(name = "special_ratio_sex")
    private String specialRatioSex;

    /**
     * 文理比例
     */
    @Column(name = "special_ratio_type")
    private String specialRatioType;

    /**
     * 对口的职业列别
     */
    private List<ProfessionalInfo> professionalInfos;

    //相关的院校
    private List schoolNames;
    //统计学校的数量
    private Integer schoolCount;

}
