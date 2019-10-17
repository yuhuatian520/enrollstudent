package com.yunhang.utils.alibabautils;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/9/27
 * \* Time: 16:45
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 检测文件是否在里面或者合法性!
 * \
 */
@Slf4j
public class FileUtils {
    /**
     * 检测文件是否合法!
     * @param fileType
     * @return
     */
    public static Boolean detectionFileInfo(MultipartFile fileType){
        List<String> imgArray = Arrays.asList("bmp", "dib", "emf", "gif", "icb", "ico", "jpg", "jpeg", "pbm", "pgm", "png");
        String ss = fileType.getContentType().substring(fileType.getContentType().lastIndexOf("/")+1);
        for (String s : imgArray) {
            if (s.equals(ss))return true;
        }
        return false;
    }

    /**
     * 检测文件是否合法!
     * @param file
     * @return Boolean
     */
    public static Boolean checkExcelFileInfo(MultipartFile file){
        //定义文件类型
        val as = Arrays.asList("xls", "xlsx");
        //获取文件名称的后缀
        val suffixName=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1).toLowerCase();
        for (String a : as) {
            if (a.equals(suffixName))return true;
        }
         return false;
    }




}
