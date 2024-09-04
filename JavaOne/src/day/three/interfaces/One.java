package day.three.interfaces;

/**
 * 중복된 메소드를 상속받아서 사용하도록 하게함.
 * extends라고 하고에도 interface에 다중 상속이 가능함.
 * 
 */
public interface One extends DuplicateMehtod // ex) DuplicateMethod2
{
	
	// 필드도 구현이 가능함.
	int f = 1; // public static int f = 1;
	
	public void first();
	
	public void second();
	
	/**
	 *  default 메소드로 내부적으로 구현이 가능함
	 *  다중 인터페이스 할당이 가능.
	 *  
	 *  저렇게 컴파일 하면 public default로 컴파일 됨.
	 *   인터페이스는 메소드가 abstract가 붙는데 이건 안붙음.
	 */
	default void default_method() {
		System.out.println("Default method로 따로 오버라이딩 하지 않는 이상 인터페이스에 구현된 메소드가 실행된다.");
	}
	
	default void default_method2() {
		System.out.println("Default method2로 따로 오버라이딩 하지 않는 이상 인터페이스에 구현된 메소드가 실행된다.");
	}
}
