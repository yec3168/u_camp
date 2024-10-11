package myspring.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.MyBasicDataSource;
import myspring.di.xml.MyDAO;
import myspring.di.xml.MyDataSource;

public class MyDAOJunitTest {
	ApplicationContext container;
	
	@BeforeEach
	public void init() {
		container = new GenericXmlApplicationContext("classpath:myspring_di.xml");
	}
	
	@Test
	void junitTest() {
		// 1. container에게 bean 요청.
		MyDAO myDao1 = container.getBean("myDAO1", MyDAO.class);
		MyDAO myDao2 = (MyDAO)container.getBean("myDAO1");
		
		System.out.println(myDao1 == myDao2);
		
		
		//2. assertSame test	
		assertSame(myDao1, myDao2);
		
		
		//3. setter injection test
		assertEquals("DAO basic", myDao1.myType());
		assertEquals("DAO basic", myDao2.myType());
		
		//4. setDataSource injection 테스트.
		myDao1.connect();
		myDao2.connect();
		assertEquals(myDao1.connect(),myDao2.connect());
		
		//5. bean호출
		MyDataSource myDataSource = container.getBean("myBasicDataSource", MyBasicDataSource.class);
		System.out.println( myDataSource.connect(myDao1.myType()));
		assertEquals("DAO basic DataSouce Connected", myDataSource.connect(myDao1.myType()));
	}
}
