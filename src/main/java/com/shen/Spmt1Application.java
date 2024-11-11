package com.shen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shen.mapper")
public class Spmt1Application {

    public static void main(String[] args) {
        SpringApplication.run(Spmt1Application.class, args);
    }

}
