package com.ucamp.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MySpringBootApplication {

	// Application 자체가 Configuration 클래스로서의 역할을 한다.
	public static void main(String[] args) {
		//기존코드
		//SpringApplication.run(MySpringBootApplication.class, args);
		
		
		SpringApplication springApplication = new SpringApplication(MySpringBootApplication.class);
		
		// application 타입 변경
		// Servlet이 default 값.
		springApplication.setWebApplicationType(WebApplicationType.SERVLET);

		// NONE을 설정하면 dataBase connect만 하고 web Application이 아니기 때문에 종료함.
//		springApplication.setWebApplicationType(WebApplicationType.NONE);
		
		springApplication.run(args);
	}

	@Bean
	public String hello(){
		return "Hello Springboot";
	}
}
