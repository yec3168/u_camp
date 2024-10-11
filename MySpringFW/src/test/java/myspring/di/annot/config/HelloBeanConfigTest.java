package myspring.di.annot.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.HelloBean;
import myspring.di.annot.HelloBeanCons;

@ExtendWith(SpringExtension.class)

// @configuration을 위한 컴테이너 객체는 AnnotationConfigApplicationContenxt
// 변경된 컨테이너객체를 로드해주는 역할을 하는 AnnotationConfigContextLoader 클래스를 추가.
@ContextConfiguration(classes = HelloBeanConfig.class, loader = AnnotationConfigContextLoader.class)
public class HelloBeanConfigTest {

	@Autowired
	HelloBean helloBean;
	
	@Autowired
	HelloBeanCons helloBeanCons;
	
	@Test
	void helloConfig() {
		assertEquals("Hello 어노테이션", helloBean.sayHello());
	}
	
	@Test
	void helloBeanConfig() {
		System.out.println(helloBeanCons.sayHello());
		assertEquals("Hello 어노테이션생성자", helloBeanCons.sayHello());
	}
}
