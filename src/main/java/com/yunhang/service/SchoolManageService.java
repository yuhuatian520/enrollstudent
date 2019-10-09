package com.yunhang.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.yunhang.dto.SchoolManagerDto;
import com.yunhang.entity.SchoolManage;
import com.yunhang.entity.StudentAttentionSchool;
import com.yunhang.mapper.SchoolManageMapper;
import com.yunhang.mapper.StudentAttentionSchoolMapper;
import com.yunhang.utils.RandomNumberGenerator;
import com.yunhang.utils.alibabautils.FileUtils;
import lombok.val;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolManageService{

    @Resource
    private SchoolManageMapper schoolManageMapper;
    //学僧关注的学校
    @Resource
    private StudentAttentionSchoolMapper studentAttentionSchoolMapper;


    /**
     * 添加学校信息
     * @param schoolManage
     * @return
     */
    public Integer apendSchoolManagerInfos(SchoolManage schoolManage) {
        schoolManage.setSchoolId(Integer.valueOf(RandomNumberGenerator.generateNumber()));
        int mark = schoolManageMapper.insertSelective(schoolManage);
            if (mark>0)return 1;
            else return 0;
    }

    /**
     * 修改学校信息!
     * @return
     */
    public Integer updateShoolManagerInfo(SchoolManage schoolManage) {
        int mark = schoolManageMapper.updateByPrimaryKeySelective(schoolManage);
        if (mark>0)return 1;
        else return 0;
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public Integer deleteSchoolInfos(SchoolManage schoolManage) {
        try {
            int sign = schoolManageMapper.deleteByPrimaryKey(schoolManage);
            if (sign > 0){
                val stu = new StudentAttentionSchool();
                stu.setSchoolId(schoolManage.getSchoolId());
                studentAttentionSchoolMapper.selectAll().parallelStream()
                        .filter(s-> s.getSchoolId().equals(stu.getSchoolId()))
                        .forEach(tu->studentAttentionSchoolMapper.delete(stu));
                return 1;
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询学校的管理信息!
     * @param schoolId
     * @return
     */
    public SchoolManage querySchoolManagerInfoBySchoolId(Integer schoolId) {
        if (schoolId > 0) {
            return schoolManageMapper.selectByPrimaryKey(schoolId);
        }
        return null;
    }


    /**
     * 查询全部的数据信息
     * @return List<SchoolManage>
     */
    public List<SchoolManage> querySchoolManagerInfosByAlls() {
        return schoolManageMapper.selectAll();
    }

    /**
     * 通过学校进行模糊查询!
     * @param schoolName
     * @return
     */
    public List<SchoolManage> vagueSearchSchoolManagerInfo(String schoolName) {
        Example example = new Example(SchoolManage.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("schoolId");
        criteria.andLike("schoolName", "%"+schoolName+"%");
        List<SchoolManage> list = schoolManageMapper.selectByExample(example);
        return list;
    }

    /**
     * 根据地址查询学校部分信息!
     * @param schoolAddress
     * @return
     */
    public List<SchoolManagerDto> querySchoolManagerInfosBySchoolAddress(String schoolAddress) {
        List<SchoolManagerDto> list2 = new ArrayList<>();
        Example example = new Example(SchoolManage.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("schoolId");
        criteria.andLike("schoolAddress","%"+schoolAddress+"%");
        List<SchoolManage> list = schoolManageMapper.selectByExample(example);

        for (SchoolManage schoolManage : list) {
            SchoolManagerDto schoolManageDto = new SchoolManagerDto();
            schoolManageDto.setSchoolId(schoolManage.getSchoolId());
            schoolManageDto.setSchoolName(schoolManage.getSchoolName());
            schoolManageDto.setSchoolPresentation(schoolManage.getSchoolPresentation());
            BeanUtils.copyProperties(schoolManage,schoolManageDto);
            list2.add(schoolManageDto);
        }
        return list2;
    }

        /**
         * 文件导入操作!
         * @param file
         * @return 0,1 成功与否!
         */
        public Integer readExcelInfo(MultipartFile file) throws Exception {
            System.out.println("我看看文件:"+file);
            Boolean mark = FileUtils.checkExcelFileInfo(file);
            System.out.println("读取通过吗:"+mark);
            if (mark){
                val params=new ImportParams();
                params.setTitleRows(1);
                params.setHeadRows(1);
                //org.apache.commons.io.FileUtils.copyInputStreamToFile(excelFile.getInputStream(), new File(Objects.requireNonNull(excelFile.getOriginalFilename())));
                InputStream inpt = file.getInputStream();
                File newFile = new File(file.getOriginalFilename());
                file.transferTo(newFile);
                List<SchoolManage> list = ExcelImportUtil.importExcel((File) file,SchoolManage.class,params);
                System.out.println("我看看list:"+list);
                System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
                return 1;
            }
            return 0;
        }



}
