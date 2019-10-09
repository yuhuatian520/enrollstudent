package com.yunhang.APPcontroller;

import com.yunhang.entity.SchoolManagerImg;
import com.yunhang.service.SchoolManagerImgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
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
 * \* Description:
 * \
 */

@Slf4j
@RestController
@RequestMapping("/appschoolinfos/")
public class AppSchoolController {

    @Resource
    private SchoolManagerImgService schoolManagerImgService;

    /**
     * 根据学校的编号来查询学校的图片信息
     * @return
     */
    @GetMapping(value = "findschoolimgsbysign/{schoolId}/{sign}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SchoolManagerImg> querySchoolInfo2SchoolImgsBySign(@PathVariable("schoolId") Integer schoolId, @PathVariable("sign") Short sign){
        List<SchoolManagerImg> s = schoolManagerImgService.findSchoolInfoImgBySchoolIdAndSign(schoolId, sign);
        Flux<SchoolManagerImg> ss = Mono.just(s).flatMapMany(Flux::fromIterable);
        return ss;
    }


}
