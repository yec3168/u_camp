package myspring.di.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myDAOBeanCons")
public class MyDAOBeanCons {
	String type;
	
	MyDataSourceBean dataSource;
	
	public MyDAOBeanCons() {
		//System.out.println("기본생성자 호출.");
	}
	
	@Autowired
	public MyDAOBeanCons(@Value("hikari") String type, @Qualifier("myHikariDataSourceBean")MyDataSourceBean dataSource) {
		//System.out.println("오버로딩 생성자 호출.");
		this.type = type;
		this.dataSource = dataSource;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setDataSource(MyDataSourceBean dataSource) {
		this.dataSource = dataSource;
	}
	
	public String myType() {
		return "DAO " + type;
	}
	
	public String connect() {
		return this.dataSource.connect(myType());
	}
}
	