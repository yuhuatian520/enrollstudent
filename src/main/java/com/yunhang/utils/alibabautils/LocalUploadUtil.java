package com.yunhang.utils.alibabautils;

import lombok.extern.flogger.Flogger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author 杨春路
 * @data 2019/10/16 11:59
 */
@Slf4j
public class LocalUploadUtil {



    public String uploadFilesToLacal(MultipartFile file){
        if (file.isEmpty()){
            return "上传文件失败,请选择文件!";
        }
        String filename = file.getOriginalFilename();

        String filepath="D://uploadTest/";
        File dest=new File(filepath+filename);
        try {
            file.transferTo(dest);
            return "上传成功";

        } catch (IOException e) {

            e.printStackTrace();
        }

        return "上传失败!";

    }
}
