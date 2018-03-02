package net.lainiao.myqq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.lainiao.myqq.dao")
public class MyqqApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(MyqqApplication.class);
		springApplication.addListeners(new ApplicationStartup());
		springApplication.run(args);
	}
}
