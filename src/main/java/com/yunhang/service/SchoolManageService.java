package com.yunhang.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.yunhang.dto.SchoolManagerDto;
import com.yunhang.entity.*;
import com.yunhang.mapper.*;
import com.yunhang.utils.RandomNumberGenerator;
import com.yunhang.utils.alibabautils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class SchoolManageService{

    @Resource
    private SchoolManageMapper schoolManageMapper;
    //学僧关注的学校
    @Resource
    private StudentAttentionSchoolMapper studentAttentionSchoolMapper;

    @Resource
    private SpecialKindMapper specialKindMapper;

    @Resource
    private SpecialKindofMapper specialKindofMapper;
    @Resource
    private ThreeSpecialKindofMapper threeSpecialKindofMapper;
    @Resource
    private SchoolSpecialMapper schoolSpecialMapper;


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
         * 文件导入操作! 导入学校!
         * @param file
         * @return 0,1 成功与否!
         */
        public String readExcelInfo(MultipartFile file) throws Exception {
            if (FileUtils.checkExcelFileInfo(file)) {
                val params = new ImportParams();
                params.setTitleRows(0);
                params.setHeadRows(1);
                List<SchoolManage> list = ExcelImportUtil.importExcel(file.getInputStream(),
                        SchoolManage.class, params);
                CompletableFuture.runAsync(()->list.parallelStream().forEach(schoolManage -> {
                    schoolManageMapper.insertSelective(schoolManage);
                }));
                return "导入成功";
            }
            return "文件不合法";
        }

    /**
     * 文件导入操作! 导入!专业!
     * @param file
     * @return 0,1 成功与否!
     */
    public String readExcelInfoSpecialInfo(MultipartFile file,Integer sign) throws Exception {
        return importExcel(file,sign);
    }

    private String importExcel(MultipartFile file,Integer sign) throws Exception {
        if (FileUtils.checkExcelFileInfo(file)) {
            switch (sign) {
                case 1:
                   var ss=setImportParams();
                    List<SpecialKind> list = ExcelImportUtil.importExcel(file.getInputStream(),
                            SpecialKind.class, ss);
                    CompletableFuture.runAsync(()->list.parallelStream().forEach(schoolManage -> {
                        specialKindMapper.insertSelective(schoolManage);
                    }));
                    return "导入成功";
                case 2:
                    var ss2=setImportParams();
                    List<SpecialKindof> list2 = ExcelImportUtil.importExcel(file.getInputStream(),
                            SpecialKindof.class, ss2);
                    CompletableFuture.runAsync(()->list2.parallelStream().forEach(schoolManage -> {
                        specialKindofMapper.insertSelective(schoolManage);
                    }));
                    return "导入成功";

                case 3:
                    var ss3=setImportParams();
                    List<ThreeSpecialKindof> list3 = ExcelImportUtil.importExcel(file.getInputStream(),
                            ThreeSpecialKindof.class, ss3);
                    CompletableFuture.runAsync(()->list3.parallelStream().forEach(schoolManage -> {
                        threeSpecialKindofMapper.insertSelective(schoolManage);
                    }));
                    return "导入成功";
                case 4:
                    var ss4=setImportParams();
                    List<SchoolSpecial> list4 = ExcelImportUtil.importExcel(file.getInputStream(),
                            SchoolSpecial.class, ss4);
                    CompletableFuture.runAsync(()->list4.parallelStream().forEach(schoolManage -> {
                        schoolSpecialMapper.insertSelective(schoolManage);
                    }));
                    return "导入成功";

                default:
                    return "导入失败!";
            }

        }
        return "文件不合法";
    }

    private  ImportParams setImportParams(){
        val params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        return params;
    }





}

