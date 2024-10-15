package myspring.customer;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.customer.dao.CustomerDao;
import myspring.customer.dao.mapper.CustomerMapper;
import myspring.customer.vo.CustomerVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_beans.xml")
public class CustomerSpringTest {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	SqlSessionFactory sqlFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	CustomerDao customerDao;
	
	
	
	// 1. DB connection Test ( pass )
	@Test @Disabled
	void dataSourceConnectionTest() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB product Name : " + metaData.getDatabaseProductName());
			System.out.println("DB URL : " + metaData.getURL());
			System.out.println("DB Usernaem : " + metaData.getUserName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Test @Disabled
	void sqlSessionFactoryTest() {
		//2. sqlSessionFactory Test ( pass)
		System.out.println(sqlFactory.getClass().getName());
		
		
		// 3. SqlSession Test ( pass )		 
		List<CustomerVO> selectList = sqlSession.selectList("customerNS.selectCustomerList");
		selectList.forEach(System.out::println);
		
		// insert data
		//CustomerVO addCustomer = new CustomerVO(1L, "first@email.com", "홍길동", 20, new Date(0));
		//System.out.println(addCustomer.toString());
		
	}
	
	@Test @Disabled
	void customerMapperTest() {
		System.out.println(customerMapper.getClass().getName());
		//customerMapper.selectCustomerList();
		List<CustomerVO> selectCustomerList = customerMapper.selectCustomerList();
		selectCustomerList.forEach(System.out::println);
	}
	
	@Test
	void customerDaoTest() {
		CustomerVO addCustomer = new CustomerVO("third@email.com", "홍길동3", 33);
		System.out.println(addCustomer.toString());
		
		// 1. Insert test
		customerDao.insert(addCustomer);
		
		// 2. email로 조회.
		CustomerVO customer = customerDao.read("first@email.com");
		System.out.println(customer.toString());
		
		//3. 목록 조회.
		List<CustomerVO> readAll = customerDao.readAll();
		readAll.forEach(System.out::println);
		
	}
}
