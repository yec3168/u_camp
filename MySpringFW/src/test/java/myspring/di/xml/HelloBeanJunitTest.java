package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {
	
	ApplicationContext container;
	
	// @Test가 실행되기 전에 반드시 실행되는 어노테이션.
	@BeforeEach
	void init() {
		container = new GenericXmlApplicationContext("classpath:spring_di.xml");
	}
	
	@Test
	void helloBeanTest() {
		System.out.println("helloBeanTest메소드 실행 -------------->");
		
		//1. Container Object 생성.
		//인터페이스임.
		//인자값으로 `xml`리소스 파일 위치를 설정하면 해당 bean이 실행된다.
		//즉, 객체가 생성됨.
		// 개발자가 직접 객체를 생성하는 것이 아닌 ApplicationContext에서 객체를 직접 생성해서 SingleTon으로 관리가 됨.
		
//		ApplicationContext container = new GenericXmlApplicationContext("classpath:spring_di.xml");
		
		
		//2. Container에게 SpirngBean요청하기
		//bean태그에 있는 id값과 똑같이 적어줘야함.
		Hello hello1 = (Hello)container.getBean("hello");
		Hello hello2 = container.getBean("hello", Hello.class);
		System.out.println(hello1 == hello2); // 싱글톤이기 때문에 서로 주소가 같음. 하나의 인스턴스를 사용하는 것.
		
		// SpringBean의 주소 비교 - assertBean(a, b);
		// Junit에서 결과가 파란색으로 나오면 true, 빨간색 나오면 false;
		Assertions.assertSame(hello1, hello2);
//		Assertions.assertNotSame(hello1, hello2);
		
		// setName과 setter injection 체크.
		Assertions.assertEquals("Hello 스프링", hello1.sayHello()); 
		
		// setPrinter의 setter injection 체크.
		hello1.print();
		
		
		
		//3. bean교체로 인한 SpringPrinter getBean으로 호출.
		Printer printer1 =container.getBean("stringPrinter", Printer.class); // StringPrinter가 상속받는 부모클래스인 Printer로도 가능.
		StringPrinter stringPrinter = container.getBean("stringPrinter", StringPrinter.class);
		assertEquals("Hello 스프링", printer1.toString());
		
	}
}
