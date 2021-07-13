package com.hand.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 自动配置
 * RabbitAutoConfiguration
 * 有自动配置了连接工厂connectionFactory
 * RabbitProperties封装了RabbitMQ的配置
 *
 */
@SpringBootApplication
@EnableCaching
@EnableRabbit
// @MapperScan("com.hand.springbootmybatis.mapper")     //有@mapper注解就不需要扫描
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
