package myspring.di.xml.annot;

import org.springframework.stereotype.Component;

@Component("myHikariDataSourceBean")
public class MyHikariDataSourceBean implements MyDataSourceBean{

	@Override
	public String connect(String type) {
		return type + " DataSouce Connected";
	}

}
