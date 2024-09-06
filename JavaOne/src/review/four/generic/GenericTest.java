package review.four.generic;

import java.util.ArrayList;

public class GenericTest {

	public static void main(String[] args) {
		
		/**
		 *  Parent - ChildOne - ChildTwo
		 */
		
		//===================================================================================================================
		
		
		/**
		 * 			 
		 * 		1. objectExtends( List <? extends T> t)
		 * 			- ? 가 올 수 있는 클래스는 T와 T의 자식들이다.
		 * 		 ex) T = Parent, 	? = Parent, ChildOne, ChildTwo
		 * 			 T = ChildTwo, 	? = ChildTwo
		 * 
		 * 		2. objectSuper(List<? super T> t)
		 * 			- ?가 올 수 있는 클래스는 T와 T의 부모이다.
		 * 		 ex) T = Parent,  	? = Parent
		 * 			 T = ChildTwo, 	? = Parent, ChildOne, ChildTwo
		 * 			
		 */
		GenericDefinition<Parent> p = new GenericDefinition<>();
		// 1. extends
		p.objectExtends(new ArrayList<Parent>());		// 가능
		p.objectExtends(new ArrayList<ChildOne>());		// 가능
		p.objectExtends(new ArrayList<ChildTwo>());		// 가능
		
		//2. super
		p.objectSuper(new ArrayList<Parent>());			// 가능
		//p.objectSuper(new ArrayList<ChildOne>());		// x
		
		
		
		
		GenericDefinition<ChildOne> c = new GenericDefinition<>();
		// 1. extends
		//c.objectExtends(new ArrayList<Parent>());		// x
		c.objectExtends(new ArrayList<ChildOne>());		// 가능
		c.objectExtends(new ArrayList<ChildTwo>());		// 가능
		
		//2. super
		c.objectSuper(new ArrayList<Parent>());			// 가능
		c.objectSuper(new ArrayList<ChildOne>());		// 가능
		//c.objectSuper(new ArrayList<ChildTwo>());		// x
		
		
		
		//===================================================================================================================
		
		
		
		/**
		 * 		static 제네릭 메소드 사용
		 *  - static 제네릭 타입 메소드는 해당 제네릭 타입을 지정해야한다.
		 *  	ex) GenericDefinition.method("String 타입");
		 *  - 파라미터로 받은 String 타입이 해당 메소드의 자료형이 된 것.
		 */
		String str = GenericDefinition.method("String 타입");
		System.out.println(str);
		
		
		
		//===================================================================================================================
		
		
		/**
		 * 		제네릭 파라미터를 받는 메소드 사용시 주의사항.
		 * - 제네릭으로 받는 타입이 String이라고 해서 String메소드를 사용해선 안된다.
		 * - T가 어떤 타입이 올 지 모르고, 만약 int가 들어오면 length 메소드는 못사용함.  ★★★★★★★★★★★★★★
		 */
		
		//===================================================================================================================
		
		
		/**
		 *  	객체 생성시 제네릭 타입을 지정하지 않는다면 자료형의 최상위 객체를 가르킴.
		 *  
		 *  	ex)  class A{}
		 *			 class B extends A{}
		 *			 class C <T extends A>{}
		 *			 
		 *			 class D <T extends B>{}
		 *			 
		 *			   *D d = new D() == D<B> d = new D<>();
		 *			   *C c = new C() == C<A> c = new C<>();
		 * 			   *C c = new C() == C<B> c = new C<>();
		 */
	}

}
