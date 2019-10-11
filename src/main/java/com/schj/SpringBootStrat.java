package com.schj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
public class SpringBootStrat {
	
	
	@RequestMapping("/say")
	public String Hello(){
		return "Hello!";
	}
	
	//项目启动主类
	public static void main(String [] args){
        SpringApplication.run(SpringBootStrat.class);

    }
}
