package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.di.annot.config.MyDAO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:myspring.di.xml")
public class MyDAOSpringTest {

	@Autowired
	MyDAO myDAO1;
	
	@Autowired
	@Qualifier("myDAO2")
	MyDAO myDAO2;
	
	
	@Resource(name ="myDAO2")
	MyDAO myDAO3;
	
	@Test
	void autowiredTest() {
		System.out.println(myDAO1.connect());

		System.out.println(myDAO2.connect());
		
		System.out.println(myDAO3.connect());
		
		//-----------------------------------------------------------------
		
		//1. assertSame test
		assertEquals(myDAO2, myDAO3);
		
		//2. setter injection test
		assertEquals("DAO hikari DataSouce Connected", myDAO2.connect());
		
		//3. connection assertEqualsTest
		assertEquals(myDAO2.connect(), myDAO3.connect());
	}
}
