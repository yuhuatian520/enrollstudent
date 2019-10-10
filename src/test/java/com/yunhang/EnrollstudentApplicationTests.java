package com.yunhang;

import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnrollstudentApplicationTests {

    @Test
    public void contextLoads() {
        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        /*List<School> list = ExcelImportUtil.importExcel(
                new File("D:\\ceshi\\大学传奇.xlsx"),
                School.class, params);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));*/

    }

}
