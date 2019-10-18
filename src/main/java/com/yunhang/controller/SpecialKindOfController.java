package com.yunhang.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yunhang.entity.*;
import com.yunhang.service.SchoolSpecialService;
import com.yunhang.service.SpecialKindService;
import com.yunhang.service.SpecialKindofService;
import com.yunhang.service.ThreeSpecialKindofService;
import com.yunhang.utils.JsonResult;
import com.yunhang.utils.ReturnCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 专业管理
 */
@Slf4j
@RestController
@RequestMapping("/specialkindofinfo/")
public class SpecialKindOfController {

    //一级专业数据
    @Autowired
    private SpecialKindService specialKindService;
    //二级专业数据
    @Autowired
    private SpecialKindofService specialKindofService;
    //三级专业数据
    @Autowired
    private SchoolSpecialService schoolSpecialService;
    @Autowired
    private ThreeSpecialKindofService threeSpecialKindofService;

    @GetMapping("firstspecialandsecondspecial")
    public JsonResult querySpecialFirstAndSecondInfo(SpecialKind specialKind){
        //一级菜单
        List<SpecialKind> firstSpecialInfo = specialKindService.querySpecialKindListInfo();
        for (SpecialKind sp:firstSpecialInfo
             ) {
            //循环出二级菜单
            List<SpecialKindof> specialkindofs = specialKindofService.querySpecialKindoflist(sp.getKindId());
                sp.setSpecialKindofList(specialkindofs);
        }
        return JsonResult.build(ReturnCode.okayCode,"success",firstSpecialInfo);
    }

    /**
     * 查询三级菜单数据信息
     * @param threeSpecialKindof
     * @return
     */
    @GetMapping("threespecialList")
    public JsonResult threeSpecialListInfos(ThreeSpecialKindof threeSpecialKindof,@RequestParam(required = false) Integer startPage,@RequestParam(required = false,value = "6") Integer pageSize){
        Page<ThreeSpecialKindof> info = PageHelper.startPage(startPage, pageSize);
        return JsonResult.build(ReturnCode.okayCode,"成功",schoolSpecialService.querySchoolSpecialInfoBySpecialKindOfId(threeSpecialKindof));
    }

    /**
     * 添加专业信息!
     * @param schoolSpecial
     * @return
     */
    @PostMapping("insertintospecialinfo")
    public JsonResult addSpecialInfoalls(@RequestBody SchoolSpecial schoolSpecial){
        String ss = JSON.toJSONString(schoolSpecial);
        if ("{}".trim().equals(ss)) {
            return JsonResult.errorMsg("数据为空!");
        }
        Integer mark = schoolSpecialService.addSchoolSpecialInfo(schoolSpecial);
        if (mark>0)return JsonResult.ok();
        else return JsonResult.errorMsg("添加失败!");
    }

    /**
     * 添加一级菜单信息
     * @param specialKind
     * @return
     */
    @PostMapping("insertintofirstinfo")
    public JsonResult addFirstSpecialInfo(@RequestBody SpecialKind specialKind){

        if ("{}".trim().equals(JSON.toJSONString(specialKind)))return JsonResult.errorMsg("数据为空!");
        Integer sign = specialKindService.appendFirstSpecialInfo(specialKind);
        if (sign>0)return JsonResult.ok();
        else return JsonResult.errorMsg("添加失败!");
    }
    /**
     * 添加二级菜单信息
     * @param specialKindof
     * @return
     */
    @PostMapping("insertintosecondinfo")
    public JsonResult addSecondSpecialInfo(@RequestBody SpecialKindof specialKindof){
        if ("{}".trim().equals(JSON.toJSONString(specialKindof)))return JsonResult.errorMsg("数据为空!");
        Integer sign = specialKindService.appendSecondSpecialInfo(specialKindof);
        if (sign>0)return JsonResult.ok();
        else return JsonResult.errorMsg("添加失败!");
    }

    /**
     * 添加三级菜单信息
     * @param threeSpecialKindof
     * @return
     */
    @PostMapping("insertintothreeinfo")
    public JsonResult addThreeSpecialInfo(@RequestBody ThreeSpecialKindof threeSpecialKindof){
        if ("{}".trim().equals(JSON.toJSONString(threeSpecialKindof)))return JsonResult.errorMsg("数据为空!");
        Integer sign = specialKindService.appendThreeSpecialInfo(threeSpecialKindof);
        if (sign>0)return JsonResult.ok();
        else return JsonResult.errorMsg("添加失败!");
    }

    /**
     * 根据传入参数进行删除专业信息数据
     * @param sign
     * @return
     */
    @GetMapping("deletespecialIinfo/{sign}")
    public JsonResult deleteSpecialInfos(@PathVariable("sign")  Integer sign,@RequestParam(required=false) Integer object){
        switch (sign){
            case 1:
                Integer mark = specialKindService.deletefirstSpecialInfo(object);
                if (mark>0)return JsonResult.ok();
                else return JsonResult.errorMsg("删除失败!");
            case 2:
               Integer mark2=specialKindofService.deleteSecondSpecialInfo(object);
               if (mark2>0)return JsonResult.ok();
                else return JsonResult.errorMsg("删除失败!");
            case 3:
               Integer mark3=threeSpecialKindofService.deleteThreeSpecialInfo(object);
                if (mark3>0)return JsonResult.ok();
                 else return JsonResult.errorMsg("删除失败!");
            case 4:
                Integer mark4=schoolSpecialService.deleteSchoolSpecialInfo(object);
                if (mark4>0)return JsonResult.ok();
                else return JsonResult.errorMsg("删除失败!");
            default:
                return JsonResult.errorMsg("请选择需要删除的信息");
        }

    }








}
