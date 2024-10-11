package myspring.di.xml;

public class MyHikariDataSource implements MyDataSource{

	@Override
	public String connect(String type) {
		return type + " DataSouce Connected";
	}

}
