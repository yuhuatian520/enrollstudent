package com.yunhang.utils.alibabautils;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import static com.yunhang.utils.alibabautils.AliBaBaConst.iPAddressInfo;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/9/27
 * \* Time: 16:40
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \上传工具类
 */
@Slf4j
public class AliBaBaUploadUtil {

    public String uploadFileToOss(MultipartFile file) throws IOException {

        if (file != null) {
            // 判断上传图片类型是否合法
            Boolean sign = FileUtils.detectionFileInfo(file);
           if (sign){
               String originalFilename = file.getOriginalFilename();
               assert originalFilename != null;
               File newFile = new File(originalFilename);
               FileOutputStream fileInput = new FileOutputStream(newFile);
               BufferedOutputStream buffer = new BufferedOutputStream(fileInput);
               fileInput.write(file.getBytes());
               fileInput.close();
               file.transferTo(newFile);
            // 获取文件的类型
            String contentType = originalFilename.indexOf(".") != -1 ? originalFilename.substring(originalFilename.lastIndexOf(".") + 1, originalFilename.length()) : null;
            // 生成新的文件名 （取当前时间戳和六位随机数拼接成文件名）
            String newFileName =UUID.randomUUID().toString().trim().replace("-","") + "." + contentType;
               // 创建OSSClient实例。
               OSS ossClient = new OSSClientBuilder().build(AliBaBaConst.endpoint,AliBaBaConst.accessKeyId,AliBaBaConst.secretAccessKey);
               PutObjectRequest putObjectRequest = new PutObjectRequest(AliBaBaConst.bucketName, newFileName,newFile);
               ossClient.putObject(putObjectRequest);
                    // 关闭OSSClient。
               ossClient.shutdown();
               if (newFile.exists()){
                   newFile.delete();
               }else {
                   log.info("文件不存在!");
               }
               return iPAddressInfo+newFileName;
           }
        }
        return "";
    }
}


