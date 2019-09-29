package com.yunhang.utils.alibabautils;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

import static com.yunhang.utils.alibabautils.AliBaBaConst.bucketName;
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

    public Serializable uploadFileToOss(MultipartFile file) throws IOException {
        OSSClient client=new OSSClient(AliBaBaConst.endpoint,AliBaBaConst.accessKeyId,AliBaBaConst.secretAccessKey);


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
               try {
                   String fileUrl = "";

                   // 判断容器是否存在,不存在就创建
                   if (!client.doesBucketExist(bucketName)) {
                       client.createBucket(bucketName);
                       CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                       createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                       client.createBucket(createBucketRequest);
                   }
                   // 设置文件路径和名称
                   //fileUrl = fileHost + (UUIDUtils.getUuid32() + file.getName().substring(file.getName().lastIndexOf("."),file.getName().length()));
                   // 上传文件
                   PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, newFileName,new FileInputStream(new File(originalFilename))));
                   System.out.println("kankan-"+result);
                   // 设置权限(公开读)
                   client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
                   if (result != null) {
                       log.info("------OSS文件上传成功------" + fileUrl);
                   }
               }catch (OSSException oe){
                   log.error(oe.getMessage());
               }catch (ClientException ce){
                   log.error(ce.getErrorMessage());
               }finally{
                   client.shutdown();
               }
               return iPAddressInfo+newFileName;
           }
        }
        return "";
    }
}


