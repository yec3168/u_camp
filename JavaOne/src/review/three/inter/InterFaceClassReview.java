package review.three.inter;

public class InterFaceClassReview implements InterOne, InterTwo{

	/**
	 * 공통적으로 들어간 메소드를 따로 분리하여 인터페이스 안에서 상속받는 또 다른 인터페이스에 정의된 메소드.
	 */
	@Override
	public void eat() {
		System.out.println("냠냠~~~~~");
		
	}
	
	
	
	 //-----------------------------------------------------------------------------------------------------------------------------//		
	
	
	/**
	 *  interOne에 정의된 불안전한 메소드
	 */
	@Override
	public void cry(String barks) {
		System.out.println(barks);
	}

	@Override
	public void wakeUp() {
		
		System.out.println("일어나기");
	}

	 //-----------------------------------------------------------------------------------------------------------------------------//		
	
	/**
	 *  intertwo에 정의된 불안전한 메소드
	 */
	@Override
	public void run() {
		System.out.println("달리기");
	}
	
	@Override
	public void walk() {
		System.out.println("걷기");
		
	}

	 //-----------------------------------------------------------------------------------------------------------------------------//		
	
	
	
	/**
	 * 이미 구현된 메소드로 따로 재정의 안해줘도 됨.
	 */
	@Override
	public void sleep() {
		
		// 꼭 앞에 인터페이스 정보를 적어줘야함.
		// 앞에 이름을 명확하게 안적어주면 Object를 의미함.
		// reason) 인터페이스를 여러 개 할당받기 때문.
		InterOne.super.sleep();
	}

	public static void main(String[] args) {
		
		InterFaceClassReview r1 = new InterFaceClassReview();
		r1.cry("멍멍~");
		
		
		
		
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();
		 
		 

		 InterOne one = new InterFaceClassReview();
		 one.cry(one.barks); // interOne에 정의된 필드.
		 
		 
		 
		 System.out.println();
		 System.out.println("=============================================================");
		 System.out.println();

		 InterFaceClassReview r2 = new InterFaceClassReview();
		 InterOne one2 = (InterOne)r2;
		 System.out.println(one2.barks); // 인터페이스는 필드도 public이라서 접근이 가능함.
		 one2.eat(); //InterFaceClassReview에서 재정의한 메소드가 실행.
		 
	}

}
