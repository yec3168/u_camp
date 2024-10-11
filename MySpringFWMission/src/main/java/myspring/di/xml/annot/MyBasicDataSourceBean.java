package myspring.di.xml.annot;

import org.springframework.stereotype.Component;

@Component("myBasicDataSourceBean")
public class MyBasicDataSourceBean implements MyDataSourceBean{

	@Override
	public String connect(String type) {
		return type + " DataSouce Connected";
	}

}
