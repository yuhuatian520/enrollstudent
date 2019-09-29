package com.yunhang.mapper;

import com.yunhang.entity.Notice;
import tk.mybatis.mapper.common.Mapper;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/9/26
 * \* Time: 16:36
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@org.apache.ibatis.annotations.Mapper
public interface NoticeMapper extends Mapper<Notice> {
    Notice addNotice(Notice notice);
}
