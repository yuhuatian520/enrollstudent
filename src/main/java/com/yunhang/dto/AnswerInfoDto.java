package com.yunhang.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/11
 * \* Time: 10:52
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
public class AnswerInfoDto {
    /**
     * 答案编号
     */
    @Id
    @Column(name = "answer_id")
    private Integer answerId;

    /**
     * 答案的内容
     */
    @Column(name = "answer_content")
    private String answerContent;

    /**
     * 关联问题编号
     */
    /*@Column(name = "question_id")
    private Integer questionId;*/


}
