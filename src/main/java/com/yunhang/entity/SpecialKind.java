package com.yunhang.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

@Data
@Table(name = "special_kind")
public class SpecialKind {
    /**
     * 专业种类编号
     */
    @Excel(name = "序号")
    @Column(name = "kind_id")
    private Integer kindId;

    /**
     * 专业种类名称
     */
    @Excel(name = "名称")
    @Column(name = "kind_name")
    private String kindName;

    /**
     * 专业种类下的编号
     */
    @Column(name = "special_kind_id")
    private Integer specialKindId;
    /**
     * 存放二级菜单数据信息
     */
    private List<SpecialKindof> specialKindofList;






}