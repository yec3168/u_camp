package day.three.interfaces;

public class InterTest {

	/**
	 * 			인터페이스
	 * - 불안전한( 구현을 안한) 메소드로 구현
	 * - 내부적으로 메소드 구현도 가능함. ( default method 라고 함)
	 * - default 메소드는 접근제어자가 public임. -> 그냥 안붙이면 모든게 public abstract
	 * - private는 안됨.
	 * - extends는 하나의 부모클래스만 상속 받지만, implements는 다중 인터페이스 할당이 가능함. 상속과 개념은 비슷하지만 다름. 강제적인것.
	 * 
	 * - 내부적으로 필드도 생성이 가능함.
	 *   ex) int one =1; -> public static final int on =1; 라는 의미.
	 * -
	 */
	
	
	public static void main(String[] args) {
		
		Two t = new Two();
		t.default_method();
		
		One o = new Two(); // 이것도 가능함 상속이랑 비슷한 의미이지만, class와 class사이의 상속과 조금 다름.
		o.default_method(); // 재정의한 메소드를 실행함.
		o.default_method2(); // 재정의하지 않아서 부모클래스에 있는 메소드가 실행됨.
		o.first(); // 오버라이딩한 메소드
		
		
		
		System.out.println();
		System.out.println("t2");
		Two t2 = (Two)o;		// One이 지금 new 인스턴스로 Two를 할당받았기 때문에 다운 캐스팅이 가능함.
		t2.default_method();	// two에 적혀있는대로 실행.
		t2.default_method2(); 
		
		System.out.println("");
		//------------------------------------------------------------------------------------------------------//
		
		
		/**
		 * o2가 new two임.
		 * 당연히 Two t= new Two(); 는 가능
		 * 
		 * two는 지금 One, One2 인터페이스를 할당 받아서
		 * 
		 * o2가 two이기에 One2 캐스팅도 가능
		 */
		One o2 = new Two();
		One2 oo = (One2)o2;
		oo.one_2();
	}

}
