package com.yunhang.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 杨春路
 * @data 2019/10/29 14:50
 */
public class MD5Utils {

    public static String createMd5(String str){
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            //把密码转换为byte类型
            byte[] b = str.getBytes();
            //加密
            byte[] digest =md5.digest(b);
            //16进制的字符
            char[] c ={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
            //用于储存加密后的字符串
            StringBuffer sb = new StringBuffer();
            //处理为16进制的字符串
            for(byte bb:digest){
                //15的8进制是0000,1111
                sb.append(c[(bb>>4)&15]);
                sb.append(c[bb&15]);
               // System.out.println(sb.toString());
            }
            return sb.toString()+"yhjygs";
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }

}
