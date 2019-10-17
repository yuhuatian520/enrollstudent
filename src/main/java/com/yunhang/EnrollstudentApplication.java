package com.yunhang;

import com.yunhang.entity.DetectionMyself;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableTransactionManagement
@SpringBootApplication
public class EnrollstudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnrollstudentApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter () {
        CorsConfiguration cfg = new CorsConfiguration();
        cfg.addAllowedHeader("*");
        cfg.addAllowedMethod("*");
        cfg.addAllowedOrigin("*");
//		cfg.addExposedHeader("*");
        cfg.setAllowCredentials(true); // //是否发送Cookie信息
        UrlBasedCorsConfigurationSource urlcfg = new UrlBasedCorsConfigurationSource();
        urlcfg.registerCorsConfiguration("/**", cfg);

        return new CorsFilter(urlcfg);
    }
    @Bean
    public DetectionMyself createObjectInfo(){
        return new DetectionMyself();
    }



}
