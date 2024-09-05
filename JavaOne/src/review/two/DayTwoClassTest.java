package review.two;

public class DayTwoClassTest {

	
	/**
	 *  	필드
	 *  - 다양한 접근제어자가 올 수 있지만, 개발자끼리 약속으로 private를 쓰기로함.
	 *  - 아무것도 안적으면 default = package_private임.
	 *  
	 */
	private String name;
	private int age;
	private String address;
	private static double salary = 3600.0;
	
	
	
	
	/**
	 * 		생성자 
	 *  - new 인스턴스를 생성할 때, 호출하는 메소드
	 *  - 생성자의 명은 클래스의 명칭과 동일해야한다.
	 *  - 모든 클래스는 하나의 생성자를 가진다.
	 *  - 만약 개발자가 따로 생성자 정의를 하지 않는다면 기본 생성자를 자동으로 생성한다.
	 *  	ex) DayTwoClassTest(){
	 *  
	 *  		}
	 *  - 개발자가 생성자 정의를 하게되면 기본생성자는 생성하지 않는다.
	 *   * 대신 파라미터가 필요한 생성자일 경우, 객체 생성시 필요 인자를 넣어줘야함.
	 *  - 생성자는 public으로 보통 생성.
	 *  - return type은 적지않는다.
	 *  
	 *  	'오버로딩'
	 *  - 메소드에서나 생성자에서 사용가능함.
	 *  - 명칭은 같으니 파라미터가 다른 경우.
	 */
	public DayTwoClassTest(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	 
	/**
	 * 		메소드
	 *  - 메소드는 행동을 나타내는 것.
	 *  - 마찬가지로 다양한 접근제어자를 가짐
	 *  - 아무것도 안적으면 default = package_private
	 *  - return type은 꼭 적어줘야한다.
	 *  
	 *  - 파라미터가 있어도 되고 없어도 된다.
	 *  
	 *  	static
	 *  - static이 붙은 메소드일 경우, 객체를 따로 생성하지 않아도 바로 사용가능하다.
	 *  - 대신 필드를 리턴하는 경우, 필드에도 static을 붙여줘야 한다.
	 *     ex) Math.random();
	 *  - 물론 접근 제어자에 영향을 받아 private로 선언하면 접근할 수 없다.
	 *  
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}
	
	private static void print() {
		System.out.println("static으로 선언한 접근제어자가 private은 print 메소드.");
	}
	
	public static double getSalary() {
		return salary;
	}
	
	
}
