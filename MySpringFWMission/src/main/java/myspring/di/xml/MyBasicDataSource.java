package myspring.di.xml;

public class MyBasicDataSource implements MyDataSource{

	@Override
	public String connect(String type) {
		return type + " DataSouce Connected";
	}

}
