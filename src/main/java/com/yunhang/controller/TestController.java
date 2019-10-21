package com.yunhang.controller;

import com.yunhang.service.SchoolImgTaginfoService;
import com.yunhang.service.SchoolManageService;
import com.yunhang.utils.JsonResult;
import com.yunhang.utils.alibabautils.AliBaBaUploadUtil;
import com.yunhang.utils.apiyun.ApiMessage;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
                      return aliBaBaUploadUtil.uploadFileToOss(s);
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
    @PostMapping("/importexcels")
    public JsonResult importExcelInfos(@RequestParam("file") MultipartFile file) throws Exception {
       String mark=schoolManageService.readExcelInfo(file);
       return JsonResult.ok(mark);
    }

    /**
     * 上传专业的Excel文档功能逻辑
     * @param file
     * @param sign
     * @return
     * @throws Exception
     */
    @PostMapping("/importexcelspecial")
    public String importExcelSpecialInfo(@RequestParam("file")MultipartFile file,Integer sign) throws Exception {
        return schoolManageService.readExcelInfoSpecialInfo(file, sign);
    }

    @Resource
    private SchoolImgTaginfoService schoolImgTaginfoService;
    @GetMapping("/taginfo")
    public Object findTagInfo(){
        return schoolImgTaginfoService.findAll();
    }


    /**
     * 发送短信
     * @return
     */
    @PostMapping("/sendmessageinfo")
    public JsonResult sendInforMations(){


        return null;
    }


    public static void main(String[] args) {
        /*//初始化clnt,使用单例方式
        YunpianClient clnt = new YunpianClient(ApiMessage.apikey).init();
        //发送短信API
        Map<String, String> param = clnt.newParam(2);
        param.put(YunpianClient.MOBILE, "15934727334");
        param.put(YunpianClient.TEXT, "【云片网】您的验证码是1234");
        Result<SmsSingleSend> r = clnt.sms().single_send(param);
        //获取返回结果，返回码:r.getCode(),返回码描述:r.getMsg(),API结果:r.getData(),其他说明:r.getDetail(),调用异常:r.getThrowable()
        //账户:clnt.user().* 签名:clnt.sign().* 模版:clnt.tpl().* 短信:clnt.sms().* 语音:clnt.voice().* 流量:clnt.flow().* 隐私通话:clnt.call().*
        //释放clnt
        //clnt.close();*/
        String text = "【云航科技】4321(4321手机验证码，请完成验证)，如非本人操作，请忽略本短信";

        Map< String, String > params = new HashMap< String, String >();
        params.put("apikey", ApiMessage.apikey);
        params.put("text", text);
        params.put("mobile", "18268336166");
         post("https://sms.yunpian.com/v2/sms/single_send.json", params);

    }

    public static String post(String url, Map < String, String > paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List < NameValuePair > paramList = new ArrayList<
                                        NameValuePair >();
                for (Map.Entry < String, String > param: paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(),
                            param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList,
                        "UTF-8"));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }



}
