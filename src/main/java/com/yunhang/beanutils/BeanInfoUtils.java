package com.yunhang.beanutils;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.yunhang.dto.TrainingInfoDto;
import com.yunhang.dto.schoolview.SchoolAndSpecialPlan;
import com.yunhang.dto.schoolview.SchoolInfoVo;
import com.yunhang.dto.vo.SpecialInfoPlanVo;
import com.yunhang.entity.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/12
 * \* Time: 13:50
 * \* To change this template use File | Settings | File Templates.
 * \* Description:创建对象的工具包
 * \
 */

@Component
public class BeanInfoUtils {

    @Bean
    public TrainingInfo createTrainingInfo(){
        return new TrainingInfo();
    }

    @Bean
    public TrainingInfoDto createTrainingInfoDto(){
        return new TrainingInfoDto();
    }

    @Bean
    public ProfessionalInfo createProFessional(){
        return new ProfessionalInfo();
    }

    @Bean
    public SchoolManage createManager(){
        return new SchoolManage();
    }

    @Bean
    public SchoolManagerImg createManagerImg(){
        return new SchoolManagerImg();
    }

    @Bean
    public SchoolInfoVo createSchoolInfoVo(){
        return new SchoolInfoVo();
    }
    @Bean
    public SpecialInfoPlanVo createSpecialInfoPlanVo(){
        return new SpecialInfoPlanVo();
    }

    @Bean
    public SchoolAndSpecialPlan createSchoolAndSpecialPlan(){
        return new SchoolAndSpecialPlan();
    }

    @Bean
    public SchoolinfoAndSpecialinfo createSchoolinfoAndSpecialinfo(){
        return new SchoolinfoAndSpecialinfo();
    }

    @Bean
    public ServletRegistrationBean DruidStatViewServle2() {
        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //添加初始化参数：initParams

        //白名单：
        servletRegistrationBean.addInitParameter("allow","192.168.1.149");
        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
        // servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
        //登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


}
