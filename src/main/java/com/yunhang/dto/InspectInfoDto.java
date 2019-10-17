package com.yunhang.dto;

import com.google.common.collect.Multiset;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/11
 * \* Time: 10:47
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 显示问题和答案
 * \
 */
@Data
public class InspectInfoDto {
    /**
     * 问题编号
     */
    @Id
    @Column(name = "question_id")
    private Integer questionId;

    /**
     * 问题标题
     */
    @Column(name = "question_name")
    private String questionName;

    /**
     * 答案内容
     */
    //@Column(name = "answer_content")
   // private String answerContent;

    /**
     * 答题时间
     */
    //@JSONField(format="yyyy-MM-dd HH:mm:ss")
    //@Column(name = "create_time")
    //private Date createTime;

    /**
     * 学生作答
     */
   // @Column(name = "student_id")
   // private Integer studentId;

    /**
     * 答案编号(主要作为答案查询)
     */
    //@Column(name = "answer_id")
   // private Integer answerId;


    /**
     * 答案的列表
     */
    private Multiset<AnswerInfoDto> answerInfoDtos;




}
