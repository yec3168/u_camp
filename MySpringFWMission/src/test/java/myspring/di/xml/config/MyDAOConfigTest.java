package myspring.di.xml.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import myspring.di.annot.MyDAOBean;
import myspring.di.annot.MyDAOBeanCons;
import myspring.di.annot.config.MyDAOBeanConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = MyDAOBeanConfig.class)
public class MyDAOConfigTest {

	@Autowired
	MyDAOBean myDAOBean;
	
	@Autowired
	@Qualifier("myDAOBeanCons")
	MyDAOBeanCons myDAOBeanCons;
	
	@Test
	void myDaoBeanConfig() {
		System.out.println(myDAOBean.myType());
		assertEquals("DAO basic", myDAOBean.myType());
		assertEquals("DAO basic DataSouce Connected", myDAOBean.connect());
		
	}
	
	@Test
	void myDaoBeanCons() {
		System.out.println(myDAOBeanCons.connect());
		assertEquals("DAO hikari", myDAOBeanCons.myType());
		assertEquals("DAO hikari DataSouce Connected", myDAOBeanCons.connect());
	}
}
