package day.four.generic;

import java.util.List;

/**
 *  	Generic
 *  - Generic은 Object를 사용함으로서 캐스팅의 불편함을 줄이기 위해서 사용된 개념.
 *  - 자바에서는 파라미터로 `T`라는 것을 사용한다.
 *  - 클래스나 static이 있는 메소드에 <T>를 붙이게 되면 해당 클래스나 메소드는 제네릭이라고 칭한다.
 *     ex) public static <T> T print(){}
 *     
 *  - 다른 클래스에서 Generic 클래스 인스턴스를 생성하기 위해서 T의 타입을 지정해야한다.
 *    ex) OneGeneric <Object> o = new OneGenric<>() 
 *  		* 위 예시처럼 인스턴스를 생성하면 o라는 인스턴스의 T는 `Object`이다.
 *  
 *  - 자바에서는 제네릭 타입의 변수를 제공한다.
 *    	T : Type
 *   	E : Element
 *   	K, V : Key, Value
 *      N : Number
 *      
 *  - 부모클래스가 제네릭이면 자식클래스도 부모의 제네릭 타입을 그대로 물려받는다.
 * 		ex) class B <T, K> extends A<T, k>
 * 			class D <K, N> extends C<K>
 * 
 *  - 부모로부터 상속받는 제네릭의 객체를 생성할 때, 따로 타입을 지정하지 않으면 최상위 객체로 지정된다.
 *  		ex) class B <T extends A> 
 *  
 *  			B b = new B() == B<A> b = new B();
 */
public class OneGeneric <T> {

	 private T t;
	 
	 
	 
	/**
	 *  	와일드 카드
	 *  - ?는 T이거나 T의 자식들
	 *  
	 *  
	 *   List < ? extends T>
	 *    One <- two <- three
	 *  -  ex) T가 Two일 때, ? 는 Two, three
	 *  	   
	 */
	public void setObjectExtends(List<? extends T> t) {
	}

	/**
	 *  	와일드 카드
	 *  - ?는 T이거나 T의 부모
	 *  
	 *  
	 *   List < ? super T>
	 *    One <- two <- three
	 *  -  ex) T가 Two일 때, ? 는 Two, One
	 *  	   
	 */
	public void setObjectSuper(List<? super T> t) {
	}
	
	
	
	
	/**
	 *  	static 제네릭 메소드
	 *  - <T>라고 칭하여 해당 메소드가 제네릭이라고 함.
	 *  - static은 필드에 접근하고 싶어도 필드도 static이 아닌 이상 접근이 안된다.
	 */
	public static <T> T print(T t) {
		return t;
	}
	
	
	
	/**
	 *  	length() error
	 *  - 현재 T가 뭐가 올지 모른다. 
	 *  - int가 오게 된다면 int에는 length라는 method가 없기때문에 error가 발생.
	 *  
	 */
	public <T> void method(T t) {
		//t.length();
		//System.out.println(t.length());
	}
}
