package review.four.generic;

import java.util.List;

/**
 * 		Generic
 *  - Generic은 Object를 사용함으로써 캐스팅을 해야하는 불편함을 줄이기 위해서 만들어 졌다.
 *  - 자바에서는 파라미터로 제공되는 'T'를 사용한다
 *  	T : Type
 *  	E : Element
 *  	K, V : Key, Value
 *  	N : Number
 *  - 클래스나 메소드, 변수에 붙일 수 있다.
 *  - <T>를 붙이게 되면 해당 클래스나 메소드는 제네릭 타입 변수라고 한다.
 *  	ex) publc class A <T>{}
 *  		public static <T> T method(){}
 *  		public T getT(){}
 *  
 *  - 다른 클래스에서 제네릭 타입 인스턴스를 생성할 때 해당 제네릭의 타입을 지정해야한다.
 *  	 ex) GenericDefintion<String> g = new GenericDefintion<>();
 *  
 *  - 부모클래스가 제네릭이면 자식클래스도 부모의 제네릭 타입을 그대로 물려받는다.
 *  	ex) class B <T, N> extends A<T>
 *  
 *  - 부모로부터 상속받는 제네릭 타입의 객체를 타입을 지정안하고 생성할 때 자동으로 최상위 부모타입을 설정한다.
 *     ex )	class D <T extends B>{}
 *     		D d = new D();  == D<B> d = new D<>();
 */


/**
 *  <T>를 붙임으로써 제네릭 타입의 클래스라는 것을 선언함.
 */
public class GenericDefinition <T>{
	
	private T t;
	
	/**
	 * 		List<? extends T> t
	 * 	- T의 객체를 상속받는 ?라는 의미
	 * 
	 *  - ? 는 T이거나 T의 자식들.
	 *  
	 *   Parent - ChildOne - ChildTwo
	 *     ex) List <? extends T>
	 *       
	 *       1. T가 Parent면
	 *        ? = Parent, ChildOne, ChildTwo
	 *       2. T가 ChildOne면
	 *        ? = ChildOne, ChildTwo
	 *     		
	 */
	public void objectExtends(List<? extends T> t) {
		
	}

	
	/**
	 * 		List<? super T> t
	 * - T의 부모이거나 T 자기 자신라는 의미.
	 * 
	 * - ?는 T이거나 T의 부모.
	 * 
	 * 	 Parent - ChildOne - ChildTwo
	 * 		ex) List<? super T> t
	 * 			
	 * 			1. T가 Parent면
	 * 			  ? = Parent
	 * 			2. T가 ChildOne면
	 * 			  ? = Parent, ChildOne
	 * 			3. T가 ChildTwo면
	 * 			  ? = Parent, ChildOne, ChildTwo
	 */
	public void objectSuper(List<? super T> t) {
		
	}
	
	
	/**
	 *  	static 제네릭 메소드
	 *  - <T>라고 칭하였기에 제네릭 타입 메소드임.
	 *  - static필드만 가져올 수 있고 return 타입은 자유롭게 설정 가능.
	 *  		ex) public static <T> void 메소드명
	 */
	public static <T> T method(T t) {
		return t;
	}
	
	
	
	/**
	 *  	제네릭 파라미터를 받는 메소드 사용시 주의사항.
	 *  - T t같이 파라미터로 제네릭을 받게 되면 어떤 타입이 올 줄 몰라 메소드 사용에 주의해야한다.
	 *   ex) s.length(), s.size()
	 */
	public <T> void methodTest(T t) {
		// 안됨.
		//t.size();
		//t.length(); 
	}
}
