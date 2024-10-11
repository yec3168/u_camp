package myspring.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_di.xml")
public class HelloBeanSpringTest {

	@Autowired
	HelloBean helloBean;
	
	@Resource(name = "springPrinter")
	PrinterBean printerBean;
	
	@Autowired
	HelloBeanCons helloBeanCons;
	
	@Test
	void constructTest() {
		System.out.println(helloBeanCons.sayHello());
		//assertEquals("Hello 어노테이션생성자", helloBeanCons.sayHello());
	}
	
	
	@Test
//	@Disabled
	void helloBeanTest() {
		assertEquals("Hello 어노테이션", helloBean.sayHello());
		
		System.out.println(helloBean.name);
		assertEquals("어노테이션", helloBean.name);
		
		
		
		helloBean.print(); // Hello 어노테이션
		System.out.println(printerBean.toString());
		assertEquals("Hello 어노테이션", printerBean.toString());
	}
	
}
