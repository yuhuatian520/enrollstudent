package com.yunhang.APPcontroller;

import com.yunhang.entity.AspirationInfo;
import com.yunhang.service.AspirationInfoService;
import com.yunhang.utils.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/12
 * \* Time: 18:00
 * \* To change this template use File | Settings | File Templates.
 * \* Description:  自我检测下面的个人分析情况
 * \
 */
@RestController
@RequestMapping("/aspirationinfo/")
public class AppAspirationInfoCtroller {

    @Resource
    private AspirationInfoService aspirationInfoService;

    /**
     * 自我分析下面的类型的数据添加!
     * @return
     */
    @PostMapping("addaspirationinfo")
    public JsonResult appendAspirationInfos(@RequestBody AspirationInfo aspirationInfo){
        aspirationInfoService.addAspirationInfos(aspirationInfo);
    return null;

    }




}
