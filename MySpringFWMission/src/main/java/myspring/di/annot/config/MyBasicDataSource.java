package myspring.di.annot.config;

public class MyBasicDataSource implements MyDataSource{

	@Override
	public String connect(String type) {
		return type + " DataSouce Connected";
	}

}
