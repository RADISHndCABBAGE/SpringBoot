package com.kfit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kfit.config.datasource.dynamic.DynamicDataSourceRegister;
/*
 * spring boot 启动类
 * */

@SpringBootApplication
//注册动态数据源
@Import({DynamicDataSourceRegister.class})
public class App {
	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}