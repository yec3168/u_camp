package review.three.interfaces;

/**
 *  인터페이스끼리 상속 받을 때는 extends
 */
public interface InterOne extends DuplicatedMethod{

	/**
	 *  	인터페이스
	 *  - 추상클래스와 똑같이 불안전한 메소드를 구현.
	 *  - 내부적으로 메소드도 구현 가능함 ( default method )
	 *  - default method는 `public`
	 *  - 다른 메소드도 public임.
	 *  
	 *  - private는 안되며, extends를 통해 하나의 인터페이스만 상속 받는다. 
	 *  - 클래스에게 상속해줄 때는 implements를 사용하여 다중상속 가능
	 *  
	 *  - 내부적으로 필드도 생성가능하나, 생성자는 생성할 수 없음.
	 *    ex ) int one =1;
	 *    * 컴파일시 자동으로 `public static final`이 추가가 됨.
	 *    
	 *  - 메소드는 자동으로` public abstract`가 붙음.
	 */
	
	
	
	// 필드도 구현 가능. 
	// 컴파일시 `public static final` 붙음
	String barks = "야옹~";   // public static final String barks = "야옹~";
	
	
	// 컴파일시 자동으로 `abstract`가 붙음.
	public void cry(String barks);	//
	public void wakeUp();
	
	
	
	/**
	 * 		default method
	 *  - 인터페이스 내부에서 구현할 수 있는 메소드
	 *  - 앞에 `default`를 붙여야한다.
	 */
	default void sleep() {
		System.out.println("zzz");
	}
	
	
	
	
	
	
}
