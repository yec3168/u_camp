package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// 패키지 내부 @Component 클래스에서 ${}를 쓰게 되면 Configuration을 정의한 Config클래스에 PropertySource를 정의해줘야 한다.
@PropertySource(value = "classpath:values.properties")

// 설정 역할을 하는 클래스
@Configuration

// package를 설정하면, 해당 패키지 안에 정의된 클래스중 @Component가 붙으면 xml처럼 만들어주는 설정.
@ComponentScan(basePackages = {"myspring.di.annot"})
public class HelloBeanConfig {
	
	// Qualifier를 안하면 메소드명이 bean의 id값.

}
