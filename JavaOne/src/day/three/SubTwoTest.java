package day.three;

public class SubTwoTest extends SubTest{


	SubTwoTest(){
		System.out.println("SubTwoTest :::: 생성자");
	}
	
	void test() {
		System.out.println("two의 test 메소드");
	}
	
	public static void ttt(SubTest sub) {
		System.out.println( sub instanceof SubTest);
		
		/**
		 * instanceOf 로 타입 체크
		 * instanceof는 다운캐스팅이 되는지 확인 인스턴스타입까지 가능
		 */
		
		if (sub instanceof SubTest) {
			System.out.println("sub test 입니다.");
		}
		else if( sub instanceof SubTwoTest) {
			System.out.println("subTwoTest 입니다.");
		}
		
	}
	
	public static void tt(SuperTest sub) {
		System.out.println( sub instanceof SubTest);
		
		/**
		 * instanceOf 로 타입 체크
		 * instanceof는 다운캐스팅이 되는지 확인 인스턴스타입까지 가능
		 */
		
		if (sub instanceof SuperTest) {
			System.out.println("SuperTest 입니다.");
		}
		else if( sub instanceof SubTest) {
			System.out.println("subTest 입니다.");
		}
		
	}
	
	
	
	
	
	/**
	 * 객체의 캐스팅은 원래 만들어진 녀석을 원래대로 만들음
	 */
	public static void main(String [] args) {
		// SubTwoTest subTwo = new SubTwoTest();
		
		
		SubTest sub = new SubTest(); // 가능
		ttt(sub);  // true subTest
		
		System.out.println();
		System.out.println();
		SuperTest s = new SubTest();
		tt(s);
		
		 //-----------------------------------------------------------------------------------------------------------------------------//	
		 
		
		
	
		/**
		 * SubTest인 sub는 타입도 SubTest, 인스턴스도 SubTest이기 때문에 
		 * 자식클래스인 subTwoTest로 캐스팅해도 원래부터 없는 거기때문에 안됨.
		 */
		//SubTwoTest two = (SubTwoTest)sub; 
		//two.test();
		//ttt(two); // 안됨.
		
		System.out.println();
		System.out.println();
		System.out.print( "sub1 :::: ");
		SubTest sub1 = new SubTwoTest(); //subTwoTest를 만들어서 subTest에 할당하는게 가능하냐  o subTwoTest가 자식이기때문에 부모클래스에 할당이 가능함.
		ttt(sub1);

	}

}
