package com.yunhang.service;

import com.yunhang.dto.NoticeDto;
import com.yunhang.entity.Notice;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.yunhang.mapper.NoticeMapper;
import org.springframework.util.StringUtils;

@Service
public class NoticeService {

    @Resource
    private NoticeMapper noticeMapper;


    public NoticeDto queryNoticeByNoticeId(Notice notice) {
        if (StringUtils.isEmpty(notice.getNoticeId())) return null;
        else {
            Notice reult = noticeMapper.addNotice(notice);
            NoticeDto noticeDto = new NoticeDto();
            BeanUtils.copyProperties(reult, noticeDto);
            return noticeDto;
        }

    }


}


