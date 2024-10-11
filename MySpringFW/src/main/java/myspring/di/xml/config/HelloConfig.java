package myspring.di.xml.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import myspring.di.xml.ConsolePrinter;
import myspring.di.xml.Hello;
import myspring.di.xml.Printer;
import myspring.di.xml.StringPrinter;

// 클래스를 bean에 정의하여 사용하는 설정.
// xml 대신 사용.
// @ComponentScan이랑 다른점은 내부적으로 커스텀할 수 있는 객체들을 생성하는 메소드를 생성.
@Configuration
@PropertySource(value = "classpath:values.properties")
public class HelloConfig {
	@Autowired
	Environment environment;
	
	
	// xml에 bean처럼 객체를 생성하여 사용한다.
	// 개발자가 커스텀하여 객체를 생성하는 것.
	// xml로 선언한는 것보다 직관적으로 볼 수 있음.
	@Bean				
	public Printer strPritner() {
		return new StringPrinter();
	}
	
	@Bean// 메소드에 정의함.		// @Component : 클래스에 정의함.
	public Printer conPriter() {
		return new ConsolePrinter();
	}
	
	@Bean // Alt + Shift + l 객체 자동생성
	public Hello hello() {
		Hello hello = new Hello();
		hello.setName("${mynameConfig}");
		hello.setName(environment.getProperty("mynameConfig"));
		hello.setPrinter(strPritner());
		return hello;
	}
	
}
