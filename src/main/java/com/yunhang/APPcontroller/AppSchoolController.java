package com.yunhang.APPcontroller;

import com.yunhang.dto.vo.SchoolManagerRecommendVo;
import com.yunhang.entity.SchoolManagerImg;
import com.yunhang.service.SchoolManageService;
import com.yunhang.service.SchoolManagerImgService;
import com.yunhang.service.SchoolSpecialService;
import com.yunhang.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/8
 * \* Time: 11:07
 * \* To change this template use File | Settings | File Templates.
 * \* Description:  学校的相关处理信息数据
 * \
 */

@Slf4j
@RestController
@RequestMapping("/appschoolinfos/")
public class AppSchoolController {

    @Autowired
    private SchoolManagerImgService schoolManagerImgService;
    @Resource
    private SchoolSpecialService schoolSpecialService;
    @Resource
    private SchoolManageService schoolManageService;

    /**
     * 根据学校的编号来查询学校的图片信息   sign :1 环境图  2:文化图
     * @return
     */
    @GetMapping(value = "findschoolimgsbysign/{schoolId}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SchoolManagerImg> querySchoolInfo2SchoolImgsBySign(@PathVariable("schoolId") Integer schoolId){
        List<SchoolManagerImg> s = schoolManagerImgService.findSchoolInfoImgBySchoolIdAndSign(schoolId);
        Flux<SchoolManagerImg> ss = Mono.just(s).flatMapMany(Flux::fromIterable);
        return ss;
    }


    /**
     * 查询学校的信息数据 通过id来   sign  是什么样子的图片
     * @return
     */ @GetMapping("queryschoolbyid/{schoolId}")
    public JsonResult findSchoolManagerInfoByStudentId(@PathVariable("schoolId") Integer schoolId){
        if (schoolId==null||schoolId<0)return JsonResult.errorMsg("ID不能为空!");
        return JsonResult.ok(schoolManagerImgService.findSchoolInfoBySchoolId(schoolId));
    }

    /**
     * 查询学校的招生计划
     * @param schoolName
     * @return
     */
    @GetMapping("queryschoolstudentplan")
    public JsonResult findSchoolManageInfo(String schoolName){
         if (StringUtils.isEmpty(schoolName.trim()))return JsonResult.errorMsg("名称不能为空!");
         else return JsonResult.ok(schoolManagerImgService.findSchoolInfoPlanBySchoolName(schoolName));
    }

    @GetMapping("queryschoolspecialinfo/{schoolId}")
    public JsonResult findSchoolManagerInfoSpecialInfos(@PathVariable("schoolId") Integer schoolId){
        return JsonResult.ok(schoolManagerImgService.findSchoolSpecialInfos(schoolId));
    }

    /**
     * 通过推荐查询院校信息和专业
     * @return
     */
    @GetMapping("recommendschoolinfo/{sign}")
    public JsonResult findSchoolManagerInfoByRecommend(@PathVariable("sign") Integer sign) {
        List<SchoolManagerRecommendVo> recommendSchool = schoolManageService.findSchoolManagerByRecommend(sign);
        if (recommendSchool==null)return JsonResult.errorMsg("暂时无推荐");
       return JsonResult.ok(recommendSchool);
    }

    /**
     * 查询学校信息和地址
     * @param
     * @return
     */
    @GetMapping("findschooladdress")
    public Mono<JsonResult> querySchoolInfoAddress(){
        List slist = schoolManageService.findSchoolManageAddressInfos();
        if (slist==null)return Mono.just(JsonResult.errorMsg("暂时无数据"));
       return   Mono.just(JsonResult.ok(slist));
    }







}
