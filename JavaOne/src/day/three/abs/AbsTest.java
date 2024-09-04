package day.three.abs;

public class AbsTest {
	
	
	public static void main(String [] args) {
		/**
		 * 				Abstract클래스
		 *  - 형태를 강제하기 위한 클래스, 인터페이스 처럼 무조건 구현해야함.
		 * 
		 * 		객체 생성이 안됨
		 * 	1. 생성자가 없나 -> x Abstract도 생성자를 가지고 있음. 
		 * 		* 구현된 메소드나 필드가 있을 수 있음.
		 * 
		 * 		해결방법
		 *  2. 해당 abstract클래스를 상속받는 자식클래스를 new 인스턴스를 통해 할당받아서 사용이 가능함.
		 *  

		 */
		//SupAbsTest s = new SupAbsTest();
		
		
		SubAbsTest sub = new SubAbsTest(); 
		SupAbsTest sup = new SubAbsTest(); // 이렇게 하면 가능.
		
		sub.one(); // sup에 있는 one 메소드를 오버라이딩
		sub.two(); 
		
		sup.one(); // 현재 인스턴스가 SubAbsTest이기 때문에 오버라이딩이 된 메소드가 존재한다면 해당 메소드를 실행함. 	
		sup.two();
	}

}
