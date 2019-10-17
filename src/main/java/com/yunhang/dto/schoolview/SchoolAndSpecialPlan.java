package com.yunhang.dto.schoolview;

import com.yunhang.dto.vo.SpecialInfoPlanVo;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/15
 * \* Time: 14:43
 * \* To change this template use File | Settings | File Templates.
 * \* Description:显示学校的招生计划数据信息
 * \
 */
@Data
public class SchoolAndSpecialPlan {

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
    /**
     * 学校里面专业计划招生数目
     */
    private List<SpecialInfoPlanVo> schoolspecialplanpeoples;



}
