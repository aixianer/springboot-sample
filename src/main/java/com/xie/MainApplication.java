package com.xie;

import com.xie.config.RedisUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.xie.mapper")
public class MainApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private RedisUtil redisUtil;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        redisUtil.set("key1", "xxx");
        System.out.println();
    }
}