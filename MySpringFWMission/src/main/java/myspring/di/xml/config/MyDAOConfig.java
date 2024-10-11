package myspring.di.xml.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import myspring.di.xml.MyBasicDataSource;
import myspring.di.xml.MyDAO;
import myspring.di.xml.MyDataSource;
import myspring.di.xml.MyHikariDataSource;

@Configuration
public class MyDAOConfig {
	
	@Bean
	public MyDataSource basicData() {
		return new MyBasicDataSource();
	}
	
	@Bean
	public MyDataSource hikariData() {
		return new MyHikariDataSource();
	}
	
	@Bean
	public MyDAO myDAO() {
		MyDAO mydao = new MyDAO();
		return mydao;
	}
}
