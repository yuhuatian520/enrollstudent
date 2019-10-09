package com.yunhang.controller;

import com.yunhang.service.SchoolManageService;
import com.yunhang.utils.JsonResult;
import com.yunhang.utils.alibabautils.AliBaBaUploadUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/9/28
 * \* Time: 9:32
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \文件上传
 */

@RestController
public class TestController {

    private final AliBaBaUploadUtil aliBaBaUploadUtil=new AliBaBaUploadUtil();

    @Resource
    private SchoolManageService schoolManageService;

    /**
     * 单文件上传
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadfileinfo")
    public JsonResult uploadFileInfoToAliOss(MultipartFile file) throws IOException {
        return JsonResult.ok(aliBaBaUploadUtil.uploadFileToOss(file));
    }

    /**
     * 多文件上传
     * @param files
     * @return
     * @throws IOException
     */
    @PostMapping("/uploadfileinfofiles")
    public List uploadFileInfoToAliOssAlls(List<MultipartFile> files) throws IOException {
      return   files.parallelStream().map(s-> {
                  try {
                      return JsonResult.ok(aliBaBaUploadUtil.uploadFileToOss(s));
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
                  return null;
              }
      ).collect(Collectors.toList());
    }

    /**
     * Excel文件导入操作!
     * @param file
     * @return
     */
    @PostMapping("importexcels")
    public JsonResult importExcelInfos(MultipartFile file) throws Exception {
       Integer mark=schoolManageService.readExcelInfo(file);
       if(mark>0)return JsonResult.ok();
       else return JsonResult.errorMsg("导入失败,请检查文件是否合法!");
    }




}
