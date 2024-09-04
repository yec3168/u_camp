package day.two;

public class Student {
	
	/**
	 * 		필드 
	 * - heap 영역에 저장되어있음.
	 * - private 로 선언되면 다른 클래서에서 객체를 생성해도 private를 사용할 수 없음.
	 * - 기본적으로 modifier(public, private etc...)를 선언하지 않으면 default로 지정.
	 */
	public String name;
	public int age;
	private String address;
	
	private static int weight = 12;
	
	
	/**
	 * 		생성자
	 * 
	 *  new 객체를 생성지 호출하는 메소드.
	 *  모든 클래스에는 최소 하나의 생성자가 존재.
	 *  생성자는 클래스의 명과 같아야한다.
	 *  클래스에 생성자를 명시적으로 정의하지 않으면 컴파일시 기본 생성자가 생성됨.
	 *  만약에 생성자를 정의하면 기본생성자는 생성되지 않는다.
	 *  생성자는 여러개 선언이 가능하다.
	 *  
	 *  '오버로딩' : 메소드명은 같으나 파라미터나 리턴타입이 다름, 생성자도 가능함.
	 *  	역할
	 *  객체를 생성하고 필드를 초기화.
	 *  
	 */
	
	// 아래 코드를 작성 안하면 컴파일시 기본 생성자 생성.
	 Student(String name, int age){
		 this.name = name;
		 this.age = age;
	 }
	
	
	
	
	/**
	 * 		메소드
	 * - 객체의 행동을 정의하는 장소
	 * - 변수의 이름을 짓 듯 메소드 명을 적는다.
	 * - 기본은 'package_private'로 같은 패키지에서만 접근이 가능한 접근제어자이다.
	 * 
	 * - 'static'은 객체 생성없이 바로 사용이 가능하다.
	 *      ** 대신 static 메소드를 사용하기 위해서 객체 안에 변수를 사용할려면 변수도 'static'으로 정의해야한다.
	 *      ** 이렇게 static을 사용하더라도 접근 제어자가 private이면 다른 클래스에서 직접적인 접근이 불가능하다.
	 */
	void sleep() {
		System.out.println("잠을 잔다.");
	}
	
	public int getAge() {
		return this.age;
	}
	
	public static int getWeight() {
		return weight;
	}
	
	public void getRegion() {
		int region_int = 10;
		System.out.println("region_int :::: " + region_int);
	}
	
	/**
	 * public : 모든 패키지에서 사용가능
	 * protected : 같은 패키지에서 사용가능하며, 상속받은 자식클래스에서 사용가능
	 * default : 같은 패키지에서만 사용가능
	 * private 같은 클래스에서만 사용가능
	 */

	

}
