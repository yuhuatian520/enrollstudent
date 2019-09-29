package com.yunhang.utils;

/**
 * @author 耀哥
 * @version 1.0
 * @date 2019/9/23 11:21
 * 返回数据类型的code值
 */
public interface ReturnCode {

    //数据传输有误
    Integer dataError=303;
    //参数传输错误
    Integer paramError=304;
    //对象为空
    Integer objectNull=305;

    Integer okayCode=200;


}
