package com.wjl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *
 * @author wangjialun
 * @date 2019/1/14
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.wjl.demo.*.dao"})
public class LearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnApplication.class, args);
	}

}

