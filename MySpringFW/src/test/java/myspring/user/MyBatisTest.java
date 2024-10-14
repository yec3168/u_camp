package myspring.user;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myspring.user.dao.UserDao;
import myspring.user.dao.mapper.UserMapper;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:spring_beans.xml")
public class MyBatisTest {
	
	@Autowired
	DataSource dataSource; // Hikari Data Source Autowired
	
	@Autowired
	SqlSessionFactory sqlFactory;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	// myspring.user.dao.mapper패키지 안 UserMapper
	UserMapper userMapper;
	
	@Autowired
	UserDao userDao;
	
//	@Autowired
//	UserService userService;
	
	@Test
	void connectionTest() {
		try {
			Connection connection = dataSource.getConnection();
			DatabaseMetaData metaData = connection.getMetaData();
			System.out.println("DB Product Name : "+metaData.getDatabaseProductName());
			System.out.println("DB URL : "+metaData.getURL());
			System.out.println("DB UserName : "+metaData.getUserName());

		} catch (SQLException e) {
			e.printStackTrace(); // error log printW
		}
	}
	
	@Test @Disabled
	void sqlSessionTest() {
		// Factory는 단순히 껍때기 같은 느낌.
		System.out.println(sqlFactory.getClass().getName());
		
		
		// SqlSession으로 실행함.
		// Unique key로 조회하기. ( id, value)  // 무조건 한 개의 값만 전달이 가능하며, 자동으로 mapping이 됨. 
		// userspace값을 주고 그 다음 id값을 줌
	    UserVO user = sqlSession.selectOne("userNS.selectUserById", "dooly");
	    System.out.println(user);
	    
	    assertEquals("둘리", user.getName());
	    
	}
	
	@Test
	void userMapperTest() {
		UserVO user =userMapper.selectUserById("gildong");
		System.out.println(user);
	}
	
	@Test
	void userDaoTest() {
		List<UserVO> userList = userDao.readAll();
		/**
		 * 		함수형 인터페이스
		 *  - 추상메서드를 딱 한 개만 가지고 있는 인터페이스.
		 *  - Java의 람다식은 함수형 인터페이스가 가진 추상 메소드를 재정의 하는 것.
		 */
		// Iterable의 forEach(Consumer)을 사용.
		// Consumer의 추상멧드 void acceopt(T t)
		
		// 1. 익명의 Anonymous InnerClass를 사용한다.
		userList.forEach(user -> System.out.println(user));
		
		System.out.println();
		
		userList.forEach(System.out::println);
		
		
//		UserVO addUser = new UserVO("spring", "스프링", "남", "seoul");
//		userList.add(addUser);
//		userList.forEach(user -> System.out.println(user));
		
		
	}
	
}
