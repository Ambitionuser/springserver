package com.it.articleservice;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = "com.it.articleservice.service")
@EnableSwagger2Doc
public class ArticleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }

}
