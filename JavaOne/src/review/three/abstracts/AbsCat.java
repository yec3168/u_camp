package review.three.abstracts;

public class AbsCat extends AbsAnimal{

	AbsCat(){
		//super()가 생략.
		System.out.println("AbsCat 생성자 입니다.");
	}
	
	/**
	 *  	부모(AbsAnimal)에서 선언된 메소드 
	 *  - 내부적으로 따로 구현이 필수임. 아니면 오류.
	 */
	@Override
	void cry() {
		System.out.println("야옹~");
	}

	
	public static void main(String[] args) {
		
		System.out.println("AbsCat 자료형의 메소드입니다.");
		AbsCat cat = new AbsCat();
		cat.cry();
		cat.eat();	// 내부 구현이라 재정의를 안하면 내부구현된 메소드가 실행.
		
		
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();
		 
		 
		 
		 
		 
		// 부모클래스를 할당받으면 오류.
		//AbsCat cat2 = new AbsAnimal(); 
		
		System.out.println("AbsAnimal 자료형의 AbsCat의 자식 인스턴스를 할당 받은 메소드입니다.");
		AbsAnimal animal = new AbsCat();
		animal.cry(); 	// AbsAnimal에는 구현이 안되어있음. 
						// new 인스턴스에 정의된 메소드를 실행시킴.
		animal.eat();
		

	}
}
