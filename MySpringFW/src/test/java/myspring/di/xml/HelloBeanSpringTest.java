package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//extendsion을 통해 확장 함.
//SpringExtension 클래스를 지정해 주면 jUnit이 테스트를 진행하는 중에 ApplicationContext를 만들고 관리하는 작업을 진행
@ExtendWith(SpringExtension.class) 

//스프링 빈(Bean) 설정 파일의 위치를 지정할 때 사용되는 어노테이션이다. ( ApplicationContext에 xml 파일을 넣는 것과 동일.)
@ContextConfiguration(locations = "classpath:spring_di.xml")
public class HelloBeanSpringTest {
	@Autowired
	Hello hello; // 값을 지정안 했을 때. // 변수명과 아이디가 일치하는 bean을 먼저 매핑.
	
	@Autowired
	@Qualifier("hello2") // 직접 지정시킴.
	Hello hello2;
	
	@Resource(name= "hello2")
	Hello hello3;
	
	@Test
	void autowiredTest() {
		System.out.println(hello.sayHello());  // hello : 스프링
		
		
		System.out.println(hello2.sayHello()); // hello: 생성자.
		
		
		System.out.println(hello3.sayHello()); // hello : 생성자
		
		//-----------------------------------------------------------------
		
		assertEquals("Hello 생성자", hello2.sayHello());
		assertEquals("Hello 생성자", hello3.sayHello());
		
		hello2.print();
	}
	
	
	
}
