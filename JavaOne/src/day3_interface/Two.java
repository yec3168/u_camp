			package day3_interface;

public class Two implements One, One2{

	@Override
	public void first() {
		System.out.println("implements 하여 할당받은 first");
		
	}

	@Override
	public void second() {
		System.out.println("implements 하여 할당받은 second");
	}

	@Override
	public void default_method() {
		// 내부적으로 수정을 안하면 인터페이스에서 선언된 메소드가 실행.
		//One.super.default_method();  // 인터페이스에 선언된 default_method가 실행.
		
		// 앞에 이름을 명확하게 안적어주면 Object를 의미함.
		One.super.default_method();
		
		//super.first() // error   object에는 first가 없음
		System.out.println("오버라이딩 하여 two에서 재정의 하였습니다.");
	}

	
	//--------------------------------------------------------------------------------//
	@Override
	public void one_2() {
		System.out.println("one_2 재정의한 메소드");
		
	}
	
	
	// One, One2 둘다 중복적인 코드를 가지고 있어서 따로 분리 시켜서 extends 써서 상속받음.
	@Override
	public void print() {
		System.out.println("인터페이스가 extends 하여 상속받은 메소드를 재정의함.");
	
	
	}

}
