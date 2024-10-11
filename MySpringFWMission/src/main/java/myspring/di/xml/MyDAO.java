package myspring.di.xml;

public class MyDAO {
	String type;
	MyDataSource dataSource;
	
	public MyDAO() {
		System.out.println("기본생성자 호출.");
	}
	public MyDAO(String type, MyDataSource dataSource) {
		System.out.println("오버로딩 생성자 호출.");
		this.type = type;
		this.dataSource = dataSource;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setDataSource(MyDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public String myType() {
		return "DAO " + type;
	}
	
	public String connect() {
		return this.dataSource.connect(myType());
	}
}
	