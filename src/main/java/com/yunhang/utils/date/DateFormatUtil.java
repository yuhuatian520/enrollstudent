package com.yunhang.utils.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/14
 * \* Time: 11:47
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public final class DateFormatUtil {
    /**
     * 返回当前时间的字符串形式
     * @return
     */
    public static String createDateAndTime(){
       return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }

}
