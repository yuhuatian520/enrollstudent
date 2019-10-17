package com.yunhang.utils.design;


import lombok.val;
import org.apache.poi.ss.formula.functions.T;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/12
 * \* Time: 9:27
 * \* To change this template use File | Settings | File Templates.
 * \* Description:单例模式
 * \
 */
public class SingletonUtil {

    /**
     * 自定义单身狗模式
     * @param t
     * @return
     */
    public static Object  createObjectInfo(Object t){
           final  val tt=new T();
        return tt;
    }







}
