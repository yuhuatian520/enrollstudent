package com.yunhang;

import cn.afterturn.easypoi.excel.entity.ImportParams;
import lombok.val;
import lombok.var;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnrollstudentApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

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

    @Test
    public void saveReids() throws InterruptedException, IOException {
        //redisTemplate.opsForValue().set("user","admin",20, TimeUnit.SECONDS);
        //睡下20秒
        //Thread.sleep(20*1000);
        //System.out.println(redisTemplate.opsForValue().get("user"));
       var url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1572873930735&di=7564dc149e339b33655afcc60a356bcd&imgtype=0&src=http%3A%2F%2Fcdn0.hbimg.cn%2Fstore%2Fwm%2Fbigfiles%2F201346%2FD525DAEC9AB6E5D6C7A1B891.jpg";
      val file=new File("E:/img/小姑娘.jpg");

       FileUtils.copyURLToFile(new URL(url),file);

    }





}
