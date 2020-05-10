package com.houkai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 如果配置文件不配置用户名密码,登录默认用户名为user,密码为自动生成的一串字符
 * 优先配置文件配置
 */
@SpringBootApplication
public class Csrf1Application {

    public static void main(String[] args) {
        SpringApplication.run(Csrf1Application.class, args);
    }

}
