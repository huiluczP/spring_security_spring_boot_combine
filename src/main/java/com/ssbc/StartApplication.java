package com.ssbc;

import com.ssbc.dao.UserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(scanBasePackages ="com.ssbc")
@MapperScan("com.ssbc.dao")
public class StartApplication {

    public static void main(String args[]){
        SpringApplication.run(StartApplication.class, args);
    }
}
