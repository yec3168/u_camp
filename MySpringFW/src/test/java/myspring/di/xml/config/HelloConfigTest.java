package myspring.di.xml.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = HelloConfig.class)
public class HelloConfigTest {
	
	@Autowired
	Hello hello;
	
	@Autowired
	
	// HelloConfig의 정의된 메소드 명을 적어주면 메소드명을 id값으로 인식하여 가져옴.
	@Qualifier("strPritner") 
	Printer printer;
	
	@Test
	void helloConfig() {
		
		assertEquals("Hello JAVA CONFIG", hello.sayHello());
		
		hello.print();
		
		assertEquals("Hello JAVA CONFIG", printer.toString());
	}
}
