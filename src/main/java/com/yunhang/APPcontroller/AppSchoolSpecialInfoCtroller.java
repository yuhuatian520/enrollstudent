package com.yunhang.APPcontroller;

import com.yunhang.dto.vo.SpecialInfoVo2;
import com.yunhang.service.SchoolSpecialService;
import com.yunhang.utils.JsonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/14
 * \* Time: 14:16
 * \* To change this template use File | Settings | File Templates.
 * \* Description:  专业信息相关数据
 * \
 */
@RestController
@RequestMapping("/specialinfo/")
public class AppSchoolSpecialInfoCtroller {

    @Resource
    private SchoolSpecialService schoolSpecialService;

    /**
     * 通过推荐的专业进行查询
     * @return
     */
    @GetMapping("queryspecialinfobyrecommond")
    public JsonResult findSpecialInfoByRecommond(){
        return JsonResult.ok(schoolSpecialService.findSpecialInfoByRecommond());
    }


    @GetMapping("queryspecialinfobyspecialid/{specialId}")
    public JsonResult findSpecialInfoBySpecialId(@PathVariable("specialId") Integer specialId){
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        if (specialId==null||specialId<0)return JsonResult.errorMsg("编号为空!");
        SpecialInfoVo2 ssList = schoolSpecialService.findSpecialInfoBySpecialId(specialId);
        ssList.setSchoolCount((int)ssList.getSchoolNames().stream().count());
        return JsonResult.ok(ssList);
    }

    /**
     * 多余的接口 后期删掉
     * @return
     */
    @GetMapping("recommendspecialinfo")
    public Mono<JsonResult> findBySchoolSpecialInfoByRecommend(){
        List slist = schoolSpecialService.findSpecialInfoByRecommonded();
        if (slist==null)return Mono.just(JsonResult.errorMsg("暂无数据"));
        return Mono.just(JsonResult.ok(slist));
    }



}
