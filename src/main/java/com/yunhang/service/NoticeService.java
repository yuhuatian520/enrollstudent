package com.yunhang.service;

import com.alibaba.fastjson.JSON;
import com.yunhang.dto.NoticeDto;
import com.yunhang.entity.Notice;
import com.yunhang.entity.SchoolManage;
import com.yunhang.mapper.NoticeMapper;
import com.yunhang.mapper.SchoolManageMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangchunlu
 * @date 2019-9-28
 */
@Service
public class NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Autowired
    private SchoolManageMapper schoolManageMapper;

    /**
     * 查询所有公告信息
     */
    public List<NoticeDto> queryAllNotice() {

        //查询所有公告
        List<Notice> result = noticeMapper.selectAll();
        //生成存储公告的对象数组result1
        List<NoticeDto> result1 = new ArrayList<>();
        for (Notice notice : result) {
                //通过公告表中的学校ID查询学校信息
            SchoolManage schoolInfo = schoolManageMapper.selectByPrimaryKey(notice.getSchoolId());
                //生成存储公告的对象noticeDto
            NoticeDto noticeDto = new NoticeDto();
                //将查询到的公告信息存到noticeDto中
            BeanUtils.copyProperties(notice, noticeDto);
                //将查询到的学校名字存入到noticeDto
            noticeDto.setSchoolName(schoolInfo.getSchoolName());
                //将noticeDto存入result数组
            result1.add(noticeDto);

        }


        return result1;


    }
    /**
     * 查询公告信息ByID
     */
    public NoticeDto queryNoticeById(Notice notice) {

        //判断传入的公告ID是否为空
        if(notice.getNoticeId()!=null){
            //查询所有公告信息
            List<Notice> noticeList= noticeMapper.selectAll();
            //遍历所有公告信息
            for (Notice result:noticeList){
                    //查询所有学校信息
                    SchoolManage schoolInfo = schoolManageMapper.selectByPrimaryKey(result.getSchoolId());
                    //生成存储公告信息的对象noticeDto
                    NoticeDto noticeDto= new NoticeDto();
                    //将查到的公告信息存到noticeDto中
                    BeanUtils.copyProperties(notice, noticeDto);
                    //将查询到的学校名存到noticeDto中
                    noticeDto.setSchoolName(schoolInfo.getSchoolName());
                    return noticeDto;


            }

        }

        return null;

    }

    /**
     * 添加公告信息
     */
    public Integer addNotice(Notice notice) {
        //查询所有的学校信息
        List<SchoolManage> schoolInfo = schoolManageMapper.selectAll();

         //如果传入的schoolId不为空则插入
        if(!StringUtils.isEmpty(notice.getSchoolId())){
            SchoolManage schoolManage=schoolManageMapper.selectByPrimaryKey(notice.getSchoolId());
            //如果传入的schoolId在schoolmanage表中是否存在,存在则执行插入,不存在,则插入失败,返回0
            for (SchoolManage s:schoolInfo) {
                //判断由通知传入的学校ID所查到的学校是否存在   学校存在才执行插入  不存则则不能执行
                if(JSON.toJSONString(s).equals(JSON.toJSONString(schoolManage))){
                    return noticeMapper.insert(notice);
                }
            }
        }

        return 0;



    }

    /**
     * 更新公告信息
     */

    public Integer updateNoticeById(Notice notice) {
       List<Notice>  noticeList= noticeMapper.selectAll();
       for (Notice n:noticeList) {
           //通过条件筛选出指定ID的Notice对象并更新该对象    同时判断是否输入了公告名称
            if(n.getNoticeId()!=notice.getNoticeId()&&notice.getNoticeName()!=null)
                return noticeMapper.updateByPrimaryKeySelective(notice);
        }
            return 0;
    }

    /**
     * 删除公告信息
     */

    public Integer deleteNoticebyid(Notice notice) {
        //判断传入的公告Id是否为空且存在于公告表中
        if (notice.getNoticeId() != null) {
            Integer mark = noticeMapper.deleteByPrimaryKey(notice);
            return mark;
        }
        else
            return 0;

    }

}


