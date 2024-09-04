package day.three;

public class SuperTest {
	/**
	 *  	현재 상태
	 *  SuperTest -> SubTest -> SubTwoTest 
	 *  
	 *   - 위 상태로 상속받는 상태
	 *   
	 *   	중요
	 *  - 자료형 변수 = new 인스턴스타입(); 
	 *  - 인스턴스타입이 자료형보다 높은 그러니까 부모클래스는 불가능
	 *  	ex) SubTest sub = new SuperTest(); (x)
	 *  
	 *  - SubTest sub = new SubTwoTest(); 가능
	 *  - SuperTest super = new SubTest(); 가능
	 */
	
	
	SuperTest(){
		System.out.println("SuperTest :::: 생성자");
	}
	
	public void aaa() {
		/**
		 *  현재 subTest 인스턴스로 되어있기때문에, subTest에도 가서 aaa 메소드가 있는지 확인
		 *   먼저 부모클래스 메소드 실행후 자식클래스 실행.
		 */
		System.out.println("부모(Super) 클래스의 aaa 메소드");
	}
	
	private void private_test() {
		System.out.println("private 상속 테스트");
	}
	
	
	public static void main(String [] args) {
		SuperTest su = new SubTest();
		
		su.aaa();
	}

}
