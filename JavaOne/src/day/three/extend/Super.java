package day.three.extend;

public class Super {
	
	/**
	 * 		필드
	 *  자식메소드에 전달되긴하나 오버라이딩이나 재정의가 되는게 아니라 완전 별개의 존재임.
	 */
	String msg ; 
	
	
	/**
	 * 		생성자
	 * - 만약 파라미터가 존재하는 생성자만 있다면 자식클래스에서 생성자에 값을 넣어줘야 오류가 안남.
	 */
	Super(){
		System.out.println("Super의 생성자 ::::");
	}
	
	void print() {
		System.out.println("Super ::::" );
	}
	
	
	public static void main(String [] args) {
		
		// 1. Super라는 타입변수에 인스턴스를 할당. 
		 
		Super s1 = new Super();
		Super s2 = new SubOne();
		Super s3 = new SubTwo();
		
		s1.print();
		s2.print(); //s2의 print
		s3.print(); //s3의 print 오버라이딩이 있으면 해당 메소드 출력. 오버라이딩이 안되어있는 메소드는 출력이 안됨.
		System.out.println();
		
		
		
		//2. 자식클래스 안에만 있는 메소드 출력.
		
			//s1.unique_method(); //안됨
			//s2.unique_method(); // 안됨.    reason) 객체 타입은 Super이기때문에 Super부터 확인함. 자식클래스를 들어가서 호출하진 못함.
			//s3.unique_method2(); // 안됨 마찬가지.
		
		 	
		//해결 (다운캐스팅)
		SubOne sub1 = (SubOne) s2;
		sub1.unique_method();
		
		
		//SubTwo two = (SubTwo)s2; // 안됨.  	s2는 인스턴스가 SubOne이기에 SubTwo의 존재만 알지 할당 받지 못함.
		
		
		SubTwo sub2 = (SubTwo) s3;
		sub2.unique_method(); // 부모클래스의 메소드도 사용가능.
		sub2.unique_method2();
		
		
		
		
		// 3. up캐스팅
		
		SubTwo two1 = new SubTwo();
		Super s4 = (Super) two1;   		//`11`` 가능
		SubOne sub3 = (SubOne)two1;		// 가능
		
	}
}
